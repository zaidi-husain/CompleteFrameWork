 package com.qa.opencart.factory;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * @Author Husain Zaidi
 */
public class DriverFactory {
	
	
	public WebDriver driver;
	public Properties prop;
	public OptionManager optionsManager;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(Properties prop) {
		
		/*
		 * This method will return driver
		 * This method is used to initialize the webdriveron the basis of given browser name
		 */
		
		String browser = prop.getProperty("browser");
		optionsManager = new OptionManager(prop);
		System.out.println("Browser Name is :" + browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tldriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else 
		System.out.println("Please pass the right browser name" + browser);
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}
	
	public synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	/*
	 * @return This method returns properties
	 * This method is used to initialise properties on the basis of given env
	 */
	public Properties initProp() {
		prop = new Properties();
		FileInputStream ip = null;
		
		String env = System.getProperty("env");
		if (env == null) {
		try {
			 ip = new FileInputStream("./src/test/resources/config/config.properties");
			//prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
	
	else {
		System.out.println("Running on the Environment" + env);
		try {
		switch (env.toLowerCase()) {
		case "qa":
			 ip = new FileInputStream("./src/test/resources/config/qa.config.properties");

		case "dev":
			 ip = new FileInputStream("./src/test/resources/config/qa.config.properties");

		case "stage":
			 ip = new FileInputStream("./src/test/resources/config/qa.config.properties");

			break;

		default:
			break;
		}}
		catch (Exception e){
			e.printStackTrace();
			}}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
/*
 * This method is created to take the screenshot
 * 
 * 
 */
	
	public String getScreenshot() {
		File srcfile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshot"+System.currentTimeMillis()+ ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcfile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	

}
