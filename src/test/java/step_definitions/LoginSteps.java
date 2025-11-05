package step_definitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import page_objects.Pages;
import utils.Enviornment;
import utils.Wait;


public class LoginSteps extends Pages {
    Wait wait = new Wait();


    @Before
    public void loadCredentials() {
        Enviornment.load();
    }

    @Given("I am on the login page")
    public void navigateToHrblizz() {
        wait.waitUntilPageLoad(driver);
        login.navigateToLoginPage();
    }

    @When("I enters a valid {string}")
    public void enterEmail(String email) {
        login.enterEmailAddress(Enviornment.get(email));

    }

    @And("I enters a valid password {string}")
    public void enterEmpPassword(String password) {
        login.enterPassword(Enviornment.get(password));
    }

    @And("I enter an invalid password {string}")
    public void enterInValidPassword(String password) {
        login.enterPassword(Enviornment.get(password));
    }

    @And("I click on the login button")
    public void clickOnLoginButton() {
        login.loginButton.click();
    }

    @Then("I should be redirected to the dashboard")
    public void employeeIsOnDashboard() throws InterruptedException {
        wait.waitLongUntilLoaderNotPresent(login.dashboardText);
        Assert.assertTrue(login.dashboardText.isDisplayed(), "Employee Dashboard not displayed!");
    }

    @Then("I should see an error message on login page")
    public void credsError(){
        wait.waitUntilVisibilityOfElement(login.errorInvalidCreds);
        Assert.assertTrue(login.errorInvalidCreds.isDisplayed(),"Error message is not displaying");
    }
    @Given("I am logged in as {string}")
    public void iLoggingInWithRoles(String emp)throws InterruptedException{
        login.iLogin(emp);
        wait.waitLongUntilLoaderNotPresent(login.dashboardText);
    }

}
