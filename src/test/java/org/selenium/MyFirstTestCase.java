package org.selenium;

import org.openqa.selenium.By;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckOutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void guestCheckOutUsingDirectBankTransfer() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Downloads\\chromedriver-win64\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
////        driver.manage().window().maximize();
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        StorePage storePage = new HomePage(driver).load().navigateToStoreUsingMenu().search("BLUE");

//        driver.get("https://askomdch.com");
//
//        HomePage homePage = new HomePage(driver);
//        StorePage storePage = homePage.navigateToStoreUsingMenu();
//
////        Storepage
//        storePage.search("BLUE");
////                enterTextInSearchFld("BLUE").
////                clickSearchBtn();
////        above is structural page object

        Assert.assertEquals(storePage.getTitle(),"Search results: “BLUE”");
        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(5000);
       CartPage cartPage= storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
        CheckOutPage checkOutPage= cartPage.clickCheckOutBtn();

//

//        driver.findElement(By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']")).click();
//        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("BLUE");
//        driver.findElement(By.cssSelector("button[value='Search']")).click();
//        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),"Search results: “BLUE”");
//        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
//
////        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='View cart']")));
//        Thread.sleep(5000);
//        driver.findElement(By.cssSelector("a[title='View cart']")).click();

//        Assert.assertEquals(driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),"Blue Shoes");
//        driver.findElement(By.cssSelector(".checkout-button")).click();


//        CheckoutPage

        checkOutPage.
                enterFirstName("demo").
                enterLastName("user").
                enterAddressLineOne("San francisco").
                enterCity("San francisco").
                enterPostCode("94188").
                enterEmail("askomsch@gmail.com").
                placeOrder();
        Thread.sleep(5000);
        Assert.assertEquals(checkOutPage.getNotice(),"Thank you. Your order has been received.");

//        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
//        driver.findElement(By.id("billing_last_name")).sendKeys("user");
//        driver.findElement(By.id("billing_address_1")).sendKeys("San francisco");
//        driver.findElement(By.id("billing_city")).sendKeys("San francisco");
//        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
//        driver.findElement(By.id("billing_email")).sendKeys("askomsch@gmail.com");
//        driver.findElement(By.id("place_order")).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-notice")));
//        Thread.sleep(5000);
//        Assert.assertEquals((driver.findElement(By.cssSelector(".woocommerce-notice")).getText()),"Thank you. Your order has been received.");

    }
    @Test
    public void loginAndCheckOutUsingDirectBankTransfer() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Downloads\\chromedriver-win64\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://askomdch.com");

        HomePage homepage = new HomePage(driver);
        StorePage storepage = homepage.navigateToStoreUsingMenu();
        storepage.search("BLUE");
        Assert.assertEquals(storepage.getTitle(),"Search results: “BLUE”");
        storepage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(5000);

        CartPage cartPage = storepage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(),"Blue Shoes");
        CheckOutPage checkOutPage = cartPage.clickCheckOutBtn();


//
//        driver.findElement(By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']")).click();
//        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("BLUE");
//        driver.findElement(By.cssSelector("button[value='Search']")).click();
//        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),"Search results: “BLUE”");
//        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='View cart']")));
//        Thread.sleep(5000);
//        driver.findElement(By.cssSelector("a[title='View cart']")).click();
//
//        Assert.assertEquals(driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),"Blue Shoes");
//        driver.findElement(By.cssSelector(".checkout-button")).click();
        checkOutPage.clickHereToLoginLink();
        Thread.sleep(5000);
        checkOutPage.login("demo2User","demopwd")
                .enterFirstName("demo").
                enterLastName("user").
                enterAddressLineOne("San francisco").
                enterCity("San francisco").
                enterPostCode("94188").
                enterEmail("askomsch@gmail.com").
                placeOrder();

        Thread.sleep(5000);
        Assert.assertEquals(checkOutPage.getNotice(),"Thank you. Your order has been received.");



//        //login
//        driver.findElement(By.cssSelector(".showlogin")).click();
//        driver.findElement(By.cssSelector("#username")).sendKeys("demo2User");
//        driver.findElement(By.cssSelector("#password")).sendKeys("demopwd");
//        driver.findElement(By.cssSelector("button[value='Login']")).click();




//        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
//        driver.findElement(By.id("billing_last_name")).sendKeys("user");
//        driver.findElement(By.id("billing_address_1")).sendKeys("San francisco");
//        driver.findElement(By.id("billing_city")).sendKeys("San francisco");
//
//        driver.findElement(By.id("billing_postcode")).clear();
//        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
//
////        clear the mail field to write new mail id
//        driver.findElement(By.id("billing_email")).clear();
//        driver.findElement(By.id("billing_email")).sendKeys("askomsch@gmail.com");
//        driver.findElement(By.id("place_order")).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-notice")));
//        Thread.sleep(5000);
//        Assert.assertEquals((driver.findElement(By.cssSelector(".woocommerce-notice")).getText()),"Thank you. Your order has been received.");

    }
}
