package com.example.trabalhojwt.repository;

import com.example.trabalhojwt.model.ERole;
import com.example.trabalhojwt.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(ERole role);
}
