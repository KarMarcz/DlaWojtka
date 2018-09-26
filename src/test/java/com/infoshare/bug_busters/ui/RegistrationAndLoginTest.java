package com.infoshare.bug_busters.ui;

import com.infoshare.bug_busters.pageObject.HomePage;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.utils.WebDriverCreators;
import com.infoshare.bug_busters.utils.WebDriverProvider;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationAndLoginTest {

    private WebDriver driver;

    private RandomDataGenerator dataGenerator;

    private HomePage homePage;

    UserDataGenerator userDataGenerator = new UserDataGenerator(dataGenerator);

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }

    @Test
    public void klikanie() {
        driver.get("http://localhost:4180/");
        homePage.klikanie();
    }

    @Test
    public void registrationWithUserDataGeneratorMethodTest() throws IOException {
        driver.get("http://localhost:4180/");

        homePage.registerUserWithDataGeneratorMethod("Karol2", "Karol", "Karol", "costam@gmail@com", "abcd1234");

        assertThat(homePage.getTextFromLogoutToConfirmLoginOrRegistration().contains("Logout")).as("User is not Registered");
    }

}
//userDataGenerator.prepareUserData().getUserName(), userDataGenerator.prepareUserData().getFirstName(), userDataGenerator.prepareUserData().getLastName(), userDataGenerator.prepareUserData().getEmail(), userDataGenerator.prepareUserData().getPassword()
