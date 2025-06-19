# E-commerce Application

Welcome! This is a simple e-commerce application built using Spring Boot, a popular framework for creating Java-based web applications. This README will guide you through understanding the project and getting it up and running.

## What is this project?

This project is a basic foundation for an online store. It currently includes features for:

*   **Products:**  Managing product information (name, description, price, etc.).
*   **Reviews:**  Allowing customers to leave reviews for products.

It's designed to be a starting point that you can expand upon to add more features like shopping carts, user accounts, payment processing, and more.

## Technologies Used

*   **Java:** The programming language used to build the application.
*   **Spring Boot:** A framework that simplifies building Java web applications.  It handles a lot of the setup and configuration for you.
*   **Spring Data JPA:**  A library that makes it easy to interact with a database using Java.  It simplifies database operations.
*   **MySQL:** A popular open-source relational database management system (RDBMS).  This project uses MySQL to store its data persistently.
*   **Maven:** A build automation tool used to manage the project's dependencies and build process.

## Prerequisites

Before you can run this project, you'll need to have the following installed on your computer:

1.  **Java Development Kit (JDK):**  Version 17 or higher is recommended. You can download it from [https://www.oracle.com/java/technologies/javase-downloads.html](https://www.oracle.com/java/technologies/javase-downloads.html) or use an open-source distribution like [https://adoptium.net/](https://adoptium.net/).  Make sure to set the `JAVA_HOME` environment variable.
2.  **Maven:**  You can download it from [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi).  Make sure to add Maven's `bin` directory to your `PATH` environment variable.
3.  **Git:** (Optional, but highly recommended)  Used for version control and downloading the project from GitHub. You can download it from [https://git-scm.com/downloads](https://git-scm.com/downloads).
4.  **MySQL:** You'll need a running MySQL server. You can download and install it from [https://www.mysql.com/downloads/](https://www.mysql.com/downloads/).  You'll also need to create a database for this project.

## Getting Started

Here's how to get the project running on your local machine:

1.  **Clone the repository:**

    Open your terminal or command prompt and navigate to the directory where you want to store the project. Then, run the following command:

    ```bash
    git clone https://github.com/Marichka75/ecommerce.git
    ```

    (If you don't have Git installed, you can download the project as a ZIP file from GitHub and extract it.)

2.  **Navigate to the project directory:**

    ```bash
    cd ecommerce
    ```

3.  **Configure MySQL:**

    *   **Create a database:**  Log in to your MySQL server (e.g., using the MySQL command-line client or a GUI tool like MySQL Workbench) and create a database for the project.  For example:

        ```sql
        CREATE DATABASE ecommerce_db;
        ```

    *   **Update `application.properties`:**  Open the `src/main/resources/application.properties` file and update the following properties with your MySQL connection details:

        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db?createDatabaseIfNotExist=true&serverTimezone=UTC
        spring.datasource.username=your_mysql_username
        spring.datasource.password=your_mysql_password
        spring.jpa.hibernate.ddl-auto=update
        ```

        Replace `ecommerce_db` with the name of the database you created, `your_mysql_username` with your MySQL username, and `your_mysql_password` with your MySQL password.  The `createDatabaseIfNotExist=true` parameter will automatically create the database if it doesn't exist (if your MySQL user has the necessary privileges).  `serverTimezone=UTC` is important to avoid timezone issues.  `spring.jpa.hibernate.ddl-auto=update` will automatically update your database schema based on your entity definitions.  **Important:** For production environments, consider using `validate` or `none` for `ddl-auto` and manage schema migrations separately.

4.  **Build the project:**

    Run the following command to download the project's dependencies and build the application:

    ```bash
    mvn clean install
    ```

    This command might take a few minutes to complete, as it needs to download all the necessary libraries.

5.  **Run the application:**

    Run the following command to start the application:

    ```bash
    mvn spring-boot:run
    ```

    This will start the Spring Boot application. You should see output in the console indicating that the application has started successfully.

6.  **Access the application:**

    Once the application is running, you can access it in your web browser at the following URL:

    ```
    http://localhost:8080
    ```

    (The port number might be different if you've configured it differently.)

## Using the Application

This application provides a REST API.  This means you interact with it using HTTP requests (like those your web browser makes).  Here are a few example endpoints:

*   **`GET /products`:**  Retrieves a list of all products.
*   **`GET /products/{id}`:** Retrieves a specific product by its ID (replace `{id}` with the actual product ID).
*   **`POST /reviews`:** Creates a new review for a product.  You'll need to send data in the request body (usually in JSON format) to specify the review details.

You can use tools like:

*   **Your Web Browser:** For simple `GET` requests.
*   **Postman:** A popular tool for testing APIs.  You can download it from [https://www.postman.com/downloads/](https://www.postman.com/downloads/).
*   **`curl`:** A command-line tool for making HTTP requests.

Important Notes

Database Configuration:

Make sure your MySQL server is running and that you've configured the connection details correctly in application.properties. Double-check the username, password, database name, and port number.

application.properties:

This file is where you configure your application. You can change things like the port number, database connection details, and more. It's located in the src/main/resources directory.

Data Initialization:

The application might not have any data initially. You'll need to add some products and reviews to the database to see them in the API responses. You can do this by using the API endpoints or by directly inserting data into the database using SQL.

Contributing

If you'd like to contribute to this project, feel free to fork the repository and submit a pull request.

Contact
If you have any questions or issues, please feel free to contact me at maria_byehan@yahoo.com.



