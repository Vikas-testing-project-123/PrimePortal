package TestAutomation.TestCases;
import org.testng.annotations.Test;

import TestAutomation.TestComponents.PrimeBaseTest;
import TestAutomation.pageobjects.contractPage;

public class createContract extends PrimeBaseTest {
	@Test
	public void createcontract() throws InterruptedException {
		login.LoginApplication("17445", "Team@2024");
		contractPage contract = new contractPage(driver);
		contract.gotoContractPage();
		contract.Addcontract("FULLERTON INDIA CREDIT COMPANY LIMITED","FULLERTON INDIA CREDIT COMPANY LIMITED/Analytics(SCM110840)","Debananda Panda" );
	}
	
}
