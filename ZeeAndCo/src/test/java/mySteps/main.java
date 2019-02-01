package mySteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.util.Password;

import java.net.PasswordAuthentication;

public class main {

    WebDriver driver;

    //Test case 1
    @Given("^I am on the homepage$")
    public void i_am_on_the_homepage() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.zeeandco.co.uk/");
    }

    @When("^I click on the sign in link$")
    public void i_click_on_the_sign_in_link() {
        driver.findElement(By.cssSelector(".actions > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).click();
    }

    @Then("^I should be taken to the create account page$")
    public void i_should_be_taken_to_the_create_account_page() {
        driver.findElement(By.cssSelector(".page-title > h1:nth-child(1)"));
        //test
        String actual_head = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/section/div/div[1]/h1")).getText();
        String expected_head = "Login or Create an Account";
        Assert.assertTrue(actual_head.equalsIgnoreCase(expected_head));
        System.out.println("Test 1 complete");
    }

    //Test case 2
    @Given("^I enter my username and password$")
    public void iEnterMyUsernameAndPassword() {
        driver.findElement(By.cssSelector("#email")).sendKeys("morrismessias@hotmail.co.uk");
        driver.findElement(By.cssSelector("#pass")).sendKeys("185Mess.");
    }

    @And("^I click the login button$")
    public void iClickTheLoginButton() {
        driver.findElement(By.cssSelector("#send2")).click();
    }

    @Then("^I should receive error message: invalid username or password$")
    public void iShouldReceiveErrorMessageInvalidUsernameOrPassword() {
        driver.findElement(By.cssSelector(".error-msg > ul:nth-child(1) > li:nth-child(1)"));
        //test
        String error_message = driver.findElement(By.xpath("/html/body/div[3]/ul/li/ul/li/span")).getText();
        String expected = "invalid login or password.";
        Assert.assertTrue(error_message.equalsIgnoreCase(expected));
        System.out.println("Test 2 complete");
    }

    //Test case 3
    @Given("^that I have forgotten my password$")
    public void thatIHaveForgottenMyPassword() throws Throwable {

        driver.findElement(By.cssSelector(".icon")).click();
        Thread.sleep(5000);
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
    }

    @And("^I enter my email address to reset my password$")
    public void iEnterMyEmailAddressToResetMyPassword() {
        driver.findElement(By.cssSelector("#email_address")).sendKeys("morrismessias@hotmail.co.uk");
    }

    @And("^I click submit$")
    public void iClickSubmit() {
        driver.findElement(By.cssSelector(".form-buttons > button:nth-child(1)")).click();
    }

    @Then("^I should navigate to another page$")
    public void iShouldNavigateToAnotherPage() {
        //Run this line of code but remember, it might of changed again because of the time you're attempting to login.
        //The initial code written before didn't work
        // because the website had a login attempt limit that we were unaware of, therefore he code had to be re-written.

        driver.findElement(By.cssSelector(".mfp-close")).click();
        //test
        String actual_title = driver.getTitle();
        String expected_title = "Forgot Your Password - Zee & Co";
        driver.close();
        Assert.assertTrue(actual_title.equalsIgnoreCase(expected_title));
        System.out.println("Test 3 complete");
    }
}
