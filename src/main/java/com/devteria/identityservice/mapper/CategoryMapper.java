package com.devteria.identityservice.mapper;

import com.devteria.identityservice.dto.request.CategoryRequest;
import com.devteria.identityservice.dto.request.CategoryUpdateRequest;
import com.devteria.identityservice.dto.request.UserUpdateRequest;
import com.devteria.identityservice.dto.response.CategoryResponse;
import com.devteria.identityservice.entity.Category;
import com.devteria.identityservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // chuyen dto sang entity
    Category toCategory(CategoryRequest request);
    // chuyen entity sang dto
    CategoryResponse toCategoryResponse(Category category);

    // Khi cập nhật thông tin user, không được ghi đè hoặc thay đổi field roles
    void updateCategory(@MappingTarget Category category, CategoryUpdateRequest request);

}