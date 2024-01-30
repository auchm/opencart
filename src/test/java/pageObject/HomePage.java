package pageObject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage  {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@CacheLookup
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement linkAccount;
	
	@CacheLookup
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement linkRegister;
	
	@CacheLookup
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Login']")  //login link added
	WebElement linkLogin;
	
	
	public void clickMyAccount() 
	{
		linkAccount.click();
	}
	
	public void clickRegister() 
	{
		linkRegister.click();
	}
	
	public void clickLogin() 
	{
		linkLogin.click();
	}
	

}
