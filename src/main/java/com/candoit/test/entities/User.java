package com.candoit.test.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "app_user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private boolean enabled;
    private String roles; // Una cadena que almacena roles separados por comas, por ejemplo: "ROLE_USER,ROLE_ADMIN"
}
