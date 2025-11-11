package com.devteria.identityservice.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@Table(name = "product_image")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ProductImage {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    Long id;

    @Column(name="image_url")
    String imageUrl;

    // 1> nhieu anh thuoc ve 1 product
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

}
