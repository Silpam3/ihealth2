Feature: Doctor portal
  Background:
    Given An Admin is in login page
    When Admin enters login credentials as EmailId "anu@gmail.com" and Password"Asdf@123"

  @doctor
  Scenario: Doctor should be able to access appointments
    Then doctor should be able to see appointments title
    Then Doctor should be able to see calender
    When doctor clicked on Appointments link
    Then doctor should be able to see booked appointments






  @cancerdoc
  Scenario : doctor can be able to filter particular disease
    And doctor clicked on Appointments link
    Then doctor should be navigated to appointments page
    When doctor filters with a disease "Cancer"
    Then only details about that disease should be displayed




