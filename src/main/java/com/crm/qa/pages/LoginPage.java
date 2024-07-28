package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;


public class LoginPage extends BaseClass {
	
	WebDriver driver;
	//To initialize webelements
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.CSS,using="input[name='username']")
	private WebElement username;
	
	@FindBy(how=How.CSS,using="input[name='password']")
	private WebElement password;
	
	@FindBy(how=How.CSS,using="input[type='submit'][value='Login']")
	private WebElement loginbtn;
	
	@FindBy(how=How.XPATH,using="//img[contains(@class, 'img-responsive') and @alt='Free CRM Software for customer "
			+ "relationship management, sales and support']")
	private WebElement crmimg;
	
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	// Actions to be performed on the page
	public String getPageTitle()
	{
		return driver.getTitle();
	}


	public HomePage loginToApplication(String name, String pwd)
	{
		username.sendKeys(name);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage(driver);
	}
		public boolean verifyimage()
		{
			return crmimg.isDisplayed();
			
		}


}
