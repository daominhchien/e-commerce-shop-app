package com.devteria.identityservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.devteria.identityservice.dto.request.UserCreationRequest;
import com.devteria.identityservice.dto.request.UserUpdateRequest;
import com.devteria.identityservice.dto.response.UserResponse;
import com.devteria.identityservice.entity.User;

@Mapper(componentModel = "spring") // thư viện
public interface UserMapper {
    // chuyển dto sang entity
    User toUser(UserCreationRequest request);

    // chuyển entity sang dto
    UserResponse toUserResponse(User user);

    // Khi cập nhật thông tin user, không được ghi đè hoặc thay đổi field roles
    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
