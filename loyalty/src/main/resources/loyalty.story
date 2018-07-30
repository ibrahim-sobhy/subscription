Meta:

Narrative:
As a user
I want to add loyalty to user
So that I can retain customer

Scenario: Adding bonus loyalty points to customer

Given customer exist
When customer do a new activation transaction in the system
Then system give customer bonus points

Given customer exist
When customer subscribe in a recurring plan
Then system add recurring points to customer

