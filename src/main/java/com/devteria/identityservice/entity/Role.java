package com.devteria.identityservice.entity;

import java.util.Set;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Table(name = "roles")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Role {
    @Id
    String name;

    @Column(name="description")
    String description;

    // nhiu nhiu vs permissions
    @ManyToMany
    Set<Permission> permissions;
}
