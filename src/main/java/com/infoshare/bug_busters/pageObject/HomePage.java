package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage {

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    private WebElement registerButton;

    @FindBy(xpath = "//input[@id='register-username-modal']")
    private WebElement userNameFieldInRegistration;

    @FindBy(xpath = "//input[@id='register-first-modal']")
    private WebElement firstNameFieldInRegistration;

    @FindBy(xpath = "//input[@id='register-last-modal']")
    private WebElement lastNameFieldInRegistration;

    @FindBy(xpath = "//input[@id='register-email-modal']")
    private WebElement emailFieldInRegistration;

    @FindBy(xpath = "//input[@id='register-password-modal']")
    private WebElement passwordFieldInRegistration;

    @FindBy(xpath = "//div[@id='register-modal']//button[@class='btn btn-primary']")
    private WebElement registerinPopUpWindowButton;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//li[@id='login']//a[@href='#'][contains(text(),'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement alertRegistration;

    private WebDriver driver;
    private Waits waits;
    private UserDataGenerator userDataGenerator = new UserDataGenerator(new RandomDataGenerator());

    public HomePage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    public void registerUserWithDataGeneratorMethod(String userName, String firstName, String lastName, String email, String password) {
        registerButton.click();
        waits.waitForElementToBeVisible(userNameFieldInRegistration);
        userNameFieldInRegistration.sendKeys(userName);
        firstNameFieldInRegistration.sendKeys(firstName);
        lastNameFieldInRegistration.sendKeys(lastName);
        emailFieldInRegistration.sendKeys(email);
        passwordFieldInRegistration.sendKeys(password);
        registerinPopUpWindowButton.click();
        waits.waitForElementToBeVisible(logoutButton);
    }

    public String getTextFromLogoutToConfirmLoginOrRegistration() {
        return logoutButton.getText();
    }

    public String alertRegistration() {
        return alertRegistration.getText();
    }

    public void regiterUserTwiceWithTheSameData() throws IOException {

        String userName = userDataGenerator.prepareUserData().getUserName()+"1111";
        String firstName = userDataGenerator.prepareUserData().getFirstName();
        String lastName = userDataGenerator.prepareUserData().getLastName();
        String email = userDataGenerator.prepareUserData().getEmail();
        String password = userDataGenerator.prepareUserData().getPassword();

        registerButton.click();
        waits.waitForElementToBeVisible(userNameFieldInRegistration);
        userNameFieldInRegistration.sendKeys(userName);
        firstNameFieldInRegistration.sendKeys(firstName);
        lastNameFieldInRegistration.sendKeys(lastName);
        emailFieldInRegistration.sendKeys(email);
        passwordFieldInRegistration.sendKeys(password);
        registerinPopUpWindowButton.click();
        waits.waitForElementToBeVisible(logoutButton);
        logoutButton.click();

        waits.waitForElementToBeVisible(loginButton);
        registerButton.click();
        waits.waitForElementToBeVisible(userNameFieldInRegistration);
        userNameFieldInRegistration.sendKeys(userName);
        firstNameFieldInRegistration.sendKeys(firstName);
        lastNameFieldInRegistration.sendKeys(lastName);
        emailFieldInRegistration.sendKeys(email);
        passwordFieldInRegistration.sendKeys(password);
        registerinPopUpWindowButton.click();

    }

}
