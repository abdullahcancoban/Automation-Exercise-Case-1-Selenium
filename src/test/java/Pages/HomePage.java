package Pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    public final String logo = "//img[@alt='Website for automation practice']";
    public final String signupLogin = "//a[contains(.,'Signup / Login')]";

    public final String loggedAcc = "//i[@class='fa fa-user']";

    public final String deleteAcc = "//a[contains(.,'Delete Account')]";
    public final String accDeleted = "//b[.='Account Deleted!']";

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
