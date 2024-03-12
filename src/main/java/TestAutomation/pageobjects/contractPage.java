package TestAutomation.pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TestAutomation.primeAbstract.PrimeAbstractComponents;

public class contractPage extends PrimeAbstractComponents {

	WebDriver driver;

	public contractPage(WebDriver driver) {

		super(driver);

		this.driver = driver;

		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText = "Contracts")
	WebElement Contractbutton;

	@FindBy(linkText = "Add Contracts")
	WebElement Addcontractpage;

	@FindBy(xpath = "//input[@id='contractno']")
	WebElement contractNumber;

	@FindBy(xpath = "//input[@id='ponumber']")
	WebElement poNumber;

	@FindBy(xpath = "//body/div[3]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]")
	WebElement customerdrop;

	@FindBy(xpath = "//div[@class='ss-option']")
	List<WebElement> cusomterOptions;

	@FindBy(xpath = "//body/div[3]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]")
	WebElement projectsele;

	@FindBy(xpath = "//div[@class='ss-option']")
	List<WebElement> projectOptions;

	@FindBy(xpath = "//input[@id='amount']")
	WebElement AmountField;

	@FindBy(xpath = "//body/div[3]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[9]/div[1]")
	WebElement DA;

	@FindBy(xpath = "//div[@class='ss-option']")
	List<WebElement> DAoptiosn;

	@FindBy(xpath = "//input[@id='contactpersonname']")
	WebElement cordinatorName;

	@FindBy(xpath = "//input[@id='contactNo']")
	WebElement Number;
	
	@FindBy(xpath = "//div[@class='pt-2 pb-4 sticky -bottom-4 bg-white']/button")
	WebElement Nextbutton;
	
	@FindBy(xpath="//div[@class='pt-2 pb-4 sticky -bottom-4 bg-white flex items-center gap-4']/button[2]")
	WebElement Next2;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement save;
	

//Go to project page flow
	public void gotoContractPage() {
		Contractbutton.click();
		String input = "http://192.168.9.30/Contract";
		String regex = ".*\\/Contract"; // Regular expression pattern to match "/Project" at the end of the string
		Assert.assertTrue(input.matches(regex), "Input contains \'/Contract\'");
	}
	

	// Add project flow
	public void Addcontract(String customer, String project, String DeliveryAnchor) throws InterruptedException {
		Random random = new Random();
		int randomNumber = random.nextInt(100000);
		Addcontractpage.click();
		contractNumber.sendKeys(Integer.toString(randomNumber));
		poNumber.sendKeys(Integer.toString(randomNumber));
		
		//Customer
		customerdrop.click();
		String desiredvalue = customer;
		for (WebElement customeroption : cusomterOptions) {
			String elementText = customeroption.getText();
			if (elementText.equals(desiredvalue)) {
				customeroption.click();

				// Select project
				projectsele.click();

				String desiredprj = project;
				for (WebElement proj : projectOptions) {
					String projText = proj.getText();
					if (projText.equals(desiredprj)) {
						proj.click();

						// Enter amount
						AmountField.sendKeys(Integer.toString(randomNumber));

						// Select delevery anchor
						DA.click();

						String Desiredda = DeliveryAnchor;
						for (WebElement da : DAoptiosn) {
							String daText = da.getText();
							if (daText.equals(Desiredda)) {
								da.click();

								// comtact number and client cordinator
								cordinatorName.sendKeys("Vikash");
								Number.sendKeys(Integer.toString(randomNumber) + "8787");
								
								//Next and save
								Nextbutton.click();
								Next2.click();
								save.click();
								String input = "http://192.168.9.30/Contract/Index";
								String regex = ".*\\/Contract"; // Regular expression pattern to match "/Project" at the end of the string
								Assert.assertTrue(input.matches(regex), "Input contains \'/Contract\'");
								
							}
						}

					}
				}
			}

		}
	}
}
