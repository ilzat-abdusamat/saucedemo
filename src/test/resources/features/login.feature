Feature: Login

  here, give some description of the feature you are automating.

  Scenario: Login with valid account
    Given user is on home page
    And click on login header link
    And enter valid username and password
    And click on login button
    Then verify that user is logged in successfully