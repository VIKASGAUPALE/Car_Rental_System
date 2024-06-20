package com.carRent.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.carRent.CommonPacakage.DBConnection;

public class GetReturnStatusDAO 
{
	public static int getStatus(String name)
	{
		System.out.println(name);
		int k=-1;
		int count=0;
		Connection con=DBConnection.getDBConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select count(*) from bookedcar where PERSONNAME=? ");
			ps.setString(1, name);
			ResultSet rs1 = ps.executeQuery();
			if(rs1.next())
			{
				
				count = rs1.getInt(1);
			}
			if(count>0)
			{
				try {
					
					PreparedStatement pstmt=con.prepareStatement("select * from bookedCar where PERSONNAME=?");
					pstmt.setString(1, name);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next())
					{
						 k = rs.getInt(8);
					}
					
				} catch (Exception e) {
					
				}
			}
			else
				k=1;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}


}
