package com.carRent.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;

import com.carRent.Bean.ConfirmBookingBean;
import com.carRent.CommonPacakage.DBConnection;

public class GenerateBookingDetailsDAO 
{

	public Map<String, Object> getDetails(String email,String carID)
	{
		Map<String, Object>map=new LinkedHashMap<String, Object>();
		Connection con = DBConnection.getDBConnection();
		
		try {
			PreparedStatement ps1=con.prepareStatement("select * from registerCarusers where email=?");
			ps1.setString(1, email);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			String peronName=rs1.getString(1);
			long aadharNo=rs1.getLong(6);
			String licenseNo=rs1.getString(7);
			
			map.put("personName", peronName);
			map.put("AadharNo", aadharNo);
			map.put("license", licenseNo);
			
			PreparedStatement ps2=con.prepareStatement("select * from cardetails where carid=?");
			ps2.setString(1, carID);
			
			ResultSet rs2 = ps2.executeQuery();
			rs2.next();
			String carName=rs2.getString(2);
			int perKMCharge=rs2.getInt(3);
			double startReading=rs2.getDouble(4);
			
			map.put("carName", carName);
			map.put("PerKMCharge", perKMCharge);
			map.put("startReading", startReading);
			

		} catch (Exception e) {
			
		}
		return map;
	}
}
