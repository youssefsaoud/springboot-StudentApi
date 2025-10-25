# Spring Boot Student API

A REST API built with Spring Boot for managing students and courses.

The project demonstrates common Java backend and Spring Boot concepts including REST APIs, PostgreSQL, JPA/Hibernate, validation, exception handling, JWT authentication, and role-based authorization.

## Technologies

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JWT
- PostgreSQL
- Maven
- Swagger / OpenAPI

## Features

- Student CRUD operations
- Course CRUD operations
- Student-course many-to-many relationship
- Request validation
- Global exception handling
- Pagination and sorting
- Custom JPQL queries
- User registration
- User login
- BCrypt password hashing
- JWT authentication
- Role-based authorization
- Swagger API documentation

## Project Architecture

The application follows a layered architecture:

Controller ? Service ? Repository ? PostgreSQL

- Controller: Handles HTTP requests and responses.
- Service: Contains application/business logic.
- Repository: Communicates with the database using Spring Data JPA.
- Entity: Represents database tables.
- DTO: Controls the data exposed through the API.
- Security: Handles authentication and authorization.

## Database

The application uses PostgreSQL.

Database name:

student_db

The database password is configured through the environment variable:

DB_PASSWORD

The JWT secret is configured through the environment variable:

JWT_SECRET

Secrets are not stored directly in the source code.

## How to Run

### 1. Create the PostgreSQL database

Create a PostgreSQL database named:

student_db

### 2. Configure environment variables

Set the following environment variables:

DB_PASSWORD

JWT_SECRET

### 3. Start the application

On Windows:

mvnw.cmd spring-boot:run

The application runs on:

http://localhost:8080

## Authentication

The API uses JWT authentication.

### Register a user

POST /auth/register

Example request:

{
  "email": "test@gmail.com",
  "password": "password123",
  "role": "USER"
}

### Login

POST /auth/login

Example request:

{
  "email": "test@gmail.com",
  "password": "password123"
}

The login endpoint returns a JWT token.

Use the token when accessing protected endpoints:

Authorization: Bearer <your-jwt-token>

## Roles

### USER

A USER can:

- View students
- View courses

### ADMIN

An ADMIN can:

- View students
- View courses
- Create students
- Update students
- Delete students
- Create courses
- Update courses
- Delete courses
- Assign courses to students

## Student Endpoints

| Method | Endpoint | Access |
|---|---|---|
| GET | /students | USER / ADMIN |
| GET | /students/{id} | USER / ADMIN |
| POST | /students | ADMIN |
| PUT | /students/{id} | ADMIN |
| DELETE | /students/{id} | ADMIN |
| GET | /students/email/{email} | USER / ADMIN |
| GET | /students/older-than/{age} | USER / ADMIN |
| POST | /students/{studentId}/courses/{courseId} | ADMIN |

## Course Endpoints

| Method | Endpoint | Access |
|---|---|---|
| GET | /courses | USER / ADMIN |
| GET | /courses/{id} | USER / ADMIN |
| POST | /courses | ADMIN |
| PUT | /courses/{id} | ADMIN |
| DELETE | /courses/{id} | ADMIN |

## Swagger

Swagger UI is available at:

http://localhost:8080/swagger-ui/index.html

Swagger can be used to view and test the API.

To test protected endpoints:

1. Login using /auth/login.
2. Copy the JWT token.
3. Click the Authorize button in Swagger.
4. Enter the token.
5. Test the protected endpoints.

## Example Users

USER:

Email: test@gmail.com

Password: password123

Role: USER

ADMIN:

Email: admin@gmail.com

Password: admin123

Role: ADMIN

These accounts are for local development/testing only.

## What This Project Demonstrates

This project demonstrates practical Spring Boot backend concepts:

- Building REST APIs
- Dependency injection
- Layered architecture
- Spring Data JPA
- Entity relationships
- PostgreSQL integration
- DTOs
- Validation
- Exception handling
- Pagination
- Sorting
- JPQL
- Spring Security
- Password hashing
- JWT authentication
- Role-based authorization
- API documentation with Swagger
