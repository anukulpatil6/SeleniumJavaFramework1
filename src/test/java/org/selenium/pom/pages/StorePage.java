package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {
    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title =By.cssSelector(".woocommerce-products-header__title.page-title");

//    we define it dynamically so can be used for any item
//    private final By addToCart = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public StorePage enterTextInSearchFld(String txt){
        driver.findElement(searchFld).sendKeys(txt);
        return this;
    }
    public StorePage clickSearchBtn(){
        driver.findElement(searchBtn).click();
        return this;
    }
    public StorePage search(String txt){
        enterTextInSearchFld(txt).clickSearchBtn();
        return this;
    }
    public String getTitle(){
        return driver.findElement(title).getText();
    }

    private By getAddToCartBtnElement(String productName){
      return By.cssSelector("a[aria-label='Add “"+ productName +"” to your cart']");

    }
    public StorePage clickAddToCartBtn(String productName){
       By addToCartBtn= getAddToCartBtnElement(productName);
        driver.findElement(addToCartBtn).click();
        return this;
    }

    public CartPage clickViewCart(){
        driver.findElement(viewCartLink).click();
        return new CartPage(driver);

    }
}
