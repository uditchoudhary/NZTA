# NZTA - API integration Test Framework Demo

This project is to showcase an API integration test framework structure and application

## About the repository

This repository contains a maven project to perform integration testing on dummy APIs
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

In terminal, run:
```
mvn clean test
```

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

