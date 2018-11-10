package com.stone.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stone.security.model.Roles;

public interface RolesRepo extends JpaRepository<Roles, Integer> {

}
