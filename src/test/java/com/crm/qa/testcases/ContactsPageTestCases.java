package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.CommonUtilities;


public class ContactsPageTestCases extends BaseClass{

	LoginPage loginpageobj;
	HomePage homepageobj;
	CommonUtilities commonutilitiesObj;
	ContactsPage contactpageObj;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialize();
		loginpageobj= new LoginPage(driver);
		commonutilitiesObj=new CommonUtilities();
		homepageobj=loginpageobj.loginToApplication(conf.getUsername(),conf.getPassword());
		
		commonutilitiesObj.switchToFrame("mainpanel");
		contactpageObj= homepageobj.clickOnContacts();
	}
	@AfterMethod
	public void teardown()
	{
		driverQuit();
	}

	@Test(priority=1)
	public void verifyContactsLable() 
	{
		Assert.assertTrue(contactpageObj.verifyContactsLabel(),"Contacts label is not present");
	}
	
	
	@Test(priority=2)
	public void selectContactsCheckboxs() 
	{
		contactpageObj.selectContactsByName("Alex Berth");
		contactpageObj.selectContactsByName("Ann Pansa");
	}
	
	/*
	@Test(priority=3)
	public void validateCreateNewContactTest() throws Exception
	{
		commonutilitiesObj.switchToFrame("mainpanel");
		homepageobj.clickOnNewContactMenuOption();
		contactpageObj.createNewContact("Mr.", "Tom", "hanks");
	}*/
	
}
