package testCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.MacbookMainPage;
import pageObject.SearchMacbookPage;
import testBase.BaseClass;
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_PC_001_Compare_MacbookTest extends BaseClass{
	
	
	@Test
	public void MacbookTest() 
	{
		
		HomePage page = new HomePage(driver);
		page.clickSearchField("macbook");
		page.clickSearchIcon();
		
		SearchMacbookPage macsrc = new SearchMacbookPage(driver);
		macsrc.ClickMacbook();
		
		MacbookMainPage mm = new MacbookMainPage(driver);
		mm.clickCompareIcon();
		
		
		
		
		
		
		
		
	}

}
