package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;
//
//public class LoginPage {
//
//	private WebDriver driver;
//	private ElementUtils eleUtil;
//	
//	//1. By locator = Object repository
//	//Locators should be private in nature
//	private By email = By.id("input-email");
//	private By password = By.id("input-password");
//	private By loginButton = By.xpath("//button[@type = 'submit']");
//	private By forgotpassword = By.linkText("Forgotten Password");
//	
//	
//	
//	
//	
//	//2. Page Constructor
//	public LoginPage(WebDriver driver) {
//		this.driver = driver;
//		eleUtil = new ElementUtils(driver);
//	}
//	
//	//3. Page Actions/methods/features
//	public String getPageTitle() {
//		return driver.getTitle();
//	}
//	
//	public String getCurrentUrl() {
//		return driver.getCurrentUrl();
//		
//	}
//	
//	public boolean isForgotPwdLinkExists() {
//		return eleUtil.doIsDisplayed(forgotpassword);
//	}
//	public void doLogin(String un, String pwd) {
//		eleUtil.doSendKeys(email, un);
//		eleUtil.doSendKeys(password, pwd);
//		eleUtil.doClick(loginButton);
//	}
//	
//}
//package com.qa.opencart.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

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
		elementUtil = new ElementUtils(driver);
	}

	// 3. page actions/methods/features:

	@Step("getting login page title....")
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	@Step("getting login page url....")
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}

	@Step("checking Forgot Pwd link Exist or not....")
	public boolean isForgotPwdlinkExist() {
		System.out.println("checking -> isForgotPwdlinkExist");
		return elementUtil.doIsDisplayed(forgotPwdLink);
	}

	@Step("checking register link Exist or not....")
	public boolean isRegisterlinkExist() {
		return elementUtil.doIsDisplayed(registerLink);
	}

	@Step("login with username : {0} and password: {1}")
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("creds: " + un + ":" + pwd);
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new AccountsPage(driver);
	}
	
	@Step("navigating to register page....")
	public RegisterationPage navigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new RegisterationPage();
	}
<<<<<<< HEAD

=======
	public HomePage doLogin(String un, String pwd) {
		eleUtil.doSendKeys(email, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginButton);
		return new HomePage();
	}
	
>>>>>>> 2fa92324c713eba86d63052e2cffc6df224931c2
}



























