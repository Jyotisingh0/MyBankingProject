package com.MyBankingProject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyBankingProject.pageObjects.LoginPage;

public class TC_LoginPage_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.enterUserName(Username);
		logger.info("entered Username");
		
		lp.enterPassword(Password);
		logger.info("entered Password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
		{
			Assert.assertTrue(true);
			logger.info("TestCase passed");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("TestCase failed");

		}
		
		
	}

}
