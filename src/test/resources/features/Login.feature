@sprint1 @login
Feature: Login

@regression
  Scenario: Login using valid credentials
#    Given I opened browser navigate to HRMS
    Then I enter valid username and password
    Then I click login btn
    And I should be able to successfully log in
#    Then I close browser

    @smoke
    Scenario: invalid login
#      Given I opened browser navigate to HRMS
      When I enter invalid "Burju_Invalid_User" and "Burju_Invalid_User"
      Then I click login btn
      And I should see an error message
#      Then I close browser


  @smoke
    Scenario Outline: Invalid Login and message validation
    When I enter "<someusername>" and "<somepassword>"
    And I click login btn
    Then I should see an "<error>" message

    Examples:
    |someusername  | somepassword | error                          |
    |  Admin       |invalidpas    |Invalid credentials             |
    |  Admin       |              | Password cannot be empty       |
    |              |Synt@x123!    |Username cannot be empty        |
    |              |              |Username cannot be empty        |
