# Attendance Management System

## Overview
The Attendance Management System is a modern, 3D-styled web application designed to track and manage student attendance seamlessly. Built entirely using Java, Spring Boot, MySQL, and Tailwind CSS. The solution exposes robust RESTful APIs interfacing securely with the backend while using standard HTML/JS client rendering to provide a premium user experience.

## Tech Stack
**Frontend:**
* HTML5
* Tailwind CSS (Styled with Glassmorphism / 3D UI)
* JavaScript (Using standard Fetch API)

**Backend:**
* Java & JDK 17
* Spring Boot (3.2.3)
* Spring Data JPA
* Maven 

**Database:**
* MySQL (Configured on default Port 3306)

## Features
* **Modern 3D Dashboard**: View real-time statistics including total students, attendance records marked, and present rate percentage inside aesthetically responsive cards.
* **REST API Endpoints**: Handle creation and fetching natively in Javascript.
* **Student Registration System**: Instantly add new students via roll numbers with asynchronous list updates.
* **Mark Attendance Grid**: Generate an attendance roster directly pulling specific dates alongside selectable Present/Absent/Late status markers.
* **Attendance Ledger**: View all recorded data comprehensively organized with visually differentiated status labels.
* **Auto-Generating Database Schema**: Configured out of the box with Spring Hibernate's `ddl-auto=update` and an automated `jdbc` initialization procedure ensuring zero manual table configuration.

## Setup Instructions

### 1. Prerequisites
* JDK 17 installed
* Maven installed (or your IDE allows running Spring Boot wrapper classes natively)
* MySQL deployed locally (using XAMPP, Workbench, etc.) running on port `3306`.

### 2. Configure the Database
The project utilizes Spring's automated configuration and `jdbc:mysql` connection strings to verify tables:
1. Access your `application.properties` located directly at:
   `src/main/resources/application.properties`
2. Validate your MySQL database credentials inside:
   ```properties
   spring.datasource.username=root
   spring.datasource.password=Pw@@2901
   ```
   *(Currently, the credentials match the default "Pw@@2901" profile in your environment configuration.)*

### 3. Build & Run Application
1. Import the project folder `attendance-system/` into any primary Java IDE (Eclipse, IntelliJ IDEA, VS Code).
2. Look for `AttendanceSystemApplication.java` inside `src/main/java/com/attendance/attendancesystem/` and compile the class.
3. The server application footprint should bind smoothly entirely upon Port `8089`.

### 4. Viewing the Project
1. Open your web browser immediately upon successful Java deployment. 
2. Redirect your path parameter entirely to:
   `http://localhost:8089`
3. A mock login screen layout mapping to `index.html` should appear, granting entry to `dashboard.html`.

## REST API Endpoints Overview

| Method | Endpoint | Description | Payload Pattern |
| ------ | -------- | ----------- | ----------------|
| GET | `/students` | Retrieves a JSON list of all registered students | None |
| POST | `/students` | Adds a newly registered student | `{"rollNo","name","email","className"}` |
| GET | `/attendance` | Pulls all logged attendance arrays | None |
| POST | `/attendance` | Submits mapping arrays containing attendance | `[{"studentId","date","status"}]` |

## Project Structure
```text
attendance-system/
│
├── src/main/java/com/attendance/attendancesystem/
│   ├── model/         => (Entity schemas mapping database elements)
│   ├── repository/    => (Data access interfacing JPA/Hibernate mapping logic)
│   ├── service/       => (Java business/validation workflows before controller handling)
│   ├── controller/    => (Publicly accessed REST APIs mapping CRUD commands)
│   ├── dto/           => (Transfer objects defining standard JSON bodies)
│   └── AttendanceSystemApplication.java   => (Execution Entry)
│
├── src/main/resources/
│   ├── static/        => (Contains all user-interfacing UI / HTML views natively attached)
│   │   ├── index.html 
│   │   ├── dashboard.html 
│   │   ├── mark_attendance.html 
│   │   └── view_attendance.html 
│   └── application.properties  => (Holds port configuration and MySQL mappings)
│
├── database.sql        => (Backup raw query setup if Auto-DDL fails manually)
└── pom.xml             => (Spring dependency management definitions)
```
