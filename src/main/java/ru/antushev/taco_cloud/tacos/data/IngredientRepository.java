package ru.antushev.taco_cloud.tacos.data;

import ru.antushev.taco_cloud.tacos.enums.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);
}
