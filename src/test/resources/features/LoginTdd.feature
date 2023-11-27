Feature: Login with TDD

  @TDD @Login

  Scenario Outline: Login with TDD
    Given User is on Login page
    When User fill <username> and <password>
    And User click login button
    Then User get verify login <result>

    Examples:
    | username | password | result |
    | standard_user | secret_sauce | Passed |
    | invalidUsername | secret_sauce | Failed |
    | standard_user | invalidPassword | Failed |