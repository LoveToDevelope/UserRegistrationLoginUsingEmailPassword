package com.user.registrationAndLogin.service;

import com.user.registrationAndLogin.dao.entity.LoginEntity;
import com.user.registrationAndLogin.dao.entity.RegistrationInformationEntity;
import com.user.registrationAndLogin.enums.ActiveStatus;
import com.user.registrationAndLogin.enums.DeleteStatus;
import com.user.registrationAndLogin.enums.EnableStatus;
import com.user.registrationAndLogin.model.LoginModel;
import com.user.registrationAndLogin.model.request.RegistrationRequestModel;
import com.user.registrationAndLogin.repository.LoginRepository;
import com.user.registrationAndLogin.repository.RegistrationRepository;
import com.user.registrationAndLogin.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
@Transactional
public class RegistrationAndLoginServiceImpl implements RegistrationAndLoginService {
    private RegistrationRepository registrationRepository;

    private RoleRepository roleRepository;
    private LoginRepository loginRepository;
    private ModelMapper mapper;

    public RegistrationAndLoginServiceImpl(RoleRepository roleRepository, RegistrationRepository registrationRepository, LoginRepository loginRepository, ModelMapper mapper) {
        this.roleRepository = roleRepository;
        this.registrationRepository = registrationRepository;
        this.loginRepository = loginRepository;
        this.mapper = mapper;
    }

    private LoginModel saveUserLoginDetails(LoginModel loginModel) {
        LoginEntity loginEntity = mapper.map(loginModel, LoginEntity.class);
        loginEntity.setRoleList(roleRepository.findByRole("ROLE_USER"));
        LoginEntity savedLoginDetails = loginRepository.save(loginEntity);

        return mapper.map(savedLoginDetails, LoginModel.class);
    }

    @Override
    public RegistrationRequestModel saveUserDetails(RegistrationRequestModel registrationRequestModel) {
        RegistrationInformationEntity registrationInformationEntity = mapper.map(registrationRequestModel, RegistrationInformationEntity.class);
        RegistrationInformationEntity savedRegistrationInformationEntity = registrationRepository.save(registrationInformationEntity);
        if (savedRegistrationInformationEntity != null) {
            LoginModel loginModel = new LoginModel();
            loginModel.setEmail(savedRegistrationInformationEntity.getEmail());
            loginModel.setCreationDate(new Date(System.currentTimeMillis()));
            loginModel.setPassword(registrationRequestModel.getPassword());
            loginModel.setIsActive(ActiveStatus.ACTIVE);
            loginModel.setIsDeleted(DeleteStatus.EXISTS);
            loginModel.setIsEnabled(EnableStatus.ENABLED);
            saveUserLoginDetails(loginModel);
        }
        return mapper.map(savedRegistrationInformationEntity, RegistrationRequestModel.class);
    }
}
