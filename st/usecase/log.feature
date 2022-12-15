Feature: login
Scenario: user login
Given user in the login page
When I enter my email address and password 
And I click on submit
Then I should be navigated to home page
