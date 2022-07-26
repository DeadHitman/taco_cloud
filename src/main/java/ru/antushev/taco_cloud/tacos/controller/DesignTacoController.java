package ru.antushev.taco_cloud.tacos.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import ru.antushev.taco_cloud.tacos.Design;
import ru.antushev.taco_cloud.tacos.data.IngredientRepository;
import ru.antushev.taco_cloud.tacos.data.TacoRepository;
import ru.antushev.taco_cloud.tacos.entity.Order;
import ru.antushev.taco_cloud.tacos.enums.Ingredient;

import ru.antushev.taco_cloud.tacos.enums.Ingredient.Type;
import ru.antushev.taco_cloud.tacos.entity.Taco;

import javax.validation.Valid;

@Slf4j
@Controller
@SessionAttributes("order")
@RequestMapping("/design")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;
    private TacoRepository designRepo;

    @Autowired
    public DesignTacoController(
            IngredientRepository ingredientRepo,
            TacoRepository designRepo) {
        this.ingredientRepo = ingredientRepo;
        this.designRepo = designRepo;
    }


    @GetMapping
    public String showDesignForm(Model model) {

        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));

        Type[] types = Type.values();
        for (Type type : types) {

            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        model.addAttribute("design", new Taco());

        return "design";

    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();

    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();

    }

    @PostMapping
    public String processDesign(
            @Valid Taco design, Errors errors, @ModelAttribute Order order) {

        if (errors.hasErrors()) {
            return "design";
        }

        log.info("Taco processDesign: " + design);


        Taco saved = designRepo.save(design);
        log.info("Taco saved: " + design);

        order.addDesign(saved);

        return "redirect:/orders/current";

    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {

        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());

    }

}