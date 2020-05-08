package com.MyBankingProject.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyBankingProject.pageObjects.AddCustomerPage;
import com.MyBankingProject.pageObjects.LoginPage;

public class TC_AddCustomerPage_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(Username);
		lp.enterPassword(Password);
		lp.clickSubmit();
		Thread.sleep(3000);
		
		logger.info("Customer Registered Details!!!");
		
		AddCustomerPage addCustomer = new AddCustomerPage(driver);
		addCustomer.clickOnNewCustomer();
		addCustomer.CustomerName("Jyoti Singh");
		addCustomer.CustGender("female");
		addCustomer.CustDOB("21", "12", "1996");
		Thread.sleep(2000);
		addCustomer.CustAddress("silicon city near club house");
		addCustomer.CustCity("Indore");
		addCustomer.CustState("Madhya Pradesh");
		addCustomer.CustPin("452012");
		addCustomer.CustMobileNo("9876543210");
		
		String email = randomString()+"@gmail.com";
		addCustomer.CustEmail(email);
		
		addCustomer.CustPassword("Jyoti123");
		addCustomer.submit();
		
		
		  Thread.sleep(3000); boolean result =
		  driver.getPageSource().contains("Customer Registered Successfully!!!");
		  
		  logger.info("Validation Started....."); 
		  if(result==true) {
		  Assert.assertTrue(true);
		  logger.info("TestCase Passed..."); 
		  } 
		  else 
		  {
		  captureScreen(driver, "addNewCustomer"); 
		  logger.info("TestCase failed...");
		  Assert.assertTrue(false); 
		  }	
	}
	
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return (generatedString);
	}
	
	public static String randomNumber()
	{
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
}
