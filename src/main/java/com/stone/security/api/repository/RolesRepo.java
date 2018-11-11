package com.stone.security.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stone.security.api.model.Roles;

public interface RolesRepo extends JpaRepository<Roles, Integer> {

}
