package com.carRent.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import org.apache.catalina.connector.Response;

import com.carRent.DAO.CaRReturnDAO;
import com.carRent.DAO.CarMatchDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/returnCar")
public class ReturnCarServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		try {

			String carid=req.getParameter("carId");
			long aadharNo=Long.parseLong(req.getParameter("aadharNo"));
			String email=req.getParameter("email");
			
			CarMatchDAO cmd=new CarMatchDAO();
			List<String> carIdList = cmd.getCar();
			

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
			
			if(isMatching)
			{
				CaRReturnDAO crd=new CaRReturnDAO();
				int returnCarCount = crd.returnCar(carid, aadharNo);
				
				
				HttpSession hs=req.getSession();
				hs.setAttribute("carid",carid);
				hs.setAttribute("aadharNo", aadharNo);
				hs.setAttribute("email",email);
				if(returnCarCount>0)
				{
					req.getRequestDispatcher("/bill").forward(req, resp);
				}
				else
				{
					req.getRequestDispatcher("noCarRent.jsp").forward(req, resp);
				}
			}
			else
			{
				PrintWriter pw=resp.getWriter();
				pw.print("Invalid Carid");
				resp.setContentType("text/html");
				req.getRequestDispatcher("carReturn.html").include(req, resp);
			}
			
			
		} catch (Exception e) {
			req.getRequestDispatcher("somethingWrong.jsp").forward(req, resp);
		}
	}

}
