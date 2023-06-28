package com.geekster.UserManagement.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Integer userId;
    @Size(min = 3, max = 50)
    private String userName;
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date of birth should be in the format 'yyyy-MM-dd'")

    private String userDOB;

@Email
    private String email;
    @Pattern(regexp = "\\d{2}\\d{10}")
    private String phoneNumber;
    private LocalDate date;



}
