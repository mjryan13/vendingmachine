package com.techelevator.Items;


public class ItemGum extends VendingItems {
	
	public ItemGum(String name, String price) {
		super(name, price);
		
	}
	
	@Override
	public String itemSound() {
		return "Chew Chew, Yum!";
	}

}
