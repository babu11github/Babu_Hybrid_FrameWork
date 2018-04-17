package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.BaseTest;
import com.gargoylesoftware.htmlunit.javascript.host.file.File;

public class TestUtil extends BaseTest {
	
	public static long PAGE_LOAD_TIMEOUT = 60;
    public static long IMPLICIT_WAIT = 60;

 //Frames
 public void switchToFrame()
 {
	driver.switchTo().frame("mainpanel") ;
 }
 
 
 // data driven fro excel
 public static String TESTDATA_SHEET_PATH = "C:\\Users\\purushotham\\eclipse-workspace\\FrameWork\\src\\main\\java\\com\\crm\\qa\\testdata\\ContactsPage.xls";
			
		 	static Workbook book;
		 	static Sheet sheet;
		  	
		  	
		  	public void switchToFrame1(){
		  		driver.switchTo().frame("mainpanel");
		  	}
		  	
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
	 			// System.out.println(data[i][k]);
	 		}
			}
	 	return data;
	 	}

      public static void takeScreenshotAtEndOfTest() throws IOException{
    	java.io.File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	//String curentDir=System.getProperty("user.dir");
    	
    	//FileUtils.copyFile(srcFile, new File("D:\\SSFRAMEWORK.png"));
	
   }
 }