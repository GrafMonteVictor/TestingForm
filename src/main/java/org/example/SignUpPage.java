package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class SignUpPage {
    private By loginButton = By.xpath("//a[@href='/login']");
    private By sighUpButton = By.xpath("//a[@href='/signup']");
    private By homeButton = By.xpath("//a[@href='/']");
    private By emailField = By.xpath("//input[@name='email']");
    private By nameField = By.xpath("//input[@name='name']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By signUpButtonForReg = By.xpath("//button[@class='button is-block is-info is-large is-fullwidth']");
    private By errorSignUp = By.xpath("//*[@class='notification is-danger']");
    private WebDriver driver;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLogin() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
    public SignUpPage clickSignUp() {
        driver.findElement(sighUpButton).click();
        return this;
    }
    public HomeMainPage clickHome() {
        driver.findElement(homeButton).click();
        return new HomeMainPage(driver);
    }
    public SignUpPage inputEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    public SignUpPage inputName(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }
    public SignUpPage inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public LoginPage signUp(String email, String password) {
        this.inputEmail(email);
        this.inputPassword(password);
        driver.findElement(signUpButtonForReg).click();
        return new LoginPage(driver);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }
    public String getError() {
        return driver.findElement(errorSignUp).getText();
    }
    public String getRandomValidEmail() {
        StringBuilder randEmail = new StringBuilder();
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        //реализуем рандомную длину строки: [3, 16]
        int a = 3;
        int b = 16;
        int targetStringLength = (int)(Math.random()*(b-a)+a);
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                //исключаем символы: < > ( ) [ ] @ , ; : \ / " * и пробел
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        randEmail.append(generatedString);
        randEmail.append("@mail.ru");

        return randEmail.toString();
    }

    public String getRandomInvalidEmail() {
        StringBuilder randEmail = new StringBuilder();
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        //реализуем рандомную длину строки: [3, 16]
        int a = 3;
        int b = 16;
        int targetStringLength = (int)(Math.random()*(b-a)+a);
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                //исключаем символы: < > ( ) [ ] @ , ; : \ / " * и пробел
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        randEmail.append(generatedString);
        randEmail.append("@mailru");

        return randEmail.toString();
    }

}
