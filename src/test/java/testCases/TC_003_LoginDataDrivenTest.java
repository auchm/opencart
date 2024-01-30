package testCases;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {
	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void test_loginDDT(String username, String password, String bb) 
	{
		
		try {
		
		logger.info("Starting TC_003 Data Driven Test");
		HomePage home = new HomePage (driver);
		home.clickMyAccount();
		home.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.emailAddress(username);
		lp.passTxtField(password);
		lp.clickLogin();

		MyAccountPage my = new MyAccountPage(driver);
		boolean targetpage = my.accLogout();		
		
		if (bb.equals("Valid")) {
			if (targetpage == true) {
				my.clickLogout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

		if (bb.equals("Invalid")) {
			if (targetpage == true) {
				my.clickLogout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
			
			
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	
		
	
	
	
	
	
	}
	
	
	

}
