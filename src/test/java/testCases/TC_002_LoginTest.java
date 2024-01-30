package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	
	

	
	
	@Test(groups= {"Sanity", "Master"})
	public void test_login() 
	{
		HomePage home = new HomePage (driver);
		home.clickMyAccount();
		home.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.emailAddress(rb.getString("email"));
		lp.passTxtField(rb.getString("password"));
		lp.clickLogin();
		
		MyAccountPage my = new MyAccountPage(driver);
		boolean img = my.accLogout();
		Assert.assertEquals(img, true);
		
		my.clickLogout();
		
		
		
	}
	
	

}
