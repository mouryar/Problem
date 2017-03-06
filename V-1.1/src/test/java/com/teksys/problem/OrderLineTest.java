package com.teksys.problem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.teksys.problem.model.Item;
import com.teksys.problem.model.OrderLine;

public class OrderLineTest {
	
	@Test
	public void orderLineTest() throws IllegalArgumentException {
		
		Item item = new Item.ItemBuilder().description("book").price((float) 12.49).build();
		OrderLine orderLine = new OrderLine(item, 1);
		assertEquals(1, orderLine.getQuantity());
		assertEquals(item, orderLine.getItem());
		
	}

	

}
