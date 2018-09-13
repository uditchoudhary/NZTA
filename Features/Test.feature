Feature: Employee management services
  In order to manage employees
  Admin should be able to
  Create, delete and update employee profiles

  Scenario: Create a new employee
    Given a new employee has joined with name "neal"
    When admin creates new profile
    Then it should be created

  Scenario: Delete an existing employee
    Given "lin" has left the company
    When admin deletes the profile
    Then it should be deleted
    And admin should see following message
    """
    successfully! deleted Records
    """
