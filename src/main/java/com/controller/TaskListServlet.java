package com.controller;

import java.io.IOException;
import java.util.List;

import com.dao.TaskDAO;
import com.model.Tasks;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/taskshome")
public class TaskListServlet extends HttpServlet{

	
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("request came for  tasks list!!!!!");
		
		TaskDAO taskdao=new TaskDAO();
		List<Tasks> allTasks = taskdao.getAllTasks();
		System.out.println("inTaskListServlet====== ");
		System.out.println(allTasks);
		
		req.setAttribute("allTasks", allTasks);
		req.setAttribute("user", "subhan");
		RequestDispatcher rd = req.getRequestDispatcher("task-home.jsp");
		rd.forward(req, resp);
	}
}