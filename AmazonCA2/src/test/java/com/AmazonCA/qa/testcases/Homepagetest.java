package com.AmazonCA.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AmazonCA.qa.base.TestBase;
import com.AmazonCA.qa.pages.Homepage;


public class Homepagetest extends TestBase{
	Homepage homepage;

	public Homepagetest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
		@BeforeMethod
	public void setUp() throws IOException {
		Initialization();
		homepage =new Homepage();
			}
	
	@Test
	public void HomepageTitleTest() {
		String title =homepage.validatehomepagetitle();
		Assert.assertEquals(title, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items");
	}
	//@Test
	public void logopresentTest() {
		boolean flag=homepage.logopresent();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void footerpresentTest() {
		boolean flag=homepage.footerpresent();
		Assert.assertTrue(flag);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
