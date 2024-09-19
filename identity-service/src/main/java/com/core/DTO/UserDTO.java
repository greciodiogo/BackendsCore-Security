package com.core.DTO;

import com.core.domain.User;

public record UserDTO(
    Integer id,
    String name,
    String username,
    String email,
    Boolean is_actived
    ) {
        public UserDTO(User user){
            this(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getIs_actived()
            );
    }
}
