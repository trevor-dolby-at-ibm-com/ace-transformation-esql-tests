REM
REM This script automates the building and testing of the application.
REM
REM Copyright (c) 2023 Open Technologies for Integration
REM Licensed under the MIT license (see LICENSE for details)
REM


REM Create the work directory
rmdir /s /q %TEMP%\ace-transformation-esql-tests-work-dir
call mqsicreateworkdir %TEMP%\ace-transformation-esql-tests-work-dir

REM Print commands
ECHO ON

REM Build everything; we can do this in this case because we want to include the unit
REM tests, but production builds should specify the projects.
ibmint deploy --input-path . --output-work-directory %TEMP%\ace-transformation-esql-tests-work-dir

REM ibmint optimize server new for v12.0.4 - speed up test runs
ibmint optimize server --work-directory %TEMP%\ace-transformation-esql-tests-work-dir --disable NodeJS

REM Run the server to run the unit tests
IntegrationServer -w %TEMP%\ace-transformation-esql-tests-work-dir --test-project Transformation_ESQL_Test --test-junit-options "--reports-dir=junit-reports"
