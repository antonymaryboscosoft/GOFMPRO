package testcase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Page.CreateCompany;
import Page.Login;

public class TestLogin extends TestBase {
		Login login;
		CreateCompany createCompany;
public TestLogin(){
		super();	
		}
@BeforeMethod
public void setUp(){
		initialization();
		login = new Login();	
		}

@Test(priority=1)
public void loginTest() throws InterruptedException{
		Logger logger=Logger.getLogger("loginTest");
		// configure log4j properties file
		PropertyConfigurator.configure("Log4j.properties");
		createCompany = login.login(prop.getProperty("Email"), prop.getProperty("Password"));
		logger.info("get login Data from Config file");
		logger.info("Successfully Login");
		}
	}


