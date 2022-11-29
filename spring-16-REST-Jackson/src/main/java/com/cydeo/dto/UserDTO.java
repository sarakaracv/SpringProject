package com.cydeo.dto;

import com.cydeo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;
    private String password;
    private String username;
    private UserRole role;

    @JsonManagedReference
    private AccountDTO account;

}
