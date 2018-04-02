package com.build.qa.build.selenium.tests;


import org.junit.Test;
import org.junit.Assert;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.homepage.HomePage;
import com.build.qa.build.selenium.pageobjects.elements.*;


public class BuildTest extends BaseFramework { 
	
 /** Cart cart;
  
	/** 
	 * Extremely basic test that outlines some basic
	 * functionality and page objects as well as assertJ
	 * Testing upload to Git
	 */
	@Test
	public void navigateToHomePage() { 
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);
		
		softly.assertThat(homePage.onBuildTheme())
			.as("The website should load up with the Build.com desktop theme.")
			.isTrue();
	}
	
	/** 
	 * Search for the Quoizel MY1613 from the search bar
	 * @assert: That the product page we land on is what is expected by checking the product title
	 */
	@Test
	public void searchForProductLandsOnCorrectProduct() { 
		// TODO: Implement this test
	driver.get(getConfiguration("HOMEPAGE"));

	HomePage homePage = new HomePage(driver, wait);
	homePage.closeWelcomeDialog();
	homePage.search("Quoizel MY1613");

	Assert.assertEquals("Quoizel MY1613", homePage.getProductTitle());

    }
	
//	/** 
//	 * Go to the Bathroom Sinks category directly (https://www.build.com/bathroom-sinks/c108504) 
//	 * and add the second product on the search results (Category Drop) page to the cart.
//	 * @assert: the product that is added to the cart is what is expected
//	 */
	@Test
	public void addProductToCartFromCategoryDrop() { 
		// TODO: Implement this test
		driver.get(getConfiguration("HOMEPAGE") + "/bathroom-sinks/c108504");

		HomePage homePage = new HomePage(driver, wait);
		homePage.closeWelcomeDialog();
	  
	  Cart cart = new Cart(driver, wait);
	  Assert.assertEquals(cart.addProductToCartByIndex(2), cart.getProductTitleInCart());
	  
	  
	}
	
//	/** 
//	 * Add a product to the cart and email the cart to yourself, also to my email address: chanelnalani@gmail.com
//	 * Include this message in the "message field" of the email form: "This is {yourName}, sending you a cart from my automation!"
//	 * @assert that the "Cart Sent" success message is displayed after emailing the cart
//	 */
	@Test
	public void addProductToCartAndEmailIt() { 
		// TODO: Implement this test
		driver.get(getConfiguration("HOMEPAGE") + "/bathroom-sinks/c108504");

		HomePage homePage = new HomePage(driver, wait);
		homePage.closeWelcomeDialog();

		Cart cartProduct = new Cart(driver, wait);
		cartProduct.addProductToCartByIndex(2);
		cartProduct.openCart();

		Email email = new Email();
		email.setYourName(getConfiguration("yourName"));
		email.setYourEmail(getConfiguration("yourEmail"));
		email.setRecipientName(getConfiguration("recipientName"));
		email.setRecipientEmail(getConfiguration("recipientEmail"));
		email.setMessage(getConfiguration("message"));

	  
	  Cart.email(email);
	  
	}
	
//	/** 
//	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
//	 * at least two filters (facets), e.g: Finish=Chromes and Theme=Modern
//	 * @assert that the correct filters are being narrowed, and the result count
//	 * is correct, such that each facet selection is narrowing the product count.
//	 */
	@Test
	public void facetNarrowBysResultInCorrectProductCounts() { 
		// TODO: Implement this test		
	driver.get(getConfiguration("HOMEPAGE"));

	HomePage homePage = new HomePage(driver, wait);
	homePage.closeWelcomeDialog();
	homePage.clickBathroomTab();
	homePage.clickByName(bath.BathroomFaucets);

	Cart cartFilter = new Cart(driver, wait);
	String count = cartFilter.filterProductByColor(Color.Chromes);
	String totalCount = cartFilter.getProductResultCount();

	Assert.assertEquals(count, totalCount);

	count = cartFilter.filterProductByTheme(Filter.Modern);
	totalCount = cartFilter.getProductResultCount();

	Assert.assertEquals(count, totalCount);

	}
	
}