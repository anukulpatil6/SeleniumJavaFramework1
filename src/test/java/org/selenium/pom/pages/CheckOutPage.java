package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class CheckOutPage extends BasePage {


    private final By firstNameFld = By.id("billing_first_name");
    private final By lastNamefld = By.id("billing_last_name");
    private By addressLineOneFld = By.id("billing_address_1");
    private By billingCityFld= By.id("billing_city");
    private By billingPostCodeFld = By.id("billing_postcode");
    private By billingEmailFld = By.id("billing_email");
    private By placeOrderBtn= By.id("place_order");
    private By successNotice = By.cssSelector(".woocommerce-notice");

    private By clickHereToLoginLink = By.cssSelector(".showlogin");
    private By userNamefld = By.cssSelector("#username");
    private By passwordfld =By.cssSelector("#password");
    private By loginBtn = By.cssSelector("button[value='Login']");



    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    public CheckOutPage enterFirstName (String firstName){
        driver.findElement(firstNameFld).clear();
        driver.findElement(firstNameFld).sendKeys(firstName);
        return this;
    }
    public CheckOutPage enterLastName (String lastName){
        driver.findElement(lastNamefld).clear();

        driver.findElement(lastNamefld).sendKeys(lastName);
        return this;
    }
    public CheckOutPage enterAddressLineOne (String addressLineOne){
        driver.findElement(addressLineOneFld).sendKeys(addressLineOne);
        return this;
    }
    public CheckOutPage enterCity (String city){
        driver.findElement(billingCityFld).sendKeys(city);
        return this;
    }
    public CheckOutPage enterPostCode (String postCode){
        driver.findElement(billingPostCodeFld).sendKeys(postCode);
        return this;
    }
    public CheckOutPage enterEmail (String email){
        driver.findElement(billingEmailFld).clear();

        driver.findElement(billingEmailFld).sendKeys(email);
        return this;
    }
    public CheckOutPage placeOrder(){
        driver.findElement(placeOrderBtn).click();
        return this;
    }
    public String getNotice(){
        return driver.findElement(successNotice).getText();

    }



    public CheckOutPage clickHereToLoginLink(){
        driver.findElement(clickHereToLoginLink).click();
        return this;
    }

    public CheckOutPage enterUserName(String username){
        driver.findElement(userNamefld).sendKeys(username);
        return this;
    }

    public CheckOutPage enterPassword(String password){
        driver.findElement(passwordfld).sendKeys(password);
        return this;
    }
    public CheckOutPage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return this;
    }
    public CheckOutPage login(String username, String password){
        return enterUserName(username).enterPassword(password).clickLoginBtn();
    }

}
