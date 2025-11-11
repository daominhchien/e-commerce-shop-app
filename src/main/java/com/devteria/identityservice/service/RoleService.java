package com.devteria.identityservice.service;

import java.util.HashSet;
import java.util.List;

import com.devteria.identityservice.entity.Permission;
import com.devteria.identityservice.entity.Role;
import com.devteria.identityservice.exception.AppException;
import com.devteria.identityservice.exception.ErrorCode;
import org.springframework.stereotype.Service;

import com.devteria.identityservice.dto.request.RoleRequest;
import com.devteria.identityservice.dto.response.RoleResponse;
import com.devteria.identityservice.mapper.RoleMapper;
import com.devteria.identityservice.repository.PermissionRepository;
import com.devteria.identityservice.repository.RoleRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

    public RoleResponse create(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAll() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

    public void delete(String role) {
        roleRepository.deleteById(role);
    }

    public void removePermissionRole(String rolename, String permissionname){
        // b1: tim
        Role role = roleRepository.findById(rolename).orElseThrow(()-> new ArithmeticException("Khong tim thay user"));


        // b2: tim permission
        Permission permission = permissionRepository.findById(permissionname)
                .orElseThrow(() -> new ArithmeticException("Permission not found: " + permissionname));


        // b3: xoa

        role.getPermissions().remove(permission);

        // 4: luu lia

        roleRepository.save(role);
    }


}
