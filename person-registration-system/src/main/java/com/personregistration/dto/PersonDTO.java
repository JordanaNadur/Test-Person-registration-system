package com.personregistration.dto;

import com.personregistration.model.Sex;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PersonDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    private Sex sex;

    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotBlank(message = "Birthplace is required")
    private String birthplace;

    @NotBlank(message = "Nationality is required")
    private String nationality;

    @NotBlank(message = "CPF is required")
    @Pattern(regexp = "\\d{11}", message = "CPF must have 11 digits")
    private String cpf;

    private String observation;
}
