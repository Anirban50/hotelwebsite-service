package com.hotel_managementService.service;

import com.hotel_managementService.entity.User;
import com.hotel_managementService.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User saveUser(User user) {
        return repo.save(user);
    }

    public Optional<User> getUserByEmail(String email_id) {
        return repo.findById(email_id);
    }
}