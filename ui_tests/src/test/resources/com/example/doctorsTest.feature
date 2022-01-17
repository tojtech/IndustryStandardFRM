Feature: Adding search functionality on Doctors page

  @FeatureTesting#123
  Scenario: Acceptance testing
    Given User opens Doctors page
    When User types first name of the Doctor in search field "Klakov"
    Then User should see first name field with result "Klakov"

  Scenario Outline: Negative Testing
    Given User opens Doctors page
    When User types first name of the Doctor in search field "<my negative data>" and pass "<password>"
    Then User should see Error Message "Are you crazy?"
    And User clicks "Ok"
    Examples:
    | my negative data |   password    |
    |       %$&^%*&    |               |
    |         %362     |    pass2      |


  @Smoke
  Scenario: test first name on Doctors page
    Given User opens Doctors page
    When User types first name of the Doctor
    Then User should see first name field