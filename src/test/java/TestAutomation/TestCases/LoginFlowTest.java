package TestAutomation.TestCases;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import TestAutomation.TestComponents.PrimeBaseTest;
import TestAutomation.data.DataReaderPrime;
import TestAutomation.pageobjects.Dashboard;


public class LoginFlowTest extends PrimeBaseTest {
	
	

	@Test(dataProvider = "getData")
	public void validLoginFlow(HashMap<String, String> input) throws InterruptedException{
		
		Dashboard dashboard = login.LoginApplication(input.get("TMCid"), input.get("Password"));
		Assert.assertEquals(driver.getTitle(), "- Prime");
		dashboard.logout();
		Assert.assertEquals(driver.getTitle(), "Login");
		
	}
	
	@Test
	public void invalidLoginFlow() throws InterruptedException{
		
		login.LoginApplication("teshjs", "Team@sdfds");
		Assert.assertEquals(login.getErrorMsg().getText(), "Login failed. Please check your credentials.");
		
	}
	
	@Test
	public void BlankLoginFlow() throws InterruptedException{
		login.LoginApplication(" ", " ");
		Assert.assertEquals(driver.getTitle(), "Login");
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {	

		
		DataReaderPrime datareader = new DataReaderPrime();
		List<HashMap<String, String>> data = datareader.getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//TestAutomation//data//Login.json");
	//	return new Object[][] { {data.get(0)}, {data.get(1)} };// we set the value according to the json data we get for single netry wwe use single
		return new Object[][] { {data.get(0)}};
	}
	
}
