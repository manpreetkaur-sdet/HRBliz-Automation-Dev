package step_definitions;

import org.openqa.selenium.WebDriver;

import utils.Enviornment;

public class BaseClass {
    public WebDriver driver = Hooks.driver;

    public void initialize() {
        Enviornment.load();
    }

    public void navigateToLoginPage() {
        initialize();
        driver.get(Enviornment.get("DEV_BASE_URL"));
    }

}
