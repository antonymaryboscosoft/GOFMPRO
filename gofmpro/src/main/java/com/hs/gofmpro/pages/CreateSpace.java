package com.hs.gofmpro.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hs.gofmpro.base.TestBase;

public class CreateSpace extends TestBase{
			@FindBy(xpath="//span[@class='icon']")
			WebElement Iconclick;
			
			@FindBy(xpath="//div[@id='o_menu_apps']//a[4]")
			WebElement Maintenance;
			
			@FindBy(xpath="//i[@class='fa fa-plus']")
			WebElement ClickPlus;
			
			@FindBy(xpath="//li[7]//div[1]//a[1]//span[1]")
			WebElement ClickSpace;
			
			@FindBy(xpath="//button[@class='btn btn-primary o_list_button_add']")
			WebElement ClickCreate;
			
			@FindBy(name="space_name")
			WebElement EnterspaceName;
			
			@FindBy(name="name")
			WebElement EnterspaceCode;
			
			@FindBy(xpath="//input[@id='o_field_input_370']")
			WebElement ClickSpaceCat;
			
			@FindBy(id="'o_field_input_371//input")
			WebElement ClickMaintenanceteam;
			
			@FindBy(xpath="//button[@class='btn btn-primary o_form_button_save']")
			WebElement ClickSave;
//Initializing the Page Objects:
public CreateSpace(){
			PageFactory.initElements(driver, this);
			
			}
public CreateEquipment  createSpace(String EnterSName, String EnterSCode ) throws InterruptedException{
			Thread.sleep(3000);
			Iconclick.click();
			Maintenance.click();
			ClickPlus.click();
			ClickSpace.click();
			Thread.sleep(3000);
			ClickCreate.click();
			Thread.sleep(3000);
			EnterspaceName.sendKeys(EnterSName);
			EnterspaceCode.sendKeys(EnterSCode);
			/*ClickSpaceCat.click();	
			List<WebElement> list = driver.findElements(By.xpath("//li[@id='ui-id-44']//a[contains(text(),'Building')]//a"));
			System.out.println(list.size());	
			for(WebElement element:list){	
				System.out.println("Values" + element.getAttribute("innerHTML"));
				String innnerhtml=element.getAttribute("innerHTML");
				if (element.getAttribute("innerHTML").contains("Building"))
				{			
				element.click();
				break;	
				}		
				System.out.println("Selected Storeowner is ====== "+innnerhtml);	
				}
				*/
			ClickMaintenanceteam.click();
			List<WebElement> list1 = driver.findElements(By.xpath("//a[contains(text(),'Electrical Team 1')]//a"));
			System.out.println(list1.size());	
			for(WebElement element:list1){	
				System.out.println("Values" + element.getAttribute("innerHTML"));
				String innnerhtml=element.getAttribute("innerHTML");
				if (element.getAttribute("innerHTML").contains("Electrical Team 1"))
				{			
				element.click();
				break;	
				}		
				System.out.println("Selected Storeowner is ====== "+innnerhtml);	
				}
			ClickSave.click();
				return new CreateEquipment();
				}
				}
