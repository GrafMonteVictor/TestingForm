package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeMainPageTest {
    private static WebDriver driver;
    private static HomeMainPage homeMainPage;
    private LoginPage loginPage;
    private SignUpPage signUpPage;

    @BeforeAll
    public static void setup() {
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        homeMainPage = new HomeMainPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 20 сек.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("homepageURL"));
    }

    @Test
    public void clickLoginTest() {
        loginPage = homeMainPage.clickLogin();
        String expected = ConfProperties.getProperty("loginpageURL");
        String actual = loginPage.getURL();
        assertEquals(expected, actual);
    }

    @Test
    public void clickSignUpTest() {
        signUpPage = homeMainPage.clickSignUp();
        String expected = ConfProperties.getProperty("signuppageURL");
        String actual = signUpPage.getURL();
        assertEquals(expected, actual);
    }

    @Test
    public void clickHome() {
        homeMainPage = homeMainPage.clickHome();
        String expected = ConfProperties.getProperty("homepageURL");
        String actual = homeMainPage.getURL();
        assertEquals(expected, actual);
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
