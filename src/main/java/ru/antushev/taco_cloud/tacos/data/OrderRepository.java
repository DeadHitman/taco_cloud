package ru.antushev.taco_cloud.tacos.data;

import ru.antushev.taco_cloud.tacos.entity.Order;

public interface OrderRepository {

    Order save(Order order);

}
