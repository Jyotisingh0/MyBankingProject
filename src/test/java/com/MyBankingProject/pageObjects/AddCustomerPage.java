package com.MyBankingProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
	WebDriver local_driver;
	
	public AddCustomerPage(WebDriver remote_driver)
	{
		local_driver = remote_driver;
		PageFactory.initElements(remote_driver, this);   
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='New Customer']")
	@CacheLookup
	WebElement lnkAddNewCustomer; 
	
	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	@CacheLookup
	WebElement txtcustomerName; 
	
	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender; 
	
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtDob; 
	
	@FindBy(how = How.XPATH, using = "//textarea[@name='addr']")
	@CacheLookup
	WebElement txtAddress; 
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'city']")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'state']")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'pinno']")
	@CacheLookup
	WebElement txtPinNo;
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'telephoneno']")
	@CacheLookup
	WebElement txtMobileNo;
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'emailid']")
	@CacheLookup
	WebElement txtEmailId;  
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'password']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'sub']")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'res']")
	@CacheLookup
	WebElement btnReset;
	 
	
	public void clickOnNewCustomer()
	{
		lnkAddNewCustomer.click();
	}
	
	public void CustomerName(String CustName)
	{
		txtcustomerName.sendKeys(CustName);;
	}
	
	public void CustGender(String CustGender)
	{
		rdGender.click();
	}
	
	public void CustDOB(String dd, String mm, String yy)
	{
		txtDob.sendKeys(dd);
		txtDob.sendKeys(mm);
		txtDob.sendKeys(yy);
	}
	
	public void CustAddress(String CustAddress)
	{
		txtAddress.sendKeys(CustAddress);
	}
	
	public void CustCity(String CustCity)
	{
		txtCity.sendKeys(CustCity);
	}
	
	public void CustState(String CustState)
	{
		txtState.sendKeys(CustState);
	}
	
	public void CustPin(String CustPin)
	{
		txtPinNo.sendKeys(String.valueOf(CustPin));
	}
	
	public void CustMobileNo(String CustMobile)
	{
		txtMobileNo.sendKeys(CustMobile);
	}
	
	public void CustEmail(String CustEmail)
	{
		txtEmailId.sendKeys(CustEmail);
	}
	
	public void CustPassword(String CustPassword)
	{
		txtPassword.sendKeys(CustPassword); 
	}
	
	public void submit()
	{
		btnSubmit.click(); 
	}
	
	public void reset()
	{
		btnReset.click(); 
	}
}
