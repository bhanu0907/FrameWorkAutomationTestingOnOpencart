package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	@FindBy(xpath = "button-shipping") WebElement buttonApplyShipping;

	@FindBy(xpath = "//div[@id='modal-shipping']//button[@class='btn btn-default']") WebElement buttonCancelShipping;

	@FindBy(xpath = "//*[@id=\"checkout-cart\"]/div[1]") WebElement successMsgCheckOUt;

	@FindBy(xpath = "input[name=\"quantity[187952]\"]") WebElement txtQuantity;


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
	}
	public void enterTheQuantity(String quantity) {
		txtQuantity.sendKeys(quantity);

	}

	public String verifyMsg() {
		String successMsg=successMsgCheckOUt.getText();
		return successMsg;
	}





}
