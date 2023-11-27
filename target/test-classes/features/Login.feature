@All
  Feature: Login

    @Test1 @Positive @ValidLogin
    Scenario: Login
      Given User is on Login page
      When User fill username and password
      And User click login button
      Then User verify login result

    @Test2 @Negative @InvalidLogin
    Scenario: Login
      Given User is on Login page
      When User fill invalid username and password
      And User click login button
      Then User get error message
