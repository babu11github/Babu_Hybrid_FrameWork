package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends BaseTest{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactsPage;
	String sheetName="ContacatsDetails";
	public ContactsPageTest() {
	super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception 
	{
		Initialization();
		testutil = new TestUtil();
		loginpage=new LoginPage();
		contactsPage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		testutil.switchToFrame();
		 contactsPage=homepage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLable()
	{
		Assert.assertTrue(contactsPage.verifyContactsLable(),"contacts labe is on the page");
	}

	
	@DataProvider
	public Object [] [] getCRMTestData()
	{
	Object data[] [] = TestUtil.getTestData(sheetName);
			
	return data;
	}
	
	
	
	
	@Test(priority=2,dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title,String firstname,String lastname,String company) throws Exception
	{
		homepage.clickOnNewContactLink();
	 //	contactsPage.createNewContact("Mr", "babu","venga","Google");
		contactsPage.createNewContact(title, firstname, lastname, company);
	}
	
	
	 @AfterMethod
     public void tearDown()
	  {
		driver.quit();
	}
}
