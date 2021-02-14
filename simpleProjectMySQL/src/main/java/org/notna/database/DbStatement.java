package org.notna.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
