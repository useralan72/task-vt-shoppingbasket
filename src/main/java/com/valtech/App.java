package com.valtech;

import com.valtech.service.BasketService;
import com.valtech.service.BasketServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Arrays;

public class App {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		for (String s: args) {
			LOGGER.debug("Program input is " + s);
		}

		BasketService basketService = new BasketServiceImpl();
		//first convert the input
		for (String arg: args) {
			basketService.addItem(ItemFactory.getProduct(arg));
		}
		BigDecimal total = basketService.getTotalCost();
		LOGGER.debug("Total is " + total);
	}

}
