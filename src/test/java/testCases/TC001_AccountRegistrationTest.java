package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"Regression","Master"})
	public void verifyAccountRegistration() {
		logger.info("====Starting TC001_AccRegTest====");
		logger.debug("This is a debug log message");

		try {
		HomePage homePage=new HomePage(driver);
		homePage.clickMyAccount();
		logger.info("Clicked on Account Link");
		
		homePage.clickOnRegisterButton();
		logger.info("Clicked on Register Link");

		AccountRegistrationPage registrationPage=new AccountRegistrationPage(driver);

		
		logger.info("Providing customer details");
		//registrationPage.setFirstName("Pandu");
		//registrationPage.setLastNAme("Krishna");

		registrationPage.setFirstName(randomName());
		registrationPage.setLastNAme(randomName());

		//registrationPage.setEmail("pandukrishna2006@gmail.com");
		//registrationPage.setTelephone("8889996660");

		String emailRandom=randomEmail()+"@gmail.com";
		registrationPage.setEmail(emailRandom);
		System.out.println(emailRandom);
		
		registrationPage.setTelephone(randomTelNumber());
		
	
		//registrationPage.setPassword("passwoard@123");
		//registrationPage.setConfirmPassword("passwoard@123");


		String passWoard=randomPasswoard();
		registrationPage.setPassword(passWoard);
		registrationPage.setConfirmPassword(passWoard);
		System.out.println(passWoard);

		registrationPage.selectAgreeCheckBox();
		registrationPage.clickOnContinue();

		
		
		logger.info("Validating Expected Message..");
		String conMesg=registrationPage.msgConfirmation();
		System.out.println(registrationPage.msgConfirmation());
		Assert.assertEquals(conMesg, "Your Account Has Been Created!");
	//	System.out.println("Sucess!!!");
		}
		
		
		catch(Exception e)
		{
			logger.error("Test Failed"+e.getMessage());
		
			Assert.fail("Test Failed"+e.getMessage());
		}
		
		finally {
			logger.info("TC001_AccountRegistrationTest is Execuited!!!");
		}
		
	}


}
