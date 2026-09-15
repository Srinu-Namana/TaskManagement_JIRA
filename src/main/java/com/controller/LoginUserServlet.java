package com.controller;

import java.io.IOException;

import com.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("request came for login!!!!!!!!!!!!");
        String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		System.out.println(email+" " +password);
		UserDAO userdao=new UserDAO();
		boolean status = userdao.validateUser(email, password);
		if(status) {
			System.out.println("login successfully!!! ");
			resp.sendRedirect("taskshome");
		}
		else {
			resp.sendRedirect("login.jsp");
		}
	}
}