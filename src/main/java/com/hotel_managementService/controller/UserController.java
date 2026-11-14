package com.hotel_managementService.controller;

import com.hotel_managementService.entity.User;
import com.hotel_managementService.service.UserService;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/userDetails")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(service.saveUser(user));
    }

    @GetMapping("/{emailId}")
    public ResponseEntity<User> getUser(@PathVariable String emailId) {
        return service.getUserByEmail(emailId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

  
    @PostMapping("/login")
      
    
    public ResponseEntity<String> loginUser(@RequestBody User loginRequest) {
        
        if (loginRequest.getEmail_id() == null || loginRequest.getPassword() == null) {
            return ResponseEntity.badRequest().body("Email and password are required");
        }

        Optional<User> userOptional = service.getUserByEmail(loginRequest.getEmail_id());

        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            if (service.checkPassword(loginRequest.getPassword(), existingUser.getPassword())) {
                return ResponseEntity.ok("Login Successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}