package com.foodhotelics.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.foodhotelics.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByEmail(String email);

}
