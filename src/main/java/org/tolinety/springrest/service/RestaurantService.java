package org.tolinety.springrest.service;

import org.tolinety.springrest.model.Restaurant;
import org.tolinety.springrest.model.Vote;

import java.util.List;

/**
 * Created by ToliNeTy on 04.03.2017.
 */
public interface RestaurantService {
    List<Restaurant> getAll();

    List<Vote> getVotes();
}
