package com.devteria.identityservice.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@Table(name = "social_accounts")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class SocialAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    Long id;
    @Column (name = "provider")
    String provider;
    @Column (name = "provider_id ")
    String provider_id;
    @Column (name = "email")
    String email;
    @Column (name = "name")
    String name;

    // nhiều tài khoản thuộc về 1 user
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;



}
