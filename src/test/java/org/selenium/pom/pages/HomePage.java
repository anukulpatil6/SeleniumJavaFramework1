package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {
    By storeMenuLink = By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']");


    public HomePage(WebDriver driver) {
        super(driver);
    }
//    fluent interface
    public StorePage navigateToStoreUsingMenu(){
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }
    public HomePage load(){
        load("/");
        return this;

    }
}
