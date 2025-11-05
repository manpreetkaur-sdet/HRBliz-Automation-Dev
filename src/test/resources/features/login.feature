@login
Feature: Login
  As employee and manager
  I want to log in to the HRBlizz application
  So that I can access my dashboard

  Scenario: Verify that an Employee can log in with valid credentials
    Given I am on the login page
    When I enters a valid "EMPLOYEE_EMAIL"
    And I enters a valid password "EMPLOYEE_PASSWORD"
    And I click on the login button
    Then I should be redirected to the dashboard

  Scenario: Verify that Manager can log in with valid credentials
    Given I am on the login page
    When I enters a valid "MANAGER_EMAIL"
    And I enters a valid password "MANAGER_PASSWORD"
    And I click on the login button
    Then I should be redirected to the dashboard

  Scenario: I cannot login with an invalid password
    Given I am on the login page
    When I enters a valid "MANAGER_EMAIL"
    And I enter an invalid password "INVALID_PASSWORD"
    And I click on the login button
    Then I should see an error message on login page