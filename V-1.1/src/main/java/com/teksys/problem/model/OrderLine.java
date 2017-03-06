package com.teksys.problem.model;

/******************************************************************************************
 * represents an order line which contains the {@link Item} and the quantity.
 * @author mouryakumarreddyrajala
 ********************************************************************************************/
public class OrderLine {

	private int quantity;
	private Item item;

	/**
	 * @param item {@link Item} of the order
	 * @param quantity Quantity of the item
	 */
	public OrderLine(Item item, int quantity) throws IllegalArgumentException {
		if (item == null) {
			System.err.println("ERROR - Item is NULL");
			throw new IllegalArgumentException("Item is NULL");
		}
		assert quantity > 0;
		this.item = item;
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}
}