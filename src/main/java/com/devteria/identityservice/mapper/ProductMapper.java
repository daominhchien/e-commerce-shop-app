package com.devteria.identityservice.mapper;

import com.devteria.identityservice.dto.request.ProductRequest;

import com.devteria.identityservice.dto.response.ProductReponse;
import com.devteria.identityservice.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    // chuyen dto sang entity
    Product toProduct(ProductRequest request);
    // chuyen entity sang dto
    ProductReponse  toProductResponse(Product product);
}
