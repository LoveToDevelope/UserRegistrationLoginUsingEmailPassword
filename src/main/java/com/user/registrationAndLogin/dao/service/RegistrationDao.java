package com.user.registrationAndLogin.dao.service;

import com.user.registrationAndLogin.dao.entity.RegistrationInformationEntity;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationDao extends CrudRepository<RegistrationInformationEntity, Integer> {
}
