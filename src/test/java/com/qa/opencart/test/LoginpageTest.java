package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class LoginpageTest extends BaseTest {
	
	@DataProvider
	public void getTestData() {
		ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
	}
	@Test
	public void loginPageTitle() {
		String logintitle =loginpage.getPageTitle();
		System.out.println("Actual title of LoginPage is :" + logintitle);
		Assert.assertEquals(logintitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void loginPageUrl() {
		String loginUrl =loginpage.getCurrentUrl();
		System.out.println("Actual Url of LoginPage is :" + loginUrl);
		Assert.assertTrue(loginUrl.contains(Constants.LOGIN_PAGE_URL));
	}
	
	@Test
	public void forgotPwdLink() {
		Assert.assertTrue(loginpage.isForgotPwdLinkExists());
		
	}

	@Test
	public void doLogin() {
		loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim() );
	}
}
