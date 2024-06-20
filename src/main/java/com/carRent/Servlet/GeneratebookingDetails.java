package com.carRent.Servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import com.carRent.Bean.ConfirmBookingBean;
import com.carRent.DAO.GenerateBookingDetailsDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/generateDetails")
public class GeneratebookingDetails extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		try {
			LocalDate givenDate=LocalDate.parse(req.getParameter("date"));
			
			
			HttpSession hs=req.getSession(false);
			GenerateBookingDetailsDAO cbd=new GenerateBookingDetailsDAO();
			String carId=(String) hs.getAttribute("carid");
			String city=(String) hs.getAttribute("city");
		
			Map<String, Object> carMap = cbd.getDetails((String)hs.getAttribute("email"),carId);
			
			
			String carName=(String) carMap.get("carName");
			String personName=(String) carMap.get("personName");
			long aadharNo=(long) carMap.get("AadharNo");
			String licenSeNo=(String) carMap.get("license");
			int perKMCharge=(int) carMap.get("PerKMCharge");
			LocalDate todaysDate=LocalDate.now();
			double StartReading=(double) carMap.get("startReading");
			
			
			ConfirmBookingBean cbb=new ConfirmBookingBean(carId, carName, personName, aadharNo, licenSeNo, todaysDate, givenDate, city, perKMCharge,StartReading);
			
			HttpSession hs2=req.getSession();
			hs2.setAttribute("CarDetails", cbb);
			req.setAttribute("bookingDetails", cbb);
			System.out.println(cbb);
			req.getRequestDispatcher("confirmBooking.jsp").forward(req, resp);
			
			
		} catch (Exception e) {
			req.getRequestDispatcher("somethingWrong.jsp").forward(req, resp);
		}
	}

}
