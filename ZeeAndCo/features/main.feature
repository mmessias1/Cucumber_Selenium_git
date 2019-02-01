Feature: Zee & Co

  Scenario: Zee and Co website
    Given I am on the homepage
    When I click on the sign in link
    Then I should be taken to the create account page

    Given I enter my username and password
    And I click the login button
    Then I should receive error message: invalid username or password

    Given that I have forgotten my password
    And I enter my email address to reset my password
    And I click submit
    Then I should navigate to another page