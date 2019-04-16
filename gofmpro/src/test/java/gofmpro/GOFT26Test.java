package gofmpro;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Com.TestBase.TestBase;
import Pages.GOFT26;
import Pages.GOFT3;
import Pages.GOFT27;
import TestUtil.TestUtil;

public class GOFT26Test extends TestBase{
	GOFT3 gOFT3;
	GOFT26 gOFT26;
	GOFT27 gOFT27;
	
	ExtentReports extent;
	ExtentTest  logger;

	public GOFT26Test(){
		super();
		
	}
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
	
		gOFT3 = new GOFT3();
		gOFT26 = new GOFT26();
		gOFT27 = new GOFT27();
		
		//extent = new ExtentReports(System.getProperty("user.dir")+"/ErrorScreenshot/)
		
	extent = new ExtentReports("/home/zentere/workspace/gofmpro/ErrorScreenshot/ExtentReport.html");

	}
		

	@Test
	public void loginTest() throws InterruptedException, IOException{
		logger = extent.startTest("login");

		//Test1
			gOFT26 = gOFT3.login(prop.getProperty("Email"), prop.getProperty("Password"));
			logger.log(LogStatus.PASS, "Login Page Pass");
			String screenshotpath = TestUtil.captureScreenshot(driver,"login");
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotpath));
			logger.log(LogStatus.INFO, "successfully Login ");
		
		/*String screenshotpath = TestUtil.captureScreenshot(driver, "login");
		test.log(LogStatus.PASS, test.addScreenCapture(screenshotpath));*/

			
				//Test2
			   logger = extent.startTest("CreateCompany");
			   logger.log(LogStatus.FAIL, "Failed to create company");
			   gOFT27 =gOFT26.CreateCompany(prop.getProperty("CompanyName"),prop.getProperty("Code"));
	}
	

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		if(result.getStatus()== ITestResult.FAILURE)
			
			
		{
			String screenshotpath = TestUtil.captureScreenshot(driver,"CreateCompany");

			//logger.log(LogStatus.FAIL, result.getName());
			logger.log(LogStatus.FAIL, result.getThrowable());
			//String screenshotpath = TestUtil.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotpath));
			logger.log(LogStatus.INFO, "Same company code entered");

			
		}
		extent.endTest(logger);

		/*else if(result.getStatus()== ITestResult.SUCCESS)
		{
			String screenshotpath = TestUtil.captureScreenshot(driver,"CreateCompany");

			logger.log(LogStatus.PASS, result.getName());
			logger.log(LogStatus.PASS, result.getThrowable());
			//String screenshotpath = TestUtil.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotpath));
			*/
			
			
			
			/*String screenshotpath = TestUtil.capture(driver,"screenshotName");
			test.pass(MarkupHelper.createLabel(result.getName()+"Test Case Pass", ExtentColor.BLUE));
			test.pass(result.getThrowable());
			test.pass("Snapshot below:"+test.addScreenCaptureFromPath(screenshotpath));*/
			
		//}
		
	}
	@AfterTest
	public void endTest() {
		extent.flush();
		extent.close();
		driver.close();

	}
}
