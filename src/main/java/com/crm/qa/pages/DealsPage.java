package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class DealsPage extends BaseClass {
	WebDriver driver;
	public DealsPage(WebDriver ddriver)
	{
		this.driver=ddriver;
		PageFactory.initElements(driver, this);
	}

}
