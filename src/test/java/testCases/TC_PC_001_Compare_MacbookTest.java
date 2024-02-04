package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
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
		
		try{
		
		HomePage page = new HomePage(driver);
		page.clickSearchField("macbook");
		page.clickSearchIcon();
		
		driver.getTitle();
		String exp = driver.getTitle();
		String act = "Search - macbook";
		
		if(exp.equals(act)) 
		{
			System.out.println("Test passed here");
		}
		
		SearchMacbookPage macsrc = new SearchMacbookPage(driver);
		macsrc.ClickMacbook();
		
		MacbookMainPage mm = new MacbookMainPage(driver);
		mm.clickCompareIcon();
		mm.clickCompareLink();
		String Product_compPagetTitle = driver.getTitle();
		Assert.assertEquals(Product_compPagetTitle, "Product Comparison");
		mm.img();
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		
	   
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
