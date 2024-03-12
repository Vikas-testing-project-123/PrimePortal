package TestAutomation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TestAutomation.primeAbstract.PrimeAbstractComponents;

public class Customer extends PrimeAbstractComponents {

	WebDriver driver;

	public Customer(WebDriver driver) {

		super(driver);

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='flex items-center gap-3 p-2']/a")
	WebElement AddCustomer;

	@FindBy(xpath = "//div/h2")
	WebElement customerpage;

	@FindBy(id = "Firstname")
	WebElement FirstName;

	@FindBy(id = "Lastname")
	WebElement LastName;

	@FindBy(xpath = "//input[@name='Companyname']")
	WebElement CompanyName;

	@FindBy(xpath = "//input[@name='Companyemail']")
	WebElement CompanyEmail;

	@FindBy(xpath = "//body[1]/div[4]/form[1]/div[4]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]")
	WebElement Currency;

	@FindBy(xpath = "/html[1]/body[1]/div[7]/div[2]/div[2]")
	WebElement INR;

	@FindBy(xpath = "//body/div[4]/form[1]/div[4]/div[2]/div[1]/div[1]/div[4]/div[1]")
	WebElement paymentTerm;

	@FindBy(xpath = "//div[@class='ss-option']")
	List<WebElement> PaymentTermoptions;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	WebElement Next;

	// Country
	@FindBy(xpath = "//body/div[4]/form[1]/div[4]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]")
	WebElement Country;

	@FindBy(xpath = "//div[@class='ss-option']")
	List<WebElement> countryName;

	//State
	@FindBy(xpath="//body/div[4]/form[1]/div[4]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]")
	WebElement Stateselectoption;
	
	@FindBy(xpath="//div[@class='ss-option']")
	List<WebElement> StateOptions;
	
	
	//City
		@FindBy(xpath="/html[1]/body[1]/div[4]/form[1]/div[4]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]")
		WebElement Cityselectoption;
		
		@FindBy(xpath="//div[@class='ss-option']")
		List<WebElement> CityOptions;
		
	//Submit button
		@FindBy(xpath="//button[contains(text(),'Save')]")
		WebElement Submit;
		
		

//	@FindBy(xpath="")
//	WebElement errorMsg;

	public void Createcustomer(String name, String lastname, String comapnyname, String companyemail,
			String paymentTermOption, String desiredCountry, String desiredState, String city) throws InterruptedException {
		AddCustomer.click();
		FirstName.sendKeys(name);
		LastName.sendKeys(lastname);
		CompanyName.sendKeys(comapnyname);
		CompanyEmail.sendKeys(companyemail);
		Currency.click();
		INR.click();
		paymentTerm.click();

		String desiredvalue = paymentTermOption;
		for (WebElement paymentoption : PaymentTermoptions) {
			String elementText = paymentoption.getText();
			if (elementText.equals(desiredvalue)) {
				paymentoption.click();
				Next.click();
				Thread.sleep(3000);
				//Country Select
				Country.click();
				String DesCountry = desiredCountry;
				for (WebElement country : countryName) {
					String countryText = country.getText();
					if (countryText.equals(DesCountry)) {
						country.click();
						//State select
						Stateselectoption.click();
						Thread.sleep(3000);
						String desirestate = desiredState;
						for( WebElement state : StateOptions) {
							String dessta =  state.getText();
							if(dessta.equalsIgnoreCase(desirestate)){
								state.click();
								Thread.sleep(3000);
								//City select 
								Cityselectoption.click();
								String desirecity = city;
								for(WebElement cty : CityOptions) {
									String cityText = cty.getText();
									if(cityText.equalsIgnoreCase(desirecity)) {
										cty.click();
										Thread.sleep(3000);
										
										//Click save button
										Submit.click();
									}
								}
							}
						}
						
					}
				}
				Thread.sleep(2000);
			}

		}
		

	}
//Search cusomter
	public void search(String customer) {
		
		String searchcustomer = customer;
		WebElement cusomtersearch = driver.findElement(By.xpath("//div[@id='tblData_filter']/label/input"));
		cusomtersearch.sendKeys(searchcustomer);
		
		String Output = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		Assert.assertEquals(searchcustomer, Output);
		
		
	}
	
//Customer header
	public WebElement header() {
		waitForWebElementToAppear(customerpage);
		customerpage.getText();
		return customerpage;
	}

}
