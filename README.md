# Distributed Systems Engineering

A hands-on engineering portfolio focused on designing, building, and understanding distributed systems using Java and modern backend technologies.

This repository contains practical implementations of real-world backend engineering problems, with an emphasis on scalability, reliability, concurrency, performance, and system design.

## Projects

| # | Project | Description | Status |
|---|---|---|---|
| 01 | [URL Shortener](projects/01-url-shortener/) | URL shortening service with efficient redirects and persistent storage | In Progress |

More distributed systems projects will be added as the repository evolves.

## Technology Stack

- **Language:** Java 21+
- **Backend:** Spring Boot
- **Build Tool:** Maven
- **Persistence:** Spring Data JPA
- **Testing:** JUnit 5, Mockito
- **Infrastructure:** Docker, Kubernetes
- **Caching & Messaging:** Redis, Apache Kafka

## Engineering Focus

- Distributed systems architecture
- Scalability and high availability
- Concurrency and thread safety
- Database design and optimization
- Caching and data consistency
- Fault tolerance and resilience
- API design and performance engineering
- Observability and monitoring

## Repository Structure

```text
distributed-systems/
│
├── projects/
│   └── 01-url-shortener/
│       ├── src/
│       ├── pom.xml
│       └── README.md
│
├── README.md
├── LICENSE
└── .gitignore
```

## Getting Started

### Prerequisites

- Java 21+
- Maven (or Maven Wrapper)
- Git

### Clone the repository

```bash
git clone https://github.com/RaviReadsCode/distributed-systems.git

cd distributed-systems
```

### Run a project

Navigate to the project directory:

```bash
cd projects/01-url-shortener
```

Build and run tests:

```bash
./mvnw clean test
```

For Windows Command Prompt or PowerShell:

```powershell
.\mvnw.cmd clean test
```

Refer to each project's README for detailed setup and execution instructions.

## Engineering Principles

Every project aims to demonstrate:

1. Clear architecture and design decisions.
2. Independently testable implementations.
3. Reliability and failure handling.
4. Performance measurement and optimization.
5. Automated testing and documentation.
6. Engineering trade-offs and scalability considerations.

## Future Roadmap

- Distributed Rate Limiter
- Distributed Cache
- Message Queue
- Distributed Lock
- Service Discovery
- API Gateway

## Author

**Raviraj Kumar Singh**

Backend & Platform Engineering | Java | Spring Boot | Distributed Systems | Kubernetes

- GitHub: [RaviReadsCode](https://github.com/RaviReadsCode)

---

*Building distributed systems by engineering them, testing their limits, and understanding their trade-offs.*
