Feature:  Admin portal

  Background:
    Given An Admin is in login page
    When Admin enters login credentials as EmailId "sriram@gmail.com" and Password"Asdf@123"

      @regression
       Scenario Outline: An Admin can be able to create new doctors
      Then Admin should be able to access dashboard
      Then Admin should be able to click on create new doctors link
      When Admin gives all valid details in the fields as  <"Doctor">,<"Qualification">,<"Note">,<"Email">,<"Contact">,<"Address">
      And click on submit form button

      Examples:
      |Doctor|Qualification|Note|Email|Contact|Address|
     |Jak   |MD           |hi  |Jak@gmail.com|09875456899|London|
        |James  |MD           |hi  |James@gmail.com|09875456779|London|

      @patients
      Scenario Outline:  An admin can be able to create new patients

        Then Admin should be able to access dashboard
        When Admin click on create new patients link
        Then Admin will go to create new patient page
        Then Admin should be able to create new patients as <"Patient">,<"Age">,<"Gender">,<"Email">,<"Contact">,<"Address">,<"Note">

        Examples:
        |Patient|Age|Gender|Email|Contact|Address|Note|
        |Paul   |68 |   Male   |paul@gmail.com     |097867575|oihjk       |hjbjhbj    |
        |Pal   |68 |   Male   |pal@gmail.com     |097867575|oihjk       |hjbjhbj    |

        @reg
        Scenario: An admin can be able to see booked appointments
          Then Admin should be able to access dashboard
          When Admin clicks on Appointments link
          Then Admin should be able to see booked appointment
