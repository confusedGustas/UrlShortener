
# URL Shortener Application

A simple URL Shortener application built with Spring Boot, PostgreSQL, Angular.

## Prerequisites

Make sure you have the following tools installed before setting up the application:

- Java Development Kit (JDK)
- Apache Maven
- PostgreSQL

## Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/confusedGustas/UrlShortener.git
    cd UrlShortener
    ```

2. **Configure PostgreSQL:**

    - Create a new database.
    - Leave the default settings as it is, Spring Boot will create the needed tables.
    - If you want configurate the settings, you can do it so by accessing the `application.yaml` file

    ```datasource:
    url: jdbc:postgresql://localhost:5432/urlshortener
    username: postgres
    password: postgres
    ```

3. **Build and run the application:**

    ```bash
    mvn spring-boot:run
    cd frontend
    npm install
    ng serve
    ```

   The application will start on `http://localhost:8080` and `http://localhost:4200`

## Usage

- Access the application through your browser (http://localhost:4200)

## License

This project is licensed under the [MIT License](./LICENSE).
