package com.devteria.identityservice.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Table(name = "order_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    Long id;
    @Column(name = "price")
    Long price;
    @Column (name = "number_of_products")
    Integer  numberOfProducts;
    @Column(name="total_money")
    Long totalMoney;
    @Column (name="color")
    String color;

    // Nhiều order_details thuộc về 1 orders
    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;


    // Nhiều order_details thuộc về 1 products
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;
}
