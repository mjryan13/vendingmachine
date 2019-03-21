package com.techelevator.Items;


import java.math.BigDecimal;

public abstract  class VendingItems {

	private String name;
	private BigDecimal price;

	public VendingItems(String name, String price) {

		this.name = name;
		this.price = new BigDecimal(price);

	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	public abstract String itemSound();

}
