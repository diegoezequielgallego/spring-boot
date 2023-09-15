package com.candoit.test.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private String roles;
}
