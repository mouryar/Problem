package com.teksys.problem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.teksys.problem.model.Item;

public class ItemTest {

	@Test
	public void testItem() {
		Item item = new Item.ItemBuilder().description("book").price((float) 12.49).build();
		
		assertEquals("book", item.getDescription());
		assertTrue((float)12.49 == item.getPrice());
	}

}
