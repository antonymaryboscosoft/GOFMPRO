package com.hs.gofmpro.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.hs.gofmpro.base.TestBase;

public class TestUtil extends TestBase{
		public static long PAGE_LOAD_TIMEOUT = 20;
		public static long IMPLICIT_WAIT = 10;
		public static String TESTDATA_SHEET_PATH = "/home/zentere/workspace/gofmpro"
				+ "/src/main/resources/com/hs/gofmpro/resources/GofmproTestData.xlsx";
		
		static Workbook book;
		static org.apache.poi.ss.usermodel.Sheet sheet;
		static JavascriptExecutor js;

public static Object[][] getTestData(String sheetName) {
			FileInputStream file = null;
			try {
				file = new FileInputStream(TESTDATA_SHEET_PATH);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			// System.out.println(sheet.getLastRowNum() + "--------" +
			// sheet.getRow(0).getLastCellNum());
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					System.out.println("The Xlsx Data is " + data[i][k]);
				}
			}
			return data;
			}	 
public 	static  String captureScreenshot(WebDriver driver,String screenshotName){
		try {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String dest =System.getProperty("user.dir")+"/ErrorScreenshot/"+screenshotName+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source,destination );
		System.out.println("Screen shot taken");
		return dest;
		}
		catch (Exception e1)
		{
		System.out .println("Exception while taking the screen shot"+e1. getMessage());
		return e1.getMessage();	
		} 	
		}}
	
	


