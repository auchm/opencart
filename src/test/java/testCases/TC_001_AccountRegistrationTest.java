package testCases;

import org.testng.Assert;



import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups= {"Regression", "Master"})
	public void test_account_Registration() 
	{
		logger.info("*****TC_001_AccountRegistrationTest****");
		logger.debug("****Generating debug log***");// also dont forget to add Debug in the root level of the log4j2 xlm
		
		try {
		HomePage home = new HomePage (driver);
		home.clickMyAccount();
		logger.info("click on my account");
		home.clickRegister();
		logger.info("click on registration");
		
		
		
		

		
		AccountRegistrationPage reg = new AccountRegistrationPage(driver);
		logger.info("providing customer details");

		reg.RegisterAccImg();
		reg.firstNameField(randomeString().toLowerCase());
		reg.lastNameField(randomeString().toUpperCase());
		reg.EmailField(randomeString()+"@gmail.com");
		reg.passWordField(randomAlphaNumeric());
		reg.privatePolicyClick();
		reg.ContinueBtn();
		logger.info("click on continue button");
		
		
		
		
		

		
		  
		/*String pwd = randomAlphaNumeric();
		 * use this for a username and password that must be the same on a web application
		 */
		//use the try catch block to properly exit a failed test wit a assertion fail
		
		
		String confmsg = reg.getConfirmationMsg();
		
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		
	}
	
	

}
