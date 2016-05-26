package com.valtech.service;

import com.valtech.model.Item;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by admin on 26/05/2016.
 */
public interface BasketService {

    /**
     * Add an Item to the basket
     * @param item
     */
    void addItem(Item item);

    /**
     * Get the total cost of all Items in the basket
     * @return
     */
    BigDecimal getTotalCost();

    /**
     * Get all the items and count
     * @return
     */
    Map<Item, Integer> getAllItems();
}
