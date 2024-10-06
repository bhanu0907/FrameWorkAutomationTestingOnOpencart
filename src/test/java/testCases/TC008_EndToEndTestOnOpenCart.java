package testCases;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC008_EndToEndTestOnOpenCart extends BaseClass {

	SoftAssert softAssert=new SoftAssert();

	@Test(groups = {"Regression","Master"})
	public void endToEnd() {
		logger.info("====Starting TC008_EndToEndTestOnOpenCart====");

		try 
		{
			HomePage homePage=new HomePage(driver);
			homePage.clickMyAccount();
			logger.info("Clicked on Account Link");

			homePage.clickOnRegisterButton();
			logger.info("Clicked on Account Link");


			//Genrting Random VAlues
			String firstNAme=randomName();
			String lastName=randomName();
			String email=randomEmail()+"@gmail.com";
			String telPhoneNum=randomTelNumber();
			String passWoard=randomPasswoard();

			AccountRegistrationPage registrationPage=new AccountRegistrationPage(driver);
			registrationPage.openCartAccountRegistration(firstNAme,lastName,email,telPhoneNum,passWoard);


			logger.info("Validating Expected Message..");
			String conMesg=registrationPage.msgConfirmation();
			System.out.println(registrationPage.msgConfirmation());
			softAssert.assertEquals(conMesg, "Your Account Has Been Created!");

			//Logout

			MyAccountPage accountPage=new MyAccountPage(driver);
			accountPage.clickOnLogout();

			//Login
			homePage.clickMyAccount();
			homePage.clickOnLoginButton();

			LoginPage loginPage=new LoginPage(driver);
			loginPage.logIn(email, passWoard);

			MyAccountPage myAccPage=new MyAccountPage(driver);
			boolean tagetPage=myAccPage.isMyAccountPageExists();

			softAssert.assertTrue(tagetPage);


			//Search and add product to cart
			homePage.searchTheProduct(properties.getProperty("product"));
			homePage.clickToSearch();

			ProductPage  productPage=new ProductPage(driver);
			productPage.addToCart();


			boolean sussesAddToCart=productPage.successfullyAddedToCart();
			softAssert.assertTrue(sussesAddToCart);

			//Applying Shipping Estimation
			ShoppingCartPage cartPage=new ShoppingCartPage(driver);
			cartPage.enterTheQuantity("2");
			cartPage.applySpipping();

			//Checkout
			cartPage.clickOnApplyShipping();

			//	softAssert.assertAll();
		}

		catch (Exception e) {
			logger.error("Test Failed"+e.getMessage());
			softAssert.fail("Test Failed"+e.getMessage());
		}
		finally {
			logger.info("TC008_EndToEndTestOnOpenCart is Execuited!!!");
		}

	}

}
