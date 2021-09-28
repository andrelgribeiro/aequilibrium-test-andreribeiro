# language: en
@swagLabs
Feature: Login page and its features

  Scenario: Validate login successfully
    Given the user navigates to the login page
    When the user inform the correct username and password
    Then the system logs in successfully

  Scenario: Attempt to login with invalid username
    Given the user navigates to the login page
    When the user inform the invalid username
    Then the system does not perform user login

  Scenario: Attempt to login the user with a wrong password
    Given the user navigates to the login page
    When the user inform the correct username and wrong password
    Then the system does not perform user login

  Scenario: Attempt to log in the user without entering the username field
    Given the user navigates to the login page
    When the user does not inform the username but entering the password
    Then the system inform the user about empty fields

  Scenario: Attempt to log in the user without entering the password field
    Given the user navigates to the login page
    When the user does not inform the password but entering the username
    Then the system inform the user about empty fields

  Scenario: Attempt to log in a locked user
    Given the user navigates to the login page
    When inform a locked user in login page
    Then the system inform that the user is locked