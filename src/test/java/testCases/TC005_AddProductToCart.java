package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class TC005_AddProductToCart extends BaseClass{

	@Test
	public void addToWishList() {
		
		logger.info("====TC005_AddProductToCart====");
		
		try {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.logIn(properties.getProperty("email"),properties.getProperty("password"));
		
		HomePage homePage=new HomePage(driver);
		homePage.searchTheProduct(properties.getProperty("product"));
		homePage.clickToSearch();
		
		ProductPage  productPage=new ProductPage(driver);
		productPage.addToCart();
		
		boolean sussesAddToCart=productPage.successfullyAddedToCart();
		
		Assert.assertTrue(sussesAddToCart);
		
		}
		
		catch (Exception e) {
			logger.error("Test Failed"+e.getMessage());
			Assert.fail("Test Failed"+e.getMessage());
		}
		finally {
			logger.info("TC005_AddProductToCart is Execuited!!!");
		}
		
	}
}
