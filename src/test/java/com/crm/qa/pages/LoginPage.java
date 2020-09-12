package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

//extending TestBase.java class in order to access driver & prop
public class LoginPage extends TestBase {
	//PageFctory / ObjectRepository:
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[1]/div/input")	
	WebElement username;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[2]/div/input")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement loginBtn;

	//initializing PageFactory/objects via Constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	////////////////////////////////////ACTIONS///////////////////////////////////
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//since the login button will now take us to HomePage hence we'll return an object of HomePage.java class
		return new HomePage();
	}

}
