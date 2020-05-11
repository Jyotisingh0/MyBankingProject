package com.MyBankingProject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyBankingProject.pageObjects.EditCustomerPage;
import com.MyBankingProject.pageObjects.LoginPage;

public class TC_EditCustomer_004 extends BaseClass{
	
	@Test
	public void editCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(Username);
		lp.enterPassword(Password);
		lp.clickSubmit();
		Thread.sleep(3000);
		
		logger.info("Customer Registered Details!!!");
		
		EditCustomerPage editCustomer = new EditCustomerPage(driver);
		editCustomer.clickOnEditCustomer();
		editCustomer.enterCustomerId("86450");
		editCustomer.clickOnSubmit();
		
		//  Guru99 Bank Edit Customer Entry Page 
		
		boolean result = driver.getPageSource().contains(" Guru99 Bank Edit Customer Entry Page ");
		
		  logger.info("Validation Started....."); 
		  if(result==true) {
		  Assert.assertTrue(true);
		  logger.info("TestCase Passed for editCustomer..."); 
		  } 
		  else 
		  {
		  captureScreen(driver, "addNewCustomer"); 
		  logger.info("TestCase failed for editCustomer...");
		  Assert.assertTrue(false); 
		  }	
		
	}

}
