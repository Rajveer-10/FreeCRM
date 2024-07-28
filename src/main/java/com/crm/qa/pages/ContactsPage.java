package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.BaseClass;

public class ContactsPage extends BaseClass{

	WebDriver driver;
	public ContactsPage(WebDriver cdriver)
	{
		this.driver=cdriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//td[contains(text(),'Contacts')]")
	private WebElement contactslbl;
	
	@FindBy(how=How.XPATH,using="//input[@id='first_name']")
	private WebElement contactsPageFirstNameField;
	
	@FindBy(how=How.XPATH,using="//input[@id='surname']")
	private WebElement contactsPageLastNameField;
	
	@FindBy(how=How.XPATH,using="//input[@class='button' and @value='Load From Company']"
			+ "//parent::td[@valign='top']//preceding-sibling::input[@type='submit' and @value='Save']")
	private WebElement contactsPageSaveButton;
	
	
	//ToWrite Dynamic Xpath for different table contents with same hirerchy we cannot use FindBy
	//Use normal driver.findBy in a method to return specific element from the table like below
	
	public void selectContactsByName(String contactname)
	{
		driver.findElement(By.xpath("//a[text()='"+contactname+"']"
				+ "//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']"
				+ "//input[@name='contact_id']")).click();
	}
	
	public boolean verifyContactsLabel()
	{
		return contactslbl.isDisplayed();
	}
	
	//Creating new contact
	public void createNewContact(String title, String firstName, String lastName)
	{
		Select sc= new Select(driver.findElement(By.xpath("//Select[@name='title' and @class='select']")));
		sc.selectByValue(title);
		contactsPageFirstNameField.sendKeys(firstName);
		contactsPageLastNameField.sendKeys(lastName);
		contactsPageSaveButton.click();
		
	}
}
