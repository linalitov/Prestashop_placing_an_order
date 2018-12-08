package Steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageElements.*;


import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    WebDriver driver;
    LoginPage logInPage;
    CategoriesPage categoriesPage;
    ProductsPage productsPage;
    DetailsPage detailsPage;
    ProceedToCheckOutPage proceedToCheckOutPage;
    AddressPage addressPage;
    DeliveryOptionPage deliveryOptionPage;
    PaymentPage paymentPage;
    ConfirmationPage confirmationPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("^Navigates to to login page$")
    public void navigatesToToLoginPage() throws Throwable {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://fo.demo.prestashop.com/en/login?back=my-account");
    }

    @When("^The user inputs the email$")
    public void theUserInputsTheEmail() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        logInPage = new LoginPage(driver);
        logInPage.setEmailInput("yjammorryz-4557@yopmail.com");
    }

    @When("^The user inputs the password$")
    public void theUserInputsThePassword() throws Throwable {
      logInPage.setPassword("password12345");
    }

    @When("^The user clicks Sign In button$")
    public void theUserClicksSignInButton() throws Throwable {
       logInPage.submitLogInButtonClick();
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @When("^The user clicks on Women section$")
    public void theUserClicksOnWomenSection() throws Throwable {
        categoriesPage = new CategoriesPage(driver);
        categoriesPage.setCategorySelectorClick();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @When("^The user clicks on the product's button$")
    public void theUserClicksOnTheProductSButton() throws Throwable {
       productsPage = new ProductsPage(driver);
       productsPage.quickViewClick();
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @When("^The user selects the product's size$")
    public void theUserSelectsTheProductSSize() throws Throwable {
       detailsPage = new DetailsPage(driver);
       detailsPage.setDropdown("M");
    }

    @When("^The user clicks  Add to the cart button$")
    public void theUserClicksAddToTheCartButton() throws Throwable {
       detailsPage.addButtonClick();
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @When("^The user clicks  Proceed to check out button$")
    public void theUserClicksProceedToCheckOutButton() throws Throwable {
       detailsPage.proceedToCheckOutClick();
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @When("^The user clicks  Proceed to check out button again$")
    public void theUserClicksProceedToCheckOutButtonAgain() throws Throwable {
        proceedToCheckOutPage = new ProceedToCheckOutPage(driver);
        proceedToCheckOutPage.proceedButtonClick();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @When("^The user clicks  Confirm address button$")
    public void theUserClicksConfirmAddressButton() throws Throwable {
      addressPage = new AddressPage(driver);
      addressPage.addressConfirmationClick();
      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @When("^The user clicks  Confirm delivery option button$")
    public void theUserClicksConfirmDeliveryOptionButton() throws Throwable {
        deliveryOptionPage = new DeliveryOptionPage(driver);
        deliveryOptionPage.deliveryOptionConfirmation();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @When("^The user selects payment type$")
    public void theUserSelectsPaymentType() throws Throwable {
      paymentPage = new PaymentPage(driver);
      paymentPage.setPaymentType();
    }

    @When("^The user accepts agreement$")
    public void theUserAcceptsAgreement() throws Throwable {
        paymentPage.acceptAgreement();
    }

    @When("^The user clicks  Submit button$")
    public void theUserClicksSubmitButton() throws Throwable {
       paymentPage.paymentSubmitClick();
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Then("^YOUR ORDER IS CONFIRMED message shows up$")
    public void yourORDERISCONFIRMEDMessageShowsUp() throws Throwable {
        confirmationPage = new ConfirmationPage(driver);
        Assert.assertEquals(confirmationPage.getConfirmationMessage(),"YOUR ORDER IS CONFIRMED");
    }

    @After
    public void closing () {
        driver.close();
        driver.quit();
    }
}
