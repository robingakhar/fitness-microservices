package com.fitness.userservice.models;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
private String firstName;
private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
private UserRole role = UserRole.USER;

    @CreationTimestamp
private LocalDate createdAt;

    @UpdateTimestamp
private LocalDate updatedAt;


}
