package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends BaseTest {
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() {
	super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		Initialization();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title,"#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority=2)
	public void validateCrmImage()
	{
		boolean flot=loginpage.validateCrmImage();
        Assert.assertTrue(flot);
	}
	
	
	@Test(priority=3)
	public void loginTest() throws Exception
	{
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
