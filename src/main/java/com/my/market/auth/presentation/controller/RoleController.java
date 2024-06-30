package com.my.market.auth.presentation.controller;

import com.my.market.auth.dto.RoleResponse;
import com.my.market.auth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/{name}")
    public ResponseEntity<RoleResponse> getRoleByName(@PathVariable String name){
        return ResponseEntity.ok(
                roleService.getRoleByName(name)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoleResponse>> getAllRoles(){
        return ResponseEntity.ok(
                roleService.getAllRoles()
        );
    }
}
