package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.BaseClass;
import utils.Wait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.XMLFormatter;


public class EmployeePage extends BaseClass {
    Wait waitElement = new Wait();

    public EmployeePage() {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".lp-dashboard-card")
    public WebElement quickAccessLeaves;

    @FindBy(css = "button[aria-label='Request new leave']")
    public WebElement plusIcon;

    @FindBy(xpath = "//*[@id='leaves-webapp']//*[contains(@class, 'tile-wrapper')][1]")
    public WebElement requestedLeave;

    @FindBy(xpath = "//span[normalize-space()='Confirm']/ancestor::button")
    public WebElement confirmLeaveButton;

    @FindBy(css = "[data-test='submit-approve']")
    public WebElement requestLeaveBtn;

    @FindBy(css = "button[data-test='withdraw-request']")
    public WebElement withdrawnRequest;

    @FindBy(xpath = "//span[normalize-space()='Withdraw']/ancestor::button")
    public WebElement withdrawnConfirm;

    public WebElement leaveRequestPopup() {
        WebDriverWait block = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.id("ess-leaveRequest-modal")));
        return modal.findElement(By.xpath("//div[text()='Add new leave']"));
    }

    public void selectDate(int days) {

        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(days);
        int currentMonth = today.getMonthValue();
        int futureMonth = futureDate.getMonthValue();
        if (futureMonth != currentMonth) {
            WebElement nextArrow = driver.findElement(By.cssSelector(".date-picker__header__arrow-wrapper.right"));
            nextArrow.click();

        }
        String formattedDate = futureDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        driver.findElement(By.id(formattedDate)).click();
        driver.findElement(By.id(formattedDate)).click();
    }

    public void verifyLeaveRequest() {
        WebElement dateElement = driver.findElement(By.className(".Vue-Toastification__snackBar-body"));
        dateElement.isDisplayed();

    }


}
