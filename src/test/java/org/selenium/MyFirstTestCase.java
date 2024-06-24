package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyFirstTestCase {

    @Test
    public void dummyTest(){
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://askomdch.com");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']")).click();
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("BLUE");
        driver.findElement(By.cssSelector("button[value='Search']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),"Search results: “BLUE”");
        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='View cart']")));
        driver.findElement(By.cssSelector("a[title='View cart']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),"Blue Shoes");
        driver.findElement(By.cssSelector(".checkout-button")).click();


        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_address_1")).sendKeys("San francisco");
        driver.findElement(By.id("billing_city")).sendKeys("San francisco");
        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
        driver.findElement(By.id("billing_email")).sendKeys("askomsch@gmail.com");
        driver.findElement(By.id("place_order")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-notice")));
        Assert.assertEquals((driver.findElement(By.cssSelector(".woocommerce-notice")).getText()),"Thank you. Your order has been received.");

    }
}
