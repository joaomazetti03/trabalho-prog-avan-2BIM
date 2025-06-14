package com.example.trabalhojwt.config;

import com.example.trabalhojwt.model.ERole;
import com.example.trabalhojwt.model.Role;
import com.example.trabalhojwt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByRole(ERole.ROLE_USER).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_USER));
            System.out.println("Role ROLE_USER adicionada ao banco de dados.");
        }

        if (roleRepository.findByRole(ERole.ROLE_ADMIN).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
            System.out.println("Role ROLE_ADMIN adicionada ao banco de dados.");
        }
    }
}
