package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h1[normalize-space()='Register Account']")
	WebElement DisplayRegisterAcc;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement FirstName_txt;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement LastName_txt;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email_txt;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Password_txt;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement continueBtn;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement privatePolicyChk;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void RegisterAccImg() 
	{
		DisplayRegisterAcc.isDisplayed();
	}
	
	public void firstNameField (String first) 
	{
		FirstName_txt.sendKeys(first);
	}
	
	public void lastNameField (String last) 
	{
		LastName_txt.sendKeys(last);
	}
	
	public void EmailField(String email) 
	{
		Email_txt.sendKeys(email);
	}
	
	public void passWordField(String pass) 
	{
		Password_txt.sendKeys(pass);
	}
	public void privatePolicyClick() 
	{
		privatePolicyChk.click();
	}
	
	public void ContinueBtn() 
	{
		continueBtn.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}
	
	
	

}
