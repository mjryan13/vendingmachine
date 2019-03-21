package com.techelevator.Items;

public class ItemCandy extends VendingItems {

		public ItemCandy(String name, String price) {
			super(name, price);
		}

		@Override
		public String itemSound() {
			return "Munch Munch, Yum!";
		}

	}


