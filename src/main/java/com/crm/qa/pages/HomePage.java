package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseTest;

public class HomePage extends BaseTest {
	
	//OR
	@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
	WebElement userNameLable;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	//ne contact
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	
	//Initializing the age object
	public HomePage() {
		
		PageFactory.initElements(driver,this);
		
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}

	
	public boolean verifyCorrectUserName()
	{
		return userNameLable.isDisplayed();
	}
	
	
	public ContactsPage clickOnContactsLink() throws Exception 
	{
		contactsLink.click();
		return new ContactsPage();
		
	}
	
	public DealsPage clickOnDealsLink() throws Exception  
	{
		contactsLink.click();
		return new DealsPage();
	
}
	
	public TasksPage clickOnTasksLink()
	{
		contactsLink.click();
		return new TasksPage();

    }
	
	//new contact link
	public void clickOnNewContactLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
		
		
		
		
	}
}