package com.techelevator.Items;

import java.math.BigDecimal;

public class ItemBeverage extends VendingItems {

	public ItemBeverage(String name, String price) {
		super(name, price);
	}

	@Override
	public String itemSound() {
		return "Glug Glug, Yum!";
	}

}
