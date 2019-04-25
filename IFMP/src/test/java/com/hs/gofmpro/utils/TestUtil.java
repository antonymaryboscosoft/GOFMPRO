package com.hs.gofmpro.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.hs.gofmpro.base.TestBase;

public class TestUtil extends TestBase{
		public static long PAGE_LOAD_TIMEOUT = 20;
		public static long IMPLICIT_WAIT = 10;
		
		public static void captureScreenshot(WebDriver driver,String screenshotName)
				
		{
			try {
				TakesScreenshot ts=(TakesScreenshot)driver;
				File source=ts.getScreenshotAs(OutputType.FILE);
				//enterscreenshot folder name
				FileUtils.copyFile(source, new File("./Screenshot/"+screenshotName+".png"));
				System.out.println("Screen shot taken");
			} catch (Exception e) {
				System.out .println("Exception while taking the screen shot");
			} }
		
		private XSSFWorkbook workBook;
		private XSSFSheet sheet;
		public TestUtil(String excelPath) throws IOException{
			File fileName = new File(excelPath);
			FileInputStream fileStream = new FileInputStream(fileName);
			workBook = new XSSFWorkbook(fileStream);
		}
		public String getTestData(String sheetName, int row, int column){
			sheet = workBook.getSheet(sheetName);
			String returnData = sheet.getRow(row).getCell(column).getStringCellValue();
			return returnData;
		}
		public int fetchRowCount(String sheetName){
			int rows = workBook.getSheet(sheetName).getLastRowNum();
			rows = rows+1;
			return rows;
		}
		
	}


