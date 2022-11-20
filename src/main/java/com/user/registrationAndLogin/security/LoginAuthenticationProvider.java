package com.user.registrationAndLogin.security;

import com.user.registrationAndLogin.dao.entity.LoginEntity;
import com.user.registrationAndLogin.dao.entity.RoleEntity;
import com.user.registrationAndLogin.exceptionsAndErrors.exception.UserNotFoundException;
import com.user.registrationAndLogin.repository.LoginRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {
    private LoginRepository loginRepository;
    private PasswordEncoder passwordEncoder;

    public LoginAuthenticationProvider(LoginRepository loginRepository, PasswordEncoder passwordEncoder) {
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        List<LoginEntity> loggedInUserEntity = loginRepository.findByEmail(authentication.getName());
        if (loggedInUserEntity.size() > 0) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (RoleEntity roleEntity : loggedInUserEntity.get(0).getRoleList()) {
                authorities.add(new SimpleGrantedAuthority(roleEntity.getRole()));
            }
            if (passwordEncoder.matches(authentication.getCredentials().toString(), loggedInUserEntity.get(0).getPassword())) {
                return new UsernamePasswordAuthenticationToken(loggedInUserEntity.get(0).getEmail(), loggedInUserEntity.get(0).getPassword(), authorities);
            } else {
                throw new UserNotFoundException("Email or Password is invalid");
            }
        } else {
            throw new UserNotFoundException("Email or Password is invalid");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
