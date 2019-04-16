package Com.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			File file = new File("/home/zentere/workspace/gofmpro/src/main/java/Config/Config.properties");
			FileInputStream ip = new FileInputStream(file);

			// FileInputStream ip = new
			// FileInputStream(System.getProperty("E:/anto/eclpslunapom/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties"));

			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","/home/zentere/Downloads/chromedriver/chromedriver_linux64/chromedriver");

			driver = new ChromeDriver();
		}
		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		/*driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);*/

		driver.get(prop.getProperty("url"));

	}
}