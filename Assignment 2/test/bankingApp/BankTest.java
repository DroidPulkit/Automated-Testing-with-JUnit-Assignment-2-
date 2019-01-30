package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingApp.AccountDoesNotExistException;
import bankingApp.AccountExistsException;
import bankingApp.Bank;
import bankingApp.Currency;
import junit.framework.Assert;

public class BankTest {
	protected Currency CAD;
	protected Currency HKD;
	protected Bank RBC;
	protected Bank TD;
	protected Bank HSBC;
	
	
	@Before
	public void setUp() throws Exception {
		
		// setup some test currencies
		this.HKD = new Currency("HKD", 0.13);
		this.CAD = new Currency("CAD", 0.75);
		
		// setup test banks
		this.RBC = new Bank("Royal Bank of Canada", CAD);
		this.TD = new Bank("TD Bank", CAD);
		this.HSBC = new Bank("Hong Kong Shanghai Banking Corporation", HKD);
		
		// add sample customers to the banks
		this.RBC.openAccount("Marcos");
		this.RBC.openAccount("Albert");
		this.TD.openAccount("Jigesha");
		this.HSBC.openAccount("Pritesh");
		
		//here we realise that the openAccount is not working.
	}

	@Test
	public void testGetName() {
		String rbcName = this.RBC.getName();

		String tdName = this.TD.getName();

		String hsbcName = this.HSBC.getName();
		
		if((rbcName == "") || (tdName == "") || (hsbcName == "")) {
			fail("Test case for getting name failed");	
		}
	}

	@Test
	public void testGetCurrency() {
		Currency rbcCurrency = this.RBC.getCurrency();

		Currency tdCurrency = this.TD.getCurrency();

		Currency hsbcCurrency = this.HSBC.getCurrency();
		
		if((rbcCurrency.getName() == "") || (tdCurrency.getName() == "") || (hsbcCurrency.getName() == "")) {
			fail("Currency not registered properly");	
		}
		
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		try {
			//created the openAccount Marcos, however didnt get any feedback from the method.
			this.RBC.openAccount("Marcos");
			
			//try to create the method again, it must present an error, if not, it means it didnt pass in the test
			this.RBC.openAccount("Marcos");
			
  
			throw new AccountExistsException();
		}catch(AccountExistsException e) {
			
			fail("OpenAccount method is not working properly. It is not creating the accounts");
		}catch(Exception e) {

			fail("OpenAccount could not be executed. It is because there is no account and ALSO because the way the method is throwing the AccountDoesNotExistException is wrong.");
		}

		
	
		// See the example in class notes for testing exceptions.
		
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		
		try {

			//Currency currecyDollar = new Currency("CAD", 0.75);

			this.RBC.deposit("Marcos", new Money(100, this.CAD));
			
		}catch(AccountDoesNotExistException e) {

			fail("TestDeposit could not be executed because Account does not exist.");
			
		}catch(Exception e) {

			fail("TestDeposit could not be executed. It is because there is no account and ALSO because the way the method is throwing the AccountDoesNotExistException is wrong.");
		}

		
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		try {

			//Currency currecyDollar = new Currency("CAD", 0.75);

			this.RBC.withdraw("Marcos", new Money(100,this.CAD));
			
		}catch(AccountDoesNotExistException e) {

			fail("testWithdraw could not be executed because Account does not exist.");
			
		}catch(Exception e) {

			fail("testWithdraw could not be executed. It is because there is no account and ALSO because the way the method is throwing the AccountDoesNotExistException is wrong.");
		}
		
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		try {

			Currency currecyDollar = new Currency("CAD", 0.75);

			this.RBC.getBalance("Marcos");
			
		}catch(AccountDoesNotExistException e) {

			fail("testGetBalance could not be executed because Account does not exist.");
			
		}
		catch(Exception e) {

			fail("testGetBalance could not be executed. It is because there is no account and ALSO because the way the method is throwing the AccountDoesNotExistException is wrong.");
		}
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		// Note: You should test both types of transfers:
		// 1. Transfer from account to account
		
		try {
			this.RBC.transfer("Marcos", "Albert", new Money(100, this.CAD));
		}
		catch(AccountDoesNotExistException e) {

			fail("Transfer from account to account could not be executed because Account does not exist");
			
		}catch(Exception e) {
			fail("testGetBalance could not be executed. It is because there is no account and ALSO because the way the method is throwing the AccountDoesNotExistException is wrong.");
			
		}
		
		
		// 2. Transfer between banks
		try {
			this.RBC.transfer("Marcos", this.TD, "Jigesha", new Money(100, this.CAD));
		}
		catch(AccountDoesNotExistException e) {

			fail("Transfer from account to account could not be executed because Account does not exist");
			
		}catch(Exception e) {
			fail("testGetBalance could not be executed. It is because there is no account and ALSO because the way the method is throwing the AccountDoesNotExistException is wrong.");
			
		}
		
		

	}
	
}
