package com.carRent.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.carRent.Bean.ConfirmBookingBean;
import com.carRent.CommonPacakage.DBConnection;

public class ConfirmBookingDAO 
{
	public int bookCar(ConfirmBookingBean cbb)
	{
		Connection con=DBConnection.getDBConnection();
		int k=0;
		try {
			
			PreparedStatement pstmt=con.prepareStatement("insert into BookedCar values(?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, cbb.getCarid());
			pstmt.setString(2, cbb.getPersonName());
			pstmt.setLong(3, cbb.getAadharNo());
			pstmt.setString(4, cbb.getLicenseNo());
			pstmt.setDate(5, Date.valueOf(cbb.getBookingDate()));
			pstmt.setDate(6, Date.valueOf(cbb.getDropDate()));
			pstmt.setDouble(7, cbb.getStartReading());
			pstmt.setInt(8,0);
			pstmt.setDouble(9, cbb.getPerKMCharge());
			
			 k=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
