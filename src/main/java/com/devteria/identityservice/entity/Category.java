package com.devteria.identityservice.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "category")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    Long id;
    @Column(name = "name")
    String name;

    // 1 category có nhiều product
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY )
    @JsonIgnore
    @Builder.Default
    List<Product> product = new ArrayList<>();




}
