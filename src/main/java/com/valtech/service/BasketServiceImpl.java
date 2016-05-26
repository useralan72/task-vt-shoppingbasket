package com.valtech.service;

import com.valtech.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by admin on 10/05/2016.
 */
public class BasketServiceImpl implements BasketService{
    private static final Logger LOGGER = LoggerFactory.getLogger(BasketServiceImpl.class);

    Map<Item, Integer> itemCountMap;

    public BasketServiceImpl() {
        this.itemCountMap = new HashMap<>();
    }
    @Override
    public void addItem(Item item) {
        itemCountMap.compute(item, (k, v) -> (v == null) ? new Integer("1") : v + 1);
    }

    public Map<Item, Integer> getAllItems() {
        return Collections.unmodifiableMap(itemCountMap);
    }

    @Override
    public BigDecimal getTotalCost() {
        BigDecimal runningTotal = BigDecimal.ZERO;
        for (Item item: itemCountMap.keySet()) {
            runningTotal = runningTotal.add(
                    item.getPrice().multiply(new BigDecimal(itemCountMap.get(item).intValue()))
            );
        }
        return runningTotal;
    }
}
