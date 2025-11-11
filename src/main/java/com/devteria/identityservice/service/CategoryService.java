package com.devteria.identityservice.service;

import com.devteria.identityservice.dto.request.CategoryRequest;
import com.devteria.identityservice.dto.request.CategoryUpdateRequest;
import com.devteria.identityservice.dto.response.CategoryResponse;
import com.devteria.identityservice.entity.Category;
import com.devteria.identityservice.mapper.CategoryMapper;
import com.devteria.identityservice.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CategoryService {
    CategoryMapper categoryMapper;
    CategoryRepository categoryRepository;

    public CategoryResponse create(CategoryRequest request){
        // build
        Category category = categoryMapper.toCategory(request);
        category = categoryRepository.save(category);
        return categoryMapper.toCategoryResponse((category));


    }

    public List<CategoryResponse> getAll() {
        var category = categoryRepository.findAll();
        return category.stream().map(categoryMapper::toCategoryResponse).toList();
    }

    public CategoryResponse update(Long id, CategoryUpdateRequest request) {
        // tim id
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ArithmeticException("Khong tim thay id"));
        // builde request sang enity
        categoryMapper.updateCategory(category, request);
        category = categoryRepository.save(category);
        return categoryMapper.toCategoryResponse((category));
    }

    public void delete(Long id){

        // tim id
        Category category = categoryRepository.findById(id).orElseThrow(()-> new ArithmeticException("khong tim duoc id"));
        categoryRepository.deleteById(id);
    }

}
