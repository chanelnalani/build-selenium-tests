package com.build.qa.build.selenium.pageobjects.elements;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;

import com.build.qa.build.selenium.pageobjects.BasePage;
import com.build.qa.build.selenium.pageobjects.elements.Color;
import com.build.qa.build.selenium.pageobjects.elements.Filter;


public class Cart {
	private By buildThemeBody;

	public Cart(WebDriver driver, Wait<WebDriver> wait) {
		WebDriverWait wait1 = new WebDriverWait(drv,30);
		super(driver, wait1);
		buildThemeBody = By.cssSelector("body.build-theme");
	}

	public boolean onBuildTheme() {
		return 
		wait.until(ExpectedConditions.presenceOfElementLocated(buildThemeBody)) != null;
	}

	@FindBy(id = "category-product-drop")
	private WebElement productDrop;

	@FindBy(id = "configure-product-wrap")
	private WebElement addToCart;

	@FindBy(id = "yourName")
	private static WebElement yourName;

	@FindBy(id = "yourEmail")
	private static WebElement yourEmail;

	@FindBy(id = "recipientName")
	private static WebElement recipientName;

	@FindBy(id = "recipientEmail")
	private static WebElement recipientEmail;

	@FindBy(xpath = "//*[@id='recommended-options']/div[1]/div/div[3]/a/p")
	private WebElement productTitleInCart;

	@FindBy(xpath = "//*[@id='facet-options']/li[2]/ul")
	private WebElement productColorFilter;

	@FindBy(xpath = "//*[@id='facet-options']/li[4]/ul")
	private WebElement productThemeFilter;

	@FindBy(xpath = "//*[@id='category-content']/div[2]/div/div[1]/span/span")
	private WebElement productResultCount;

	@FindBy(xpath = "//*[@id='header']/section[2]/div/div/div/a[2]/button")
	private WebElement cartBtn;

	@FindBy(xpath = "//*[@id='page-content']/div[1]/div[1]/div/section[2]/div/div[1]/table/tbody/tr[3]/td/button[1]")
	private static WebElement emailbtn;

	@FindBy(xpath = "//*[@id='cart-email']/div/div/div[2]/div[2]/form/div[4]/button")
	private static WebElement emailcartBtn;

	public String addProductToCartByIndex(int index) {
		WebElement element = productDrop.findElements(By.tagName("li")).get(index - 1)
				.findElement(By.xpath("/div[2]/a/div[2]/span"));
		String productTitle = element.getText();
		element.click();
		addToCart.click();
		return productTitle;

	}

	public void openCart() {
		cartBtn.click();
	}

	public static void email(Email email) {
		emailbtn.click();
		yourName.sendKeys(email.getYourName());
		yourEmail.sendKeys(email.getYourEmail());
		recipientName.sendKeys(email.getRecipientName());
		recipientEmail.sendKeys(email.getRecipientEmail());
		emailcartBtn.click();
	}

	public String getProductTitleInCart() {
		return productTitleInCart.getText();

	}

	public String filterProductByColor(Color color) {
		List<WebElement> li = productColorFilter.findElements(By.tagName("li"));

		String count = "";

		for (WebElement webElement : li) {
			String name = webElement.findElement(By.tagName("label")).getAttribute("data-facet-value");
			if (name.equalsIgnoreCase(color.getName())) {
				count = webElement.findElement(By.xpath("/label/span")).getText().replace("(", "").replace(")", "");
				webElement.click();
				break;
			}

		}
		return count;

	}

	public String filterProductByTheme(Filter theme) {
		List<WebElement> li = productThemeFilter.findElements(By.tagName("li"));

		String count = "";

		for (WebElement webElement : li) {
			String name = webElement.findElement(By.tagName("label")).getAttribute("data-facet-value");
			if (name.equalsIgnoreCase(theme.getName())) {
				count = webElement.findElement(By.xpath("/label/span")).getText().replace("(", "").replace(")", "");
				webElement.click();
				break;
			}

		}
		return count;
	}

	public String getProductResultCount() {
		return productResultCount.getText().replace(",", "");
	}


}
