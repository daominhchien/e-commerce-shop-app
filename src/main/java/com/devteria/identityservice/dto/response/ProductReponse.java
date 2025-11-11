package com.devteria.identityservice.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductReponse {
    Long id;
    String name;
    Long price;
    String thumbnail;
    String description;
    String categoryName;
    List<String> productImageUrl;

}
