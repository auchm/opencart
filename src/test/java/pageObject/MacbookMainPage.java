package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MacbookMainPage extends BasePage {
	
	public MacbookMainPage(WebDriver driver)
	{
		super(driver);
	}
	
	@CacheLookup
	@FindBy(xpath="//i[@class='fa-solid fa-arrow-right-arrow-left']")
	WebElement compareIcon;
	
	@CacheLookup
	@FindBy(xpath="//a[normalize-space()='product comparison']")
	WebElement compareLink;
	
	public void clickCompareIcon() 
	{
		compareIcon.click();
	}
	
	public void clickCompareLink() 
	{
		compareLink.click();
	}

}
