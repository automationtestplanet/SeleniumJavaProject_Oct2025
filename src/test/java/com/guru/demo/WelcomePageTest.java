package com.guru.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WelcomePageTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/Hello/Desktop/Welcome.html");
        Thread.sleep(5000);


        WebElement userNameElement = driver.findElement(By.id("userName"));
        System.out.println(userNameElement.getTagName());

        System.out.println(userNameElement.isEnabled());
        System.out.println(userNameElement.isDisplayed());

        String idValue = userNameElement.getAttribute("id");
        System.out.println(idValue);
        System.out.println(userNameElement.getAttribute("placeholder"));
        System.out.println(userNameElement.getAttribute("required"));

        driver.findElement(By.id("userName")).sendKeys("Test User");
        driver.findElement(By.name("Password")).sendKeys("Test@Password");

        System.out.println(driver.findElement(By.className("checkbox")).isSelected());
        driver.findElement(By.className("checkbox")).click();
        System.out.println(driver.findElement(By.className("checkbox")).isSelected());

        driver.findElement(By.tagName("textarea")).sendKeys("What is a Functional Interface in Java, and can you name some built-in example");

//        driver.findElement(By.linkText("Terms & Conditions")).click();

        System.out.println(driver.findElement(By.partialLinkText("Terms")).getText());
        System.out.println(driver.findElement(By.partialLinkText("Terms")).getAttribute("href"));
//        driver.findElement(By.partialLinkText("Terms")).click();

        System.out.println(driver.findElement(By.cssSelector("[value='Register']")).getAttribute("onclick"));
        driver.findElement(By.cssSelector("[value='Register']")).click();

    }
}
