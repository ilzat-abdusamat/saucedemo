Feature: Contact

  Users should be able to send a contact message.

  Scenario: Submit a contact form with valid data
    Given user is on home page
    And click on contact header link
    And fill out the contact form
    And click on send message button
    Then verify that form is submitted


  Scenario Outline: name

    Given I run the step with "<firstName>" and "<lastName>"

    Examples:
      | firstName  | lastName  |
      | parameter1a | parameter2a |
      | parameter1b | parameter2b |