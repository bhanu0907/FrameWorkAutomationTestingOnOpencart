package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.reactivex.rxjava3.functions.Action;

public class AccountRegistrationPage extends BasePage{


	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	//Web Elements

	@FindBy(xpath ="//input[@id='input-firstname']") WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']") WebElement txtLastNAme;	

	@FindBy(xpath ="//input[@id='input-email']") WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']") WebElement txtTelPhone;

	@FindBy(xpath = "//input[@id='input-password']")  WebElement txtPassWord;

	@FindBy(xpath = "//input[@id='input-confirm']") WebElement txtConfirmPwd;

	@FindBy(css = "input[name=\"agree\"]") WebElement chkdBox;

	@FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]") WebElement buttonContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;

	

	//Actions Methods

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);

	}

	public void setLastNAme(String lname) {
		txtLastNAme.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String tel) {
		txtTelPhone.sendKeys(tel);

	}

	public void setPassword(String pwd) {
		txtPassWord.sendKeys(pwd);

	}

	public void setConfirmPassword(String conPwd) {
		txtConfirmPwd.sendKeys(conPwd);

	}

	public void selectCheckBox() {
		chkdBox.click();

	}

	public void clickOnContinue() {



		//Option 1
		//	buttonContinue.click();

		//Optinon2
			buttonContinue.submit();

		//Optinon3
//		JavascriptExecutor jS=(JavascriptExecutor) driver;
//		jS.executeScript("arguments[0].click()", buttonContinue);


		//Option4
//		Actions actions=new Actions(driver);
//		actions.moveToElement(buttonContinue).click().build().perform();
		
//	WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(10));
//	myWait.until(ExpectedConditions.elementToBeClickable(buttonContinue));
		
	}

	public String msgConfirmation() {

		try {
			return (msgConfirmation.getText());
		}
		catch (Exception e) {
			return e.getMessage();
		}

	}
}
