package com.my.market.auth.service;

import com.my.market.auth.domain.entity.RoleEntity;
import com.my.market.auth.dto.RoleRequest;
import com.my.market.auth.dto.RoleResponse;

import java.util.List;

public interface RoleService {
    RoleResponse getRoleByName(String roleName);
    List<RoleResponse> getAllRoles ();

}
