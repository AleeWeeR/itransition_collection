package com.itransition.appusercollection.payload;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterDto {

    @NotNull(message = "Username is required")
    String username;

    @NotNull(message = "Password is required")
    String password;

    @NotNull(message = "Password confirm is required")
    String passwordConfirm;

    @NotNull(message = "email is required")
    String email;

}
