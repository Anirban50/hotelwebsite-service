package com.hotel_managementService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel_managementService.entity.UserQuery;

public interface UserQueryRepository extends JpaRepository<UserQuery, Integer> {
	

}
