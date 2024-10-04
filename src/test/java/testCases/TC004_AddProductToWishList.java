package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class TC004_AddProductToWishList extends BaseClass {

	LoginPage loginPage;
	ProductPage productPage;
	HomePage homePage;

	
	@Test
	public void addToWishList() {
		logger.info("====Starting TC004_LoginTest====");
		
		try {
		loginPage=new LoginPage(driver);
		loginPage.logIn(properties.getProperty("email"), properties.getProperty("password"));
		
	
		homePage=new HomePage(driver);
		homePage.searchTheProduct(properties.getProperty("product"));
		homePage.clickToSearch();
		
		productPage=new ProductPage(driver);
		productPage.addToWishList();
		
		
		boolean sucessWishlist=productPage.successfullyAddedToWishList();
		
		Assert.assertTrue(sucessWishlist);
		
		}
		
		catch (Exception e) {
			logger.error("Test Failed"+e.getMessage());
			Assert.fail("Test Failed"+e.getMessage());
		}
		finally {
			
			logger.info("TC004_LoginTest is Execuited!!!");
		}
	}
}
