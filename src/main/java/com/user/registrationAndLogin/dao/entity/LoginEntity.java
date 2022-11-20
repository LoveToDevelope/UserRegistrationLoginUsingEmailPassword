package com.user.registrationAndLogin.dao.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity(name = "user_login_details_info")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "CREATION_TIME")
    private Date creationDate;
    @Column(name = "IS_ENABLED")
    private String isEnabled;
    @Column(name = "IS_ACTIVE")
    private String isActive;
    @Column(name = "IS_DELETED")
    private String isDeleted;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_details_info", joinColumns = {@JoinColumn(name = "USER_ID")}, inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    private Set<RoleEntity> roleList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Set<RoleEntity> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<RoleEntity> roleList) {
        this.roleList = roleList;
    }
}
