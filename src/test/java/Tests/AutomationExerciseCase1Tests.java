package Tests;

import Pages.HomePage;
import Pages.SignUpLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class AutomationExerciseCase1Tests {
    private WebDriver driver;
    private HomePage homePage;
    private SignUpLoginPage signUpLoginPage;


    @BeforeEach
    void setup() {
        //1. Launch browser

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        signUpLoginPage = new SignUpLoginPage(driver);

        //2. Navigate to url 'http://automationexercise.com'

        driver.get("https://automationexercise.com/");
    }

    @Test
    void testCaseRegisterUser() {

        //3.Verify that home page is visible successfully

        homePage.waitUntilTheElementShowXpath(homePage.logo);
        WebElement logo = driver.findElement(By.xpath(homePage.logo));
        Assertions.assertTrue(logo.isDisplayed());

        //4. Click on 'Signup / Login' button

        homePage.clickOnElementXpath(homePage.signupLogin);
        signUpLoginPage.waitUntilTheElementShowXpath(signUpLoginPage.newUserSignUp);

        //5. Verify 'New User Signup!' is visible

        WebElement newUserSignUp = driver.findElement(By.xpath(signUpLoginPage.newUserSignUp));
        Assertions.assertTrue(newUserSignUp.isDisplayed());

        //6. Enter name and email address

        signUpLoginPage.typeInBlankXpath(signUpLoginPage.name, "name");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.email, "emailadree823ss@gmail.com");

        //7. Click 'Signup' button

        signUpLoginPage.clickOnElementXpath(signUpLoginPage.signUpButton);

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

        WebElement enterNewAccInfo = driver.findElement(By.xpath(signUpLoginPage.enterAccInfo));
        Assertions.assertTrue(enterNewAccInfo.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth

        signUpLoginPage.getRandomButton().click(); // To randomly select one of the mr and mrs options.
        signUpLoginPage.selectRandomDate();
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.password, "Password");

        //10. Select checkbox 'Sign up for our newsletter!'

        signUpLoginPage.clickOnElementXpath(signUpLoginPage.newsletter);

        //11. Select checkbox 'Receive special offers from our partners!'

        signUpLoginPage.clickOnElementXpath(signUpLoginPage.optin);

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        signUpLoginPage.typeInBlankXpath(signUpLoginPage.firstName, "First Name");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.lastName, "Last Name");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.company, "Apple");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.address, "Milky Way Galaxy");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.address2, "Solar System, World");
        signUpLoginPage.selectRandomCountry();
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.state, "California");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.city, "Cupertino");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.zipCode, "07050");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.mobilePhoneNumber, "05551234567");

        //13. Click 'Create Account button'

        signUpLoginPage.clickOnElementXpath(signUpLoginPage.createAccountButton);

        //14. Verify that 'ACCOUNT CREATED!' is visible

        signUpLoginPage.waitUntilTheElementShowXpath(signUpLoginPage.accountCreatedPng);
        WebElement accountCreated = driver.findElement(By.xpath(signUpLoginPage.accountCreatedPng));
        Assertions.assertTrue(accountCreated.isDisplayed());

        //15. Click 'Continue' button

        signUpLoginPage.waitUntilTheElementShowXpath(signUpLoginPage.continueButton);
        signUpLoginPage.clickOnElementXpath(signUpLoginPage.continueButton);

        //16. Verify that 'Logged in as username' is visible

        homePage.waitUntilTheElementShowXpath(homePage.loggedAcc);
        WebElement loggedAcc = driver.findElement(By.xpath(homePage.loggedAcc));
        Assertions.assertTrue(loggedAcc.isDisplayed());

        //17. Click 'Delete Account' button

        homePage.waitUntilTheElementShowXpath(homePage.deleteAcc);
        homePage.clickOnElementXpath(homePage.deleteAcc);

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        homePage.waitUntilTheElementShowXpath(homePage.accDeleted);
        WebElement deletedAcc = driver.findElement(By.xpath(homePage.accDeleted));
        Assertions.assertTrue(deletedAcc.isDisplayed());

        signUpLoginPage.clickOnElementXpath(signUpLoginPage.continueButton);
    }

    @AfterEach
    void teardown() {
        driver.close();
    }
}
