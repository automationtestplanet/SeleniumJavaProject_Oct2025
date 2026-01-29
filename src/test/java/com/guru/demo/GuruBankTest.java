package com.guru.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        driver.get("https://demo.guru99.com/V4/index.php");

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

        if (driver.findElement(By.xpath("//td[contains(text(),'Manger Id')]")).getText().contains("mngr652220")) {
            System.out.println("Login Successful");
            System.out.println("--------------------------Add New Customer-----------------------------");
            driver.findElement(By.linkText("New Customer")).click();
            if (driver.findElement(By.xpath("//p[text()='Add New Customer']")).isDisplayed()) {
                driver.findElement(By.name("name")).sendKeys("TestCustomer");
                String gender = "male";
                if (gender.equalsIgnoreCase("male")) {
                    driver.findElement(By.xpath("//input[@name='rad1'][1]")).click();
                } else if (gender.equalsIgnoreCase("female")) {
                    driver.findElement(By.xpath("//input[@name='rad1'][21]")).click();
                }

//                driver.findElement(By.id("dob")).sendKeys("2000-01-29");   // We need to use Java Script to set the date of birth
                JavascriptExecutor jse = (JavascriptExecutor) driver;
//                jse.executeScript("document.getElementById('dob').value='2001-01-29'");
                WebElement dobEle = driver.findElement(By.id("dob"));
                String dateOfBirth = "2000/01/29";
                // set attribute via setAttribute
                jse.executeScript("arguments[0].setAttribute('value', arguments[1]);", dobEle, dateOfBirth);
//                // or set the value property directly
//                jse.executeScript("arguments[0].value = arguments[1];", dobEle, dateOfBirth);

                driver.findElement(By.name("addr")).sendKeys("SR Nagar");
                driver.findElement(By.name("city")).sendKeys("Hyderabad");
                driver.findElement(By.name("state")).sendKeys("Telangana");
                driver.findElement(By.name("pinno")).sendKeys("500038");
                driver.findElement(By.name("telephoneno")).sendKeys("9876543210");

                String currentTimeStamp = new SimpleDateFormat("HHmmss").format(new Date());
                String emailId = "testcustomer" + currentTimeStamp + "@gmail.com";

                driver.findElement(By.name("emailid")).sendKeys(emailId);
                driver.findElement(By.name("password")).sendKeys("Test@1234");
                driver.findElement(By.name("sub")).click();

                if (driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).isDisplayed()) {
                    System.out.println("New Customer is added successfully");
                    String cusId = driver.findElement(By.xpath("//td[contains(text(),'Customer ID')]//following-sibling::td")).getText();
                    String actualName = driver.findElement(By.xpath("//td[contains(text(),'Customer Name')]//following-sibling::td")).getText();
                    String mobileNumber = driver.findElement(By.xpath("//td[contains(text(),'Mobile No.')]//following-sibling::td")).getText();
                    if (actualName.equalsIgnoreCase("TestCustomer") && mobileNumber.equalsIgnoreCase("9876543210")) {
                        System.out.println("New Customer details are verified successfully, Customer ID is: " + cusId);
                    } else {
                        System.out.println("New Customer details are not matching");
                    }
                } else {
                    System.out.println("New Customer is not added successfully");
                }


            } else {
                System.out.println("Add New Customer Page is not displayed");
            }

            // Edit the Customer

            //Delete the Customer


            // Add New Account

            //Edit the Account

            //Delete the Account


        } else {
            System.out.println("Home Page is not displayed, Login is failed");
        }


//        driver.close();
    }
}
