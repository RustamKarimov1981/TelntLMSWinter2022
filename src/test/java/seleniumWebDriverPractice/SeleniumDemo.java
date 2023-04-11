package seleniumWebDriverPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumDemo {
//    public static void main(String[] args) throws InterruptedException {
    @Test
    public void demo1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http:/www.google.com/");
        WebElement searchInputField = driver.findElement(By.name("q"));
        searchInputField.sendKeys("iPhone");
        Thread.sleep(3000);
        searchInputField.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement appleText = driver.findElement(By.tagName("h3"));
        String expectedAppleIphoneText = "iPhone - Apple";

        Assert.assertEquals(appleText.getText(), expectedAppleIphoneText);
        System.out.println("Test Passed");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
        String sessionID = ((RemoteWebDriver)driver).getSessionId().toString();
        System.out.println("Session ID: " + sessionID);
        driver.close();
        driver.quit();
    }
    @Test
    public void demo2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/text-box/");
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("John Doe");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("john@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("24 Ibraimova str.");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("312 Karasaev str.");
    }
    @Test
    public void verfyPermanentAddress(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/text-box/");

        // вводим адрес в поле permanentAddress
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("312 Karasaev str.");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // ожидаемый текст адреса
        String expectedPermanentAddress = "Permananet Address :312 Karasaev str.";

        WebElement actualPermanentAddress = driver.findElement(By.id("output")).findElement(By.id("permanentAddress"));

        // проверяем, соответствует ли текст адреса в поле ожидаемому значению
        Assert.assertEquals(actualPermanentAddress.getText(), expectedPermanentAddress);
        driver.close();
        driver.quit();
    }
}
