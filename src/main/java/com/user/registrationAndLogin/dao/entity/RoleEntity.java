package com.user.registrationAndLogin.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "roles_details_info")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "IS_ACTIVE")
    private String isActive;
    @ManyToMany(mappedBy = "roleList", fetch = FetchType.EAGER)
    private List<LoginEntity> loginEntities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public List<LoginEntity> getLoginEntities() {
        return loginEntities;
    }

    public void setLoginEntities(List<LoginEntity> loginEntities) {
        this.loginEntities = loginEntities;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", isActive='" + isActive + '\'' +
                ", loginEntities=" + loginEntities +
                '}';
    }
}
