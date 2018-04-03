package com.build.qa.build.selenium.tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.homepage.AddToCartPage;
import com.build.qa.build.selenium.pageobjects.homepage.HomePage;
import com.build.qa.build.selenium.pageobjects.elements.*;


public class BuildTest extends BaseFramework { 
	WebDriver chromeDriver;
	WebDriver firefoxDriver;
	
	@Before
	public void setUp() {
		firefoxDriver = driver;
		System.setProperty("webdriver.gecko.driver", "/Users/chanel.nalani/Documents/workspace/geckodriver");
		firefoxDriver = new FirefoxDriver();
	}
	@After
	public void tearDown() {
		chromeDriver = driver;
		firefoxDriver.quit();
	}
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
	 * @difficulty Easy
	 */
	@Test
	public void searchForProductLandsOnCorrectProduct() { 
		// TODO: Implement this test
		
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);
		
		softly.assertThat(homePage.onBuildTheme())
			.as("The website should load up with the Build.com desktop theme.")
			.isTrue();
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
		BathroomSinksPage sinksPage= new BathroomSinksPage(driver, wait);
		AddToCartPage cartPage=sinksPage.addSecondProductToCart();
		softly.assertThat(cartPage.getProductText())
			.as("The search text result should be have text containing Kohler K-2214")
			.contains("Kohler K-2214");
	  
	}
	
	/** 
	 * Add a product to the cart and email the cart to yourself, also to my email address: jgilmore+SeleniumTest@build.com
	 * Include this message in the "message field" of the email form: "This is {yourName}, sending you a cart from my automation!"
	 * @assert that the "Cart Sent" success message is displayed after emailing the cart
	 * @difficulty Medium-Hard
	 */
	@Test
	public void addProductToCartAndEmailIt() { 
		// TODO: Implement this test

	}
	
	/** 
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Theme=Modern
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 */
	@Test
	public void facetNarrowBysResultInCorrectProductCounts() { 
		// TODO: Implement this test		

	}
	
}