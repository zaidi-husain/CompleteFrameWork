package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

public class RegistrationPage {
	
	public WebDriver driver;
	private ElementUtils eleUtil;
	
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By pwd = By.id("input-password");
	
	private By subs = By.id("input-newsletter-yes");
	
	private By agree = By.xpath("//input[@name ='agree']");
	
	private By submit = By.xpath("//button[contains(text(), 'Continue')]");
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtils(driver);
		
	}
	
	public void getRegisterPageTitle(String firstName, String lastName, String email, String pwd) {
		eleUtil.doSendKeys(this.firstName, firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.pwd, pwd);
		eleUtil.doClick(this.subs);
		eleUtil.doClick(agree);
		eleUtil.doClick(submit);
		
	}

}
