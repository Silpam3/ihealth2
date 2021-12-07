Feature: User Login Scenario

  Background:
    Given A user goes to login page by clicking URL

@uservalid
  Scenario Outline: User should login with valid credentials


    When A "<user>" gives credentials as EmailID "<username>" and Password "<password>"
    Then "<user>" should login successfully and dashboard page should be displayed

    Examples:
      | user  | username      | password |
      | admin | sriram@gmail.com | Asdf@123 |
      | Patient| anu@gmail.com | Asdf@123 |
  |doctor  |        sreeji0008@gmail.com       |  Asdf@123         |
@userinvalid
    Scenario Outline: User shouldn't login with invalid credentials

      When A "<user>" gives in valid credentials as EmailID "<username>" and Password "<password>"
      Then "<user>" should n't  login successfully with invalid credentials and an  error message should be displayed

    Examples:
      | user  | username      | password |
      | admin | sriram@gmail.com | Asf@123 |
      | Patient| anu@gmail.com | Asd@123 |
      |doctor  |        sreeji0008@gmail.com       |  Asdf@23         |



