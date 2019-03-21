package com.techelevator;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.techelevator.view.CashRegister;
import com.techelevator.view.InputFileReader;
import com.techelevator.view.Menu;
import com.techelevator.view.VendingMachine;

import Items.VendingItems;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE };
	private static final String FEED_MONEY = "Feed Money";
	private static final String SELECT_PRODUCT = "Select Product";
	private static final String FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION}; 
	
	
	private static final String ONE_DOLLAR = "$1";
	private static final String TWO_DOLLAR = "$2";
	private static final String FIVE_DOLLAR = "$5";
	private static final String TEN_DOLLAR = "$10";
	private static final String[] FEEDING_MONEY_OPTION = {ONE_DOLLAR, TWO_DOLLAR, FIVE_DOLLAR,TEN_DOLLAR}; 
	
	private Menu menu;
	private VendingMachine vending;
	
	
	public  VendingMachineCLI(Menu menu, VendingMachine vending) {
		this.menu = menu;
		this.vending = vending;
		
		
	}
	
	public void run() {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				menu.printMessage(vending.getInventory());
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (true) {
					System.out.println("balance equals $ " + vending.getBalance());
			String purchaseMenu = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			if (purchaseMenu.equals(FEED_MONEY)) {
				String userMoneyChoice = (String) menu.getChoiceFromOptions(FEEDING_MONEY_OPTION);
			
			if (userMoneyChoice.equals(ONE_DOLLAR)) {
				vending.feedMoney(new BigDecimal("1.00"));
			}
			else if (userMoneyChoice.equals(TWO_DOLLAR)) {
				vending.feedMoney(new BigDecimal("2.00"));
			}
			else if (userMoneyChoice.equals(FIVE_DOLLAR)) {
				vending.feedMoney(new BigDecimal("5.00"));
			}
			else if (userMoneyChoice.equals(TEN_DOLLAR)) {
				vending.feedMoney(new BigDecimal("10.00"));
			}
			}
			else if (purchaseMenu.equals(SELECT_PRODUCT)) {
				String temp = vending.getInventory();
				String[] temp2 = temp.split("\n");
				String purchaseChoice = (String) menu.getChoiceFromOptions(temp2);
				System.out.println(vending.returnPurchase(purchaseChoice));
			}
			else if (purchaseMenu.equals(FINISH_TRANSACTION)) {
				CashRegister change = vending.zeroBalance();
				System.out.println("\n Your change is " + change);
				break;
			}
			
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		InputFileReader newFile = new InputFileReader();
		Map<String, List<VendingItems>> VendingItems = newFile.readVendingItem("vendingmachine.csv");
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu, new VendingMachine(VendingItems));
		cli.run();
	}
}
