package com.cleaningServices.Dummy;



public class DummyService {
	
	private String description;

	private double price;
	
	private String sname;
	
	private String spname;
	
	private int status;
	
	private String lname;
	
	private  String catname;
	
	
	
	public DummyService(String catname, String description, double price, String sname, String spname, int status,String lname) {
		super();
		this.catname = catname;
		this.description = description;
		this.price = price;
		this.sname = sname;
		this.spname = spname;
		this.status = status;
		this.lname = lname;
	}
	
	
	public DummyService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getLabour_name() {
		return lname;
	}

	public void setLabour_name(String lname) {
		this.lname = lname;
	}

	

	
	
	
	

}
