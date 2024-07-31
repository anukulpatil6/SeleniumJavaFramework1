package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {

     private final By productName = By.cssSelector("td[class='product-name'] a");
     private final By checkOutBtn = By.cssSelector(".checkout-button");
    private final By cartHeading = By.cssSelector(".has-text-align-center");
    public CartPage(WebDriver driver) {
        super(driver);
    }

//    public Boolean isLoaded(){
//       return wait.until(ExpectedConditions.textToBe(cartHeading,"Cart"));
//    }
    public String getProductName(){
      return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
//    return driver.findElement(productName).getText();
    }

    public CheckOutPage clickCheckOutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn)).click();
//        driver.findElement(checkOutBtn).click();
        return new CheckOutPage(driver);
    }
}

