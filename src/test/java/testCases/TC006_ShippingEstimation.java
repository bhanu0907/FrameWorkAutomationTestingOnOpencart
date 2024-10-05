package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC006_ShippingEstimation extends BaseClass {

	
	@Test
	public void applyingTheShippingEstimation() {
		
		logger.info("====TC005_AddProductToCart====");
		
		try {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.logIn(properties.getProperty("email"),properties.getProperty("password"));
		
		HomePage homePage=new HomePage(driver);
		homePage.searchTheProduct(properties.getProperty("product"));
		homePage.clickToSearch();
		
		ProductPage  productPage=new ProductPage(driver);
		productPage.addToCart();
		productPage.clickOnCartItem();
		productPage.clickOnViewItem();
		
		ShoppingCartPage cartPage=new ShoppingCartPage(driver);
		
		cartPage.enterTheQuantity("2");
		cartPage.clickOnEstimateShipping();
		cartPage.selectCountry();
		cartPage.selectRegion();
		cartPage.enterPostCode();
		cartPage.clickOnGetQuotes();
		cartPage.selectFlatShipping();
		cartPage.clickOnApplyShipping();
	
		String sucessMsg=cartPage.verifyMsg();
		
		Assert.assertEquals(sucessMsg,"Success: Your shipping estimate has been applied!\r\n"
				+ "    ");
		}
		
		catch (Exception e) {
			logger.error("Test Failed"+e.getMessage());
			Assert.fail("Test Failed"+e.getMessage());
		}
		finally {
			logger.info("TC006_ShippingEstimation is Execuited!!!");
		}
		
		
	}
	
	
}
