package com.user.registrationAndLogin.repository;

import com.user.registrationAndLogin.dao.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {
    List<LoginEntity> findByEmail(String email);
}
