package com.hotel_managementService.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "email_id")
    @JsonProperty("email_id")
    private String email_id;

    private String password;

    @Column(name = "is_admin")
    @JsonProperty("is_admin")
    private boolean is_admin;

    public User() {}

    public User(String email_id, String password, boolean is_admin) {
        this.email_id = email_id;
        this.password = password;
        this.is_admin = is_admin;
    }

    public String getEmail_id() { return email_id; }
    public void setEmail_id(String email_id) 
    { this.email_id = email_id; }

    public String getPassword() { return password; }
    public void setPassword(String password) 
    { this.password = password; }

    public boolean isIs_admin() { return is_admin; }
    public void setIs_admin(boolean is_admin)
    { this.is_admin = is_admin; }
}