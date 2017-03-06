package com.teksys.problem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.teksys.problem.model.Item;
import com.teksys.problem.model.Order;
import com.teksys.problem.model.OrderLine;
import com.teksys.problem.service.CalculatorService;

public class CalculatorServiceTest {
	
	@Test
	public void caluculateTest() throws Exception
	{
		Map<String, Order> o = new LinkedHashMap<String, Order>();
		Order c = new Order();
		c.add(new OrderLine(new Item.ItemBuilder().description("book").price((float) 12.49).build(), 1));
		c.add(new OrderLine(new Item.ItemBuilder().description("music CD").price((float) 14.99).build(), 1));
		c.add(new OrderLine(new Item.ItemBuilder().description("chocolate bar").price((float) 0.85).build(), 1));

		o.put("Order 1", c);
		assertTrue(31.16 == new CalculatorService().calculate(o));
		
	}
	
	@Test
	public void emptyCaluculateTest() throws Exception
	{
		Map<String, Order> o = new LinkedHashMap<String, Order>();
		Order c = new Order();

		o.put("Order 1", c);
		assertTrue(0 == new CalculatorService().calculate(o));
		
	}

}
