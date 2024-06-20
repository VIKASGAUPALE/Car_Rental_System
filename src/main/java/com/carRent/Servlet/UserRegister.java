package com.carRent.Servlet;

import java.io.IOException;

import com.carRent.Bean.CarUserBean;
import com.carRent.DAO.UserRegisterDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class UserRegister extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		try {
			String name=req.getParameter("fullname");
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			long mobileNo=Long.parseLong(req.getParameter("phone"));
			String address=req.getParameter("address");
			long aadharNo=Long.parseLong(req.getParameter("aadhar"));
			String licenseNo=req.getParameter("license");
			
			CarUserBean cub=new CarUserBean(name, email, password, mobileNo, address, aadharNo, licenseNo);
			
			UserRegisterDAO ur=new UserRegisterDAO();
			int registerUserCount = ur.registerCarUser(cub);
			
			if(registerUserCount>0)
			{
				System.out.println("register success");
				req.getRequestDispatcher("userLogin.html").forward(req, resp);
			}
			else
			{
				req.getRequestDispatcher("registerFailed.jsp").forward(req, resp);
				
			}
			
		} catch (Exception e) {
			req.getRequestDispatcher("somethingWrong.jsp").forward(req, resp);
		}
	
		
	}
}
