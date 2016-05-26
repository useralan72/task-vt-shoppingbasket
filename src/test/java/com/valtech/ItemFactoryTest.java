package com.valtech;

import com.valtech.model.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by admin on 26/05/2016.
 */
public class ItemFactoryTest {

    @Test
    public void shouldGiveAppleWhenInputIsApple() {
        String productInput = "Apple";

        Item item = ItemFactory.getProduct(productInput);

        assertNotNull(item);
        assertEquals(item, ItemFactory.APPLE);
    }

    @Test
    public void shouldGiveOrangeWhenInputIsOrange() {
        String productInput = "Orange";

        Item item = ItemFactory.getProduct(productInput);

        assertNotNull(item);
        assertEquals(item, ItemFactory.ORANGE);
    }
}
