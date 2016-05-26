package com.valtech.service;

import com.valtech.ItemFactory;
import com.valtech.model.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class BasketServiceImplTest {

	BasketService basketService;

	Item apple;
	Item orange;
	
	@Before
	public void setUp() {
		basketService = new BasketServiceImpl();
		apple = ItemFactory.getProduct("Apple");
		orange = ItemFactory.getProduct("Orange");
	}

	@Test
	public void shouldAddAnItemToTheBasket() {
		//WHEN
		basketService.addItem(apple);

		//THEN
		assertTrue(basketService.getAllItems().containsKey(apple));
		assertTrue(basketService.getAllItems().size() == 1);
	}
	
	@Test
	public void shouldGiveTotalGivenListOfItems() {
		//WHEN
		basketService.addItem(apple);
		basketService.addItem(apple);
		basketService.addItem(apple);
		basketService.addItem(orange);
				
		BigDecimal result = basketService.getTotalCost();
		Assert.assertNotNull(result);
		Assert.assertEquals(new BigDecimal("2.05"), result);
		
	}

}
