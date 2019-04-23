package com.hs.gofmpro.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hs.gofmpro.base.TestBase;

public class CreateEquipmentCategory extends TestBase{
	/*GOFT15==As an Admin/Manager, I would like to create the equipment category, so the 
	Technician can locate the Equipment*/
	//Equipment Category
	
		@FindBy(xpath="//span[@class='icon']")
		WebElement Iconclick;
		
		@FindBy(xpath="//div[@id='o_menu_apps']//a[5]")
		WebElement Facility;
		
		@FindBy(xpath="//i[@class='fa fa-plus']")
		WebElement ClickPlus;
		
		@FindBy(xpath="//span[contains(text(),'Equipment Category')]")
		WebElement ClickEquipmentCat;
		
		@FindBy(xpath="//button[contains(text(),'Create')]")
		WebElement ClickCreate;
		
		@FindBy(xpath="//input[@name='name']")
		WebElement EnterEName;
		
		@FindBy(xpath="//div[@class='o_input_dropdown']//input[@type='text']")
		WebElement PEqp;
		
		@FindBy(xpath="//div[@class='o_form_buttons_edit']//button[@type='button'][contains(text(),'Save')]")
		WebElement ClickSave;
//delete Space EquipmentCategory
		@FindBy(xpath="//a[contains(text(),'Equipment Category')]")
		WebElement EquipmentCategory;
		
		@FindBy(xpath="//span[@class='o_sidebar_drw fa fa-chevron-left']")
		WebElement ClickSideBar;
		
		@FindBy(xpath="//a[contains(text(),'Delete')]")
		WebElement ClickDelete;
		
		@FindBy(xpath="//span[contains(text(),'Ok')]")
		WebElement ClickOk;
	
//Initializing the Page Objects:
public CreateEquipmentCategory(){
		PageFactory.initElements(driver, this);
		}
		
public CreateSpace createEquipmentCat(String EnterENa ) throws InterruptedException{
		Thread.sleep(5000);
		Iconclick.click();
		Thread.sleep(5000);
		Facility.click();
		Thread.sleep(5000);
		ClickPlus.click();
		Thread.sleep(5000);
		ClickEquipmentCat.click();
		Thread.sleep(5000);
		ClickCreate.click();
		Thread.sleep(5000);
		EnterEName.sendKeys(EnterENa);
		Thread.sleep(5000);
		PEqp.click();
		List<WebElement> list1 = driver.findElements(By.xpath("//li[@id='ui-id-81']//a[contains(text(),'Electrical')]//a"));
		System.out.println(list1.size());	
		for(WebElement element:list1){	
			System.out.println("Values" + element.getAttribute("innerHTML"));
			String innnerhtml=element.getAttribute("innerHTML");
			if (element.getAttribute("innerHTML").contains("Electrical"))
			{			
			element.click();
			break;	
			}		
			System.out.println("Selected Storeowner is ====== "+innnerhtml);	
			}
			
		ClickSave.click();
		Thread.sleep(5000);
		return new CreateSpace();

		}
public CreateSpace DeleteEquipmentCat() throws InterruptedException{
		ClickSideBar.click();
		Thread.sleep(5000);
		ClickDelete.click();
		Thread.sleep(5000);
		ClickOk.click();
		Thread.sleep(5000);
		EquipmentCategory.click();
		return new CreateSpace();
		}

		}
