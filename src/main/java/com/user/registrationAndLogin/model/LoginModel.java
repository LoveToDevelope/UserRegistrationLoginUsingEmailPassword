package com.user.registrationAndLogin.model;

import com.user.registrationAndLogin.enums.ActiveStatus;
import com.user.registrationAndLogin.enums.DeleteStatus;
import com.user.registrationAndLogin.enums.EnableStatus;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public class LoginModel {
    private String email;
    private String password;
    private Date creationDate;
    private EnableStatus isEnabled;
    private ActiveStatus isActive;
    private DeleteStatus isDeleted;

    private Set<RoleModel> roles;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public EnableStatus getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(EnableStatus isEnabled) {
        this.isEnabled = isEnabled;
    }

    public ActiveStatus getIsActive() {
        return isActive;
    }

    public void setIsActive(ActiveStatus isActive) {
        this.isActive = isActive;
    }

    public DeleteStatus getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(DeleteStatus isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleModel> roles) {
        this.roles = roles;
    }
}
