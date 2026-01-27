package com.guru.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class GuruBankTest {

    public static void main(String[] args) throws Exception {

//        ChromeOptions options  = new ChromeOptions();
//        options.addArguments("--headless=new");

//        WebDriver driver = new ChromeDriver(options);
//        WebDriver.Options options = driver.manage();
//        WebDriver.Window window = options.window();
//        window.maximize();
//        driver.navigate().to("https://demo.guru99.com/V1/index.php");
//        driver.navigate().to("https://www.google.com");
//        driver.navigate().refresh();
//        Thread.sleep(5000);
//        driver.navigate().back();
//        Thread.sleep(5000);
//        driver.navigate().forward();
//        Thread.sleep(5000);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/V1/index.php");

        Thread.sleep(5000);

        String curUrl = driver.getCurrentUrl();
        System.out.println("Current Browser URL: " + curUrl);

        String pageTitle = driver.getTitle();
        System.out.println("Current Page Title: " + pageTitle);

//        List<WebElement> allWebElements = driver.findElements(By.name("uid"));

        WebElement userNameWebElement = driver.findElement(By.name("uid"));
        userNameWebElement.sendKeys("mngr652220");
//
        driver.findElement(By.name("password")).sendKeys("pyjAjAj");
        driver.findElement(By.name("btnLogin")).click();







//        driver.close();
    }
}
