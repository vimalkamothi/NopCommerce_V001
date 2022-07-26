Feature: Login

  Scenario: Successful login with valid credentials
    Given I want to launch Chrome browser
    When I opn URL "https://demo.nopcommerce.com/"
    And I click on Login link
    And I enter Email as "vimal.kamothi1@gmail.com" and Password as "VimKam@13579"
    And Click on the Login button
    Then I validate the Logout link
    When I click on Logout link
    Then I validate the Login link
    And I close browser
