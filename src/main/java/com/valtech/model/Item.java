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

    public Item(String name, BigDecimal price) {
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
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", price=" + price + "]";
    }

}
