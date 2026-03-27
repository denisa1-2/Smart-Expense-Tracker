# Smart-Expense-Tracker

## Overview

Smart Expense Tracker is a backend RESt API built with Java and Spring Boot thta allows users to manage personal expenses, categorize spending, and analyze financial data through aggregated statistics.

The application demonstrates core backend development concepts such as a RESTful API design, database relationships, validation, and business logic implementation.

## Features

### User Management
- Create a new user
- Get all users
- Get user by ID

### Category Management
- Create categories (e.g., Food, Transport, Shopping)
- prevent duplicate categories
- Get all categories

### Expense Management
- Create expenses linked to users and categories
- Get all expenses
- Filter expenses by:
    - user
    - category
- Delete expenses

### Statistics
- Total expenses per category
- Total expenses per month

### Validation & Error Handling
- Input validation using DTOs
- Custom error handling:
    - `400 Bad Request`
    - `404 Not found`
- Duplicate resource protection

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySSQL
- Lombok
- Maven
- Postman (API testing)

## Architecture

The project follows a layered architecture: controller -> service -> repository -> database:

- **Controller** - handles HTTP requests
- **Service** - contains business logic
- **Repository** - database access (JPA)
- **Model** -  entity classes
- **DTO** - request validation
- **Exception** - custom error handling

## Database Design

### Entities:
- **User**
- **Category**
- **Expense**

### Relationships:
- One User -> Many Expenses
- One Category -> Many Expenses

## API Endpoints

### Users
- `POST /api/users`
- `GET /api/users`
- `GET /api/users/{id}`

### Categories
- `POST /api/categories`
- `GET /api/categories`

### Expenses
- `POST /api/expenses`
- `GET /api/expenses`
- `GET /api/expenses/user/{userId}`
- `GET /api/expenses/category/{categoryId}`
- `DELETE /api/expenses/{id}`

### Statistics
- `GET /api/expenses/stats/category`
- `GET /api/expenses/stats/month?month=MM&year=YYYY`

## Exemple Requests

### Create user
```json
{
  "name": "Denisa",
  "email": "denisa@test.com"
}
```

### Create Category
```json
{
  "name": "Food"
}
```

### Create Expense
```json
{
  "amount": 50,
  "description": "Lunch",
  "date": "2026-03-27",
  "userId": 1,
  "categoryId": 1
}
```

## Setup & Run
1. Clone the repository
   ```bash
   git clone https://github.com/denisa1-2/smart-expense-tracker.git
   ```
2. Configure database
   - Create a MySQL database:
     ```sql
     CREATE DATABASE smart_expense_tracker;
     ```
   - Update `application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/smart_expense_tracker
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```
3. Run the application
   ```bash
    mvn spring-boot:run
   ```
   - Application will start on: http://localhost:8080
  
## Future Improvements
- Update (PUT) endpoints
- Authentification & autorization (Spring Security)
- Frontend integration
- Docker support
     
