package com.controller;

import java.io.IOException;

import com.dao.TaskDAO;
import com.model.Tasks;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateTask")
public class UpdateTaskServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("request came for find task by id ");
		int id = Integer.parseInt(req.getParameter("id"));

		TaskDAO taskdao = new TaskDAO();
		Tasks task = taskdao.FindTaskById(id);
		req.setAttribute("task", task);
		RequestDispatcher rd = req.getRequestDispatcher("updateTaskForm.jsp");
		rd.forward(req, resp);
	}
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("request recived for update task");
		int id =Integer.parseInt(req.getParameter("taskId"));
		String taskName = req.getParameter("taskName");
		int storyPoints =Integer.parseInt(req.getParameter("storyPoints"));
		String assignedTo = req.getParameter("assignedTo");
		String taskDescription = req.getParameter("taskDescription");
		Tasks task=new Tasks(taskName, taskDescription, storyPoints, assignedTo);
		task.setTaskId(id);
		System.out.println(task);
		
		TaskDAO taskdao=new TaskDAO();
		boolean status = taskdao.UpdateTask(task);
		if(status) {
			resp.sendRedirect("taskshome");
		}
	}

}