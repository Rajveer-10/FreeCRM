package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.CommonUtilities;


public class LoginPageTestCases extends BaseClass {

	LoginPage loginpageobj;
	HomePage homepageobj;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialize();
		loginpageobj= new LoginPage(driver);
	}
	
	@AfterMethod
	public void teardown()
	{
		driverQuit();
	}
	
	/*
	@Test
	public void screenshot() throws Exception
	{
		CommonUtilities.captureScreenshotLocal();
		//obj1.captureScreenshotLocal();
	}*/
	

	@Test(priority=1)
	public void verifyTitleTest()
	{
		String title=loginpageobj.getPageTitle();
		//To add testng report logs
		Reporter.log("Asserting the Title", true);
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
		
		
	}
	
	@Test(priority=2)
	public void validateCrmLogoImage()
	{
		boolean flag= loginpageobj.verifyimage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		homepageobj= loginpageobj.loginToApplication(conf.getUsername(),conf.getPassword());
	} 
}
