package sms.dao;

import sms.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void createTable() {
       String sql = "CREATE TABLE IF NOT EXISTS students ("
        + "id INTEGER PRIMARY KEY, "
        + "name TEXT NOT NULL, "
        + "email TEXT NOT NULL, "
        + "gender TEXT NOT NULL, "
        + "course TEXT NOT NULL, "
        + "marks REAL NOT NULL)";
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    public boolean addStudent(Student student) {
      String sql = "INSERT INTO students(id, name, email, gender, course, marks) VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

           pst.setInt(1, student.getId());
           pst.setString(2, student.getName());
           pst.setString(3, student.getEmail());
           pst.setString(4, student.getGender());
           pst.setString(5, student.getCourse());
           pst.setDouble(6, student.getMarks());

            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
          javax.swing.JOptionPane.showMessageDialog(null, "Student ID already exists ");
          return false;
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student(
                       
        rs.getInt("id"),
        rs.getString("name"),
        rs.getString("email"),
        rs.getString("gender"),
        rs.getString("course"),
        rs.getDouble("marks")
);
                
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }

        return students;
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name=?, email=?, gender=?, course=?, marks=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, student.getName());
            pst.setString(2, student.getEmail());
            pst.setString(3, student.getGender());
            pst.setString(4, student.getCourse());
            pst.setDouble(5, student.getMarks());
            pst.setInt(6, student.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
    public List<Student> searchStudentsByName(String keyword) {
    List<Student> students = new ArrayList<>();
    String sql = "SELECT * FROM students WHERE name LIKE ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, "%" + keyword + "%");
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Student student = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("gender"),
                    rs.getString("course"),
                    rs.getDouble("marks")
            );
            students.add(student);
        }
    } catch (SQLException e) {
        System.out.println("Error searching students: " + e.getMessage());
    }

    return students;
}
}