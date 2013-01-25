Feature: Notepad

Scenario: Load File
Given notepad is running
When I load the file data.txt
Then the editor should contain Hello World!
