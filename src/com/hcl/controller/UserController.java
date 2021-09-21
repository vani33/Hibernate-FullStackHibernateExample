package com.hcl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.DAO.UserDAO;
import com.hcl.model.User;


@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		try {
			UserDAO userDAO = new UserDAO();
			User user = new User();
			user.setUserName(userName);
			user.setEmail(email);
			user.setPhone(phone);
			user.setCity(city);
			userDAO.addUserDetails(user);
			response.sendRedirect("success.jsp");
			
		}
		catch(Exception e) {
			e.getMessage();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
