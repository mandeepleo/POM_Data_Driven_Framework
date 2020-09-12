package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement contactsLabel;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div/div[2]/table/tbody/tr/td[1]")
	WebElement contactCheckBox1;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div/a/button")
	WebElement newContactBtn;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/div/input")
	WebElement firstName;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[2]/div/div/input")
	WebElement lastName;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div/button[2]")
	WebElement saveContactBtn;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[2]/div/div[1]/div[1]")
	WebElement afterSaveLabel;
	
	//constructor for initializing page objects
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	////////////////////--ACTIONS--///////////////////////
	
	public void verifyContactsLabel() {
		Assert.assertTrue(contactsLabel.isDisplayed(),"Failed to find ContactsPage Label");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Contacts label is displayed.");	
	}
	
	public void selectAContact() {
		Assert.assertTrue(contactCheckBox1.isDisplayed(),"Failed to find Contact CheckBox"); //if check-box is not found, execution will terminate
		contactCheckBox1.click(); //check box will be selected if above assertion is passed/true
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Contact checkbox is selected.");
	}
	
	public void newContactLink() {
		Assert.assertTrue(newContactBtn.isDisplayed(),"Could not locate New Contact button.");
		newContactBtn.click(); //click on New Contact button		
	}
	
	public void createNewContact(String f_name, String l_name) {
		firstName.sendKeys(f_name); //enter first name
		lastName.sendKeys(l_name);  //enter last name
		Assert.assertTrue(saveContactBtn.isDisplayed());
		System.out.println("Save Contact button is located.");
		saveContactBtn.click();    //click on Save Contact button
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(afterSaveLabel.isDisplayed()); //verify label is displayed after save to confirm save success
		System.out.println("Contact saved successfully.");
	}
	
	
	
}


