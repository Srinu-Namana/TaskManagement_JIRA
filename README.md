# 🚀 TaskFlow – Advanced Java Task Management System

## 📌 Project Overview

**TaskFlow** is an Advanced Java based **Task Management System** inspired by applications like **JIRA**.

The application helps teams create, assign, track and manage project tasks efficiently.

The project demonstrates how to build a real-time web application using:

* Java
* Servlets
* JDBC
* MySQL
* HTML
* CSS
* JSP
* DAO Design Pattern
* MVC Architecture

The application follows a layered architecture where the **Servlet acts as the Controller**, the **Model represents application data**, and the **DAO layer communicates with the MySQL database**.

---

## 🎯 Project Objective

The main objective of this project is to develop an enterprise-style Task Management application where users can:

* Create tasks
* Assign tasks to team members
* Define story points
* Add task descriptions
* Store task information in MySQL
* View created tasks
* Manage tasks through a centralized task management system

---

# 🏗️ Architecture

The project follows the **MVC + DAO architecture**.

```text
                USER
                  |
                  ↓
             HTML / JSP
                  |
                  ↓
          ┌────────────────┐
          │    SERVLET     │
          │   Controller   │
          └────────────────┘
                  |
                  ↓
             MODEL / DTO
                  |
                  ↓
          ┌────────────────┐
          │      DAO       │
          │  TaskDAO.java  │
          └────────────────┘
                  |
                  ↓
              JDBC
                  |
                  ↓
          ┌────────────────┐
          │     MySQL      │
          │   Database     │
          └────────────────┘
```

---

# 🛠️ Technologies Used

| Technology    | Purpose                  |
| ------------- | ------------------------ |
| Java          | Application development  |
| Servlets      | Request handling         |
| JSP           | Dynamic web pages        |
| HTML          | Page structure           |
| CSS           | UI design                |
| JDBC          | Database connectivity    |
| MySQL         | Data persistence         |
| Apache Tomcat | Application server       |
| DAO Pattern   | Database operations      |
| MVC           | Application architecture |
| Maven         | Dependency management    |

---

# 📂 Project Structure

```text
TaskManagementSystem
│
├── src/main/java
│   │
│   ├── com.controller
│   │   └── CreateTaskServlet.java
│   │
│   ├── com.dao
│   │   └── TaskDAO.java
│   │
│   ├── com.model
│   │   └── Tasks.java
│   │
│   └── com.util
│       └── DBConnection.java
│
├── src/main/webapp
│   │
│   ├── create-task.jsp
│   ├── tasks-home.jsp
│   └── css/
│
├── pom.xml
└── README.md
```

---

# 🔄 Task Creation Flow

The task creation process works as follows:

```text
User
  ↓
Create Task Form
  ↓
POST /createTask
  ↓
CreateTaskServlet
  ↓
Read Request Parameters
  ↓
Create Tasks Object
  ↓
TaskDAO
  ↓
JDBC
  ↓
MySQL
  ↓
Task Created Successfully
  ↓
Redirect to /taskshome
```

---

# 🎮 CreateTaskServlet

The application provides the following URL mapping:

```java
@WebServlet("/createTask")
```

The servlet handles the POST request using:

```java
protected void doPost(
    HttpServletRequest req,
    HttpServletResponse resp)
```

The controller receives the following task information:

```text
taskName
storyPoints
assignedTo
taskDescription
```

The request parameters are converted into a `Tasks` object and passed to the DAO layer.

```java
String taskName = req.getParameter("taskName");

int storyPoints =
    Integer.parseInt(req.getParameter("storyPoints"));

String assignedTo =
    req.getParameter("assignedTo");

String taskDescription =
    req.getParameter("taskDescription");

Tasks task =
    new Tasks(
        taskName,
        taskDescription,
        storyPoints,
        assignedTo
    );
```

The controller then calls:

```java
TaskDAO taskdao = new TaskDAO();

boolean status =
    taskdao.createTask(task);
```

If the task is successfully created, the user is redirected to:

```text
taskshome
```

---

# 🗄️ MySQL Database

Create a database:

```sql
CREATE DATABASE taskflow;
```

Select the database:

```sql
USE taskflow;
```

Example task table:

```sql
CREATE TABLE tasks (
    id INT PRIMARY KEY AUTO_INCREMENT,
    task_name VARCHAR(150) NOT NULL,
    task_description VARCHAR(500),
    story_points INT,
    assigned_to VARCHAR(100)
);
```

---

# 📊 Sample Task Data

```sql
INSERT INTO tasks
(task_name, task_description, story_points, assigned_to)
VALUES
(
    'Login Module',
    'Develop user login functionality',
    5,
    'Rahul'
);
```

Another example:

```sql
INSERT INTO tasks
(task_name, task_description, story_points, assigned_to)
VALUES
(
    'Employee Dashboard',
    'Develop employee dashboard',
    8,
    'Priya'
);
```

---

# 🔌 JDBC Database Connection

The application uses JDBC to communicate with MySQL.

