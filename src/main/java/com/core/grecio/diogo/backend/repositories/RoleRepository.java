package com.core.grecio.diogo.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.core.grecio.diogo.backend.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    @Query(
      value = "SELECT r.* FROM roles r " +
              "JOIN role_user ru ON r.id = ru.role_id " +
              "WHERE ru.user_id = :userId", 
      nativeQuery = true
    )
    Role findByUserId(@Param("userId") Integer userId);
}
