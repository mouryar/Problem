package com.teksys.problem.model;

/******************************************************************************************
 * represents an item, contains a price and a description.
 * @author mouryakumarreddyrajala
 ********************************************************************************************/
public class Item {

	private String description;
	private float price;

	private Item(String description, float price) {
		super();
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public float getPrice() {
		return price;
	}

	public static class ItemBuilder {
		
		private String description;
		private float price;

		public ItemBuilder description(String description)
		{
			this.description = description;
			return this;
		}
		
		public ItemBuilder price(float price)
		{
			this.price = price;
			return this;
		}
		
		public Item build()
		{
			return new Item(this.description,this.price);
		}
	}
}
