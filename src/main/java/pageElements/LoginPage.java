package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By emailInput = By.name("email");
    By passwordInput = By.name("password");
    By submitLogInButton = By.id("submit-login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmailInput(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword (String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void submitLogInButtonClick () {
        driver.findElement(submitLogInButton).click();
    }

    public void submitLogIn (String email, String password) {
        setEmailInput(email);
        setPassword(password);
        submitLogInButtonClick();
    }
}