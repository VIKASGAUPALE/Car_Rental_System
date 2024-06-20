package com.carRent.Bean;

import java.time.LocalDate;
import java.util.Date;

public class ConfirmBookingBean 
{
	private String carid;
	private String carName;
	private String personName;
	private long AadharNo;
	private String licenseNo;
	private LocalDate bookingDate;
	private LocalDate dropDate;
	private  String location;
	private double perKMCharge;
	private double startReading;
	public ConfirmBookingBean(String carid, String carName, String personName, long aadharNo, String licenseNo,
			LocalDate bookingDate, LocalDate dropDate, String location, double perKMCharge,double startReading) {
		super();
		this.carid = carid;
		this.carName = carName;
		this.personName = personName;
		AadharNo = aadharNo;
		this.licenseNo = licenseNo;
		this.bookingDate = bookingDate;
		this.dropDate = dropDate;
		this.location = location;
		this.perKMCharge = perKMCharge;
		this.startReading=startReading;
	}
	public String getCarid() {
		return carid;
	}
	public void setCarid(String carid) {
		this.carid = carid;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public long getAadharNo() {
		return AadharNo;
	}
	public void setAadharNo(long aadharNo) {
		AadharNo = aadharNo;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalDate getDropDate() {
		return dropDate;
	}
	public void setDropDate(LocalDate dropDate) {
		this.dropDate = dropDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getPerKMCharge() {
		return perKMCharge;
	}
	public void setPerKMCharge(int perKMCharge) {
		this.perKMCharge = perKMCharge;
	}
	public double getStartReading() {
		return startReading;
	}
	public void setStartReading(double startReading) {
		this.startReading = startReading;
	}
	@Override
	public String toString() {
		return "ConfirmBookingBean [carid=" + carid + ", carName=" + carName + ", personName=" + personName
				+ ", AadharNo=" + AadharNo + ", licenseNo=" + licenseNo + ", bookingDate=" + bookingDate + ", dropDate="
				+ dropDate + ", location=" + location + ", perKMCharge=" + perKMCharge + ", startReading="
				+ startReading + "]";
	}
	
	
	

}