Example configuration:

```text
Database      : taskflow
Host          : localhost
Port          : 3306
Username      : root
Password      : your_password
```

Example JDBC URL:

```text
jdbc:mysql://localhost:3306/taskflow
```

---

# 🧩 DAO Layer

The `TaskDAO` class is responsible for database operations.

Example responsibilities:

```text
createTask()
getAllTasks()
getTaskById()
updateTask()
deleteTask()
```

This keeps database-related code separate from the Servlet/controller.

### Example

```java
public boolean createTask(Tasks task) {

    // JDBC connection

    // Prepare SQL statement

    // Set task values

    // Execute INSERT

    // Return status
}
```

---

# 📋 CRUD Operations

The project can be extended to support complete CRUD functionality.

| Operation | Description             |
| --------- | ----------------------- |
| Create    | Create a new task       |
| Read      | View existing tasks     |
| Update    | Modify task information |
| Delete    | Remove a task           |

```text
CREATE
   ↓
READ
   ↓
UPDATE
   ↓
DELETE
```

---

# 🎯 JIRA-Like Features

The application can be enhanced with the following features:

### 👤 User Management

* User registration
* Login
* Logout
* Role-based access
* Admin/User roles

### 📋 Task Management

* Create task
* Update task
* Delete task
* Assign task
* Task description
* Story points
* Priority
* Status
* Due date

### 🔄 Task Status

```text
TODO
  ↓
IN PROGRESS
  ↓
CODE REVIEW
  ↓
TESTING
  ↓
DONE
```

### 🏃 Sprint Management

```text
Project
   ↓
Sprint
   ↓
Tasks
   ↓
Team Members
```

### 📊 Dashboard

The dashboard can display:

```text
Total Tasks
      ↓
+------------+
|     50     |
+------------+

Completed
      ↓
+------------+
|     20     |
+------------+

In Progress
      ↓
+------------+
|     15     |
+------------+

Pending
      ↓
+------------+
|     15     |
+------------+
```

---

# 🔐 Future Security Enhancement

The application can be upgraded using:

```text
Java Servlet
     +
Session Management
     +
Authentication
     +
Role-Based Authorization
```

For an advanced version, the project can later be migrated to:

```text
Spring Boot
Spring Security
JWT
Spring Data JPA
REST APIs
React
MySQL
```

---

# 🚀 Future Enhancements

The following features can be added to make the project more enterprise-level:

* 🔐 JWT Authentication
* 👥 Role-Based Access Control
* 📋 Kanban Board
* 🏃 Sprint Management
* 📊 Reports & Analytics
* 🔔 Email Notifications
* 📎 File Attachments
* 💬 Task Comments
* 🔍 Advanced Search
* 🏷️ Labels & Tags
* 📅 Due Date & Reminders
* 📝 Activity/Audit Logs
* ⚡ REST APIs
* 🤖 AI Task Summarization
* 🤖 AI-based Task Prioritization

---

# ▶️ How to Run the Project

### Step 1 – Clone the Project

```bash
git clone <your-github-repository-url>
```

### Step 2 – Create MySQL Database

```sql
CREATE DATABASE taskflow;
```

### Step 3 – Create Required Tables

Execute the SQL scripts provided in the project.

### Step 4 – Configure Database

Update:

```text
DBConnection.java
```

with your MySQL username and password.

### Step 5 – Configure Tomcat

Deploy the application on:

```text
Apache Tomcat
```

### Step 6 – Start the Application

Run the application from Eclipse/STS/IntelliJ with Tomcat.

### Step 7 – Open Browser

```text
http://localhost:8080/TaskManagementSystem/
```

---

# 🧪 Example Request

### Create Task

```text
POST /createTask
```

### Parameters

```text
taskName=Login Module
storyPoints=5
assignedTo=Rahul
taskDescription=Develop login functionality
```

### Expected Result

```text
Task Created Successfully
        ↓
Redirect
        ↓
/taskshome
```

---

# 💼 Resume Description

### TaskFlow – Enterprise Task Management System

Developed a **JIRA-inspired Task Management System** using **Core Java, Servlets, JSP, JDBC and MySQL** following the **MVC and DAO design patterns**. Implemented task creation, assignment, story-point estimation and task management functionality with a layered architecture.

---

# 🎤 Interview Explanation

> "I developed a JIRA-inspired Task Management System using Java Servlets, JSP, JDBC and MySQL. I followed MVC architecture and used the DAO pattern for database operations. The Servlet acts as the controller, receives task details from the JSP form, creates a model object and passes it to the DAO layer. The DAO communicates with MySQL using JDBC. The system can be extended with task status, priority, sprint management, role-based authentication and Kanban board functionality."

---

# 👨‍💻 Author

**Srikanth**

Java Full Stack Trainer / Developer

**Technologies:**
Java | Servlets | JSP | JDBC | MySQL | Spring Boot | REST APIs | Microservices | AI

---

## ⭐ Project Tagline

> **TaskFlow – Plan. Assign. Track. Deliver.**
