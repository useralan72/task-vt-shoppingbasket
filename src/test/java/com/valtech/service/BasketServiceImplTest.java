package com.valtech.service;

import com.valtech.ItemFactory;
import com.valtech.model.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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
	public void shouldGiveTotalGivenStringListOfItems() {
		//WHEN
		List<String> basketList = Arrays.asList("Apple", "Apple", "Apple", "Orange");

		BigDecimal result = basketService.getTotalCost(basketList);
		Assert.assertNotNull(result);
		Assert.assertEquals(new BigDecimal("2.05"), result);

	}

	@Test
	public void shouldGiveTotalGivenStringListCountOfItems() {
		//WHEN - apples are bogof so should be 2 * apples + 2 * oranges
		List<String> basketList = Arrays.asList("Apple", "Apple", "Apple", "Orange", "Orange", "Orange");

		BigDecimal result = basketService.getTotalCostWithOffers(basketList);
		Assert.assertNotNull(result);
		Assert.assertEquals(new BigDecimal("1.70"), result);

	}

}
