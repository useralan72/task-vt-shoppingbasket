package com.valtech.service;

import com.valtech.ItemFactory;
import com.valtech.model.Item;
import com.valtech.model.Offer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by admin on 10/05/2016.
 */
public class BasketServiceImpl implements BasketService{
    private static final Logger LOGGER = LoggerFactory.getLogger(BasketServiceImpl.class);

    @Override
    public BigDecimal getTotalCost(List<String> items) {
        //map the string array to a list of items
        BigDecimal totalCost = items.stream()
                .map(s -> ItemFactory.getProduct(s))
                .map((x) -> x.getPrice()).reduce((x, y) -> x.add(y)).orElse(BigDecimal.ZERO);
        return totalCost;
    }

    @Override
    public BigDecimal getTotalCostWithOffers(List<String> items) {

        Map<Item, Long> itemCountMap = items.stream()
                .map(s -> ItemFactory.getProduct(s))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //update totals
        itemCountMap.replaceAll((key, value) -> determineOfferTotal(key.getOffer(), value));
        //BigDecimal sum = itemCountMap.entrySet().stream().reduce((x, y) -> x.getKey().getPrice().multiply(y.getValue()));

        BigDecimal runningTotal = BigDecimal.ZERO;
        for (Item item: itemCountMap.keySet()) {
            runningTotal = runningTotal.add(
                    item.getPrice().multiply(new BigDecimal(itemCountMap.get(item).intValue()))
            );
        }
        return runningTotal;
    }

    private Long determineOfferTotal(Offer offer, Long total) {
        if (offer == null) {
           return total;
        }
        if (offer.equals(Offer.BOGOF)) {
            return (total/2 + total%2);
        }
        if (offer.equals(Offer.THREEFORTWO)) {
            return (total / 3) * 2 + (total % 3);
        }
        return total;
    }
}
