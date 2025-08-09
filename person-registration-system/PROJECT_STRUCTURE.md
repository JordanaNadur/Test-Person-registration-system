# Person Registration System - Project Structure (SOLID Principles)

## 📁 Project Organization

This project is organized following SOLID principles and Clean Architecture concepts:

```
person-registration-system/
├── backend/                          # Backend API (Java Spring Boot)
│   ├── src/main/java/com/personregistration/
│   │   ├── api/                     # API Layer (Controllers)
│   │   │   ├── v1/                  # API Version 1
│   │   │   │   └── PersonController.java
│   │   │   └── v2/                  # API Version 2
│   │   │       └── PersonControllerV2.java
│   │   ├── config/                  # Configuration Layer
│   │   │   ├── SecurityConfig.java
│   │   │   └── SwaggerConfig.java
│   │   ├── domain/                  # Domain Layer (Entities)
│   │   │   ├── model/
│   │   │   │   ├── Person.java
│   │   │   │   ├── Address.java
│   │   │   │   └── Sex.java
│   │   │   └── repository/
│   │   │       └── PersonRepository.java
│   │   ├── application/             # Application Layer (Services)
│   │   │   ├── service/
│   │   │   │   ├── PersonService.java
│   │   │   │   └── PersonServiceImpl.java
│   │   │   └── dto/
│   │   │       ├── PersonDTO.java
│   │   │       ├── AddressDTO.java
│   │   │       └── PersonWithAddressDTO.java
│   │   ├── infrastructure/          # Infrastructure Layer
│   │   │   ├── exception/
│   │   │   │   ├── ResourceNotFoundException.java
│   │   │   │   └── DuplicateResourceException.java
│   │   │   └── util/
│   │   │       └── CpfValidator.java
│   │   └── presentation/            # Presentation Layer
│   │       └── controller/
│   │           └── SourceController.java
│   ├── src/test/                    # Tests
│   │   └── integration/
│   │       └── PersonControllerV2IT.java
│   ├── pom.xml
│   └── Dockerfile
├── frontend/                        # Frontend (Angular)
│   ├── src/app/
│   │   ├── core/                    # Core Module (Singletons)
│   │   │   ├── services/
│   │   │   │   ├── person.service.ts
│   │   │   │   └── auth.service.ts
│   │   │   └── models/
│   │   │       ├── person.model.ts
│   │   │       └── address.model.ts
│   │   ├── features/                # Feature Modules
│   │   │   ├── person-registration/
│   │   │   │   ├── components/
│   │   │   │   │   ├── person-form/
│   │   │   │   │   └── person-list/
│   │   │   │   └── person-registration.module.ts
│   │   │   └── person-management/
│   │   │       └── ...
│   │   └── shared/                  # Shared Module
│   │       ├── components/
│   │       ├── directives/
│   │       └── pipes/
│   ├── angular.json
│   └── package.json
└── docs/                            # Documentation
    ├── API.md
    ├── SETUP.md
    └── DEPLOYMENT.md
```

## 🎯 SOLID Principles Implementation

### Single Responsibility Principle (SRP)
- **Controllers**: Handle only HTTP requests/responses
- **Services**: Contain business logic only
- **Repositories**: Handle only data persistence
- **DTOs**: Handle only data transfer
- **Validators**: Handle only validation logic

### Open/Closed Principle (OCP)
- **API versioning**: v1 and v2 endpoints coexist
- **Extensible validation**: Easy to add new validators
- **Modular architecture**: Easy to add new features

### Liskov Substitution Principle (LSP)
- **Repository interfaces**: Can be substituted with different implementations
- **Service interfaces**: Can be mocked for testing

### Interface Segregation Principle (ISP)
- **Focused interfaces**: Each interface has a specific purpose
- **DTO segregation**: Separate DTOs for different use cases

### Dependency Inversion Principle (DIP)
- **Dependency injection**: All dependencies injected via constructors/setters
- **Interface-based design**: Services depend on interfaces, not implementations

## 🏗️ Clean Architecture Layers

### 1. Presentation Layer (API)
- **Controllers**: Handle HTTP requests
- **DTOs**: Data transfer objects
- **Exception Handlers**: Global exception handling

### 2. Application Layer (Business Logic)
- **Services**: Business logic implementation
- **Use Cases**: Specific business operations

### 3. Domain Layer (Core Business)
- **Entities**: Person, Address, Sex
- **Value Objects**: CPF, Email
- **Repository Interfaces**: Data access contracts

### 4. Infrastructure Layer
- **Repository Implementations**: JPA/Hibernate
- **External Services**: CPF validation
- **Configuration**: Security, Database

## 🔄 Separation of Concerns

### Backend (Java Spring Boot)
- **Controllers**: REST API endpoints
- **Services**: Business logic
- **Repositories**: Data access
- **Models**: Database entities
- **DTOs**: API contracts
- **Validators**: Input validation
- **Exceptions**: Error handling

### Frontend (Angular)
- **Components**: UI components
- **Services**: API communication
- **Models**: TypeScript interfaces
- **Modules**: Feature organization
- **Guards**: Route protection
- **Interceptors**: HTTP handling

## 🚀 Deployment Structure

### Docker Configuration
- **Backend**: Spring Boot application container
- **Frontend**: Angular application container
- **Database**: H2 in-memory database (dev) / PostgreSQL (prod)

### Environment Configuration
- **Development**: Hot reload, detailed logging
- **Production**: Optimized builds, security headers
