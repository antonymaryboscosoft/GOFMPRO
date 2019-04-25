package com.hs.gofmpro.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hs.gofmpro.base.TestBase;

public class CreateCompany extends TestBase {
//GOFT26 Create Company and parent Company.
		@FindBy(xpath="//span[@class='icon']")
		WebElement Iconclick;
		
		@FindBy(xpath="//a[28]")
		WebElement Setting;
		
		@FindBy(xpath="//i[@class='fa fa-plus']")
		WebElement ClickPlus;
		
		@FindBy(xpath="//span[contains(text(),'Companies')]")
		WebElement ClickCompany;
		
		@FindBy(xpath="//button[contains(text(),'Create')]")
		WebElement CreateCmp;
		
		@FindBy(xpath="//div[@name='name']//input[@type='text']")
		WebElement CompanyName;
		
		@FindBy(xpath="//input[@name='code']")
		WebElement Code;
		
		@FindBy(xpath="//div[@name='parent_id']//input[@type='text']")
		WebElement PCompany;
		
		@FindBy(xpath="//div[@class='o_form_buttons_edit']//button[@type='button'][contains(text(),'Save')]")
		WebElement Save;
		
		@FindBy(xpath="//li[@class='breadcrumb-item']//a[@href='#'][contains(text(),'Companies')]")
		WebElement Company;
		
//Delete Company
		@FindBy(xpath="//div[@class='o_menu_apps']//a[8]")
		WebElement Inventory;
		
		@FindBy(xpath="//li[@class='o_switch_company_menu']//a[@class='dropdown-toggle']")
		WebElement ClickSymbol;
		
		@FindBy(xpath="//a[contains(text(),'HELIXSENSE')]")
		WebElement ClickHelixsense;
		
		@FindBy(xpath="//ul[@class='o_menu_systray']//a[11]")
		WebElement ClickTCSCM;
		
		@FindBy(xpath="//a[@class='dropdown-item o_menu_entry_lvl_3']//span[contains(text(),'Rules')]")
		WebElement ClickRules;
		
		@FindBy(xpath="//th[@class='o_list_record_selector']//label[@class='custom-control-label'][contains(text(),'​')]")
		WebElement ClickAction;
		
		@FindBy(xpath="//a[contains(text(),'Delete')]")
		WebElement ClickDelete;
		
		@FindBy(xpath="//span[contains(text(),'Ok')]")
		WebElement ClickOk;
		
		@FindBy(xpath="//span[contains(text(),'Warehouses')]")
		WebElement WareHouse;
		
		@FindBy(xpath="//td[@class='o_list_record_selector']//label[@class='custom-control-label'][contains(text(),'​')]")
		WebElement ClickAction1;
public CreateCompany(){
		PageFactory.initElements(driver, this);
		}
public CreateUser CreateCompany(String CmpNa, String Cd) throws InterruptedException{
       /* int i =2;
        	
        if(i==2){
        	
        }*/
		Thread.sleep(10000);
		Iconclick.click();
		//scrollPageDown(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Setting);
        Thread.sleep(10000);
        Setting.click();
        Thread.sleep(10000);
        driver.navigate().refresh();
        Thread.sleep(10000);
        ClickPlus.click();
        Thread.sleep(10000);
        ClickCompany.click();
        Thread.sleep(10000);
        CreateCmp.click();
        Thread.sleep(10000);
        CompanyName.sendKeys(CmpNa);
        Thread.sleep(10000);
        Code.sendKeys(Cd);
		Thread.sleep(10000);
        Save.click();
        Thread.sleep(10000);
        Company.click();
		return new CreateUser();
	}
	
public CreateUser DeleteCompany() throws InterruptedException{
        Thread.sleep(5000);
		Iconclick.click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView();", Inventory);
        Thread.sleep(5000);
        Inventory.click();
        Thread.sleep(5000);
        ClickSymbol.click();
        Thread.sleep(5000);
        ClickHelixsense.click();
        Thread.sleep(5000);
        ClickPlus.click();
        Thread.sleep(5000);
        ClickRules.click();
        Thread.sleep(5000);
        ClickSymbol.click();
        Thread.sleep(5000);
        ClickTCSCM.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//label[1]")).click();
        driver.findElement(By.xpath("//th[@class='o_list_record_selector']//label[@class='custom-control-label'][contains(text(),'​')]")).click();
        Select select = new Select(driver.findElement(By.xpath("//th[@class='o_list_record_selector']//label[@class='custom-control-label'][contains(text(),'​')]")));
        select.selectByValue("&#8203;");
        
     /*   WebElement CheckBox = driver.findElement(By.xpath("//th[@class='o_list_record_selector']//label[@class='custom-control-label'][contains(text(),'​')]//label"));
        CheckBox.click();
        System.out.println(CheckBox.isSelected());*/
        //ClickAction.click();
        Thread.sleep(5000);
        ClickDelete.click();
        Thread.sleep(5000);
        ClickOk.click();
        Thread.sleep(5000);
        ClickPlus.click();
        Thread.sleep(5000);
        WareHouse.click();
        Thread.sleep(5000);
        ClickAction1.click();
        Thread.sleep(5000);
        ClickDelete.click();
        Thread.sleep(5000);
        ClickOk.click();
        Thread.sleep(10000);
		Iconclick.click();
		//scrollPageDown(driver);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView();", Setting);
        Thread.sleep(10000);
        Setting.click();
        Thread.sleep(10000);
        driver.navigate().refresh();
        Thread.sleep(10000);
        ClickPlus.click();
        Thread.sleep(10000);
        ClickCompany.click();
        ClickSymbol.click();
        ClickHelixsense.click();

		return new CreateUser();
	}
		
	}
	//This is scroll endof the page
	/*public static void scrollPageDown(WebDriver driver){
		JavascriptExecutor js= ((JavascriptExecutor )driver);
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}*/
	


