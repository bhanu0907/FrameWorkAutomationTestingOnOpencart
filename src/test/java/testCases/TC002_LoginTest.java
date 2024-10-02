package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	
	@Test(groups = {"Sanity","Master"})
	public void verify_login()
	{
		logger.info("====Starting TC002_LoginTest====");
		//		String email = "";
		//		String passWoard = "";
		//		
		//		LoginPage loginPage=new LoginPage(driver);
		//		loginPage.logIN(email, passWoard);

		
		
		try {
		//HomePage
		HomePage homePage=new HomePage(driver);

		homePage.clickMyAccount();
		homePage.clickOnLoginButton();
		
		//LoginPage
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterEamil(properties.getProperty("email"));
		loginPage.enterPasswoard(properties.getProperty("password"));
		loginPage.submitLoginButton();
		
		//MyAccountPage
		MyAccountPage myAccPage=new MyAccountPage(driver);
		boolean tagetPage=myAccPage.isMyAccountPageExists();
		
		Assert.assertTrue(tagetPage);
		}
		catch (Exception e) {
			logger.error("Test Failed"+e.getMessage());
			Assert.fail("Test Failed"+e.getMessage());
		}
		finally {
			
			logger.info("TC002_LoginTest is Execuited!!!");
		}


	}

}
