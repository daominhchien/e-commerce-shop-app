package com.devteria.identityservice.controller;

import com.devteria.identityservice.dto.request.ApiResponse;
import com.devteria.identityservice.dto.request.CategoryRequest;
import com.devteria.identityservice.dto.request.CategoryUpdateRequest;
import com.devteria.identityservice.dto.response.CategoryResponse;
import com.devteria.identityservice.dto.response.PermissionResponse;
import com.devteria.identityservice.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CategoryController {

    CategoryService categoryService;

    @PostMapping("/create")
    ApiResponse<CategoryResponse> create(@RequestBody CategoryRequest request) {
        return ApiResponse.<CategoryResponse>builder()
                .result(categoryService.create(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<CategoryResponse>> getAll() {
        return ApiResponse.<List<CategoryResponse>>builder()
                .result(categoryService.getAll())
                .build();
    }

    @PutMapping("/{id}")
    ApiResponse<CategoryResponse> update( @PathVariable Long id,
                                          @RequestBody CategoryUpdateRequest request){

        return ApiResponse.<CategoryResponse>builder()
                .result(categoryService.update(id,request))
                .build();

    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        categoryService.delete(id);

    }


}
