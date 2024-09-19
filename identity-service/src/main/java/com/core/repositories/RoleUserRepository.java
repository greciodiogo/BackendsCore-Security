package com.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.domain.RoleUser;

public interface RoleUserRepository extends JpaRepository<RoleUser, Long>{
}
