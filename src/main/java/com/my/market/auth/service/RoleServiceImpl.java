package com.my.market.auth.service;

import com.my.market.auth.domain.entity.RoleEntity;
import com.my.market.auth.domain.entity.RoleName;
import com.my.market.auth.dto.RoleRequest;
import com.my.market.auth.dto.RoleResponse;
import com.my.market.auth.persistence.repository.RoleRepository;
import com.my.market.auth.util.mapper.RoleMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper mapper;

    @Override
    public RoleResponse getRoleByName(String roleName) {

        RoleEntity role = roleRepository.findRoleEntitiesByName(RoleName.fromName(roleName))
                .orElseThrow(() -> new EntityNotFoundException("Role not found with name: " + roleName));
        RoleResponse response = mapper.roleEntityToResponse(role);
        return response;
    }

    @Override
    public List<RoleResponse> getAllRoles() {
        return mapper.rolesToListResponse(roleRepository.findAll());
    }


}
