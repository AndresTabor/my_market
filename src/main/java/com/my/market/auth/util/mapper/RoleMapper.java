package com.my.market.auth.util.mapper;

import com.my.market.auth.domain.entity.RoleEntity;
import com.my.market.auth.dto.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "name", source = "name")
    RoleResponse roleEntityToResponse(RoleEntity role);

    List<RoleResponse> rolesToListResponse(List<RoleEntity> roles);
}
