package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.util.TestUtil;



public class LoginPage {

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "x-username")
	WebElement username;
	
	@FindBy(id = "loginContinue")
	WebElement logincontinue;
	
	@FindBy(id = "x-pwd")
	WebElement password;
	
	@FindBy(id = "loginSubmit")
	WebElement loginBtn;
	
	public HomePage login(String Un, String pwd) throws InterruptedException{
		

		username.sendKeys(Un);	
		TestUtil.WaitUntilElementVisible(logincontinue);
		logincontinue.click();
		password.sendKeys(pwd);		
		loginBtn.isEnabled();
		loginBtn.click();
		
		return new HomePage();
		
		
		
	}

}

