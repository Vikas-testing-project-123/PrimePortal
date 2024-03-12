package TestAutomation.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestAutomation.TestComponents.PrimeBaseTest;
import TestAutomation.pageobjects.Customer;
import TestAutomation.pageobjects.Dashboard;

public class AddCustomerTest extends PrimeBaseTest{
		@Test
		public void AddCustomerflow() throws InterruptedException {
			Dashboard dashboard = login.LoginApplication("17445", "Team@2024");
			Customer customer = dashboard.gotocustomer();
			Assert.assertEquals(customer.header().getText(), "List of Customers");
			customer.Createcustomer("Vikash", "Singh", "TDETest", "Test@test.com", "0DPDC", "india", "Uttarakhand", "Dehradun");
			Thread.sleep(2000);
			customer.search("TDETest");
		
		}
}
