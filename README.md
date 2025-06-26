# MongoDB Social Media API

A RESTful API for a simple social media platform, developed using Spring Boot and MongoDB. This project was created as part of a workshop from the "Java COMPLETO 2023 Programação Orientada a Objetos +Projetos" course by Professor Nélio Alves.

### 🚀 Key Features

* **User Management**: Full CRUD (Create, Read, Update, Delete) operations for users.
* **Post Management**: Users can create posts with titles, content, and comments.
* **Embedded Documents**: Comments are embedded within the post document.
* **Data Transfer Objects (DTOs)**: DTOs are used to control the data exposed through the API endpoints.
* **Custom Queries**: The `PostRepository` includes custom queries using `@Query` for advanced searching.
* **Endpoint for User's Posts**: Retrieve all posts created by a specific user.
* **Exception Handling**: Centralized exception handling for events like `ObjectNotFoundException`.

## Built With

This project is built with the following technologies:

* **Java**: Version 24
* **Spring Boot**: Version 3.5.3
* **Maven**: For dependency management and project build.
* **MongoDB**: NoSQL database used for data storage.

## Getting Started

To get a local copy up and running, follow these simple steps.

### 📋 Prerequisites

* Java Development Kit (JDK) 24 or later
* Apache Maven
* A running instance of MongoDB

### ⚙️ Installation & Setup

1.  **Clone the repository:**
    ```sh
    git clone <repository-url>
    ```

2.  **Configure the database:**
    Open the `src/main/resources/application.properties` file and ensure the `spring.data.mongodb.uri` property points to your MongoDB instance. The default is set to:
    ```properties
    spring.data.mongodb.uri=mongodb://localhost:27017/workshop_mongo 
    ```

3.  **Run the application:**
    You can run the application using the Spring Boot Maven plugin:
    ```sh
    mvn spring-boot:run
    ```
    The application will start, and the API will be available at `http://localhost:8080`.

## API Endpoints

The following are the available API endpoints.

### User Endpoints

| Method   | Endpoint          | Description                                         |
| :------- | :---------------- | :-------------------------------------------------- |
| `GET`    | `/users`          | Retrieves a list of all users.               |
| `GET`    | `/users/{id}`     | Retrieves a specific user by their ID.         |
| `POST`   | `/users`          | Creates a new user.                            |
| `PUT`    | `/users/{id}`     | Updates an existing user.                      |
| `DELETE` | `/users/{id}`     | Deletes a user by their ID.                  |
| `GET`    | `/users/{id}/posts` | Retrieves all posts made by a specific user. |

### Post Endpoints

| Method | Endpoint                                                              | Description                                                                                          |
| :----- | :-------------------------------------------------------------------- | :--------------------------------------------------------------------------------------------------- |
| `GET`  | `/posts/{id}`                                                         | Retrieves a specific post by its ID.                                                          |
| `GET`  | `/posts/titlesearch?text=<text>`                                      | Searches for posts with titles containing the given text (case-insensitive).              |
| `GET`  | `/posts/fullsearch?text=<text>&minDate=<yyyy-MM-dd>&maxDate=<yyyy-MM-dd>` | Performs a full-text search on post titles within a specified date range. |
