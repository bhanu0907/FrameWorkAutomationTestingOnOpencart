package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{

	public ProductPage(WebDriver driver) {
		super(driver);

	}

	//Actions ac;

	@FindBy(xpath = "//*[@id=\"content\"]/div[3]//button[1]") WebElement addToCartButton;

	@FindBy(xpath = "//*[@id=\"content\"]/div[3]//button[2]") WebElement wishListButton;

	@FindBy(xpath = "//*[@id=\"product-search\"]/div[1]/a[2]") WebElement successMsg;


	public void addToWishList()
	{
		//ac=new Actions(driver);
		//ac.scrollToElement(wishListButton).click().build().perform();
		//System.out.println("clicked");

		wishListButton.click();
		System.out.println("clicked");

	}

	public void addToCart() {
		//ac=new Actions(driver);
		//ac.scrollToElement(addToCartButton).click().build().perform();
		//System.out.println("clicked");

		addToCartButton.click();
	}

	public boolean successfullyAddedToWishList() throws InterruptedException {
		//WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(5));
		//driverWait.until(ExpectedConditions.visibilityOf(successMsg));
		//Thread.sleep(4000);

		//ac.scrollToElement(successMsg);
		//System.out.println(successMsg.getText());
		return (successMsg.getText().equals("wish list"));
	}

	public boolean successfullyAddedToCart() {
		//ac.scrollToElement(successMsg);

		return (successMsg.getText().equals("shopping cart"));
	}

}
