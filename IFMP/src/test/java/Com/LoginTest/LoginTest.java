package Com.LoginTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Modules.HomePage;
import Com.Modules.Login;
import Com.TestBase.TestBase;

public class LoginTest extends TestBase {
	
	Login login;
	HomePage homePage;
	
	public LoginTest(){
		super();
		
	}
	@BeforeMethod
	public void setUp(){
		initialization();
	
		login = new Login();	
	}

	@Test(priority=1)
	public void loginTest() throws InterruptedException{
		homePage = login.login(prop.getProperty("Email"), prop.getProperty("Password"));
		
	}
	@Test(priority=2)
	public void loginPageTitleTest(){
		String title = login.validateLoginPageTitle();
		Assert.assertEquals(title, "gofmpro");
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}