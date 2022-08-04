package ru.antushev.taco_cloud.tacos.data;

import ru.antushev.taco_cloud.tacos.entity.Taco;

public interface TacoRepository {

    Taco save(Taco design);

}
