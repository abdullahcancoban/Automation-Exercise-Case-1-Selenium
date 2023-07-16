package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SignUpLoginPage extends Page {


    public final String newUserSignUp = "//h2[.='New User Signup!']";

    public final String name = "//input[@name='name']";
    public final String email = "//div[@class='signup-form']//input[@name='email']";
    public final String signUpButton = "//button[.='Signup']";
    public final String enterAccInfo = "//b[.='Enter Account Information']";

    // The following code sequence ensures random selection of mr and mrs on the signup page.
    public List<WebElement> getButtons() {
        return driver.findElements(By.xpath("//input[@value='Mrs' or @value='Mr']"));
    }

    public WebElement getRandomButton() {
        List<WebElement> buttons = getButtons();
        Random random = new Random();
        int randomIndex = random.nextInt(buttons.size());
        return buttons.get(randomIndex);
    }

    //// The following code sequence ensures random date selection on the signup page.
    public void selectRandomDate() {
        WebElement daySelect = driver.findElement(By.xpath("//select[@id='days']"));
        WebElement monthSelect = driver.findElement(By.xpath("//select[@id='months']"));
        WebElement yearSelect = driver.findElement(By.xpath("//select[@id='years']"));

        List<WebElement> dayOptions = daySelect.findElements(By.tagName("option"));
        List<WebElement> monthOptions = monthSelect.findElements(By.tagName("option"));
        List<WebElement> yearOptions = yearSelect.findElements(By.tagName("option"));

        Random random = new Random();
        int randomDayIndex = random.nextInt(dayOptions.size());
        int randomMonthIndex = random.nextInt(monthOptions.size());
        int randomYearIndex = random.nextInt(yearOptions.size());

        dayOptions.get(randomDayIndex).click();
        monthOptions.get(randomMonthIndex).click();
        yearOptions.get(randomYearIndex).click();
    }

    public final String password = "//input[@id='password']";
    public final String newsletter = "//input[@id='newsletter']";
    public final String optin = "//input[@id='optin']";

    public final String firstName = "//input[@id='first_name']";
    public final String lastName = "//input[@id='last_name']";
    public final String company = "//input[@id='company']";
    public final String address = "//p[4]/input[@class='form-control']";
    public final String address2 = "//p[5]/input[@class='form-control']";

    //// The following code sequence ensures random country selection on the signup page.
    public void selectRandomCountry() {
        WebElement countrySelect = driver.findElement(By.xpath("//select[@id='country']"));

        List<WebElement> countryOptions = countrySelect.findElements(By.tagName("option"));


        Random random = new Random();
        int randomCountryIndex = random.nextInt(countryOptions.size());


        countryOptions.get(randomCountryIndex).click();
    }

    public final String state = "//input[@id='state']";
    public final String city = "//input[@id='city']";
    public final String zipCode = "//input[@id='zipcode']";
    public final String mobilePhoneNumber = "//input[@id='mobile_number']";
    public final String createAccountButton = "//button[.='Create Account']";
    public final String accountCreatedPng = "//b[.='Account Created!']";

    public final String continueButton = "//a[.='Continue']";


    public SignUpLoginPage(WebDriver driver) {
        super(driver);
    }
}
