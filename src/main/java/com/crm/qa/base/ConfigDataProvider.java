package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() throws IOException,InterruptedException
	{
		
		File srcfile= new File("C:\\Users\\Rajveer\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		FileInputStream fis= new FileInputStream(srcfile);
		pro=new Properties();
		pro.load(fis);
	}
	
	public String getbrowsername()
	{
		return pro.getProperty("Browser");
	}
	public String gettestingURL()
	{
		return pro.getProperty("qaURL");
	}
	public String getDriverLocalOrRemote()
	{
		return pro.getProperty("Driver");
	}
	public String getUsername()
	{
		return pro.getProperty("username");
	}
	public String getPassword()
	{
		return pro.getProperty("password");
	}
	public String getimplicitWait()
	{
		return pro.getProperty("implicitWait");
	}
}
