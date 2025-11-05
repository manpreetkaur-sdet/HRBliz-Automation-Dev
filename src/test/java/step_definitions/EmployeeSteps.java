package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import page_objects.Pages;
import utils.Helpers;
import utils.Wait;


public class EmployeeSteps extends Pages {
    Wait wait = new Wait();
    Helpers helpers = new Helpers();

    @And("I click on quick access")
    public void clickOnQuickAccess() {
        wait.waitUntilVisibilityOfElement(employeePage.quickAccessLeaves);
        employeePage.quickAccessLeaves.click();
    }

    @And("I click on plus icon")
    public void clickOnPlusSign() {
        wait.waitUntilPageLoad(driver);
        wait.waitAndClick(employeePage.plusIcon);
    }

    @And("I am on the leave request page")
    public void leaveRequestPage() {
        employeePage.leaveRequestPopup().isDisplayed();
    }

    @And("I select {int} days from today in Calendar")
    public void selectDays(int days) {
        employeePage.selectDate(days);
    }

    @And("I click on Request leave button")
    public void requestLeave() {
        helpers.scrollToElement(employeePage.requestLeaveBtn);
        wait.waitAndClick(employeePage.requestLeaveBtn);
    }

    @And("I click on leave Confirm button")
    public void leaveConfirm() {
        wait.waitAndClick(employeePage.confirmLeaveButton);
    }

    @Then("the leave request should appear in my leave request list")
    public void leaveRequestShow() {
        employeePage.requestedLeave.isDisplayed();
    }

    @And("I withdrawn the created request")
    public void withdrawLeaveRequest() {
        wait.waitUntilVisibilityOfElement(employeePage.requestedLeave);
        employeePage.requestedLeave.click();
        wait.waitAndClick(employeePage.withdrawnRequest);
        wait.waitAndClick(employeePage.withdrawnConfirm);
    }
}