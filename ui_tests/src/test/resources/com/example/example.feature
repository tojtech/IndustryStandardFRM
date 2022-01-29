Feature: Sign In

  Background:

  @REGRESSION
  Scenario: Open start page
    Given user opens index page
    And user clicks at Customers section
    And API request to Mediyor!
    And User validates data in DB
    When user clicks at Customers section
    When sleep


