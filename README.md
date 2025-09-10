# API Movieflix

REST API for managing movie catalogs and streaming services, developed with Spring Boot and modern architecture.

## About the Project

Movieflix is a platform that allows users to discover movies available on various streaming services. The project was developed with a focus on:

- **Content Organization**: Efficient movie categorization
- **Multiple Services**: Integration with various streaming services
- **Security**: JWT authentication for endpoint protection
- **Performance**: Optimized queries and caching for better performance
- **Scalability**: Architecture prepared for growth
- 
## Architecture

The project follows a layered architecture:

```
src/main/java/dev/flix/
├── config/         # Spring Configurations and Security
├── controller/     # REST Controllers
├── entity/         # JPA Entities
├── repository/     # Spring Data Repositories
├── service/        # Business rules
├── exception/      # Custom exceptions
└── mapper/         # Conversion between DTOs and entities
```

## Technologies Used

### Backend
- **Java 17**: LTS version with modern language features
- **Spring Boot 3**: Framework for agile development
- **Spring Security**: Security and authentication
- **Spring Data JPA**: Data persistence
- **JWT**: Tokens for stateless authentication
- **Lombok**: Boilerplate code reduction
- **Bean Validation**: Data validation

### Database
- **PostgreSQL 15**: Robust relational database
- **Flyway**: Migrations for schema control

### Development Tools
- **Maven**: Dependency management and build
- **JUnit 5**: Unit tests
- **Mockito**: Mocking for tests
- **Swagger/OpenAPI**: API documentation

## Features

### Authentication and Authorization
- User registration and login system
- Authentication via JWT
- Route protection by user profile

### Category Management
- Complete CRUD of movie categories
- Data validation
- Dependency handling

### Streaming Services
- Provider registration and management
- Association with movies
- Integrity validations

### Movie Catalog
- Detailed movie registration
- Search by multiple criteria
- Association with categories and services
- Rating system

## Prerequisites

- Java 17+
- PostgreSQL 15+
- Maven 3.8+
- Curl (for scripted testing)

## How to Run

The project includes scripts to facilitate building and running:

### Available Scripts

- `build.sh`: Compiles the project and generates the JAR file
- `start.sh`: Starts the application using the generated JAR file

### Step by Step

1. Clone the repository
```bash
git clone [repository-url]
```

2. Configure the PostgreSQL database in the `application.properties` file:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/movieflix
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Run the project build:
```bash
./build.sh
```

4. Start the Application:
```bash
./start.sh
```

Alternatively, you can run it manually:

```bash
# Build manually
mvn clean package

# Manual execution
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

## API Documentation

### Endpoints

#### Authentication
- POST `/auth/register` - Register new user
- POST `/auth/login` - User login

#### Categories
- POST `/movieflix/category` - Create category
- GET `/movieflix/category` - List categories
- GET `/movieflix/category/{id}` - Search category by ID
- DELETE `/movieflix/category/{id}` - Delete category

#### Streaming Services
- POST `/movieflix/stream-service` - Create service
- GET `/movieflix/stream-service` - List services
- GET `/movieflix/stream-service/{id}` - Search service by ID
- DELETE `/movieflix/stream-service/{id}` - Delete service

#### Movies
- POST `/movieflix/movie` - Create Movie
- GET `/movieflix/movie` - List movies
- GET `/movieflix/movie/{id}` - Search movie by ID
- GET `/movieflix/movie/search?category={id}` - Search movies by category
- PUT `/movieflix/movie` - Update movie
- DELETE `/movieflix/movie/{id}` - Delete movie

## Contributing

1. Fork the project
2. Create a branch for your feature (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Autores

* **Julio C D Louzano** 

## License

This project is licensed under the MIT license - see the [LICENSE] file for details.