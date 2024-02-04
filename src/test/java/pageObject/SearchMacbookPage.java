package pageObject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchMacbookPage extends BasePage{
	
	public SearchMacbookPage(WebDriver driver)
	{
		super(driver);
	}
	

	@CacheLookup
	@FindBy(xpath="//img[@title='MacBook']")
	WebElement macBook;
	
	public void ClickMacbook() 
	{
		macBook.click();
	}
	

}
