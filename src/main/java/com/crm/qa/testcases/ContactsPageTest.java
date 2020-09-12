package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	ContactsPage contactsPageObj;
	LoginPage loginPageObj;
	HomePage homePageObj;
	
	String sheetName = "contacts";
	
	//constructor calling Super class i.e. TestBase.java class
		public ContactsPageTest() {
			super();
		}
		
		@BeforeMethod
		public void setUp() {
			initialization(); //calling initialization method of super class
			contactsPageObj = new ContactsPage();
			loginPageObj = new LoginPage();
			homePageObj = loginPageObj.login(prop.getProperty("username"), prop.getProperty("password")); //login into application
			homePageObj.clickOnContactsLink(); //opening Contacts page
		}
		
		@Test(priority=1)
		public void verifyContactsPageLabel() {
			contactsPageObj.verifyContactsLabel();
		}
		
		@Test(priority=2)
		public void selectContact() {
			contactsPageObj.selectAContact();
		}
		
		@DataProvider
		public Object[][] getCRMTestData() {
			Object data[][] = TestUtil.getTestData(sheetName);
			return data;
		}
		
		@Test(priority=3,dataProvider="getCRMTestData")
		public void validateCreateNewContact(String fname, String lname) {
			contactsPageObj.newContactLink();
			contactsPageObj.createNewContact(fname, lname);
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
		
		
}
