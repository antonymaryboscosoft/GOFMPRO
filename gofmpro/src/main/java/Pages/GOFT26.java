package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.TestBase.TestBase;

public class GOFT26 extends TestBase {
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
	
	//Initializing the Page Objects:
	public GOFT26(){
		PageFactory.initElements(driver, this);
	}
	public GOFT27 CreateCompany(String CmpNa, String Cd) throws InterruptedException{
		Thread.sleep(2000);
		Iconclick.click();
		//scrollPageDown(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Setting);
        Setting.click();
        ClickPlus.click();
        Thread.sleep(2000);
        ClickCompany.click();
        Thread.sleep(2000);
        CreateCmp.click();
        Thread.sleep(2000);
        CompanyName.sendKeys(CmpNa);
        Thread.sleep(2000);

        Code.sendKeys(Cd);
        /*
        PCompany.click();
        
        List<WebElement> list = driver.findElements(By.xpath("//ul[@id='ui-id-8']//li//a"));
		System.out.println(list.size());	
		for(WebElement element:list){	
			System.out.println("Values" + element.getAttribute("innerHTML"));
			String innnerhtml=element.getAttribute("innerHTML");
			if (element.getAttribute("innerHTML").contains("Create and Edit...)"))
			{			
			element.click();
			break;	
			}		
			System.out.println("Selected Storeowner is ====== "+innnerhtml);	
			}*/
       
        Save.click();
        Thread.sleep(2000);
        Company.click();
		return new GOFT27();

		
	}
	//This is scroll endof the page
	/*public static void scrollPageDown(WebDriver driver){
		JavascriptExecutor js= ((JavascriptExecutor )driver);
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}*/
	

}
