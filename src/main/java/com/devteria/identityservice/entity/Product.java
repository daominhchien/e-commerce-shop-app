package com.devteria.identityservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "products")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Product {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "price")
    Long price;
    @Column(name="thumbnail")
    String thumbnail;
    @Column (name = "description")
    String description;


    // 1> nhiều product thuộc nhiều về category
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    // 2> 1 prduct co nhiu product_image
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore
    @Builder.Default
    List <ProductImage> productImages = new ArrayList<>();

    // 3> 1 product cos nhiue order_details
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore
    @Builder.Default
    List<OrderDetail> orderDetails = new ArrayList<>();







}
