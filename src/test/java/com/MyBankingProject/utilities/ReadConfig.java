package com.MyBankingProject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	public ReadConfig()							//constructor
	{
		File src = new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	
	public String getUrl()
	{
		String Url = prop.getProperty("baseUrl");
		return Url;
	}
	
	public String getUsername()
	{
		String Username = prop.getProperty("Username");
		return Username;
	}
	
	public String getPassword()
	{
		String Password = prop.getProperty("Password");
		return Password;
	}
	
	public String getChromePath()
	{
		String chromePath = prop.getProperty("chrome_path");
		return chromePath;
	}
	
	public String getIEPath()
	{
		String iePath = prop.getProperty("ie_path");
		return iePath;
	}
	
	public String getGeckoPath()
	{
		String geckoPath = prop.getProperty("gecko_path");
		return geckoPath;
	}
	
	public String getLogPath()
	{
		String logPath = prop.getProperty("log_path");
		return logPath;
	}
	
	
}
