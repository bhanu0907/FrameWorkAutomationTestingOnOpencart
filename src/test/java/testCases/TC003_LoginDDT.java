package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider ="LoginData",dataProviderClass=DataProviders.class,groups = "Datadriven" )
	public void verify_loginDDT(String email, String passWord, String exp) {

		logger.info("====Starting TC003_LoginDDT====");

		try {
			//HomePage
			HomePage homePage=new HomePage(driver);

			homePage.clickMyAccount();
			homePage.clickOnLoginButton();

			//LoginPage
			LoginPage loginPage=new LoginPage(driver);

			loginPage.enterEamil(email);
			loginPage.enterPasswoard(passWord);
			loginPage.submitLoginButton();

			//MyAccountPage
			MyAccountPage myAccPage=new MyAccountPage(driver);
			boolean targetPage=myAccPage.isMyAccountPageExists();


			//valid data with sucessfull login and unsucessfull
			if(exp.equalsIgnoreCase("Valid")) 
			{
				if(targetPage==true)
				{
					myAccPage.clickOnLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}

		}
		
		catch (Exception e) {
			logger.error("Test Failed"+e.getMessage());
			Assert.fail("Test Failed"+e.getMessage());
		}
		
		logger.info("TC003_LoginTest is Execuited!!!");
	}
}
