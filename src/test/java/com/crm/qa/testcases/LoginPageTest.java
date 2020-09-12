package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

//extending TestBase.java class in order to access driver & prop
public class LoginPageTest extends TestBase{
	
	LoginPage loginPageObj; //declaring object of LoginPage.java class
	HomePage homePageObj;   //declaring object of HomePage.java class
	
	//constructor calling Super class i.e. TestBase.java class
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization(); //calling initialization method of super class
		loginPageObj = new LoginPage(); //creating object of LoginPage.java class
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPageObj.validateLoginPageTitle(); //calling method of LoginPage.java class by using object loginPageObj
		Assert.assertEquals(title, "Cogmento CRM", "Title mismatch!");
		System.out.println("Page title is correct.");
	}
	
	@Test(priority=2)
	public void loginTest() {
		homePageObj = loginPageObj.login(prop.getProperty("username"), prop.getProperty("password")); //calling login() method of LoginPage.java class
	}
	
}
