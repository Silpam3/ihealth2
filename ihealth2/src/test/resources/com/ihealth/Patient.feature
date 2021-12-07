Feature:  patient portal
  Background: Patient should login with credentials as "sreeji0008@gmail.com" and "Asdf@123"

    Given A Patient is in login page
    When a Patient should login with valid credentials as "sreeji0008@gmail.com" and "Asdf@123"
    Then Patient should goto patient dashboard
    @patientprescription
    Scenario:  patient should successfully goto prescription page and should be able to see prescriptions


      When Patient clicks on Prescription link
      Then Patient should goto Prescription page
      Then Patient should see the message "All active prescriptions are displayed here."

      @patientappointments
   Scenario: patient should successfully goto prescription page and should be able to see prescriptions

     When Patient clicks on Appointments link
     Then Patient should goto Appointments page
     Then patient should see the message as "All active appointments are displayed here. Click here to add new appointments."

        @patientbookappointment
        Scenario: patient should be able to book new appointment
          When patient clicks on book an appointment link
          Then Patient book new appointments page will display
          When Patient enters new appointment details  and clicks on the submitbutton
          Then Patient details should be submitted
