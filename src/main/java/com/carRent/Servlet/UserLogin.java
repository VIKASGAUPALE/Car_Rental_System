package com.carRent.Servlet;

import java.io.IOException;

import com.carRent.Bean.CarUserBean;
import com.carRent.DAO.UserLoginDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class UserLogin extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		try {
			String userName=req.getParameter("email");
			String password=req.getParameter("password");
			
			UserLoginDAO uld=new UserLoginDAO();
			CarUserBean cub=uld.getLogin(userName, password);
			
			if(cub!=null)
			{
				HttpSession hs=req.getSession(true);
				hs.setAttribute("email", userName);
				req.getRequestDispatcher("loginOption.html").forward(req, resp);
			}
			else
			{
				
				req.getRequestDispatcher("loginFailed.jsp").forward(req, resp);
			}
			
			
		} catch (Exception e) {
			req.getRequestDispatcher("somethingWrong.jsp").forward(req, resp);
		}
	}

}
