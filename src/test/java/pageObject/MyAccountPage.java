package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage (WebDriver driver)
	{
		super(driver);
	}
	

	@CacheLookup
	@FindBy(xpath="//h2[normalize-space()='My Account']")  //login link added
	WebElement AcctImage;
	
	@CacheLookup
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")  //login link added
	WebElement logOutlink;
	
	

	public boolean accLogout() {
		try {
			return (AcctImage.isDisplayed());
		} catch (Exception e) {
			return (false);

		}
		
	}
	
	public void clickLogout()
	{
		logOutlink.click();
	}

}
