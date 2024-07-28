package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;


public class HomePage extends BaseClass{

WebDriver driver;
	
	//initializing webelements
	public HomePage(WebDriver hdriver)
	{
		this.driver=hdriver;
		PageFactory.initElements(driver, this);
	}
	
	//Web Elements
		@FindBy(how=How.XPATH,using="//td[contains(text(),'User: Gagan Khanna')]")
		private WebElement usernameLabel;
		
		@FindBy(how=How.XPATH,using="//a[contains(text(),'Contacts')]")
		private WebElement contactsMenu;
		
		@FindBy(how=How.XPATH,using="//a[contains(text(),'Deals')]")
		private WebElement dealsMenu;

		@FindBy(how=How.XPATH,using="//a[contains(text(),'Tasks')]")
		private WebElement tasksMenu;
		
		@FindBy(how=How.XPATH,using="//a[contains(text(),'New Contact')]")
		private WebElement NewContactMenu;
		
		@FindBy(how=How.XPATH,using="//a[contains(text(), 'Contacts')]//parent::li//ul//li//a[text()='New Contact']")
		private WebElement NewContactMenu1;
		
		@FindBy(how=How.XPATH,using="//a[contains(text(), 'Messages')]")
		private WebElement Messageslink;
		
		@FindBy(how=How.XPATH,using="//input[@value= 'New Message']")
		private WebElement NewMessageLink;
		
		@FindBy(how=How.XPATH,using="//input[@id= 'subject']")
		private WebElement SubjectInputBox;
		
		@FindBy(how=How.XPATH,using="//textarea[@name='msg']")
		private WebElement MessageInputBox;
		
		@FindBy(how=How.XPATH,using="//input[@type='submit' and @value='Post']")
		private WebElement PostButton;
		
		//Getter methods to access private web elements
		public WebElement getUsernameLabel() 
		{
			return usernameLabel;
		}

		public WebElement getContactsMenu() 
		{
			return contactsMenu;
		}
		public WebElement getDealsMenu() 
		{
			return dealsMenu;
		}

		public WebElement getTasksMenu() {
			return tasksMenu;
		}

		//Methods for HomePage
		public boolean verifyUserNameDisplayed()
		{
			return usernameLabel.isDisplayed();
		}
		public String verifyHomePageTitle()
		{
			return driver.getTitle();
		}
		
		public ContactsPage clickOnContacts()
		{
			contactsMenu.click();
			return new ContactsPage(driver);
		}
		public void clickOnNewContactMenuOption() throws InterruptedException
		{
			Actions actions=new Actions(driver);
			actions.moveToElement(contactsMenu).build().perform();
			NewContactMenu.click();
		}
		public DealsPage clickOnDeals()
		{
			dealsMenu.click();
			return new DealsPage(driver);
		}
		
		public void newMessageCreation(String title, String msg)
		{
			Messageslink.click();
			NewMessageLink.click();
			SubjectInputBox.sendKeys(title);
			MessageInputBox.sendKeys(msg);
			PostButton.click();
		}
}
