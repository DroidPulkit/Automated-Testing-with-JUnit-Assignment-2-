package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingApp.Currency;
import bankingApp.Money;

public class MoneyTest {
	protected Currency CAD, HKD, NOK, EUR;
	protected Money CAD100, EUR10, CAD200, EUR20, CAD0, EUR0, CADnegative100;
	
	@Before
	public void setUp() throws Exception {
		// setup sample currencies
		CAD = new Currency("CAD", 0.75);
		HKD = new Currency("HKD", 0.13);
		EUR = new Currency("EUR", 1.14);
		
		// setup sample money amounts
		CAD100 = new Money(100, CAD);
		
		EUR10 = new Money(10, EUR);
		CAD200 = new Money(200, CAD);
		EUR20 = new Money(20, EUR);
		CAD0 = new Money(0, CAD);
		EUR0 = new Money(0, EUR);
		CADnegative100 = new Money(-100, CAD);
	}

	@Test
	public void testGetAmount() {
		double amountGot = CAD100.getAmount();
		
		if(amountGot != 100) {
			fail("getAmount() method failed");
		}
		
	}

	@Test
	public void testGetCurrency() {
		Currency currencyGot = CAD100.getCurrency();
		
		if(currencyGot.getName() != "CAD") {
			fail("getCurrency() method failed");
		}
	}

	@Test
	public void testToString() {
		String stringGot = EUR20.toString();
		//System.out.println(stringGot);
		if(!stringGot.contentEquals("20.0 EUR")) {
			fail("toString() method failed");
		}
	}

	@Test
	public void testGetUniversalValue() {
		double universalValueGot = EUR0.getUniversalValue();
		if (universalValueGot != 1.14) {
			fail("getUniversalValue() method failed");
		}
	}

	@Test
	public void testEqualsMoney() {
		boolean equalMoneyGot = CAD0.equals(EUR0);
		if(!equalMoneyGot) {
			fail("Equals Money method failed");
		}
	}

	@Test
	public void testAdd() {
		Money newMoney = CAD200.add(CADnegative100);
		if(newMoney.getAmount() != 100) {
			fail("Add() method failed");
		}
		
		Money newMoney2 = EUR20.add(EUR10);
		if(newMoney2.getAmount() != 30) {
			fail("Add() method failed");
		}
		
	}

	@Test
	public void testSubtract() {
		Money newMoney = EUR20.subtract(EUR10);
		if(newMoney.getAmount() != 10) {
			fail("Subtract() method failed");
		}
		
		Money newMoney2 = EUR20.subtract(EUR10);
		if(newMoney2.getAmount() != 10) {
			fail("Add() method failed");
		}
	}

	@Test
	public void testIsZero() {
		if(!EUR0.isZero()) {
			fail("IsZero() method failed");
		}
	}

	@Test
	public void testNegate() {
		Money newMoney = CAD100.negate();
		if (newMoney.getAmount() != -100) {
			fail("Negate() method failed");
		}
	}

	@Test
	public void testCompareTo() {
		int compareToGot = CAD100.compareTo(CAD200);
		if (compareToGot != 0) {
			fail("compareTo() method failed");
		}
	}
}
