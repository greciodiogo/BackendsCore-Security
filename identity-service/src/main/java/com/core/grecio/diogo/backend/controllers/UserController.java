package com.core.grecio.diogo.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.grecio.diogo.backend.Helpers.EnvelopeResponse;
import com.core.grecio.diogo.backend.DTO.AuthResponseDTO;
import com.core.grecio.diogo.backend.DTO.LoginRequestDTO;
import com.core.grecio.diogo.backend.domain.Permission;
import com.core.grecio.diogo.backend.domain.PermissionField;
import com.core.grecio.diogo.backend.domain.Role;
import com.core.grecio.diogo.backend.domain.User;
import com.core.grecio.diogo.backend.repositories.PermissionFieldRepository;
import com.core.grecio.diogo.backend.repositories.PermissionRepository;
import com.core.grecio.diogo.backend.repositories.RoleRepository;
import com.core.grecio.diogo.backend.services.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private AuthenticationManager manager ;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PermissionFieldRepository permissionFieldRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PermissionRepository permissionRepository;

    @PostMapping("/login")
    public ResponseEntity<EnvelopeResponse<?>> login(@RequestBody @Valid LoginRequestDTO jsonBody) {
        var token = new UsernamePasswordAuthenticationToken(jsonBody.username(), jsonBody.password());
        var authenticacao = manager.authenticate(token);

        var generateToken = tokenService.generateToken((User) authenticacao.getPrincipal());

        var user = (User) authenticacao.getPrincipal();
       
         // Buscar role do usuário
        List<PermissionField> permissionField = permissionFieldRepository.findAll();
        Role role = roleRepository.findByUserId(user.getId());

        // Supondo que `Permission` está relacionada a `Role`
        List<Permission> permissions = permissionRepository.findPermissionsByUserId(user.getId());


        var authResponse = new AuthResponseDTO(
            generateToken,  user, role, permissions, permissionField);
            
        EnvelopeResponse<?> data = new EnvelopeResponse<>(
            authResponse,
            "Usuário logado com sucesso",
            200
        );
        return ResponseEntity.ok(data);
    }
}
