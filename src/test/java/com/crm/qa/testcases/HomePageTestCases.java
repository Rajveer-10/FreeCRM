package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.CommonUtilities;

public class HomePageTestCases extends BaseClass{

	//Test cases should be independent should launch browser and close it for every TC
		//Launch browser
		//Execute TC
		//Quit browser
		
		LoginPage loginpageobj;
		HomePage homepageobj;
		CommonUtilities commonutilitiesObj;
		ContactsPage contactpageObj;
		String sheetname= "Messages";
		
		@BeforeMethod
		public void setup() throws IOException, InterruptedException
		{
			initialize();
			loginpageobj= new LoginPage(driver);
			commonutilitiesObj=new CommonUtilities();
			homepageobj=loginpageobj.loginToApplication(conf.getUsername(),conf.getPassword());
		}
		@AfterMethod
		public void teardown()
		{
			driverQuit();
		}
		
		
		@Test(priority=1)
		public void verifyHomePageTitleTest()
		{
			String expectedTitle= "CRMPRO";
			Assert.assertEquals(homepageobj.verifyHomePageTitle(), expectedTitle,"HomePage Title not matched");
		}
		
		@Test(priority=2)
		public void verifyUserNameTest()
		{
			commonutilitiesObj.switchToFrame("mainpanel");
			Assert.assertTrue(homepageobj.verifyUserNameDisplayed(), "User name is not found");
			
		}
		@Test(priority=3)
		public void verifyClickOnContactsTest()
		{
			commonutilitiesObj.switchToFrame("mainpanel");
			contactpageObj=homepageobj.clickOnContacts();
		}
		
		@DataProvider
		public Object[][] getCRMTestData()
		{
			Object data[][]=CommonUtilities.getTestData(sheetname);
			return data;
			
		}
		//if we have 2 rows this TC will run 2 times, if 1 row then 1 time
		@Test(priority=3, dataProvider="getCRMTestData")
		public void verifyNewMessageCreationTest(String title, String Msg)
		{
			commonutilitiesObj.switchToFrame("mainpanel");
			homepageobj.newMessageCreation(title, Msg);
		}
		
		
}
