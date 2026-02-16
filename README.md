# ABC Technologies - Retail Portal (Java + MySQL + Docker Compose)

A simple retail portal built with Java (Servlets/JSP) packaged as a WAR and deployed on Tomcat, with MySQL for persistent storage.

## Features
- Add Product
- List Products
- Edit Product
- Delete Product

## Tech Stack
- Java 8, Maven (WAR)
- JSP/Servlets
- MySQL 8
- Docker + Docker Compose
- Tomcat 9

## Run Locally (Docker)
```bash
mvn clean package
docker compose up --build