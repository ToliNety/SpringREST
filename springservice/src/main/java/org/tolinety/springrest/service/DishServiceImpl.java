package org.tolinety.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.tolinety.springrest.model.Dish;
import org.tolinety.springrest.repository.DishRepository;

import java.util.List;

import static org.tolinety.springrest.util.ValidationUtil.checkNew;
import static org.tolinety.springrest.util.ValidationUtil.checkNotFoundWithId;

/**
 * Created by tolin on 18.06.2017.
 */
@Service
public class DishServiceImpl implements DishService {
    @Autowired
    DishRepository repository;

    @Override
    public List<Dish> getAllByRestaurant(int restaurantId) {
        return repository.getByRestaurant(restaurantId);
    }

    @Override
    public Dish create(Dish dish, int restaurantId) {
        Assert.notNull(dish);
        checkNew(dish);
        return checkNotFoundWithId(repository.save(dish, restaurantId), restaurantId);
    }

    @Override
    public Dish update(Dish dish, int restaurantId) {
        Assert.notNull(dish);
        return checkNotFoundWithId(repository.save(dish, restaurantId), restaurantId);
    }

    @Override
    public Dish get(int id) {
        return repository.get(id);
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }
}