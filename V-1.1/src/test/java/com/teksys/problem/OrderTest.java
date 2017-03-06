package com.teksys.problem;


import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.teksys.problem.model.Item;
import com.teksys.problem.model.Order;
import com.teksys.problem.model.OrderLine;


public class OrderTest {
	
	
	@Test
	public void emptyOrderTest()
	{
		Order c = new Order();
		assertEquals(0, c.size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addOrderIllegalArgumentExceptionTest() throws IllegalArgumentException
	{
		Map<String, Order> o = new LinkedHashMap<String, Order>();
		Order c = new Order();
		c.add(null);
		
	}
	
	@Test
	public void ordersizeTest()
	{

		Order c = new Order();

		c.add(new OrderLine(new Item.ItemBuilder().description("book").price((float) 12.49).build(), 1));
		c.add(new OrderLine(new Item.ItemBuilder().description("music CD").price((float) 14.99).build(), 1));
		c.add(new OrderLine(new Item.ItemBuilder().description("chocolate bar").price((float) 0.85).build(), 1));

		assertEquals(3, c.size());
	}
	
	@Test
	public void getOrderLineByIndexTest()
	{
		Order c = new Order();
		Item item1 = new Item.ItemBuilder().description("book").price((float) 12.49).build();
		OrderLine orderLine = new OrderLine(item1, 1);
		c.add(orderLine);
		assertEquals(orderLine, c.get(0));
	}
}
