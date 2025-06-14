package com.example.trabalhojwt.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
@Tag(name = "Testes", description = "Endpoints para testar acesso público e por roles")
public class TestController {

    @Operation(summary = "Acesso público: Retorna uma mensagem de teste para todos")
    @GetMapping("/all")
    public String allAccess() {
        return "Conteúdo Público.";
    }

    @Operation(summary = "Acesso de usuário: Retorna uma mensagem de teste para usuários autenticados (ROLE_USER ou ROLE_ADMIN)")
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess() {
        return "Conteúdo de Usuário.";
    }

    @Operation(summary = "Acesso de administrador: Retorna uma mensagem de teste para administradores (ROLE_ADMIN)")
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Conteúdo de Administrador.";
    }
}