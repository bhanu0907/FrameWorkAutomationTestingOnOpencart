package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	//WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		//this.driver=driver;
	}

	@FindBy(xpath  = "//div[@id=\"top-links\"]//li[2]//span[1]") WebElement lnkMyAccount;

	@FindBy(xpath = "//div[@id=\"top-links\"]/ul/li[2] //li[1]/a") WebElement lnkRegister;
	
	@FindBy(xpath = "//div[@id='top-links']/ul/li[2]//li[2]/a") WebElement lnkLogin;

	//	By lnkMyAccount1Selector= By.xpath("//div[@id=\"top-links\"]//li[2]//span[1]");
	//	WebElement lnkMyAccount1=driver.findElement(lnkMyAccount1Selector);
	
	@FindBy(xpath = "//div[@id='search']//input[@name=\"search\"]") WebElement searchBar;
	
	
	@FindBy(xpath = "//div[@id=\"search\"]//button") WebElement clickTosearch;
	public void clickMyAccount() {
		lnkMyAccount.click();
		
	}
	
	public void clickOnRegisterButton(){
		lnkRegister.click();
		
	}
	
	public void clickOnLoginButton()
	{
		lnkLogin.click();
		
	}
	
	public void searchTheProduct(String product) {
		searchBar.sendKeys(product);
		
	}
	
	public void clickToSearch() {
		clickTosearch.click();
	}
	
}
