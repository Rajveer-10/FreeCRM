package com.crm.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.crm.qa.base.BaseClass;

public class CommonUtilities extends BaseClass
{
	
	public static long implicitwaittime=15;
	
	public static String Testdata_Sheet_Path="C:\\Users\\Rajveer\\eclipse-workspace\\FreeCRMTest\\src\\main\\java"
			+ "\\com\\crm\\qa\\testdata\\Free_CRM_TestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	//Method to capture screenshot
	public static void captureScreenshotLocal() throws IOException
	{
		File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdirectory= System.getProperty("user.dir");
		FileHandler.copy(srcfile, new File(currentdirectory + "\\Screenshots\\Screenshot_" + getCurrentDate() + ".png"));
		
	}

	//Method to return date in specific format
	public static String getCurrentDate()
	{
		DateFormat customformat = new SimpleDateFormat("dd_MM_YYYY_HH_mm_ss");
		Date currentdate= new Date();
		return customformat.format(currentdate);
	}
	
	public void switchToFrame(String framename) 
	{
		driver.switchTo().frame(framename);
	}
	
	public static Object[][] getTestData(String sheetname) 
	{
		FileInputStream fis=null;
		try {
		fis= new FileInputStream(Testdata_Sheet_Path); }
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try {
		book=WorkbookFactory.create(fis);  }
		catch(IOException e)
		{
			e.printStackTrace();
		}
		sheet= book.getSheet(sheetname);
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i< sheet.getLastRowNum();i++)
		{
			for(int j=0; j<sheet.getRow(i).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}

}
