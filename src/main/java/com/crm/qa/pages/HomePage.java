package com.crm.qa.pages;

import com.crm.qa.base.TestBase;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//extending TestBase.java class in order to access driver & prop
public class HomePage extends TestBase {
	@FindBy(xpath="//*[@id=\"top-header-menu\"]/div[3]/span[1]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/a[3]/span")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/a[5]/span")
	WebElement dealsLink;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/a[6]/span")
	WebElement tasksLink;
	
	//constructor for initializing page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	///////////////////////////ACTIONS////////////////////////////
	
	public void verifyHomePageTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title,"Cogmento CRM", "HomePageTitle is incorrect.");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("HomePage title is correct. The title displayed is: "+title);
	}
	
	public void verifyuserNameLabel() {
		Assert.assertTrue(userNameLabel.isDisplayed());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("UserName label is displayed on HomePage.");
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("Clicked on Contacts link.");
		return new ContactsPage();
	}
	
		
}
