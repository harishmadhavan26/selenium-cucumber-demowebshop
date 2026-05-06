Feature: Register

Scenario: Successful registration

  Given user is on register page
  When user enters registration details and clicks register button
  Then user should be registered successfully