package TestAutomation.TestCases;
import org.testng.annotations.Test;
import TestAutomation.TestComponents.PrimeBaseTest;
import TestAutomation.pageobjects.projectsPage;

public class AddprojectsTest extends PrimeBaseTest{
	@Test
	public void addProjectFlow() throws InterruptedException {
		login.LoginApplication("17445", "Team@2024");
		projectsPage project = new projectsPage(driver);
		project.gotoProjectPage();
		project.Addproject("KAJARIA CERAMICS LIMITED", "28022024", "Testonlyproject", "Sushan Aich", "Internal", "Kockpit Analytics", "Custom Apps");
	}
	@Test
	public void searchproject() {
		login.LoginApplication("17445", "Team@2024");
		projectsPage project = new projectsPage(driver);
		project.gotoProjectPage();
		project.search("Testonlyproject");
	}
}
