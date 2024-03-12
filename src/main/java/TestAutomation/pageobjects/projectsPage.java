package TestAutomation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestAutomation.primeAbstract.PrimeAbstractComponents;

public class projectsPage extends PrimeAbstractComponents {

	WebDriver driver;

	public projectsPage(WebDriver driver) {

		super(driver);

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Add Project")
	WebElement AddprojectButton;

	@FindBy(linkText = "Projects")
	WebElement Projectspage;

	@FindBy(xpath = "//body/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement CustomerNamedropdown;

	@FindBy(xpath = "//div[@class='ss-option']")
	List<WebElement> CustomerNameoptions;

	@FindBy(id = "ProjectNo")
	WebElement ProjectNo;

	@FindBy(id = "ProjectName")
	WebElement ProjectName;

	@FindBy(xpath = "//body/div[3]/form[1]/div[1]/div[4]/div[1]")
	WebElement Accountmanagerdropdown;

	@FindBy(xpath = "//div[@class='ss-option']")
	List<WebElement> Accountmanageroptions;

	@FindBy(xpath = "//body/div[3]/form[1]/div[1]/div[5]/div[1]")
	WebElement ProjectTypedropdown;

	@FindBy(xpath = "//div[@class='ss-option']")
	List<WebElement> Projecttypeoptions;

	@FindBy(xpath = "//body/div[3]/form[1]/div[1]/div[7]/div[1]")
	WebElement projectpracticedrop;

	@FindBy(xpath = "//div[@class='ss-option']")
	List<WebElement> Projecpracticeoptions;

	@FindBy(xpath = "//body/div[3]/form[1]/div[1]/div[8]/div[1]")
	WebElement subpracticedrop;

	@FindBy(xpath = "//div[@class='ss-option']")
	List<WebElement> subpracticedropoptions;

	@FindBy(id = "saveButton")
	WebElement Saveproject;

	@FindBy(xpath = "//body/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/label[1]/input[1]")
	WebElement search;

//Go to project page flow
	public void gotoProjectPage() {
		Projectspage.click();
		String input = "http://192.168.9.30/Project";
		String regex = ".*\\/Project"; // Regular expression pattern to match "/Project" at the end of the string
		Assert.assertTrue(input.matches(regex), "Input contains \"/Project\"");
	}

	// Searhc project
	public void search(String project) {

		String searchproject = project;
		search.sendKeys(searchproject);

		String Output = driver.findElement(By.xpath("//td[1]")).getText();
		Assert.assertEquals(searchproject, Output);
	}

	// Add project flow
	public void Addproject(String Cusotmer, String projectno, String projectname, String Accountmanager,
			String projectType, String practice, String subprac) throws InterruptedException {

		AddprojectButton.click();
		CustomerNamedropdown.click();

		String desiredvalue = Cusotmer;
		for (WebElement customeroption : CustomerNameoptions) {
			String elementText = customeroption.getText();
			if (elementText.equals(desiredvalue)) {
				customeroption.click();

				// projectNumber
				ProjectNo.sendKeys(projectno);

				// projectName
				ProjectName.sendKeys(projectname);

				// Account Manager select
				Accountmanagerdropdown.click();
				String desiredAccountmanager = Accountmanager;
				for (WebElement accountmanoption : Accountmanageroptions) {
					String managervalue = accountmanoption.getText();

					if (managervalue.equals(desiredAccountmanager)) {
						accountmanoption.click();

						// projectType
						ProjectTypedropdown.click();
						String desiredprojecttype = projectType;
						for (WebElement accounttype : Projecttypeoptions) {
							String accunttypetext = accounttype.getText();
							if (accunttypetext.equals(desiredprojecttype)) {
								accounttype.click();

								// projectpractice and subpractice
								projectpracticedrop.click();
								String desirecpractice = practice;
								for (WebElement Practiceop : Projecpracticeoptions) {
									String pracopt = Practiceop.getText();
									if (pracopt.equals(desirecpractice)) {
										Practiceop.click();
										Thread.sleep(3000);
										// Subpractice selection
										subpracticedrop.click();
										String dessubpractice = subprac;
										for (WebElement subpra : subpracticedropoptions) {
											String subpr = subpra.getText();
											if (subpr.equals(dessubpractice)) {
												subpra.click();
												Thread.sleep(3000);
												// Save project
												Saveproject.click();

											}
										}
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

}
