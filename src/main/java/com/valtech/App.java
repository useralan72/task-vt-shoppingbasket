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
		//first get total not including offers
		BigDecimal total = basketService.getTotalCost(Arrays.asList(args));
		LOGGER.debug("Total is " + total);

		//first get total not including offers
		BigDecimal totalWithOffers = basketService.getTotalCostWithOffers(Arrays.asList(args));
		LOGGER.debug("Total with offers is " + totalWithOffers);
	}

}
