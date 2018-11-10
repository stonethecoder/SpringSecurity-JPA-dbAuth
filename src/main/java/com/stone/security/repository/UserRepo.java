package com.stone.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stone.security.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByUsername(String username);

}
