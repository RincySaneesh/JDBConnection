This pgm is an application that interacts with a MySQL database to manage student records.

StudentService Class: Handles the database operations.

Constructor: Connects to the MySQL database using JDBC.
createStudent(): Prompts the user to input student details (ID, name, roll number, marks) and inserts this data into the database.
readStudent(): Fetches and displays all student records from the database.
StudentMenu Class: Provides a menu-driven interface.

It gives the user three options:
Add a new student.
View existing students.
Exit the application.
Depending on the user's choice, it calls the relevant method from StudentService.
This application lets users add student records and view them through basic database queries using a simple menu system.