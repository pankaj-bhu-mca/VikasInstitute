package com.src.cotroller;

import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.model.StudentRegisterModel;
import com.src.dao.StudentDAO;

@WebServlet("/SaveStudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String Sname = request.getParameter("name");
		String Fname = request.getParameter("fname");
		String Course = request.getParameter("course");
		int Mobile = Integer.parseInt("mobile");
		String Address = request.getParameter("address");
		String City = request.getParameter("city");
		String State = request.getParameter("state");
		int Pincode = Integer.parseInt("pincode");
		String Dob = request.getParameter("dob");
		String Email = request.getParameter("email");
		String Password = request.getParameter("password");
		String Gender = request.getParameter("gender");

		StudentRegisterModel e = new StudentRegisterModel();
		e.setSname(Sname);
		e.setFname(Fname);
		e.setCourse(Course);
		e.setMobile(Mobile);
		e.setAddress(Address);
		e.setCity(City);
		e.setState(State);
		e.setPincode(Pincode);
		e.setDob(Dob);
		e.setEmail(Email);
		e.setPassword(Password);
		e.setGender(Gender);

		int status = StudentDAO.saveStudent(e);
		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("register.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}
}
