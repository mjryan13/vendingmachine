package com.techelevator.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Items.VendingItems;

public class VendingMachine {

	private Map<String, List<VendingItems>> vendingInventory;
	private BigDecimal balance = BigDecimal.ZERO;
	
	//FileWriter logFile = new FileWriter("logFile.txt");
	
	public VendingMachine(Map<String, List<VendingItems>> vendingInventory) throws FileNotFoundException {
		this.vendingInventory = vendingInventory;
	}
	
	public String getInventory() {
		ArrayList<String> outPut = new ArrayList<String>();
		String getRandomName = " ";
		for (String getKey: vendingInventory.keySet()) {
			outPut.add(getKey);
			Collections.sort(outPut);
		}
		for (String keyValue : outPut) {
			if (!vendingInventory.get(keyValue).isEmpty()) {
				getRandomName += keyValue + "|" + vendingInventory.get(keyValue).get(0).getName() +": $"+ vendingInventory.get(keyValue).get(0).getPrice();
			}
		}
		return getRandomName;
		
	}
	public void feedMoney(BigDecimal money) {
		balance = balance.add(money);
		String messageForLog = "Feed Money";
		messageForLog = messageForLog + "$ " + money + "$ " + balance;
		//logFile.logFile(messageForLog);
		
	}
	public String returnPurchase(String userChoice) {
		String indexKey = userChoice.substring(0, 2);
		List<VendingItems> inventoryPurchaseReturn = new ArrayList<>();
		VendingItems hold;
		if (inventoryPurchaseReturn.get(0).getPrice().compareTo(balance) < 1) {
			balance = balance.subtract(inventoryPurchaseReturn.get(0).getPrice());
			String messageForLog = userChoice + " ";
			//logFile.logFile(messageForLog);
			
			hold = inventoryPurchaseReturn.remove(0);
			vendingInventory.put(indexKey, inventoryPurchaseReturn);
		return hold.itemSound();
		}
		
		return "Not enough balance";
		
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public CashRegister zeroBalance() {
		CashRegister refund = new CashRegister(balance);
		balance = BigDecimal.ZERO;
		
		return refund;
		
		
	}
	
	
	
	
	 

}
