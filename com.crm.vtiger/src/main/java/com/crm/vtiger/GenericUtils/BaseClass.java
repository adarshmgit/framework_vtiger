package com.crm.vtiger.GenericUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.objectrepository.LoginPage;

public class BaseClass {

	// Generic util class Object creation 
	public WebDriver driver;
	public static WebDriver sdriver;
	public JavaUtility jUtil=new JavaUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public FileUtility fUtil=new FileUtility();
	public ExcelUtility EUtil=new ExcelUtility();
	
	
	@BeforeSuite(groups={"Smoke test","Regression test"}) 
	public void configBS(){
		//connect to DB
	}

	@BeforeTest(groups={"Smoke test","Regression test"})
	public void configBT() {
		//launch browser in parallel mode
	}
	//@Optional("chromer")String browserName
    //@Parameters("browser")
	@BeforeClass(groups={"Smoke test","Regression test"})
	public void configBC( ) throws Throwable {
		String browserName=fUtil.getPropertyKeyValue("browser");
		
		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		sdriver=driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@BeforeMethod(groups={"Smoke test","Regression test"})
	public void setUp() throws Throwable {
		//get the common data from property file
		
		String URL=fUtil.getPropertyKeyValue("url");
		String Username=fUtil.getPropertyKeyValue("username");
		String Password=fUtil.getPropertyKeyValue("password");

		//Step 1 : Application login
		driver.get(URL);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(Username, Password);
	}
	
	@AfterMethod(groups={"Smoke test","Regression test"})
	public void tearDown() throws Throwable {
		//signout from application
		HomePage homepage=new HomePage(driver);
		homepage.signOut();
	    //wUtil.waitAndClick(driver.findElement(By.xpath("//a[text()='Sign Out']")));

	}

	@AfterClass(groups={"Smoke test","Regression test"})
	public void configAC() {
		driver.quit();
	}

	@AfterTest(groups={"Smoke test","Regression test"})
	public void configAT() {
		//close driver reference in parallel mode
	}

	@AfterSuite(groups={"Smoke test","Regression test"})
	public void configAS() {
		// close DB connection
	}


}


