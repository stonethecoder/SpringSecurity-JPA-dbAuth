package com.stone.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stone.security.model.Roles;

@Repository
public interface RolesRepo extends JpaRepository<Roles, Integer> {

}
