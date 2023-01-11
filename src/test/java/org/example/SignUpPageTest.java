package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignUpPageTest {
    private static WebDriver driver;
    private static SignUpPage signUpPage;
    private LoginPage loginPage;
    private HomeMainPage homeMainPage;
    private final String EXIST_EMAIL = ConfProperties.getProperty("email");
    private final String PASSWORD = ConfProperties.getProperty("password");


    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        signUpPage = new SignUpPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("signuppageURL"));
    }

    //проверка кликабельности кнопок
    @Test
    public void clickLoginTest() {
        loginPage = signUpPage.clickLogin();
        String expected = ConfProperties.getProperty("loginpageURL");
        String actual = loginPage.getURL();
        assertEquals(expected, actual);
    }

    @Test
    public void clickSignUpTest() {
        signUpPage = signUpPage.clickSignUp();
        String expected = ConfProperties.getProperty("signuppageURL");
        String actual = signUpPage.getURL();
        assertEquals(expected, actual);
    }

    @Test
    public void clickHome() {
        homeMainPage = signUpPage.clickHome();
        String expected = ConfProperties.getProperty("homepageURL");
        String actual = homeMainPage.getURL();
        assertEquals(expected, actual);
    }
    //проверка регистрации
    @Test
    public void signUpWithNewUser() {
        loginPage = signUpPage.signUp(signUpPage.getRandomValidEmail(),PASSWORD);
        String expected = ConfProperties.getProperty("loginpageURL");
        String actual = loginPage.getURL();
        assertEquals(expected, actual);
    }

    @Test
    public void signUpWithExistUser() {
        loginPage = signUpPage.signUp(EXIST_EMAIL, PASSWORD);
        String errorText = loginPage.getErrorText();
        boolean flag = errorText.contains("Email address already exists");
        assertTrue(flag);
    }

    @Test
    public void signUpWithoutData() {
        loginPage = signUpPage.signUp("","");
        String expected = ConfProperties.getProperty("signuppageURL");
        String actual = loginPage.getURL();
        assertEquals(expected, actual);


    }

    @Test
    public void signUpNewUserWithoutPassword() {
        loginPage = signUpPage.signUp(signUpPage.getRandomValidEmail(),"");
        String expected = ConfProperties.getProperty("signuppageURL");
        String actual = loginPage.getURL();
        assertEquals(expected, actual);

    }

    @Test
    public void signUpNewUserWithInvalidEmail() {
        String invalidEmail = signUpPage.getRandomInvalidEmail();
        loginPage = signUpPage.signUp(invalidEmail,"12345678");
        String expected = ConfProperties.getProperty("signuppageURL");
        String actual = loginPage.getURL();
        assertEquals(expected, actual);
    }

    @AfterAll
    public static void tearDown() {
        //driver.quit();
    }
}
