package com.user.registrationAndLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true)
public class UserRegistrationLoginUsingEmailPasswordApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserRegistrationLoginUsingEmailPasswordApplication.class, args);
    }

}
