# ace-transformation-esql-tests
Example unit tests for the transformation using ESQL in a message flow tutorial.

This repo contains tests for both the original use case and an additional enhancement to check for
blank input and return an HTTP 400 status code in that case; the original code fails with XML
writing errors instead of flagging the blank input as a client error.

## Branches

**initial-project** contains the tutorial itself with no additional tests.

**with-first-unit-test** has a unit test that validates the flow using the tutorial XML input message.

**with-failing-second-unit-test** has an additional test that sends a blank HTTP message into the flow
and expectes an HTTP 400 status code. No new code has been written at this point, so the test fails.

**main** has the full solution, with the additional checking and tests that pass.
