package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

public class LoginPage {

	private WebDriver driver;
	private ElementUtils eleUtil;
	
	//1. By locator = Object repository
	//Locators should be private in nature
	private By email = By.id("emailInput");
	private By password = By.id("passwordInput");
	private By loginButton = By.name("Submit");
	////button[@type = 'submit']
	private By forgotpassword = By.linkText("Forgotten Password");
	
	
	//2. Page Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtils(driver);
	}
	
	//3. Page Actions/methods/features
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
		
	}
	
	public boolean isForgotPwdLinkExists() {
		return eleUtil.doIsDisplayed(forgotpassword);
	}
	public HomePage doLogin(String un, String pwd) {
		eleUtil.doSendKeys(email, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginButton);
		return new HomePage();
	}
	
}
