package com.teksys.problem.model;

import java.util.ArrayList;
import java.util.List;

/******************************************************************************************
 * Order holds list of {@link OrderLine}. 
 * @author mouryakumarreddyrajala
 ********************************************************************************************/
public class Order {

	private List<OrderLine> orderLines;
	
	public Order() {
		orderLines = new ArrayList<>();
	}

	/**
	 * Adds will add OrderLine to orderLines arrayList.
	 * @param {@link OrderLine}
	 */
	public void add(OrderLine orderLine) throws IllegalArgumentException {
		if (orderLine == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		orderLines.add(orderLine);
	}

	/**
	 * Return size of orderLines 
	 * @return length
	 */
	public int size() {
		return orderLines.size();
	}

	/**
	 * Return order line at a given index in orderLines
	 * @param int index
	 * @return {@link OrderLine}
	 */
	public OrderLine get(int i) {
		return orderLines.get(i);
	}
	
	/**
	 * Return all orderLines
	 * @return List<{@link OrderLine}>
	 */
	public List<OrderLine> get() {
		return orderLines;
	}

	/**
	 * clear all orderLines
	 */
	public void clear() {
		this.orderLines.clear();
	}
}
