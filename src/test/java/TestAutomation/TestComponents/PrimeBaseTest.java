package TestAutomation.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import TestAutomation.pageobjects.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PrimeBaseTest {
	public WebDriver driver;
	public Login login;

	public WebDriver initializeDriver() throws IOException {

		// properties class
		Properties prop = new Properties();
		FileInputStream Fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//TestAutomation/primeresources/GlobalData.properties");
		prop.load(Fis);
		String browserName = System.getProperty("browser") !=null ? prop.getProperty("browser") : prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver();
			//driver.manage().window().setSize(new Dimension(1440,900));//fullscreen
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			// WebDriver driver = new ();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	
	
	
	
	@BeforeMethod(alwaysRun = true)
	public  Login launchApplication() throws IOException {
		driver = initializeDriver();
		login = new Login(driver);
		login.goTo();
		return login;
	}

//	@AfterMethod(alwaysRun = true)
//	public void tearDown() {
//		driver.close();
//	}
}
