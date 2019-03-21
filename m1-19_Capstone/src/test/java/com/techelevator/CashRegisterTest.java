package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.techelevator.view.CashRegister;

import junit.framework.Assert;

public class CashRegisterTest {
	
	
	private CashRegister change;
	
	@Test
	public void quater_add_together_dollar() {
		change = new CashRegister(new BigDecimal(1.00));
		assertEquals(4, change.getQuarters());
		
	}
	
	@Test
	public void dime_add_together_dollar() {
		change = new CashRegister(new BigDecimal(.20));
		assertEquals(2, change.getDime());
		
	}
	
	@Test
	public void nickle_add_together_dollar() {
		change = new CashRegister(new BigDecimal(.05));
		assertEquals(1, change.getNickle());
	
	}
	@Test
	public void add_upto_180() {
		change = new CashRegister(new BigDecimal(1.90));
		assertEquals(7, change.getQuarters());
		assertEquals(1, change.getNickle());
		assertEquals(1, change.getDime());


	}
	@Test
	public void add_upto_95_cents() {
		change = new CashRegister(new BigDecimal(0.95));
		assertEquals(3, change.getQuarters());
		assertEquals(2, change.getDime());
	}

}
