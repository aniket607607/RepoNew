Feature: Test CRM

  Scenario Outline: Test CRM website
    Given I open CRM homepage
    When I enter valid "<username>" and "<password>"
    And click on login
    Then landing page should be displayed

    Examples: 
      | username        | password   |
      | groupautomation | Test@12345 |