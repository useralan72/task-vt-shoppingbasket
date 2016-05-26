package com.valtech.model;

import com.valtech.Exception.ItemException;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * Created by admin on 26/05/2016.
 */
public final class Item {

    private String name;
    private BigDecimal price;
    private Offer offer;

    public Item(String name, BigDecimal price, Offer offer) {
        //name validation
        if (StringUtils.isEmpty(name)) {
            throw new ItemException("name cannot be empty");
        }
        //price validation
        if (price == null) {
            throw new ItemException("price cannot be null");
        }
        this.name = name;
        this.price = price;
        this.offer = offer;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Offer getOffer() {
        return offer;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", price=" + price + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!name.equals(item.name)) return false;
        if (!price.equals(item.price)) return false;
        return offer == item.offer;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + offer.hashCode();
        return result;
    }
}
