package com.carRent.Servlet;

import java.io.IOException;

import com.carRent.Bean.ConfirmBookingBean;
import com.carRent.DAO.ConfirmBookingDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/confirmBooking")

public class ConfirmBookingServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		 try {
			 HttpSession hs=req.getSession(false);
			 Object attribute = hs.getAttribute("CarDetails");
			 ConfirmBookingBean cbb=(ConfirmBookingBean)attribute;
		      
			  System.out.println(cbb);
			  ConfirmBookingDAO cbd=new ConfirmBookingDAO();
			  int bookStatus = cbd.bookCar(cbb);
			  
			  if(bookStatus>0)
			  {
				  req.setAttribute("username", cbb.getPersonName());
				  req.getRequestDispatcher("bookingSuccessfull.jsp").forward(req, resp);
			  }
			  else
			  {
				  req.getRequestDispatcher("bookingFailed.jsp").forward(req, resp);
			  }
			
			
		} catch (Exception e) {
			req.getRequestDispatcher("somethingWrong.jsp").forward(req, resp);
		}
	}
}
