package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPageObj;
	HomePage homePageObj;
	ContactsPage contactsPageObj;
	
	//constructor calling Super class i.e. TestBase.java class
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization(); //calling initialization method of super class
		loginPageObj = new LoginPage(); //creating object of LoginPage.java class
		homePageObj = loginPageObj.login(prop.getProperty("username"), prop.getProperty("password")); //login into the application by calling login() method of LoginPage.java
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		homePageObj.verifyHomePageTitle();
	}
	@Test(priority=2)
	public void verifyUserNameLabel() {
		homePageObj.verifyuserNameLabel();	
	}
	
	@Test(priority=3)
	public void clickOnContactsLinkText() {
		contactsPageObj = homePageObj.clickOnContactsLink();		
	}	
		
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
