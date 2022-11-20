package com.user.registrationAndLogin.controller;

import com.user.registrationAndLogin.dao.entity.RegistrationInformationEntity;
import com.user.registrationAndLogin.model.request.RegistrationRequestModel;
import com.user.registrationAndLogin.repository.RegistrationRepository;
import com.user.registrationAndLogin.service.RegistrationAndLoginService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserRegistrationController {

    private RegistrationAndLoginService registrationAndLoginService;
    private PasswordEncoder passwordEncoder;
    private ModelMapper mapper;

    private RegistrationRepository registrationRepository;

    public UserRegistrationController(RegistrationAndLoginService registrationAndLoginService, PasswordEncoder passwordEncoder, ModelMapper mapper, RegistrationRepository registrationRepository) {
        this.registrationAndLoginService = registrationAndLoginService;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
        this.registrationRepository = registrationRepository;
    }

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RegistrationRequestModel> registerUser(@RequestBody RegistrationRequestModel requestModel) {
        requestModel.setPassword(passwordEncoder.encode(requestModel.getPassword()));
        RegistrationRequestModel registrationRequestModel = registrationAndLoginService.saveUserDetails(requestModel);
        return new ResponseEntity<>(registrationRequestModel, HttpStatus.OK);
    }

    @GetMapping(value = "/authenticatedUsers", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<RegistrationInformationEntity>> listUsers() {
        List<RegistrationInformationEntity> all = registrationRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
