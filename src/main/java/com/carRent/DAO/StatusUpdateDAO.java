package com.carRent.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.carRent.CommonPacakage.DBConnection;

public class StatusUpdateDAO 
{
	public int updateCustomerStatus(String carid,long aadharNo)
	{
		Connection con =DBConnection.getDBConnection();
		int k=0;
		try {
			PreparedStatement pstmt=con.prepareStatement("update bookedcar set RETURNSTATUS=? where CARID=? and AADHARNO=?");
			pstmt.setInt(1, 1);
			pstmt.setString(2, carid);
			pstmt.setLong(3, aadharNo);
			k = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
