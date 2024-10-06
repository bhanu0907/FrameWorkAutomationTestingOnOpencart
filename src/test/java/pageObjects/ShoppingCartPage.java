package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class ShoppingCartPage extends BasePage{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	Select select;

	@FindBy(xpath = "//div[@id='accordion']/div[2]//a") WebElement estimateShipping;

	@FindBy(xpath = "//select[@id='input-country']")  WebElement dropDownCountry;

	@FindBy(xpath = "//select[@id='input-zone']") WebElement dropDownRegion;

	@FindBy(xpath = "//input[@id='input-postcode']") WebElement txtfieldPostCode;

	@FindBy(xpath = "//button[@id='button-quote']") WebElement buttonGetQuotes;

	@FindBy(css ="input[name='shipping_method']") WebElement radioFlatShipping;

	@FindBy(id = "button-shipping") WebElement buttonApplyShipping;

	@FindBy(xpath = "//div[@id='modal-shipping']//button[@class='btn btn-default']") WebElement buttonCancelShipping;

	@FindBy(xpath = "//*[@id='checkout-cart']/div[1]") WebElement successMsgCheckOut;

	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input") WebElement txtQuantity;

	@FindBy(xpath = "//div[@id=\"content\"]/form") WebElement frameShoppingCArt ;

	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div[2]/a") WebElement buttonCheckout;
	
	public void enterTheQuantity(String quantity) {
		//driver.switchTo().frame(frameShoppingCArt);
		txtQuantity.sendKeys(quantity);
		//driver.switchTo().defaultContent();

	}

	public void clickOnEstimateShipping() {
		estimateShipping.click();

	}

	public void selectCountry() {

		select=new Select(dropDownCountry);
		select.selectByValue("99");


	}

	public void selectRegion() {
		select=new Select(dropDownRegion);
		select.selectByValue("1489");

	}

	public void enterPostCode() {
		txtfieldPostCode.sendKeys("583117");
	}

	public void clickOnGetQuotes() {
		buttonGetQuotes.click();
	}

	public void selectFlatShipping() {
		radioFlatShipping.click();
	}

	public void clickOnApplyShipping() {
		buttonApplyShipping.click();
		System.out.println("Shipped");
		
	}


	public boolean verifyMsg() {
		
		return successMsgCheckOut.isDisplayed();
	}
	
	public void clickOnCheckOutButton() throws InterruptedException {
		Actions actions=new Actions(driver);
		actions.scrollToElement(buttonCheckout).perform();
		buttonCheckout.click();
		
		
//		System.out.println("not clicked");
//		buttonCheckout.click();
//		System.out.println("clicked");
//		Thread.sleep(3000);
//		System.out.println("yes clicked");
		
	}
	
	
	
	public void applySpipping() {
		ShoppingCartPage cartPage=new ShoppingCartPage(driver);
		//cartPage.enterTheQuantity("2");
		cartPage.clickOnEstimateShipping();
		cartPage.selectCountry();
		cartPage.selectRegion();
		cartPage.enterPostCode();
		cartPage.clickOnGetQuotes();
		cartPage.selectFlatShipping();
		cartPage.clickOnApplyShipping();
		
	
	}





}
