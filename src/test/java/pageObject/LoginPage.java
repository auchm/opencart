package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailTxt;
	

	@FindBy(xpath="//input[@id='input-password']")
	WebElement passTxt;
	

	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement logBtn;
	
	
	public void emailAddress(String email) 
	{
		emailTxt.sendKeys(email);
	}
	
	public void passTxtField (String pass) 
	{
		passTxt.sendKeys(pass);
	}

	public void clickLogin () 
	{
		logBtn.click();
	}
}
