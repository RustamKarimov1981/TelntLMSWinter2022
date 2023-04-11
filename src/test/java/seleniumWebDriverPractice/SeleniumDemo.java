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
        String sessionID = ((RemoteWebDriver) driver).getSessionId().toString();
        System.out.println("Session ID: " + sessionID);
        driver.close();
        driver.quit();
    }

    @Test
    public void demo2() {
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
    public void verfyUserName() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/text-box/");

        // вводим адрес в поле userName
        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("Rustam");
        Thread.sleep(1000);
        WebElement submitButton = driver.findElement(By.id("submit"));
        Thread.sleep(1000);
        submitButton.click();

        // ожидаемый текст userName
        String expectedUserName = "Name:Rustam";

        WebElement actualUserName = driver.findElement(By.id("output")).findElement(By.id("name"));

        // проверяем, соответствует ли userName в поле ожидаемому значению
        Assert.assertEquals(actualUserName.getText(), expectedUserName);
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }

    @Test
    public void verfyUserMail() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/text-box/");

        // вводим адрес в поле userEmail
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("rustam@gmail.com");
        Thread.sleep(1000);
        WebElement submitButton = driver.findElement(By.id("submit"));
        Thread.sleep(1000);
        submitButton.click();

        // ожидаемый текст userEmail
        String expectedUserEmail = "Email:rustam@gmail.com";

        WebElement actualUserEmail = driver.findElement(By.id("output")).findElement(By.id("email"));

        // проверяем, соответствует ли email в поле ожидаемому значению
        Assert.assertEquals(actualUserEmail.getText(), expectedUserEmail);
        Thread.sleep(1000);
        driver.close();
        driver.quit();

    }

    @Test
    public void verfyCurrentAddress() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/text-box/");

        // вводим адрес в поле currentAddress
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("12 Washington st. Chicago, IL");
        Thread.sleep(3000);
        WebElement submitButton = driver.findElement(By.id("submit"));
        Thread.sleep(3000);
        submitButton.click();

        // ожидаемый текст адреса
        String expectedCurrentAddress = "Current Address :12 Washington st. Chicago, IL";

        WebElement actualCurrentAddress = driver.findElement(By.id("output")).findElement(By.id("currentAddress"));

        // проверяем, соответствует ли текст адреса в поле ожидаемому значению
        Assert.assertEquals(actualCurrentAddress.getText(), expectedCurrentAddress);
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

    @Test
    public void verfyPermanentAddress() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/text-box/");

        // вводим адрес в поле permanentAddress
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("312 Linkoln st. Naperville, IL");
        Thread.sleep(3000);
        WebElement submitButton = driver.findElement(By.id("submit"));
        Thread.sleep(3000);
        submitButton.click();

        // ожидаемый текст адреса
        String expectedPermanentAddress = "Permananet Address :312 Linkoln st. Naperville, IL";

        WebElement actualPermanentAddress = driver.findElement(By.id("output")).findElement(By.id("permanentAddress"));

        // проверяем, соответствует ли текст адреса в поле ожидаемому значению
        Assert.assertEquals(actualPermanentAddress.getText(), expectedPermanentAddress);
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
// -------------------------------------
    // General Test
    @Test
    public void verifyGeneralParameters() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/text-box/");

        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("Rustam");
        Thread.sleep(1000);
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("rustam@gmail.com");
        Thread.sleep(1000);
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("12 Washington st. Chicago, IL");
        Thread.sleep(1000);
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("312 Linkoln st. Naperville, IL");
        Thread.sleep(1000);
        WebElement submitButton = driver.findElement(By.id("submit"));
        Thread.sleep(1000);
        submitButton.click();

        String expectedUserName = "Name:Rustam";
        WebElement actualUserName = driver.findElement(By.id("output")).findElement(By.id("name"));
        Assert.assertEquals(actualUserName.getText(), expectedUserName);
        Thread.sleep(1000);

        String expectedUserEmail = "Email:rustam@gmail.com";
        WebElement actualUserEmail = driver.findElement(By.id("output")).findElement(By.id("email"));
        Assert.assertEquals(actualUserEmail.getText(), expectedUserEmail);
        Thread.sleep(1000);

        String expectedCurrentAddress = "Current Address :12 Washington st. Chicago, IL";
        WebElement actualCurrentAddress = driver.findElement(By.id("output")).findElement(By.id("currentAddress"));
        Assert.assertEquals(actualCurrentAddress.getText(), expectedCurrentAddress);
        Thread.sleep(1000);

        String expectedPermanentAddress = "Permananet Address :312 Linkoln st. Naperville, IL";
        WebElement actualPermanentAddress = driver.findElement(By.id("output")).findElement(By.id("permanentAddress"));
        Assert.assertEquals(actualPermanentAddress.getText(), expectedPermanentAddress);
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }
}
