package com.valtech;

import com.valtech.Exception.ItemException;
import com.valtech.model.Item;

import java.math.BigDecimal;

/**
 * Created by admin on 26/05/2016.
 */
public class ItemFactory {

    static Item APPLE = new Item("Apple", new BigDecimal("0.60"));
    static Item ORANGE = new Item("Orange", new BigDecimal("0.25"));

    public static Item getProduct(String product) {
        if ("Apple".equals(product)) {
            return APPLE;
        }
        if ("Orange".equals(product)) {
            return ORANGE;
        }
        throw new ItemException(product + "is not defined");
    }
}
