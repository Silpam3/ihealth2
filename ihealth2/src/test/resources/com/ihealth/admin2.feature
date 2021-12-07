Scenario: An admin can be able to see booked appointments

Given An Admin is in login page
When Admin enters login credentials as EmailId "sriram@gmail.com" and Password"Asdf@123"
Then Admin should be able to access dashboard
When Admin clicks on Appointments link
Then Admin should be able to see booked appointment






