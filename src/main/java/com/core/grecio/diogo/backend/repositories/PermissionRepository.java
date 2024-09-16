package com.core.grecio.diogo.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.core.grecio.diogo.backend.domain.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer>{
      @Query(value="SELECT p.id, p.name, p.slug, p.is_deleted FROM permissions p",  nativeQuery=true)
      // @Query(value="SELECT p.id, p.name, p.slug, p.is_deleted FROM permissions p JOIN permission_user pru ON p.id = pru.permission_id WHERE pru.user_id =:userId",  nativeQuery=true)
    List<Permission> findPermissionsByUserId(@Param("userId") Integer userId);
}
