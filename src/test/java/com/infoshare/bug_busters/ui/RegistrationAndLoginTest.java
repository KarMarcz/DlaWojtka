package com.infoshare.bug_busters.ui;

import com.infoshare.bug_busters.pageObject.HomePage;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.utils.WebDriverCreators;
import com.infoshare.bug_busters.utils.WebDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationAndLoginTest {

    private WebDriver driver;

    private HomePage homePage;

    private UserDataGenerator userDataGenerator = new UserDataGenerator(new RandomDataGenerator());

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void registrationWithUserDataGeneratorMethodTest() throws IOException {
        driver.get("http://localhost:4180/");

        homePage.registerUserWithDataGeneratorMethod(userDataGenerator.prepareUserData().getUserName(), userDataGenerator.prepareUserData().getFirstName(), userDataGenerator.prepareUserData().getLastName(), userDataGenerator.prepareUserData().getEmail(), userDataGenerator.prepareUserData().getPassword());

        assertThat(homePage.getTextFromLogoutToConfirmLoginOrRegistration().contains("Logout")).as("User is not Registered");
    }

    @Test
    public void registrationTwiceWithTheSameData() throws IOException {
        driver.get("http://localhost:4180/");
        homePage.regiterUserTwiceWithTheSameData();
        assertThat(homePage.alertRegistration().contains("There was a problem with your registration: Internal Server Error")).as("Alert is not show after creating two indentical accounts");
    }

    @Test
    public void loginAfterRegistration() throws IOException {
        driver.get("http://localhost:4180/");
        homePage.loginUserAfterRegistration();
        assertThat(homePage.getTextFromLogoutToConfirmLoginOrRegistration().contains("Logout")).as("User is not Logged");
    }

}