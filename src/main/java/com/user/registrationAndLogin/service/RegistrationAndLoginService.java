package com.user.registrationAndLogin.service;

import com.user.registrationAndLogin.model.LoginModel;
import com.user.registrationAndLogin.model.request.RegistrationRequestModel;

public interface RegistrationAndLoginService {

    RegistrationRequestModel saveUserDetails(RegistrationRequestModel registrationRequestModel);
}
