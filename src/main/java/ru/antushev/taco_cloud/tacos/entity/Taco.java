package ru.antushev.taco_cloud.tacos.entity;

import java.util.Date;
import java.util.List;
import lombok.Data;
import ru.antushev.taco_cloud.tacos.enums.Ingredient;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

@Data
public class Taco {

    private Long id;

    private Date createdAt;

    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

}
