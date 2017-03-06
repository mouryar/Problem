package com.teksys.problem;

import java.util.LinkedHashMap;
import java.util.Map;

import com.teksys.problem.model.Item;
import com.teksys.problem.model.Order;
import com.teksys.problem.model.OrderLine;
import com.teksys.problem.service.CalculatorService;

public class Foo {

	public static void main(String[] args) throws Exception {

		Map<String, Order> o = new LinkedHashMap<String, Order>();

		Order c = new Order();

		c.add(new OrderLine(new Item.ItemBuilder().description("book").price((float) 12.49).build(), 1));
		c.add(new OrderLine(new Item.ItemBuilder().description("music CD").price((float) 14.99).build(), 1));
		c.add(new OrderLine(new Item.ItemBuilder().description("chocolate bar").price((float) 0.85).build(), 1));

		o.put("Order 1", c);

		// Reuse cart for an other order
		c = new Order();

		c.add(new OrderLine(new Item.ItemBuilder().description("imported box of chocolate").price(10).build(), 1));
		c.add(new OrderLine(
				new Item.ItemBuilder().description("imported bottle of perfume").price((float) 47.50).build(), 1));

		o.put("Order 2", c);

		// Reuse cart for an other order
		c = new Order();

		c.add(new OrderLine(
				new Item.ItemBuilder().description("Imported bottle of perfume").price((float) 27.99).build(), 1));
		c.add(new OrderLine(new Item.ItemBuilder().description("bottle of perfume").price((float) 18.99).build(), 1));
		c.add(new OrderLine(new Item.ItemBuilder().description("packet of headache pills").price((float) 9.75).build(),
				1));
		c.add(new OrderLine(
				new Item.ItemBuilder().description("box of imported chocolates").price((float) 11.25).build(), 1));

		o.put("Order 3", c);

		new CalculatorService().calculate(o);

	}
}
