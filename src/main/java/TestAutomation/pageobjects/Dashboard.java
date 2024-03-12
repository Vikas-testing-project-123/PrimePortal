package TestAutomation.pageobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestAutomation.primeAbstract.PrimeAbstractComponents;


public class Dashboard extends PrimeAbstractComponents {

	WebDriver driver;

	public Dashboard(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "hs-dropdown-with-header")
	WebElement profile;
//	List<WebElement> products;
	
	@FindBy(xpath = "//div[@class='mt-2 py-2 first:pt-0 last:pb-0']/a")
	 WebElement Logout;
	
	@FindBy(xpath = "//body/div[1]/ul[1]/li[4]")
	WebElement customerbuttondashboard;


	public void logout() throws InterruptedException {
		profile.click();
		Logout.click();
	}
	public Customer gotocustomer() {
		customerbuttondashboard.click();
		Customer customer = new Customer(driver);
		return customer;
	}

}

