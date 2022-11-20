package com.user.registrationAndLogin.repository;

import com.user.registrationAndLogin.dao.entity.RegistrationInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationInformationEntity, Integer> {
}
