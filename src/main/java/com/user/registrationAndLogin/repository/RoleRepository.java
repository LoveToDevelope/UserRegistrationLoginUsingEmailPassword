package com.user.registrationAndLogin.repository;

import com.user.registrationAndLogin.dao.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    Set<RoleEntity> findByRole(String role_user);

}
