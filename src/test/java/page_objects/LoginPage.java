package page_objects;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;
import utils.Enviornment;
import utils.Wait;


public class LoginPage extends BaseClass {

    Wait waitElement = new Wait();
    public LoginPage() {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    public WebElement email;

    @FindBy(xpath = "//div[text()='Password']/following::input[1]")
    public WebElement password;

    @FindBy(css = "button[data-test='perform-login']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[text()='Employee self service']")
    public WebElement dashboardText;

    @FindBy(className = "login-response-error")
    public WebElement errorInvalidCreds;


    public void enterEmailAddress(String emailText) {
        waitElement.waitUntilVisibilityOfElement(email);
        email.sendKeys(emailText);
    }

    public void enterPassword(String pwd){
        password.sendKeys(pwd);
    }


    public void iLogin(String emp) {
        waitElement.waitUntilPageLoad(driver);
        navigateToLoginPage();
        waitElement.waitUntilVisibilityOfElement(email);
        if(emp.equalsIgnoreCase("Employee")){
            email.sendKeys(Enviornment.get("EMPLOYEE_EMAIL"));
            password.sendKeys(Enviornment.get("EMPLOYEE_PASSWORD"));
            loginButton.click();


        } else if (emp.equalsIgnoreCase("Manager")) {
            email.sendKeys(Enviornment.get("MANAGER_EMAIL"));
            password.sendKeys(Enviornment.get("MANAGER_PASSWORD"));
            loginButton.click();

        }
        else {
            System.out.println("Please enter valid credentials");
        }

    }
}
