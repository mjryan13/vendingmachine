package com.techelevator.Items;

public class ItemChips extends VendingItems {

	public ItemChips(String name, String price) {
		super(name, price);
	}

	@Override
	public String itemSound() {
		return "Crunch Crunch, Yum!";
	}

}
