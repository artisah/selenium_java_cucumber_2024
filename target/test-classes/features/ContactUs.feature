@contact-us @regression

Feature: Webdriver University Web page - Contact Us page

  Background:
    Given I access the webdriver university contact us page

  @smoke
  Scenario: Validate successfull submission -  unique data
    When  I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on submit button
    Then I should be present with successfully contact us submission message

  @ignore
  Scenario: Validate successfull submission - specific data
    When I enter a specific first name Priya
    And I enter a specific last name sanghi
    And I enter a specific email address test@aaa.com
    And I enter a specific comment "This is test comment"
    And I click on submit button
    Then I should be present with successfully contact us submission message