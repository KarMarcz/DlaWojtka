package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    private WebDriver driver;
    private Waits waits;

    public HomePage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    public void klikanie() {
        registerButton.click();
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

}
