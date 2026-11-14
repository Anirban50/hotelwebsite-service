package com.hotel_managementService.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor  
@NoArgsConstructor
@Table(name = "users")

public class User {

    @Id
    @Column(name = "email_id")
    @JsonProperty("email_id")
    private String email_id;

    private String password;

    

  

  
    
}