# Student Management System

A desktop-based **Student Management System** built with **Java Swing**, **SQLite**, and **JDBC**. The system helps users manage student records through a simple graphical user interface.

## Features

* User login interface
* Add new student records
* Update existing student records
* Delete student records
* Search students by:

  * ID
  * Name
  * Email
  * Gender
  * Course
* Sort students by:

  * Name
  * Marks
* About page
* Logout feature
* Input validation for required fields
* Marks validation to ensure values do not exceed 100

## Technologies Used

* Java
* Java Swing
* SQLite
* JDBC
* NetBeans IDE

## Project Structure

```text
src/
├── sms.dao/
│   ├── DBConnection.java
│   └── StudentDAO.java
├── sms.model/
│   └── Student.java
└── sms.ui/
    ├── LoginForm.java
    ├── MainForm.java
    └── About.java
```

## Database

The project uses an SQLite database file:

```text
students.db
```

The `students` table stores:

* `id`
* `name`
* `email`
* `gender`
* `course`
* `marks`

## How to Run the Project

1. Open the project in **NetBeans**.
2. Make sure the SQLite JDBC library is added to the project libraries.
3. Build the project.
4. Run the project starting from the login form.

## Main Functionalities

### Add Student

Adds a new student after validating that all fields are filled correctly.

### Update Student

Updates a selected student record only when all required fields are filled.

### Delete Student

Deletes the selected student after confirmation.

### Search Student

Allows searching by a selected category using a combo box.

### Sort Students

Displays students sorted by name or marks.

### About Page

Displays information about the application, features, and technologies used.

## Validation Rules

* All required fields must be filled before adding or updating a student.
* Student marks must be a valid number.
* Marks cannot be less than 0.
* Marks cannot exceed 100.
* Student ID must be unique.

## Authors

**YUMVAGUSENGA Ange**

**IGIRANEZA Kevin**

## Notes

This project was developed for academic purposes and demonstrates the use of:

* Object-Oriented Programming
* Java GUI development with Swing
* Database connectivity using JDBC
* CRUD operations in a desktop application

