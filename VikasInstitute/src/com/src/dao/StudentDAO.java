package com.src.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.sc.model.StudentRegisterModel;

public class StudentDAO {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/", "hospital", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return con;
	}

	public static int saveStudent(StudentRegisterModel e) {
		int status = 0;
		try {
			Connection con = StudentDAO.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into studentregistration(sname, father, course, mobile, address, city, state, pin, dob, email, password, gender) values (?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, e.getSname());
			ps.setString(2, e.getFname());
			ps.setString(3, e.getCourse());
			ps.setInt(4, e.getMobile());
			ps.setString(5, e.getAddress());
			ps.setString(6, e.getCity());
			ps.setString(7, e.getState());
			ps.setInt(8, e.getPincode());
			ps.setString(9, e.getDob());
			ps.setString(10, e.getEmail());
			ps.setString(11, e.getPassword());
			ps.setString(12, e.getGender());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
}
