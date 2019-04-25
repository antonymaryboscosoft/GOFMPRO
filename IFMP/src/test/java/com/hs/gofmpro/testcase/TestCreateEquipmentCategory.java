package com.hs.gofmpro.testcase;

import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.hs.gofmpro.base.TestBase;
import com.hs.gofmpro.pages.CreateEquipmentCategory;
import com.hs.gofmpro.pages.CreateSpace;
import com.hs.gofmpro.pages.CreateSpaceCategory;
import com.hs.gofmpro.pages.Login;
import com.hs.gofmpro.utils.TestUtil;

public class TestCreateEquipmentCategory extends TestBase {
		Login login;
		CreateSpaceCategory createSpaceCategory;
		CreateEquipmentCategory createEquipmentCategory;
		CreateSpace createSpace;
		
	
		String sheetName ="GofmInput";

	
public TestCreateEquipmentCategory(){
		super();
		}
@BeforeMethod
public void setUp() throws InterruptedException, IOException{
		initialization();
		login = new Login();
		
		createSpaceCategory = new CreateSpaceCategory();
		createEquipmentCategory = new CreateEquipmentCategory();
		createSpace = new CreateSpace();
		
		}


@Test(priority=1)
public void loginTest(String EnterSName) throws InterruptedException{
//Test1
		createSpaceCategory = login.login(prop.getProperty("Email"), prop.getProperty("Password"));	
		createEquipmentCategory = createSpaceCategory.createSpaceCat(prop.getProperty("EnterSName"));	
		 createSpace = createEquipmentCategory.createEquipmentCat(prop.getProperty("EnterEName"));
		 
	 }
@AfterMethod
public void tearDown(ITestResult result) throws IOException{
		
		driver.close();
	
		}

}
