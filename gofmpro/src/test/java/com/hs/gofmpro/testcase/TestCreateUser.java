package com.hs.gofmpro.testcase;

import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.hs.gofmpro.base.TestBase;
import com.hs.gofmpro.pages.CreateCompany;
import com.hs.gofmpro.pages.CreateSpaceCategory;
import com.hs.gofmpro.pages.CreateUser;
import com.hs.gofmpro.pages.Login;
import com.hs.gofmpro.utils.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestCreateUser extends TestBase{
		Login login;
		CreateCompany createCompany;
		CreateUser createUser;
		CreateSpaceCategory createSpaceCategory;
		ExtentReports extent;
		ExtentTest  logger;
public TestCreateUser(){
		super();
		}
@BeforeMethod
public void setUp() throws InterruptedException{
		initialization();
		login = new Login();
		createCompany = new CreateCompany();
		createUser = new CreateUser();
		createSpaceCategory = new CreateSpaceCategory();
		extent = new ExtentReports("/home/zentere/workspace/gofmpro/ErrorScreenshot/ExtentReport.html");
		logger  = extent.startTest("loginPage");
		}
@Test(priority=1)
public void loginTest() throws InterruptedException{
//Test1
			createCompany = login.login(prop.getProperty("Email"), prop.getProperty("Password"));	
			logger.log(LogStatus.PASS, "Login Page Pass");
			String screenshotpath = TestUtil.captureScreenshot(driver,"login");
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotpath));
			logger.log(LogStatus.INFO, "successfully Login ");
			logger.log(LogStatus.INFO, "Login Completed");
		
//Test2
			ExtentTest test2 = extent.startTest("CreateCompany");
			createUser =createCompany.CreateCompany(prop.getProperty("CompanyName"),prop.getProperty("Code"));
			test2.log(LogStatus.PASS, "CreateCompany Pass");
			String screenshotpath1 = TestUtil.captureScreenshot(driver,"CreateCompany");
			test2.log(LogStatus.PASS, logger.addScreenCapture(screenshotpath1));
			test2.log(LogStatus.INFO, "Successfully CreateCompany ");	
			
//Test3
			 ExtentTest  test3= extent.startTest("CreateUser");
			 createSpaceCategory =createUser.CreateUser(prop.getProperty("EnterName"), prop.getProperty("EnterEmail"));
			 test3.log(LogStatus.PASS, "CreateUser Pass");
			 String screenshotpath2 = TestUtil.captureScreenshot(driver,"CreateUser");
			 test3.log(LogStatus.PASS, logger.addScreenCapture(screenshotpath2));
			 test3.log(LogStatus.INFO, "Successfully CreateUser ");
			 
			 createSpaceCategory = createUser.DeleteCreateUser();
			 }
	
	

@AfterMethod
public void tearDown(ITestResult result) throws IOException{
		if(result.getStatus()== ITestResult.FAILURE)		
			{
			String screenshotpath = TestUtil.captureScreenshot(driver,"CreateCompany");
			logger.log(LogStatus.FAIL, result.getName());
			logger.log(LogStatus.FAIL, result.getThrowable());
			//String screenshotpath = TestUtil.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotpath));
			logger.log(LogStatus.INFO, "Same company code entered");
			}
			//extent.endTest(logger);
			extent.flush();
			driver.close();

			}
/*
@AfterTest
		public void CloseTest() {
			extent.close();
			driver.quit();

			}*/}

