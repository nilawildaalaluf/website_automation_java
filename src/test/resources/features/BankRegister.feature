@All
Feature: Para bank Registration

  @positive @register
  Scenario: Success register
    Given User is on parabank homepage
    When User click register link button
    Then User is in register page
    When User input name
    And User input address detail
    And User input valid username and password
    And User input password confirmation
    When User click Register button
    Then User register successfully

  @negative @register
  Scenario: Failed register - Missmatch Password
    Given User is on parabank homepage
    When User click register link button
    Then User is in register page
    When User input name
    And User input address detail
    And User input valid username and password
    And user input invalid password confirmation
    When User click Register button
    Then user get error password did not match
