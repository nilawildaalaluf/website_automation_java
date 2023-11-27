@All
Feature: Para bank Registration with TDD

    @TDD @register
    Scenario Outline: Register Bank Positive and Negative
      Given User see parabank homepage
      When User can click register link button
      Then User see register page
      When User input name for bank account
      And User input address detail account
      And User can input <username> and <password>
      And User can input <rePassword> confirmation
      When User click Register button account
      Then User bank get verify login <result>

      Examples:
        | username | password | rePassword | result |
        | MyName | 12345 | 12345 | Passed |
        | MyName| 12345 | 11111 | Failed |
