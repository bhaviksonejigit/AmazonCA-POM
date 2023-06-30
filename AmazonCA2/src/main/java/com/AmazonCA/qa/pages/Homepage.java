package com.AmazonCA.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AmazonCA.qa.base.TestBase;

public class Homepage extends TestBase {
	
	//PageFactory
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchtextbox;
	
	@FindBy(xpath="//a[@id='nav-logo-sprites']")
	WebElement amazonlogo;
	
	@FindBy(xpath="//div[@id='navFooter']")
	WebElement footer;
	//List<WebElement> footerlist=footer.findElements(By.tagName("a"));
	
	//@FindBy(xpath="//label[@id='searchDropdownDescription']")
	//WebElement dropdownbox;
	//List<WebElement> options=dropdownbox.findElements(By.xpath("//option[contains@value='search-alias']"));
		
	public Homepage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	public boolean logopresent() {
	 return amazonlogo.isDisplayed();
	}
	public boolean footerpresent() {
		 return footer.isDisplayed();
		}
		
	public String validatehomepagetitle() {
		return driver.getTitle();
			}
	
	}
