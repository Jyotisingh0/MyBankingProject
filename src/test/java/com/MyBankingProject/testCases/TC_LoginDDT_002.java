package com.MyBankingProject.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MyBankingProject.pageObjects.LoginPage;
import com.MyBankingProject.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider = "LoginData")
	public void loginDDT(String username, String Password) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(username);
		logger.info("Username is provided");
		
		lp.enterPassword(Password);
		logger.info("Password is provided");
		
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); 	//Close alert
			driver.switchTo().defaultContent();		//focus on current page
			Assert.assertTrue(false);	
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.warn("Login Passed");
			lp.clicklogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); 	//Closing logout alert
			driver.switchTo().defaultContent();		//focus on current page
			
		}
	}
	
	public boolean isAlertPresent()		// User defined method to check whether alert is present or not
	{
		try 
		{
			driver.switchTo().alert();
			return true;	
		} 
		catch (NoAlertPresentException e) 
		{
			return false;
		}
			
	}
	
	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/MyBankingProject/testData/LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][] = new String[rownum][colcount];
		
		for (int i = 1; i <= rownum; i++) 
		{
			for (int j = 0; j < colcount; j++)
			{
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j); //1 0
			}
		}
		return loginData;
	}
}
