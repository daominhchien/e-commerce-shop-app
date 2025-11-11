package com.devteria.identityservice.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "username", unique = true, columnDefinition = "VARCHAR(255) COLLATE utf8mb4_unicode_ci")
    String username;
    @Column(name = "password")
    String password;
    @Column(name="first_name")
    String firstName;
    @Column (name="last_name")
    String lastName;
    @Column(name = "date_of_birth")
    LocalDate dob;
    @Column(name="phone_number")
    String phoneNumber;
    @Column(name = "address")
    String address;
    @Column(name="is_active")
    Boolean isActive;
    @Column(name = "facebook_account_id")
    String facebookAccountId;
    @Column(name = "google_account_id")
    String googleAccountId;

    // 1> NHIU NHIU VS ROLE => ROLE_USER
    @ManyToMany
    Set<Role> roles;

    // 2> 1  user cos nhieu social ( ( khoong tao thuoc tinh trong bang )
    @OneToMany (mappedBy = "user", fetch = FetchType.LAZY )
    @JsonIgnore
    List<SocialAccount> socialAccounts = new ArrayList<>() ;

    // 3> 1 USER CO NHIU ORDER ( khoong tao thuoc tinh trong bang )
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    @Builder.Default
    List <Order> orders = new ArrayList<>() ;

}
