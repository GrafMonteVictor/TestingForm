package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//������:
    //PageFactory
        //���������� @FindBy(xPath"")
        //���� ��������� WebElement
        //�������������� WebElement: MainPage mainPage = PageFactory.initElements(driver, MainPage.class)
    //���������: @Test, @AfterAll, AfterEach, @Ignore?
    //Asserts: assertTrue/False, assertEquals/NotEquals, assertNull/NotNull,
    //��� ������ �������� - ��������� �����: MainPageTest,

//���������
    //�������� �� ������� ������� ������ ����
        //clickSighUp() return new Page
        //inputEmail() return this.Page
        //register() return new Page
        //����� ��������� ������ ������
    //������� ����������
    //��������� ������� ������� � ����� java

//�������� ��������������� ������������
//��������� ����������������
public class ProfileTest {
    private static String homepageURL = ConfProperties.getProperty("homepageURL");
    private static String loginpageURL = ConfProperties.getProperty("loginpageURL");
    private static String signuppageURL = ConfProperties.getProperty("signuppageURL");
    private static String profilepageURL = ConfProperties.getProperty("profilepageURL");
    private static SignUpPage signUpPage;
    private static LoginPage loginPage;
    private static ProfilePage profilePage;
    private static HomeMainPage homeMainPage;
    private static WebDriver driver;
    //private String name = ConfProperties.getProperty("name");
    @BeforeAll
    public static void setup() {
        //�������� ���������� ��������
        driver = new ChromeDriver();
        homeMainPage = new HomeMainPage(driver);
        //���� ��������������� �� ������ �����
        driver.manage().window().maximize();
        //�������� �� ���������� ����� = 10 ���.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @BeforeEach
    public void toHomepage() {
        driver.get(homepageURL);
    }
    @Test
    public void registerTest() {
        homeMainPage.click(homeMainPage.getSighUpRefLocator());
        signUpPage = new SignUpPage(driver);
        signUpPage.inputEmail(email);
        signUpPage.inputPassword(password);
        signUpPage.clickSignUp();
        String expected = loginpageURL;
        String actual = driver.getCurrentUrl();
        assertEquals(expected, actual);
    }

    @Test
    public void loginTest() {
        homeMainPage.click(homeMainPage.getLoginRefLocator());
        loginPage = new LoginPage(driver);
        loginPage.input(LoginPage.emailLocator, email);
        loginPage.input(LoginPage.passwordLocator, password);
        loginPage.click(LoginPage.loginLocator);
        boolean flag = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.urlContains("profile"));
        assertTrue(flag);
        //�������� ���������
        profilePage = new ProfilePage(driver);
        profilePage.click(profilePage.logoutRefLocator);
        String expected = homepageURL;
        String actual = driver.getCurrentUrl();
        assertEquals(expected, actual);
    }

    @Test
    public void sighOutTest() {

    }


    @AfterAll
    public static void tearDown() {
//        profilePage.entryMenu();
//        profilePage.userLogout();
//        driver.quit();
    }
}
