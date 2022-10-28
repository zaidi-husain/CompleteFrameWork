package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public Properties prop;
	public DriverFactory df;
	public LoginPage loginpage;
	
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		loginpage = new LoginPage(driver);
	}
	
	
	
	
	
	@AfterTest
	public void Teardown() {
		driver.quit();
	}

}
