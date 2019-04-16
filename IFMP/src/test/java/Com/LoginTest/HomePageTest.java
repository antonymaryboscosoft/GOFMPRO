package Com.LoginTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Modules.HomePage;
import Com.Modules.Login;
import Com.Modules.MaintenancePage;
import Com.TestBase.TestBase;

public class HomePageTest extends TestBase {
	Login login;
	HomePage homePage;
	MaintenancePage maintenancePage;

	public HomePageTest(){
		super();
		
	}
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
	
		login = new Login();
		homePage = new HomePage();
		maintenancePage = new MaintenancePage();

}
	@Test(priority=1)
	public void loginTest() throws InterruptedException{
		homePage = login.login(prop.getProperty("Email"), prop.getProperty("Password"));
		maintenancePage =homePage.CreateCompany(prop.getProperty("CompanyName"),
				prop.getProperty("Code"), prop.getProperty("CompanyCategory"));
	}
	/*@Test(priority=2) 
	public void verifyMaintenancePage() throws InterruptedException{
		maintenancePage =homePage.CreateCompany(prop.getProperty("CompanyName"),
				prop.getProperty("Code"), prop.getProperty("CompanyCategory"));
	}*/

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	}
