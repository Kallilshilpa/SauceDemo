# Functional UI Automation for https://www.saucedemo.com/

# Project: `SauceDemo`

## Project structure

- `src/test/java` has 6 packages:

    * `com.saucedemo.base` - contain classes with common code for tests

    * `com.saucedemo.config` - contains project configuration file

    * `com.saucedemo.pages` - contains web page specific classes

    * `com.saucedemo.tests` - contains the test classes to be run

    * `com.saucedemo.testdata` - contains test data file `TestData.xlsx`

    * `com.saucedemo.utils` - contains utility classes
- `screenshots` - folder where screen shots which are taken during the test execution failure will be stored
	
## Maven Dependencies Required for SauceDemo

1. `selenium-java` as UI automation tool
3. `testng` as testing framework
4. `apache-poi` for excel parsing and manipulation

## Instructions for running SauceDemo

1. Download and install JDK8.
2. Download and install Maven.
3. Open command prompt/terminal emulator and navigate to the project directory.
4. Run the project using `mvn clean test`.