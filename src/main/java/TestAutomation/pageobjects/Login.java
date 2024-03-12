package TestAutomation.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestAutomation.primeAbstract.PrimeAbstractComponents;

public class Login extends PrimeAbstractComponents{
	
	WebDriver driver;
	public Login(WebDriver driver) {
		
		super (driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="tmC_Id")
	WebElement TMC;
	
	@FindBy(id="password")
	WebElement TMCPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Login;
	
	@FindBy(xpath="//div[@class='toast new-error']/div[2]")
	WebElement errorMsg;
	
	public Dashboard LoginApplication(String tmcid, String tmcpassword) {
		TMC.sendKeys(tmcid);
		TMCPassword.sendKeys(tmcpassword);
		Login.click();
		Dashboard dashboard = new Dashboard(driver);
		return dashboard;
	}
	public void goTo() {
		driver.get("http://192.168.9.30/");
	}
	public WebElement getErrorMsg() {
		waitForWebElementToAppear(errorMsg);
		errorMsg.getText();
		return errorMsg;
	}
	
	
	
	
}
