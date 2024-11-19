# WeBlog Java JDBC Application

## Project Description

WeBlog is a Java-based web application that allows bloggers to register, post blogs, and view all registered bloggers
and blogs. It provides a menu-driven interface for users to interact with the application. The system supports both 
private and public blogs, storing the data in a PostgreSQL database, and uses JDBC for database interaction. The
application is designed with a layered architecture, following best practices such as separation of concerns and 
dependency injection.

## Technologies Used

- **Java**: Core programming language used for the application logic.
- **PostgreSQL**: Database used to store blogger and blog data.
- **JDBC**: Java Database Connectivity for interacting with the PostgreSQL database.
- **Docker Containers**: For containerizing the application to ensure consistency across different environments.

## Project Structure
### Java and JDBC
The project follows a modular structure organized into several packages:

- **config**: Contains configuration classes for database connectivity.
    - `DBConfig.java`: Configuration class for setting up the database connection.

- **db**: Contains Data Access Object (DAO) interfaces for blog and blogger operations.
    - `BlogDAO.java`: Interface for operations related to blog data.
    - `BloggerDAO.java`: Interface for operations related to blogger data.
    - **impl**: Contains implementations of the DAO interfaces.
        - `BlogDAOImpl.java`: Implementation of `BlogDAO` for blog data operations.
        - `BloggerDAOImpl.java`: Implementation of `BloggerDAO` for blogger data operations.

- **entity**: Contains the entity classes that map to the database tables.
    - `Blog.java`: Represents a blog entity.
    - `Blogger.java`: Represents a blogger entity.

- **service**: Contains service interfaces and their implementations.
    - `BlogService.java`: Interface for blog-related services.
    - `BloggerService.java`: Interface for blogger-related services.
    - **impl**: Contains implementations of the service interfaces.
        - `BlogServiceImpl.java`: Implementation of `BlogService`.
        - `BloggerServiceImpl.java`: Implementation of `BloggerService`.

- **ui**: Contains classes related to the user interface.
    - **viewer**: Contains interface and implementation for presenting the UI.
        - `WeBlogView.java`: Interface for the main view of the application.
        - **impl**: Contains implementation of the view interface.
            - `WeBlogViewImpl.java`: Concrete implementation of the `WeBlogView` interface.
    - **presenter**: Contains the presenter that controls the flow of the UI logic.
        - `WeBlogPresenter.java`: Presenter class that handles user interactions.

- **WeBlog.java**: The main class that starts the program and launches the user interface.

### table.sql
The `table.sql` file is used for the creation and management of the database schema in PostgreSQL for the weblog 
management system. It defines the structure of the following tables:

- **blogger**: Stores information about bloggers, including their email, password, name, and address.
- **blogger_interest**: Stores the interests of bloggers.
- **blog**: Stores blog posts, including their title, body, privacy setting, timestamp, and associated blogger's email.
- **comment**: Stores comments on blogs, including the comment body, timestamp, and the blogger who made the comment.
- **reader**: Stores followers and followings between bloggers.

This script includes appropriate data types, primary keys, and foreign key constraints to ensure data integrity and the
relationships between the tables.


## Features

The application provides the following functionalities:

1. **Register as a Blogger**: Users can register as a blogger by entering their email, password (which is encoded),
name, address, and a list of interests.
2. **List All Registered Bloggers**: Display a list of all bloggers, showing their email, name, and address.
3. **Post a Blog**: Bloggers can create a blog by entering their email, blog title, body, and privacy setting 
(public/private). The system automatically records the current date and time as the blog’s posting time.
4. **List All Blogs**: Display all blogs, including their ID, title, body, visibility (public/private), date/time, 
and the blogger’s name.
5. **Exit**: Exits the application.

## Prerequisites
- **Java** (JDK 11 or higher)
- **PostgreSQL** (Ensure you have PostgreSQL running locally or in a container)
- **JDBC driver** for PostgreSQL (ensure it's included in the project)

## Setup Instructions
### Database Setup
1. Create a PostgreSQL database with a name of your choice.
2. Create username and password for your database.
3. Run the SQL script `table.sql` to create the `book` table and insert sample data.

### Development Environment Setup
1. **Install Java Development Kit (JDK)**:
    - Ensure that JDK is installed on your system.
2. **Install PostgreSQL**:
    - Download and install PostgreSQL.
3. **Download PostgreSQL JDBC Driver**:
    - Download the JDBC driver from [PostgreSQL JDBC Download Page](https://jdbc.postgresql.org/download/.).
    - Make sure to place the downloaded JAR file in the same directory as your `MyStore.java` file or note its path for 
      the classpath.
4. **Set Environment Variables** (optional):
    - If you want to run Java commands from any directory, ensure that the JDK `bin` directory is added to your
      system's PATH environment variable.
5. **Verify Installation**:
    - Check if Java and PostgreSQL are correctly installed by running the following commands in your terminal:
      ```bash
      java -version
      ```
      ```bash
      psql --version
      ```
      
### Steps to Install and Run
**Clone the repository**:
   ```bash
   git clone <repository_url>
   cd weblog
