package com.carRent.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.carRent.Bean.CarUserBean;
import com.carRent.CommonPacakage.DBConnection;

public class UserLoginDAO 
{
	public CarUserBean getLogin(String email,String password)
	{
		CarUserBean cub=null;
		
		Connection con=DBConnection.getDBConnection();
		
		try {
			PreparedStatement pstmt =con.prepareStatement("select * from RegisterCarUsers where EMAIL=? and PASSWORD=?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				cub=new CarUserBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getLong(6),rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cub;
	}
}
