package gofmpro;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;








import Com.TestBase.TestBase;
import Pages.GOFT26;
import Pages.GOFT3;

public class GOFT3Test extends TestBase {
	GOFT3 gOFT3;
	GOFT26 gOFT26;
	public GOFT3Test(){
		super();
		
	}
	@BeforeMethod
	public void setUp(){
		initialization();
	
		gOFT3 = new GOFT3();	
	}

	@Test(priority=1)
	public void loginTest() throws InterruptedException{
		gOFT26 = gOFT3.login(prop.getProperty("Email"), prop.getProperty("Password"));
		
	
	
	}
	
	}


