package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfilePageTest {
    private static WebDriver driver;
    private ProfilePage profilePage;
    private HomeMainPage homeMainPage;

    @BeforeEach
    public void setup() {
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        profilePage = new ProfilePage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 20 сек.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpageURL"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfProperties.getProperty("email"), ConfProperties.getProperty("password"));
    }

    @Test
    public void clickLogoutTest() {
        homeMainPage = profilePage.clickLogout();
        String expected = ConfProperties.getProperty("homepageURL");
        String actual = homeMainPage.getURL();
        assertEquals(expected, actual);
    }

    @Test
    public void clickProfileTest() {
        profilePage = profilePage.clickProfile();
        String expected = ConfProperties.getProperty("profilepageURL");
        String actual = profilePage.getURL();
        assertEquals(expected, actual);
    }

    @Test
    public void clickHome() {
        homeMainPage = profilePage.clickHome();
        String expected = ConfProperties.getProperty("homepageURL");
        String actual = homeMainPage.getURL();
        assertEquals(expected, actual);
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
