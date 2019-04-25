package com.hs.gofmpro.testcase;

import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.hs.gofmpro.base.TestBase;
import com.hs.gofmpro.pages.CreateCompany;
import com.hs.gofmpro.pages.CreateEquipmentCategory;
import com.hs.gofmpro.pages.CreateSpace;
import com.hs.gofmpro.pages.CreateSpaceCategory;
import com.hs.gofmpro.pages.CreateUser;
import com.hs.gofmpro.pages.Login;
import com.hs.gofmpro.utils.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestCreateEquipmentCategory extends TestBase {
		Login login;
		CreateCompany createCompany;
		CreateUser createUser;
		CreateSpaceCategory createSpaceCategory;
		CreateEquipmentCategory createEquipmentCategory;
		CreateSpace createSpace;
		ExtentReports extent;
		ExtentTest  logger;
	
		String sheetName ="GofmInput";

	
public TestCreateEquipmentCategory(){
		super();
		}
@BeforeMethod
public void setUp() throws InterruptedException, IOException{
		initialization();
		login = new Login();
		createCompany = new CreateCompany();
		createUser = new CreateUser();
		createSpaceCategory = new CreateSpaceCategory();
		createEquipmentCategory = new CreateEquipmentCategory();
		createSpace = new CreateSpace();
		extent = new ExtentReports("/home/zentere/workspace/gofmpro/ErrorScreenshot/ExtentReport.html");
		logger  = extent.startTest("loginPage");	
		}

@DataProvider
public Object[][] getData(){
		Object data [][] =	TestUtil.getTestData(sheetName);
		return data;
	
}

@Test(priority=1, dataProvider="getData")
public void loginTest(String EnterSName) throws InterruptedException{
//Test1
		createCompany = login.login(prop.getProperty("Email"), prop.getProperty("Password"));	
		logger.log(LogStatus.PASS, "Login Page Pass");
		String screenshotpath = TestUtil.captureScreenshot(driver,"login");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotpath));
		logger.log(LogStatus.INFO, "successfully Login ");
		logger.log(LogStatus.INFO, "Login Completed");

//Test2
	/*	ExtentTest test2 = extent.startTest("CreateCompany");
		createUser =createCompany.CreateCompany(prop.getProperty("CompanyName"),prop.getProperty("Code"));
		test2.log(LogStatus.PASS, "CreateCompany Pass");
		String screenshotpath1 = TestUtil.captureScreenshot(driver,"CreateCompany");
		test2.log(LogStatus.PASS, logger.addScreenCapture(screenshotpath1));
		test2.log(LogStatus.INFO, "Successfully CreateCompany ");
		createUser=createCompany.DeleteCompany();
		String screenshotpathDC = TestUtil.captureScreenshot(driver,"DeleteCompany");
		test2.log(LogStatus.PASS, logger.addScreenCapture(screenshotpathDC));
		test2.log(LogStatus.INFO, "Successfully DeleteCompany ");*/
		
/*//Test3
		 ExtentTest  test3= extent.startTest("CreateUser");
		 createSpaceCategory =createUser.CreateUser(prop.getProperty("EnterName"), prop.getProperty("EnterEmail"));
		 test3.log(LogStatus.PASS, "CreateUser Pass");
		 String screenshotpath2 = TestUtil.captureScreenshot(driver,"CreateUser");
		 test3.log(LogStatus.PASS, logger.addScreenCapture(screenshotpath2));
		 test3.log(LogStatus.INFO, "Successfully CreateUser ");
		 createSpaceCategory = createUser.DeleteCreateUser();
		 String screenshotpathD = TestUtil.captureScreenshot(driver,"DeleteUser");
		 test3.log(LogStatus.PASS, logger.addScreenCapture(screenshotpathD));
		 test3.log(LogStatus.INFO, "Successfully DeleteUser ");*/
		
//Test4
		 ExtentTest test4 = extent.startTest("CreateSpaceCategory");
		 
		// createEquipmentCategory = createSpaceCategory.createSpaceCat(prop.getProperty("EnterSName"));
		 createEquipmentCategory = createSpaceCategory.createSpaceCat(EnterSName);
		 test4.log(LogStatus.PASS, "CreateSpaceCategory Pass");
		 String screenshotpath3 = TestUtil.captureScreenshot(driver, "CreateSpaceCategory");
		 test4.log(LogStatus.PASS, logger.addScreenCapture(screenshotpath3));
		 test4.log(LogStatus.INFO, "Successfully CreateSapce Category");
		 createEquipmentCategory = createSpaceCategory.DeleteSpaceCat();
		 String screenshotpathDS = TestUtil.captureScreenshot(driver, "DeleteSpaceCategory");
		 test4.log(LogStatus.PASS, logger.addScreenCapture(screenshotpathDS));
		 test4.log(LogStatus.INFO, "Successfully DeleteSapce Category");
		 
//Test5
		 ExtentTest test5 = extent.startTest("CreateEquipmentCategory");
		 createSpace = createEquipmentCategory.createEquipmentCat(prop.getProperty("EnterEName"));
		 test5.log(LogStatus.PASS, "CreateEquipmentCategory Pass");
		 String screenShotPath4 = TestUtil.captureScreenshot(driver, "CreateEquipmentCategory");
		 test5.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath4));
		 test5.log(LogStatus.INFO, "Successfully CreateEquipment Category");
		 createSpace =createEquipmentCategory.DeleteEquipmentCat();
		 String screenShotPathDE = TestUtil.captureScreenshot(driver, "DeleteEquipmentCategory");
		 test5.log(LogStatus.PASS, logger.addScreenCapture(screenShotPathDE));
		 test5.log(LogStatus.INFO, "Successfully DeleteEquipment Category");
	 }
@AfterMethod
public void tearDown(ITestResult result) throws IOException{
		if(result.getStatus()== ITestResult.FAILURE)		
		{
		String screenshotpath = TestUtil.captureScreenshot(driver,"CreateCompany");
		logger.log(LogStatus.FAIL, result.getName());
		logger.log(LogStatus.FAIL, result.getThrowable());
		logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotpath));
		logger.log(LogStatus.INFO, "Same company code entered");
		}
		extent.flush();
		driver.close();
	
		}

}
