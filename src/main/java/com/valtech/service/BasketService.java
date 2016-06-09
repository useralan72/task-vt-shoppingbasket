package com.valtech.service;

import com.valtech.model.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 26/05/2016.
 */
public interface BasketService {

    /**
     * Get the total cost for a string array of items
     * @param items
     * @return
     */
    BigDecimal getTotalCost(List<String> items);

    /**
     * Take into account offers
     * @param items
     * @return
     */
    BigDecimal getTotalCostWithOffers(List<String> items);
}
