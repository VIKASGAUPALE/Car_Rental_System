package com.carRent.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import com.carRent.CommonPacakage.DBConnection;
import com.carRent.DAO.CarMatchDAO;
import com.carRent.DAO.GETPersonName;
import com.carRent.DAO.GetReturnStatusDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/carmatch")
public class CarMatch extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		try {
			String carid=req.getParameter("car-id");
			System.out.println(carid);
			
			CarMatchDAO cm=new CarMatchDAO();
			List<String> carIdList=cm.getCar();
			
			Iterator<String> itr=carIdList.iterator();
			boolean isMatching=false;
			
			while(itr.hasNext())
			{
				if(carid.equals(itr.next()))
				{
					isMatching=true;
					break;
				}
			}
			HttpSession hs1=req.getSession(false);
			String email=(String) hs1.getAttribute("email");
			
			String name=GETPersonName.getName(email);
			
			
			if(isMatching)
			{
				int k=GetReturnStatusDAO.getStatus(name);
				if(k==1)
				{
					HttpSession hs=req.getSession(true);
					hs.setAttribute("carid", carid);
					req.getRequestDispatcher("inputDroping.html").forward(req, resp);
				}
				else
				{
					req.getRequestDispatcher("alreadyBooked.jsp").forward(req, resp);	
				}
			}
			else
			{
				req.getRequestDispatcher("noCarAvailable.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			req.getRequestDispatcher("somethingWrong.jsp").forward(req, resp);
		}
	}
		

}
