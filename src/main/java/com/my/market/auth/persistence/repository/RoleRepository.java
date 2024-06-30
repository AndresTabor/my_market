package com.my.market.auth.persistence.repository;

import com.my.market.auth.domain.entity.RoleEntity;
import com.my.market.auth.domain.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
    Optional<RoleEntity> findRoleEntitiesByName(RoleName name);
}
