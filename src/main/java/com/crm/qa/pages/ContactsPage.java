package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.BaseTest;

public class ContactsPage extends BaseTest {
	
	
	//OR
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLable;

	// new contact Or
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save' and @class='button' ]")
	WebElement saveBtn;

	public ContactsPage()  {
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	 public boolean verifyContactsLable(){
	     return contactsLable.isDisplayed();
		}
	 
	/* public void selectContactsByName(String name) {
		 driver.findElement(By.xpath("//a[text()="]"))
	 }*/
	 
	 
	public void createNewContact(String title,String ftname,String ltname,String comp)
	{
		Select dd=new Select(driver.findElement(By.name("title")));
		dd.selectByVisibleText("title");
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		company.sendKeys(comp);
	}
	}


