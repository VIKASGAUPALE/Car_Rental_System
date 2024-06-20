package com.carRent.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.carRent.CommonPacakage.DBConnection;

public class GETPersonName
{
	public static String getName(String email)
	{
		String name="";
		Connection con=DBConnection.getDBConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from registercarusers where email=?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				 name = rs.getString(1);
			}
			
		} catch (Exception e) {
			
		}
		return name;
	}

}
