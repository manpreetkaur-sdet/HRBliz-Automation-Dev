Feature: Employee Leave Request
  As an employee
  I want to create a leave request
  So that my manager can approve or reject it

  Scenario: Employee can create a new leave request
    Given I am logged in as "Employee"
    And I click on quick access
    And I click on plus icon
    And I am on the leave request page
    And I select 7 days from today in Calendar
    And I click on Request leave button
    And I click on leave Confirm button
    Then the leave request should appear in my leave request list