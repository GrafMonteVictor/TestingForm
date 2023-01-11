package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private HomeMainPage homeMainPage;
    private LoginPage loginPage;
    private SignUpPage signUpPage;
    private By homeButton = By.xpath("//*[@href='/']");
    private By loginButton = By.xpath("//*[@href='/login']");
    private By signUpButton = By.xpath("//*[@href='/signup']");
    private By emailField = By.xpath("//input[@name='email']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By rememberMeCheckBox = By.xpath("//label[text()[contains(.,'Remember me')]]");
    private By loginButtonForEnter = By.xpath("//button[@class='button is-block is-info is-large is-fullwidth']");
    private By errorCheckLogin = By.xpath("//*[@class='notification is-danger']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomeMainPage clickHomeButton() {
        driver.findElement(homeButton).click();
        return new HomeMainPage(driver);
    }

    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }
    public LoginPage inputEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    public LoginPage inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public ProfilePage clickLoginButtonForEnter() {
        driver.findElement(loginButtonForEnter).click();
        return new ProfilePage(driver);
    }
    public LoginPage clickRememberMeCheckbox() {
        driver.findElement(rememberMeCheckBox).click();
        return this;
    }
    public ProfilePage login(String email, String password) {
        this.inputEmail(email);
        this.inputPassword(password);
        this.clickLoginButtonForEnter();
        return new ProfilePage(driver);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }
    public String getErrorText() {
        return driver.findElement(errorCheckLogin).getText().trim();
    }

}
