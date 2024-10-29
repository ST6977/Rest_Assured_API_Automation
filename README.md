## What is Rest Assured in API Automation?

 Rest Assured is an open-source Java library used to test RESTful APIs. It provides a domain-specific language (DSL) for writing API tests in a simple and readable format. Rest Assured supports various HTTP methods such as GET, POST, PUT, DELETE, etc., and allows us to set request headers, query parameters, and request bodies. It also provides easy-to-use assertion methods to validate the response received from the server. 
 Rest Assured is widely used in the industry for API testing due to its simplicity and effectiveness.

## Project Scenerio:

- Login by admin (admin@roadtocareer.net/1234)
- Create 2 new customers and a agent
- Give 2000 tk from System account to the newly created agent
- Deposit 1500 tk to a customer from the agent account
- Withdraw 500 tk by the customer to the agent
- Send money 500 tk to another customer
- Payment 100 tk to any merchant by the recipient customer
- Check balance of the recipient customer

## Technology Used:

- Rest Assured
- commons-configuration
- Jackson Databind
- TestNG
- Java
- Gradle
- intellij idea
- Allure

## How to run this project:

- Clone this project
- hit the following command: gradle clean test
- for Allure Report hit: allure generate allure-results --clean -o allure-report and allure serve allure-results

## Alure Report Overview:
![rest-allure-report-2](https://github.com/user-attachments/assets/69ab396b-e00e-4ca3-aa63-e5f649d95f60)

## Alure Report Behaviour:
![rest-allure-behave](https://github.com/user-attachments/assets/e2cd5e77-f320-4b09-b8ec-27b67e3bfdda)



