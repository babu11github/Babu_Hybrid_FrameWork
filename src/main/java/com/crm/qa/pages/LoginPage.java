package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseTest;

public class LoginPage extends BaseTest {
	

	//object repository (or)
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement loginBtn;
		
		@FindBy(xpath="//button[contains(text(),'Sign Up')]")
		WebElement SignUpBtn;
		
		@FindBy(xpath="//img[contains(@class,'img-responsive')]")
		WebElement FreeCrmImage;
		

		public LoginPage() {
			
		//Initializing the page ojects
		PageFactory.initElements(driver,this);
		
		}
		
		//actions
		public String validateLoginPageTitle()
		{
			return driver.getTitle();
		}

		public boolean validateCrmImage()
		{
			return FreeCrmImage.isDisplayed();
		}
		
		public HomePage login(String un,String pwd) throws Exception
		{
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			
			return new  HomePage();
		}
		
		
	}



	

