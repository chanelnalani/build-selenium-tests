package com.build.qa.build.selenium.pageobjects.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;
import com.build.qa.build.selenium.pageobjects.homepage.AddToCartPage;

public class BathroomSinksPage extends BasePage{

	public BathroomSinksPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		
	}

	@FindBy(id = "product-composite-560374")
	private WebElement secondItem;
	
	@FindBy(xpath = "//button[text()='Add to Cart']")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//button[@href='/index.cfm?page=cart:cart' ]")
	private WebElement goToCartButton;
	
	@FindBy(xpath = "//strong[text()='Free Shipping!']")
	private WebElement freeShipping;
	
	@FindBy(xpath = "(//div[@class='modal-header table modal-no-title']//button[@class='close js-modal-close '])[2]")
	private WebElement closePopUp;
	
	//Add product to cart
	public AddToCartPage addSecondProductToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
		closePopupWindow();
		scrollToAnElement(secondItem);
		secondItem.click();
		wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
		scrollToAnElement(freeShipping);
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		addToCartButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
		goToCartButton.click();
		return new AddToCartPage(driver, wait);
		
	}
	
	// Closes the subscribe popup
	public void closePopupWindow(){
		wait.until(ExpectedConditions.elementToBeClickable(closePopUp));
		closePopUp.click();
	}

	public void scrollToAnElement(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	
}
