@login @regression

Feature: Webdriver University Web page - Login page

  Background:
    Given I access the webdriver university Login page

  @smoke
  Scenario Outline: Validate successfull and unsuccessfull login
    When I enter username <username>
    And I enter password <password>
    And I click on Login button
    Then I should be present with <loginValidationMessage> Login message

    Examples:
      | username     | password     | loginValidationMessage |
      | webdriver    | webdriver123 | validation succeeded   |
      | webdriverwer | webdriver234 | validation failed      |


#Withour Scenario Outline
#  Scenario: Validate successfull login with correct username and password
#    When I enter username "webdriver"
#    And I enter password webdriver123
#    And I click on Login button
#    Then I should be present with successfully Login message
#
#  Scenario: Validate unsuccessfull login with wrong username and password
#    When I enter username "webdriver123"
#    And I enter password webdriverQQQ
#    And I click on Login button
#    Then I should be present with unsuccessfully Login message