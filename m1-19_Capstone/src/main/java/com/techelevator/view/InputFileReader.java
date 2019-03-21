package com.techelevator.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



/*
 * JOB: Read a file and Split in "|".
 * add the value and items to the vendingItems
 */
public class InputFileReader {

	public Map<String, List<VendingItems>> readVendingItem(String path) throws IOException {
		
		Map<String, List<VendingItems>> vendingItems = new HashMap<>();
		File vendingSlot = new File(path);
		try (Scanner reader = new Scanner(vendingSlot)) {
			String fileLine = reader.nextLine();
			List<VendingItems> items = new ArrayList<>();
			String[] parts = fileLine.split("//|");
			if (parts[0].startsWith("A")) {
				for (int i = 0; i < 5; i++) {
					items.add(new ItemChips(parts[1], parts[2]));
				}
				vendingItems.put(parts[0], items);
			}
			 else if (parts[0].startsWith("B")) {
				for (int i = 0; i < 5; i++) {
					items.add(new ItemCandy(parts[1], parts[2]));
				}
				vendingItems.put(parts[0], items);
			} else if (parts[0].startsWith("C")) {
				for (int i = 0; i < 5; i++) {
					items.add(new ItemBeverage(parts[1], parts[2]));
				}
				vendingItems.put(parts[0], items);
			}
			else if (parts[0].startsWith("D")) {
				for (int i = 0; i < 5; i++) {
					items.add(new ItemGum(parts[1], parts[2]));
				}
				vendingItems.put(parts[0], items);
			} 
		}

		return vendingItems;

	}
}
