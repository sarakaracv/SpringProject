package com.cydeo.dto;

import com.cydeo.enums.UserRole;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String email;
    private String password;
    private String username;
    private UserRole role;
    private AccountDTO account;

}
