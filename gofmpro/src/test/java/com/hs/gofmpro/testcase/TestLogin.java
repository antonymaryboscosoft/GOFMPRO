package com.hs.gofmpro.testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.hs.gofmpro.base.TestBase;
import com.hs.gofmpro.pages.CreateCompany;
import com.hs.gofmpro.pages.Login;

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
		createCompany = login.login(prop.getProperty("Email"), prop.getProperty("Password"));
		
	}}


