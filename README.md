# Spring Boot CI/CD Demo with Maven and GitHub Actions
[![Java CI with Maven](https://github.com/mhamp/monorepo/.github/workflows/build.yml/badge.svg)](https://github.com/mhamp/monorepo/.github/workflows/build.yml)   [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=mhamp_monorepo&metric=alert_status&token=6bfb21494a165dcff0985732ecce5daf4f12aba9)](https://sonarcloud.io/summary/new_code?id=mhamp_monorepo)(https://sonarcloud.io/dashboard?id=mhamp_monorepo)

by [Mathias Hamp](https://github.com/mhamp), Munich, May 2025


This project demonstrates how to set up a complete CI/CD pipeline for a Spring Boot application using:
- Maven as the build tool
- GitHub Actions for workflow automation
- SonarQube for code quality analysis
- JaCoCo for code coverage reporting

## Project Structure

The project follows a multi-module Maven structure:
```bash
/pom.xml         # reactor POM
/user/pom.xml    # demo user module
/authentication/pom.xml     # demo authentication module
/aggregator/pom.xml   # demo aggregator module
```

## Key Features

1. **Maven Build Configuration**:
    - Multi-module project setup
    - JaCoCo integration for code coverage
    - SonarQube analysis integration

2. **GitHub Actions Workflow**:
    - Automated build and test execution
    - SonarQube analysis
    - Caching for faster builds

3. **Code Quality**:
    - SonarQube analysis with quality gates
    - JaCoCo code coverage reporting
    - Integration with pull requests

## Prerequisites

- Java 21+
- Maven 3.6+
- SonarQube Cloud account (optional)
- GitHub account

## Setup Instructions

### 1. Local Development Setup

```bash
git clone https://github.com/mhamp/monorepo.git
cd monorepo
mvn install
````
### 2. Running Tests with Coverage
```bash
mvn clean verify
```
### 3. Running SonarQube Analysis Locally
```bash
mvn clean verify sonar:sonar \
  -Dsonar.login=your-sonar-token \
  -Dsonar.host.url=https://your-sonar-instance.url
```
## GitHub Actions Workflow
The workflow is defined in `.github/workflows/build.yml` and performs:

1. Build and test the application 
2. Run SonarQube analysis 
3. Upload coverage reports to SonarCloud

### Workflow Triggers
- On push to main branch 
- On pull requests
## Configuration
### JaCoCo Configuration
The JaCoCo plugin is configured in the parent POM to:

- Instrument tests with the prepare-agent goal 
- Generate aggregated reports with report-aggregate in the tests module

```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.7</version>
    <executions>
        <execution>
            <id>prepare-agent</id>
            <goals><goal>prepare-agent</goal></goals>
        </execution>
    </executions>
</plugin>
```
## Credits
This project setup is based on the excellent work by:
- Andreas Grub (QAware GmbH) 2020 - <a href="https://blog.qaware.de/posts/sonarqube-and-jacoco/">SonarQube with JaCoCo in multi-module Maven project</a> 
- Tibor Blenessy (Sonar Sroucer) 2019 - <a href="https://community.sonarsource.com/t/coverage-test-data-importing-jacoco-coverage-report-in-xml-format/12151">Importing JaCoCo coverage report in XML format</a> 

## Licence
License
This project is licensed under the Apache 2.0 - see the [LICENCE](LICENCE.txt) file for details.