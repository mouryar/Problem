package com.teksys.problem.service;

import java.util.Map;

import com.teksys.problem.model.Order;
import com.teksys.problem.model.OrderLine;

/******************************************************************************************
 * Calculator service helps to get total gross amount, total service tax of list of orders.
 * @author mouryakumarreddyrajala
 ********************************************************************************************/

public class CalculatorService {

	/**
	 * receives a collection of orders. For each order, iterates on the order
	 * lines and calculate the total price which is the item's price * quantity
	 * * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without
	 * taxes for this order
	 * 
	 * @param ordersMap Map<{@link String}, {@link Order}>
	 */
	public double calculate(Map<String, Order> ordersMap) {

		double grandtotal = 0;

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : ordersMap.entrySet()) {
			
			System.out.println("*******" + entry.getKey() + "*******");
			Order r = entry.getValue();
			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order

			for (OrderLine orderLine : r.get()) {

				// Calculate the taxes
				double tax = 0;
				if (orderLine.getItem().getDescription().contains("imported")) {
					tax = orderLine.getItem().getPrice() * 0.15; // Extra 5% tax
					// imported items
				} else {
					tax = orderLine.getItem().getPrice() * 0.10;
				}
				// Calculate the total price
				double totalprice = orderLine.getItem().getPrice() + tax;
				// Print out the item's total price
				System.out.println(orderLine.getQuantity() + " " + orderLine.getItem().getDescription() + ": "
						+ Math.ceil(totalprice * 100) / 100);
				// Keep a running total
				totalTax += tax;
				total += orderLine.getItem().getPrice();
			}

			// Print out the total taxes
			System.out.println("Sales Tax: " + rounding(totalTax));
			total = total + totalTax;

			// Print out the total amount
			System.out.println("Total: " + rounding(total));
			grandtotal += total;
		}

		System.out.println("Sum of orders: " + rounding(grandtotal));
		return rounding(grandtotal);
	}

	private double rounding(double totalTax) {
		return Math.floor(totalTax * 100) / 100;
	}
	
	
}