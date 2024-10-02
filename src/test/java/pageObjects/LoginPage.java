package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//input[@id='input-email']") WebElement txtEmailAddress;
	
	@FindBy(xpath = "//input[@id='input-password']") WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='input-password']/following::input[1]") WebElement loginButton;

	public void enterEamil(String email)
	{
		txtEmailAddress.sendKeys(email);
	}
	
	public void enterPasswoard(String passwoard) {
		txtPassword.sendKeys(passwoard);
	}
	
	public void submitLoginButton()
	{	loginButton.click();
	
	}
	
	public void logIN(String email, String passwoard) {
		HomePage homePage=new HomePage(driver);
		
		homePage.clickMyAccount();
		homePage.clickOnLoginButton();
		
		txtEmailAddress.sendKeys(email);
		txtPassword.sendKeys(passwoard);
		loginButton.click();
				
	}
	
	
}
