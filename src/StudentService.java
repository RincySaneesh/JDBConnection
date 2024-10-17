import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class StudentService {
    Connection con;
    public StudentService()
    {
        String url = "jdbc:mysql://localhost:3306/MyDatabase";
        String username = "root";
        String password = "root";

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void createStudent()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your ID:");
        int studId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Your Name:");
        String studName = sc.nextLine();

        System.out.println("Enter Your Roll No:");
        int rollNo = sc.nextInt();
        System.out.println("Enter Your Mark:");
        int mark = sc.nextInt();
// INSERT INTO `mydatabase`.`studenttable` (`StudentId`, `Name`, `RollNo`, `Marks`)
// VALUES ('005', 'sdg', '23', '67');

        String insertQuery = "INSERT INTO studenttable (StudentId,Name,RollNo,Marks) VALUES (?, ?, ?,?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
            preparedStatement.setInt(1, studId);
            preparedStatement.setString(2, studName);
            preparedStatement.setInt(3, rollNo);
            preparedStatement.setInt(4, mark);

            // Execute the insert operation
            int rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Data Entered Successfully!!!");
    }

    public void readStudent() {
        System.out.println("The Datas are:");
        //SELECT * FROM mydatabase.studenttable;
        String selectQuery = "SELECT StudentId, Name, RollNo, Marks FROM studenttable";
        try {
        PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int studId = resultSet.getInt("StudentId");
                String studName = resultSet.getString("Name");
                int rollNo = resultSet.getInt("RollNo");
                int mark = resultSet.getInt("Marks");
                System.out.println("ID: " + studId + ", Name: " + studName + ", Roll No: " + rollNo + ", Mark: " + mark);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}