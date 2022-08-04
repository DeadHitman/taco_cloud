package ru.antushev.taco_cloud.tacos.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Order {

    private Long id;

    private Date placedAt;

    @NotBlank(message="Name is required")
    @Size(max=50, message="City must be at least 50 characters long")
    private String name;

    @NotBlank(message="Street is required")
    @Size(max=50, message="Street must be at least 50 characters long")
    private String street;

    @NotBlank(message="City is required")
    @Size(max=50, message="City must be at least 50 characters long")
    private String city;

    @NotBlank(message="State is required")
    @Size(min=2, message="State must be at least 2 characters long")
    @Size(max=2, message="State must be at least 2 characters long")
    private String state;

    @NotBlank(message="Zip code is required")
    @Size(max=10, message="Zip must be at least 10 characters long")
    private String zip;

    @NotBlank(message="CCNumber code is required")
    @Size(max=16, message="CCNumber must be at least 16 characters long")
//    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;

    @NotBlank(message="ccExpiration code is required")
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message="Must be formatted MM/YY")
    private String ccExpiration;

    @NotBlank(message="ccCVV code is required")
    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }


}