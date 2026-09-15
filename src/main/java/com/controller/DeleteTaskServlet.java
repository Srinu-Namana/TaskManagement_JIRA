package com.controller;

import java.io.IOException;

import com.dao.TaskDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteTask")
public class DeleteTaskServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("request came for delete task with id");
		int id = Integer.parseInt(req.getParameter("id"));
		
		TaskDAO taskdao=new TaskDAO();
		boolean status = taskdao.deleteTaskbyId(id);
		
		if(status) {
			resp.sendRedirect("taskshome");
		}
	}
}