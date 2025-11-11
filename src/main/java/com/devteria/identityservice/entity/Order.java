package com.devteria.identityservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Table(name = "orders")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    Long id;

    @Column(name = "fullname", length = 100)
    private String fullName;

    @Column(name = "email", length = 100)
    String email;

    @Column(name = "phone_number",nullable = false, length = 100)
    String phoneNumber;

    @Column(name = "address", length = 100)
    String address;

    @Column(name = "note", length = 100)
    String note;

    @Column(name="order_date")
    Date orderDate;

    @Column(name = "status")
    String status;

    @Column(name = "total_money")
    Integer totalMoney;

    @Column(name = "shipping_method")
    String shippingMethod;

    @Column(name = "shipping_address")
    String shippingAddress;

    @Column(name = "shipping_date")
    LocalDate shippingDate;

    @Column(name = "tracking_number")
    String trackingNumber;

    @Column(name = "payment_method")
    String paymentMethod;

    @Column(name = "active")
    Boolean active;//thuộc về admin

    // Nhiều đơn hàng thuộc về 1 user
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    // 1 order thuoc ve nhiu ordertails
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @JsonIgnore
    @Builder.Default
    List <OrderDetail> orderDetails = new ArrayList<>() ;




}
