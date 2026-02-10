# 🏋️‍♂️ AI-Powered Fitness Microservices Application
**Spring Boot • React • Kafka • Keycloak • Google Gemini**

---

## 📌 Project Overview

This project is a **production-grade, full-stack fitness application** built using a **microservices architecture**.  
It combines **Spring Boot microservices**, a **React frontend**, **OAuth2 security with Keycloak**, **event-driven communication using Apache Kafka**, and **AI-powered recommendations generated via Google Gemini**.

The application demonstrates **real-world backend and full-stack engineering practices**, including service discovery, centralized configuration, secure API gateways, asynchronous messaging, and AI integration.

---

## 🏗️ High-Level Architecture

| Layer | Description |
|------|------------|
| Frontend | React (Vite) SPA with OAuth2 PKCE authentication |
| API Gateway | Spring Cloud Gateway (routing, JWT validation, security) |
| Service Registry | Eureka Server (dynamic service discovery) |
| Backend Services | Independent Spring Boot microservices |
| Messaging | Apache Kafka (event-driven async processing) |
| AI Engine | Google Gemini API via Spring AI |
| Databases | PostgreSQL & MongoDB |
| Security | OAuth2 / OpenID Connect using Keycloak |
| Config | Spring Cloud Config Server |
| Infrastructure | Docker (Kafka, Keycloak, MongoDB, PostgreSQL) |

---

## 🧩 Backend Microservices

### 1️⃣ User Service
- **Technology**: Spring Boot, Spring Data JPA, PostgreSQL
- Manages user profiles and metadata
- Syncs users with Keycloak identities
- UUID-based primary keys
- REST APIs for user operations

---

### 2️⃣ Activity Service
- **Technology**: Spring Boot, MongoDB
- Manages user fitness activities
- Performs synchronous user validation via User Service
- Publishes activity events to Kafka

---

### 3️⃣ AI Service
- **Technology**: Spring Boot, Spring AI, MongoDB
- Consumes Kafka activity events
- Sends structured prompts to Google Gemini
- Generates AI-driven fitness insights and recommendations
- Stores processed AI responses

---

## 🔁 Inter-Service Communication

| Type | Mechanism | Usage |
|----|----|----|
| Synchronous | REST + Spring WebClient | User validation |
| Asynchronous | Apache Kafka | Activity → AI processing |

Kafka enables:
- Loose coupling between services  
- Fault tolerance  
- Non-blocking, scalable workflows  

---

## 🔐 Security Architecture

- OAuth2 and OpenID Connect
- Keycloak as Identity & Authorization Server
- PKCE Flow for secure frontend authentication
- Spring Cloud Gateway as the single entry point
- JWT validation and user identity propagation

---

## 🌐 API Gateway Responsibilities

- Central routing for all microservices
- JWT token validation with Keycloak
- CORS configuration for frontend access
- User identity extraction and forwarding
- Prevents direct access to internal services

---

## 🤖 AI Integration (Google Gemini)

- Activity data converted into structured prompts
- Gemini returns detailed nested JSON responses:
  - Fitness analysis
  - Improvement areas
  - Suggestions
  - Safety guidelines
- Responses parsed using Jackson (`ObjectMapper`, `JsonNode`)
- Processed recommendations stored in MongoDB

---

## 🎨 Frontend (React)

- React with Vite for fast builds
- Redux for global state management
- React Router for navigation
- Material UI for UI components
- Axios with interceptors for JWT handling
- OAuth2 PKCE authentication with Keycloak
- Token-aware UI and protected routes

---

## 🔄 Authentication & User Sync Flow

1. User logs in via React using OAuth2 PKCE
2. Keycloak issues JWT access token
3. API Gateway validates token
4. Gateway extracts Keycloak user ID
5. Gateway syncs user with User Service (if new)
6. Requests forwarded to backend services
7. Activity Service validates user synchronously
8. Activity data published to Kafka
9. AI Service consumes and processes activity data
10. AI recommendations stored and returned to frontend

---

## ⚙️ Configuration & Infrastructure

- Spring Cloud Config Server for centralized configuration
- Environment-specific property management
- Dockerized infrastructure:
  - Kafka
  - Keycloak
  - PostgreSQL
  - MongoDB
- Ensures local environment parity and reproducibility

---

## 🧪 Testing & Validation

- Postman for secured API testing
- End-to-end validation:
  - Authentication
  - User creation and synchronization
  - Activity submission
  - Kafka messaging
  - AI recommendation generation
- Frontend testing via React UI

---

## 📚 Key Technical Highlights

- Multiple databases across microservices
- Event-driven architecture with Kafka
- Centralized security at gateway level
- OAuth2 PKCE for SPA authentication
- AI-powered feature integration
- Reactive programming with WebClient and Mono
- Clean separation of concerns
- Production-ready architectural patterns

---

## 🎯 Learning Outcomes

- Design scalable microservices architectures
- Implement secure OAuth2 authentication
- Use Kafka for asynchronous communication
- Integrate AI models into backend systems
- Manage centralized configuration
- Build modern React frontends
- Apply enterprise-grade engineering practices

