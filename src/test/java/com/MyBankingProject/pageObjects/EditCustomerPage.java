package com.MyBankingProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
WebDriver local_driver;
	
	public EditCustomerPage(WebDriver remote_driver)
	{
		local_driver = remote_driver;
		PageFactory.initElements(remote_driver, this);   
	}

	@FindBy(how = How.XPATH, using = "//a[text() = 'Edit Customer']")
	@CacheLookup
	WebElement lnkEditCustomer;
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'cusid']")
	@CacheLookup
	WebElement txtCustomerId;	
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'AccSubmit']")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickOnEditCustomer()
	{
		lnkEditCustomer.click();
	}
	
	public void enterCustomerId(String CustId)
	{
		txtCustomerId.sendKeys(CustId);
	}
	
	public void clickOnSubmit()
	{
		btnSubmit.click();
	}

}
