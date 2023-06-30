 package com.AmazonCA.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.AmazonCA.qa.util.Testutil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException {
		
		prop =new Properties();
		FileInputStream fis = new FileInputStream("C:\\QA\\SeleniumWorkSpace\\AmazonCA-POM-main\\AmazonCA-POM-main\\AmazonCA-POM\\AmazonCA-POM\\src\\main\\java\\com\\AmazonCA\\qa\\config\\config.properties");
		prop.load(fis);
	}
	public static void Initialization() {
		
		String browser=prop.getProperty("browser");
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\QA\\Drivers\\geckodriver-v0.32.2-win64\\geckodriver.exe");
			driver = new FirefoxDriver(); 
		}else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\QA\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			driver = new SafariDriver();
		}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
