package com.carRent.Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/available")
public class AvailableCar extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		try {
			String city=req.getParameter("city");
			
			HttpSession hs=req.getSession(true);
			hs.setAttribute("city", city);
			
			req.getRequestDispatcher("availableCars.html").forward(req, resp);
		} catch (Exception e) {
			req.getRequestDispatcher("somethingWrong.jsp").forward(req, resp);
		}
		
	}
}
