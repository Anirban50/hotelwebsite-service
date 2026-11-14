package com.hotel_managementService.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel_managementService.entity.UserQuery;
import com.hotel_managementService.repository.UserQueryRepository;

@RestController
public class UserQueryController {
	@Autowired
    private UserQueryRepository userQueryRepository;
	
	
	@PostMapping("/userquery")
    public ResponseEntity<Map<String, String>> saveUserQuery(
            @RequestBody UserQuery userQuery) {

        Map<String, String> response = new HashMap<>();

        try {
            userQuery.setStatus("Open");

            userQueryRepository.save(userQuery);

            response.put("status", "success");
            response.put("message", "User query successfully saved.");

            return ResponseEntity.ok(response);

        } catch (Exception e) {

            response.put("status", "error");
            response.put("message", "Failed to save user query.");

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }
    }

}
