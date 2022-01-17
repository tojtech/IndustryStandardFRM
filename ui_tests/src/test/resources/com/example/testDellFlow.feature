Feature: HomePage Workflow Testing

  @Smoke
  Scenario: Test of the Dell Home Page
    Given User opens Dell Home Page
    And User clicks at the search bar
    And User types a search keyword "Monitor" to the search bar
    When User clicks Search button
    Then Monitor Shipped Fast label should be displayed