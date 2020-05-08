package com.MyBankingProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver local_driver;
	
	 public LoginPage(WebDriver remote_driver)
	{
		local_driver = remote_driver;
		PageFactory.initElements(remote_driver, this);   
	}

	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath ="//a[text()='Log out']")
	WebElement btnLogout;
	
	
	public void enterUserName(String Uname)
	{
		txtUserName.sendKeys(Uname);;
	}
	
	public void enterPassword(String Pwd)
	{
		txtPassword.sendKeys(Pwd);;
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}

	public void clicklogout()
	{
		btnLogout.click();
	}

}
