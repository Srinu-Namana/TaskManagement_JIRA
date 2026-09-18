
create database taskmanagementdb;

use  taskmanagementdb;

-- Users table: stores everyone who registers/logs in (e.g. Scrum Master)
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL
);

-- Tasks table: simple CRUD entity managed from the dashboard
CREATE TABLE IF NOT EXISTS tasks (
    task_id INT AUTO_INCREMENT PRIMARY KEY,
    task_name VARCHAR(150) NOT NULL,
    task_description VARCHAR(500),
    story_points INT DEFAULT 0, 
    assigned_to VARCHAR(100)
);
