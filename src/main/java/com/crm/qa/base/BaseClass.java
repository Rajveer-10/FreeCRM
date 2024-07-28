package com.crm.qa.base;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.crm.qa.utilities.CommonUtilities;
import com.crm.qa.utilities.WebEventListener;

public class BaseClass {

		public static WebDriver driver;
		public ConfigDataProvider conf;
		public static EventFiringWebDriver e_driver;
		public static WebEventListener eventListener;
		
		//Actions class
		//public Actions actions=new Actions(driver);
		
		//Method to initialize driver instance as per local or remote in singleton manner
		public void initialize() throws IOException, InterruptedException 
		{
			System.out.println("inside initialize method");
			
			conf= new ConfigDataProvider();
			
			if(conf.getDriverLocalOrRemote().equalsIgnoreCase("Local"))
			{
					if(conf.getbrowsername().equalsIgnoreCase("Chrome"))
					{
					//System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
					System.setProperty("webdriver.chrome.driver","C:\\Users\\Rajveer\\eclipse-workspace\\Framework\\Drivers\\chromedriver.exe");
					driver= new ChromeDriver();
					}
					else if (conf.getbrowsername().equalsIgnoreCase("Firefox"))
					{
						System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
						driver= new FirefoxDriver();
					}
				
			}
			
			else if(conf.getDriverLocalOrRemote().equalsIgnoreCase("Remote"))
			{
				
					if(conf.getbrowsername().equalsIgnoreCase("Chrome"))
					{
					System.setProperty("webdriver.chrome.driver","C:\\Users\\Rajveer\\eclipse-workspace\\Framework\\Drivers\\chromedriver.exe");
					driver= new ChromeDriver();
					}
					else if (conf.getbrowsername().equalsIgnoreCase("Firefox"))
					{
						System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
						driver= new FirefoxDriver();
					}
				
			}
			
			//Event listener
			e_driver=new EventFiringWebDriver(driver);
			eventListener=new WebEventListener();
			e_driver.register(eventListener);
			driver=e_driver;
			
			System.out.println("Launching URL");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Long.parseLong(conf.getimplicitWait()), TimeUnit.SECONDS);
			driver.get(conf.gettestingURL());
			
		  }
		
		public void driverQuit()
		{
			System.out.println("Quitting Browser");
			driver.quit();
		}
		
		

}
