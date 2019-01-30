package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingApp.Currency;

public class CurrencyTest {
	
	/* Example currencies: 
	 * 	CAD = Canadian dollar
	 * 	EUR = Euros
	 * 	GBP = Great British Pounds
	 * 	HKD = Hong Kong Dollars
	 */
	public Currency CAD, EUR, GBP, HKD, BRL;
	
	@Before
	public void setUp() throws Exception {
		// Setup some test currencies to use in the below test cases
		CAD = new Currency("CAD", 0.75);
		EUR = new Currency("EUR", 1.14);
		HKD = new Currency("HKD", 0.13);
		BRL = new Currency("BRL", 0.27);
	}

	@Test
	public void testGetName() {
		// Write the test case for testing the getName() function
		
		String nameGot = CAD.getName();
		
		if(nameGot != "CAD") {
			fail("getName() method failed");
		}
		
	}
	
	@Test
	public void testGetRate() {
		// @TODO: Write the test case for testing the getRate() function
		
		double rateGot = CAD.getRate();
		
		if(rateGot != 0.75) {
			fail("getRate() method failed");
		}
		
	}
	
	@Test
	public void testSetRate() {
		// @TODO: Write the test case for testing the setRate() function
		// For this function, you should do:
		// 1. Assert that the oldRate is correct
		// 2. Change the rate
		// 3. Assert that the newRate is correct
		// You will end up with 2 assert() statements in this function.
		double oldTestRate = 0.75;
		assertEquals(CAD.getRate(), oldTestRate, 0.001);
		
		CAD.setRate(1.75);
		double newTestRate = 1.75;
		
		assertEquals(CAD.getRate(), newTestRate, 0.001);
	}
	
	@Test
	public void testValueInUSD() {
		// @TODO: Write the test case for testing the valueInUSD() function
		double amount = 100;
		double valueInUSD = CAD.valueInUSD(amount);
		
		if (valueInUSD != 75) {
			fail("valueInUSD(double amount) method failed");
		}	
		
	}
	
	@Test
	public void testValueInThisCurrency() {
		// @TODO: Write the test case for testing the valueInThisCurrency() function
		// For this function, you should:
		try
		{
			// 1. Assert the value of the "other" currenc
			assertEquals(CAD.valueInThisCurrency(100, EUR), 65.79, 0.001);
			
			double cadConvertedToEUR = CAD.valueInThisCurrency(100, EUR);
			
			//2. Get the value in "this" currency
			double eurConvertedToCAD = EUR.valueInThisCurrency(cadConvertedToEUR, CAD);
		
			//3. Assert that the value in "this" currency is correct 
			assertEquals(100, eurConvertedToCAD, 0.001);
			
		}catch (Exception e){

			fail("Write test case here");
		}

	}

}
