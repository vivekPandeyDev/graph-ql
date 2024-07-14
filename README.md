# Overview
GraphQL is a query language for APIs that allows clients to request specific data they need. It provides a more efficient and flexible alternative to traditional REST APIs by enabling clients to define the structure of the data they require. Here are some key concepts and features of GraphQL:
# Read Me First
The following was discovered as part of building this project:
Created a basic graph-ql with employee and department, where multiple department is mapped to single employee. `EMPLOYEE (*) ------ (1) DEPARTMENT` .
## Feature
* Interceptor 
* Exception Handling
* SchemeMapping, QueryMapping, Mutation Mapping
* Jpa Repository to save employee and department
* [To access graph-ql](http://localhost:8080/graphiql?path=/graphql)
* [To access h2-console](http://localhost:8080/h2-console)


# Getting Started

# Installation Guide
### Navigate to the parent Dir of Dockerfile and docker-compose
#####
    1. docker build --no-cache -t graph-ql-app .
    2. docker-compose up --build
#####
### To check logs
#####
    1. docker-compose logs postgres-db
    2. docker-compose logs graph-ql-app
#####

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.0/reference/htmlsingle/index.html#web)
* [Spring for GraphQL](https://docs.spring.io/spring-boot/docs/3.3.0/reference/htmlsingle/index.html#web.graphql)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.0/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a GraphQL service](https://spring.io/guides/gs/graphql-server/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)


# GraphQL Schema Overview

## Queries

### employees
Retrieves a list of all employees including their `id`, `name`, `salary`, and associated `department`.

### employeeById(id: ID!)
Retrieves an employee by their unique `id`. Returns `id`, `name`, `salary`, and `department` details.

### employeeByName(employeeName: String!)
Retrieves a list of employees matching the specified `employeeName`. Returns `id`, `name`, `salary`, and `department` details for each employee.

### departments
Retrieves a list of all departments including their `id`, `name`, and associated list of `employees`.

### departmentById(id: ID!)
Retrieves a department by its unique `id`. Returns `id`, `name`, and list of `employees` within the department.

### departmentByName(departmentName: String!)
Retrieves a list of departments matching the specified `departmentName`. Returns `id`, `name`, and list of `employees` for each department.

## Mutations

### createEmployee(employeeInput: CreateEmployeeInput)
Creates a new employee with the specified `name`, optional `salary`, and `departmentId`. Returns the created employee object including `id`, `name`, `salary`, and `department`.

### updateSalary(updateSalaryInput: UpdateSalaryInput)
Updates the salary of an employee identified by `employeeId`. Requires `employeeId` and `salary` fields in the `updateSalaryInput`. Returns the updated employee object.

### createDepartment(name: String!)
Creates a new department with the specified `name`. Returns the created department object including `id` and `name`.

## Types

### Employee
Represents an employee with fields `id`, `name`, `salary`, and `department`.

### Department
Represents a department with fields `id`, `name`, and a list of associated `employees`.


