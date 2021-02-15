package org.notna.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.notna.model.Student;

public class DbStatement {
	public static void insertStudent(Student student){
		String sql = "INSERT INTO programming_class(name, mobile_number, course) VALUES (?,?,?);";
		try {
			PreparedStatement insert = DbConnection.getConnection().prepareStatement(sql);
			insert.setString(1, student.getName());
			insert.setString(2, student.getMobileNr());
			insert.setString(3, student.getCourse());
			insert.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static List<Student> selectStudentList(){
		List<Student> studentList = new ArrayList<Student>();
		String sql = "SELECT * FROM programming_class";
		try {
			Statement select = DbConnection.getConnection().createStatement();
			ResultSet result = select.executeQuery(sql);
			while(result.next()){
				studentList.add(new Student(result.getInt("id"), result.getString("name"), result.getString("mobile_number"), result.getString("course")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}

	public static void deleteStudent(Student student){
		String sql = "DELETE FROM programming_class WHERE id = ?;";
		try {
			PreparedStatement delete = DbConnection.getConnection().prepareStatement(sql);
			delete.setInt(1, student.getId());
			delete.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateStudent(Student oldStudent, Student newStudent){
		String sql = "UPDATE programming_class SET name=?,mobile_number=?,course=? WHERE id = ?;";
		try {
			PreparedStatement update = DbConnection.getConnection().prepareStatement(sql);
			update.setString(1, newStudent.getName());
			update.setString(2, newStudent.getMobileNr());
			update.setString(3, newStudent.getCourse());
			update.setInt(4, oldStudent.getId());
			update.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
