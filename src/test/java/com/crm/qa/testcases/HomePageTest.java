package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends BaseTest {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactsPage;
	public HomePageTest() {
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
		
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO","HOME PAGE TITLE IS NOT MATCHED");
	}
	
	@Test(priority=2)
	public void verifyUsernameTest()
	{
	testutil.switchToFrame();
	Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() throws Exception
	{
		testutil.switchToFrame();
		contactsPage = homepage.clickOnContactsLink();
	}
		
     @AfterMethod
     public void tearDown()
	  {
		driver.quit();
	}

}
