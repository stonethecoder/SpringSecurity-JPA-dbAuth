package com.stone.security.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stone.security.api.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUsername(String username);

}
