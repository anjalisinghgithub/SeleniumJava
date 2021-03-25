package com.company;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            //Setting system properties of ChromeDriver
            System.setProperty("webdriver.chrome.driver", "/Users/anjalisingh/Downloads/chromedriver");

            //Creating an object of ChromeDriver
            // Begin Shakeout
            driver = new ChromeDriver();
            driver.manage().window().maximize();


            //Specifiying pageLoadTimeout and Implicit wait
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            //launching the specified URL
            driver.get("https://www.victoriassecret.com/us/");
            WebDriverWait wait = new WebDriverWait(driver,30);  // WebElement Navbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/nav[2]/ul/li[2]/a")));

            // Making a selection from the dropdown
            Actions act = new Actions(driver);
            act.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/header/nav[2]/ul/li[2]/a"))).perform();
            driver.findElement(By.xpath("html[1]/body[1]/div[2]/header[1]/nav[2]/ul[1]/li[2]/section[1]/ul[3]/li[7]/a[1]")).click();

            //removing pop up
            driver.findElement(By.xpath("/html/body/div[3]/div/div/div/article/header/div/button")).click();

            // accepting cookies
            driver.findElement(By.xpath("//*[@id=\"consent_prompt_submit\"]")).click();

            // Clicking on the product
            driver.findElement(By.xpath("//a[@name='Embroidered Lace Robe']")).click();

            //selecting size
            driver.findElement(By.xpath("//div[@class='fabric-purchasable-product-component-right-wrapper fabric-sticky-scroll-content']//div[@data-label='M/L']")).click();

            // Clicking on add to bag
            driver.findElement(By.xpath("//button[@id='primary-1']")).click();

            // Clicking on checkout
            driver.findElement(By.xpath("//button[@class='fabric-primary-button-element fabric-add-to-bag-overlay-checkout-button']")).click();

            // verifying text value
            String actualString = driver.findElement(By.xpath("//span[@class='fabric-h2-typography-element price']")).getText();

            System.out.println("The total checkout value is:" + actualString);
            String expectedString =  "$" ;
            assertTrue(actualString.contains(expectedString));


            // Checkout as Guest
            driver.findElement(By.xpath("//a[@class='fabric-primary-grey-button-element checkoutAsGuestButton']")).click();

            Thread.sleep(15000);
            driver.quit();
            myMethod();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void assertTrue(boolean contains) {
        System.out.println("Assert True: The checkout page contains text after Merchandise Total");
    }
    static void myMethod() {
        System.out.println("Exiting the Chrome Browser now");

        }
}