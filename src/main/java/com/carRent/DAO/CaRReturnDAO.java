package com.carRent.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.carRent.CommonPacakage.DBConnection;

public class CaRReturnDAO 
{
	public int returnCar(String carid,long aadharNo)
	{
		Connection con = DBConnection.getDBConnection();
		int k=0;
		try {
			PreparedStatement pstmt=con.prepareStatement("select count(*) from bookedCar where CARID=? and AADHARNO=? and RETURNSTATUS=?");
			pstmt.setString(1, carid);
			pstmt.setLong(2, aadharNo);
			pstmt.setInt(3, 0);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				k=rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
