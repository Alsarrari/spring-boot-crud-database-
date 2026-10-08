package com.employee_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Value;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank(message = "The name must not be blank")
    @Size(min = 2 , max = 100)
    private String name;
    @NotBlank(message = "The author must not be blank")
    private String author;
    @NotBlank(message = "The category must not be blank")
    private String category;
    @Positive(message = "The price must be positive.")
    private double price;
    @NotBlank(message = "The email must not be blank")
    @Email
    private String email;

}
