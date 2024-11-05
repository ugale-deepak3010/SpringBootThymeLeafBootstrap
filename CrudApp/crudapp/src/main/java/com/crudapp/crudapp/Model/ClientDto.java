package com.crudapp.crudapp.Model;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    
    private long id;

    @NotEmpty(message = "First Name is required!")
    private String firstName;

    @NotEmpty(message = "Last Name is required!")
    private String lastName;

    @NotEmpty(message = "Email is required!")
    @Email(message = "Invalid Email!")
    private String email;

    private String phone;

    private String address;

    @NotEmpty(message = "Status is required!")
    private String status;
    private  LocalDate createdAt;
}
