package com.personregistration.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Builder
public class AddressDTO {

    private Long id;

    @NotBlank(message = "Street is required")
    private String street;

    @NotBlank(message = "Number is required")
    private String number;

    private String complement;

    @NotBlank(message = "Neighborhood is required")
    private String neighborhood;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    @Pattern(regexp = "[A-Z]{2}", message = "State must be a valid 2-letter code")
    private String state;

    @NotBlank(message = "ZIP code is required")
    @Pattern(regexp = "\\d{8}", message = "ZIP code must have 8 digits")
    private String zipCode;

    // Constructors
    public AddressDTO() {}

    public AddressDTO(Long id, String street, String number, String complement, 
                      String neighborhood, String city, String state, String zipCode) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

}
