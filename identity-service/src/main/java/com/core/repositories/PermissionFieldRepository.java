package com.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.domain.PermissionField;

public interface PermissionFieldRepository extends JpaRepository<PermissionField, Long> {
}
