package com.techelevator.view;

import java.math.BigDecimal;

public class CashRegister {
	
	private int quarter;
	private int dime;
	private int nickle;
	private BigDecimal changeCalculation;
	
	public CashRegister(BigDecimal changeCalculation) {
		this.changeCalculation = changeCalculation;
		
		while (changeCalculation.compareTo(new BigDecimal("0.25")) > -1) {
			changeCalculation = changeCalculation.subtract(new BigDecimal("0.25"));
			quarter += 1;
		}
		while (changeCalculation.compareTo(new BigDecimal("0.10")) > -1) {
			changeCalculation = changeCalculation.subtract(new BigDecimal("0.10"));
			dime += 1;
		}
		while (changeCalculation.compareTo(new BigDecimal("0.05")) > -1) {
			changeCalculation = changeCalculation.subtract(new BigDecimal("0.05"));
			nickle += 1;
		}
		
	}
	
	public String toString() {
		return quarter + "quarter" + dime + "dime" + nickle + "nickle";		
	}
	

	public int getQuarters() {
		return quarter;
	}

	public int getDime() {
		return dime;
	}

	public int getNickle() {
		return nickle;
	}
	

}
