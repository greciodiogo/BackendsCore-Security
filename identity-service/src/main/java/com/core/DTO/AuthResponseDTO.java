package com.core.DTO;

import java.security.Permission;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.core.domain.Role;
import com.core.domain.User;

public record AuthResponseDTO<T>(
        Token<T> token,
        User user,
        Role role,
        List<Permission> permissions,
        List<Permission> permissionFields,
        String last_access
    ) {  
        public AuthResponseDTO(String token, User user,Role role, List<Permission> permissions, List<Permission> permissionFields) {
            this(
                new Token<>("Bearer",token),
                user, 
                role,
                permissions,
                permissionFields,
                formatDate(LocalDate.now(), "yyyy-MM-dd") // data_actual
                );
        }

        private static String formatDate(LocalDate date, String pattern) {
            return date != null ? date.format(DateTimeFormatter.ofPattern(pattern)) : null;
        }
    
    public record Token<T>(
        String type,
        String token
        ) {}

}