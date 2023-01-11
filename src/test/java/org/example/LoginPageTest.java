package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private HomeMainPage homeMainPage;
    private SignUpPage signUpPage;
    private final String VALID_EMAIL = ConfProperties.getProperty("email");
    private final String VALID_PASSWORD = ConfProperties.getProperty("password");
    private final String NOT_EXIST_EMAIL = "87654321@mail.ru";
    private final String NOT_VALID_PASSWORD = "87654321";

    @BeforeAll
    public static void setup() {
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 20 сек.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpageURL"));
    }

    //проверка работоспособности кнопок
    @Test
    public void clickHomeButtonTest() {
        homeMainPage = loginPage.clickHomeButton();
        System.out.println(homeMainPage.toString());
        String expected = ConfProperties.getProperty("homepageURL");
        String actual = homeMainPage.getURL();
        assertEquals(expected, actual);
    }

    @Test
    public void clickLoginButtonTest() {
        loginPage = loginPage.clickLoginButton();
        String expected = ConfProperties.getProperty("loginpageURL");
        String actual = loginPage.getURL();
        assertEquals(expected, actual);
    }

    @Test
    public void clickSignUpButtonTest() {
        signUpPage = loginPage.clickSignUpButton();
        String expected = ConfProperties.getProperty("signuppageURL");
        String actual = signUpPage.getURL();
        assertEquals(expected, actual);
    }
    //проверка работоспособности авторизации
    @Test
    public void loginWithValidEmailPassTest() {
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        String expected = ConfProperties.getProperty("profilepageURL");
        String actual = loginPage.getURL();
        assertEquals(expected, actual);
    }

    @Test
    public void loginWithEmptyPasswordTest() {
        loginPage.login(VALID_EMAIL,"");
        String errorText = loginPage.getErrorText();
        boolean flag = errorText.contains("Please check your login");
        assertTrue(flag);
    }
    @Test
    public void loginWithEmptyDataTest() {
        loginPage.login("","");
        String errorText = loginPage.getErrorText();
        boolean flag = errorText.contains("Please check your login");
        assertTrue(flag);
    }
    @Test
    public void loginWithNotExistEmailTest() {
        loginPage.login(NOT_EXIST_EMAIL, "12345");
        String errorText = loginPage.getErrorText();
        boolean flag = errorText.contains("Please check your login");
        assertTrue(flag);
    }
    @Test
    public void loginWithNotValidPasswordTest() {
        loginPage.login(VALID_EMAIL,NOT_VALID_PASSWORD);
        String errorText = loginPage.getErrorText();
        boolean flag = errorText.contains("Please check your login");
        assertTrue(flag);
    }
    @AfterAll
    public static void tearDown() {
        //driver.quit();
    }
}
