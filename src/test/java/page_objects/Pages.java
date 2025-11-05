package page_objects;

import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

public class Pages extends BaseClass {
    public LoginPage login;
    public EmployeePage employeePage;

    public Pages() {
        login = new LoginPage();
        employeePage = new EmployeePage();
        PageFactory.initElements(driver, this);
    }
}
