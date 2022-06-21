Feature: HomePage Tests GITHUB

  @Regression @GHID-2307
  Scenario Outline: test transition between Home Page and Sign Up Page
    Given I am a logged out GitHub user
    And I should see Home Page Title displayed
    And Home Page Title should contain text 'Where the world builds software'
    When I type "<email>" to Email address field
    And I see Green button is displayed
    And click the Green button
    Then I should see SignUp page widget
    Examples:
      |       email            |
      |       test@test.com    |
      |       new@email.com    |



