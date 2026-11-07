package com.hotel_managementService.controller;

import com.hotel_managementService.entity.User;
import com.hotel_managementService.service.UserService;
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
}