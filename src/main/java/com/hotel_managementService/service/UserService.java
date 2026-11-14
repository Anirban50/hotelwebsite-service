package com.hotel_managementService.service;

import com.hotel_managementService.entity.User;
import com.hotel_managementService.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user) {
       
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public Optional<User> getUserByEmail(String email_id) {
        return repo.findById(email_id);
    }

   
    public boolean checkPassword(String rawPassword, String storedPassword) {
       
        if (storedPassword.startsWith("$2a$") || storedPassword.startsWith("$2b$") || storedPassword.startsWith("$2y$")) {
         
            return passwordEncoder.matches(rawPassword, storedPassword);
        } else {
          
            return rawPassword.equals(storedPassword);
        }
    }
}