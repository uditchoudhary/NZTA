# NZTA - API integration Test Framework Demo

This project is to showcase an API integration test framework structure and application

## About the repository

This repository contains a maven project to perform integration testing on dummy APIs. 
Dummy api service is provided by http://dummy.restapiexample.com/ .
Test scenarios are written in Gherkin format executed by cucumber and JUnit. 
Following tools and softwares are used to build the project: 
* Java
* Maven
* Cucumber
* Gherkin
* JUnit
* RestAssured
* IntelliJ

### Prerequisites

1. Maven path configured 
2. Java JDK/JRE installed and configured
3. IDE

### Installing

1. Clone the repository
2. Import it to an IDE
3. Resolve proxies and maven dependencies

## Running the tests

* Run with default environment (dummy)
In terminal, run:
```
mvn clean test
```
* Run with specific environment (dev)
```
mvn clean test -P dev
```

### Create different environment (e.g. sit)
1. Create a directory (sit) under src/main/resources/envProfile
2. add config.properties file under new directory (sit)
3. open maven (pom.xml) and add a new profile
        <profile>
            <id>sit</id>
            <properties>
                <build.profile.id>sit</build.profile.id>
            </properties>
        </profile>

By default "dummy" environment is set to default.
To change default profile, 
set activeByDefault tag to true  to the profile you want as default

## Setup Jenkins
1. Install and configure Jenkins
https://jenkins.io/doc/book/installing/
2. Once configured, open browser and enter
http://localhost:8080/
3. Create new Item -> Free style project -> Ok
4. Under Source Code Management -> Select Git
- Add Repository URL and Credentials
5. Under Build -> Add build step -> Select Execute shell
- Give following command
```
mvn clean test
```
6. For Cucumber report ( add plugin )
- under Post-build Actions, select Cucumber report
```
Json Reports Path  - build/cucumber-reports/
File Include Pattern - Cucumber.json
```
7. Save the page.



## Who do I talk to?

For more information Contact: 
**Udit Choudhary** at uditchoudhary@gmail.com

