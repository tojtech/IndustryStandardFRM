Feature: HomePage Workflow Testing

  @Smoke
  Scenario: how I love Dell PCs
    Given User opens Dell Home Page and run
    And User clicks at the search bar
    And User types a search keyword "Monitor@123.com" to the search bar
    When User clicks Search button
    Then Monitor Shipped Fast label should be displayed