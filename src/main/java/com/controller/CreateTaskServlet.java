package com.controller;

import java.io.IOException;

import com.dao.TaskDAO;
import com.model.Tasks;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/createTask")
public class CreateTaskServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("request came for create new task!!!");
		String taskName = req.getParameter("taskName");
		int storyPoints =Integer.parseInt(req.getParameter("storyPoints"));
		String assignedTo = req.getParameter("assignedTo");
		String taskDescription = req.getParameter("taskDescription");
		
		Tasks task=new Tasks(taskName, taskDescription, storyPoints, assignedTo);
		System.out.println(task);
		
		TaskDAO taskdao=new TaskDAO();
		boolean status = taskdao.createTask(task);
		
		if(status) {
			resp.sendRedirect("taskshome");
		}
		
		
	}

}