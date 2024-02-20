package com.cleaningServices.entities;

import jakarta.persistence.*;

@Entity
@Table(name="services")
public class Service1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int service_id;
	
	@Column
	private String description;
	
	@Column
	private double price;
	
	@Column
	private String sname;
	
<<<<<<< HEAD
	@Column
	private int status;
	
	@ManyToOne
	  @JoinColumn(name="sp_id")
		ServiceProvider sp_id;
	
	@ManyToOne
	  @JoinColumn(name="catid")
		Category catid;
	
	@ManyToOne
	  @JoinColumn(name="labour_id")
		Labour lid;

	public Service1(String description, double price, String sname, int status, ServiceProvider sp_id,
			Category catid, Labour lid) {
=======
	@ManyToOne
	  @JoinColumn(name="sp_id")
		ServiceProvider sid;
	


	public Service1(String description, double price, String sname, ServiceProvider sid) {
>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803
		super();
		
		this.description = description;
		this.price = price;
		this.sname = sname;
<<<<<<< HEAD
		this.status = status;
		this.sp_id = sp_id;
		this.catid = catid;
		this.lid = lid;
	}

	
	
	public Service1(int status) {
		super();
		this.status = status;
	}



	public Service1() {
		super();
	}



	public Labour getLid() {
		return lid;
	}


	public void setLid(Labour lid) {
		this.lid = lid;
	}


=======
		this.sid=sid;
		//this.labour_id=labour_id;
	}

>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803
	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

<<<<<<< HEAD
=======
	public ServiceProvider getSid() {
		return sid;
	}

	public void setSid(ServiceProvider sid) {
		this.sid = sid;
	}

>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803
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

<<<<<<< HEAD
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ServiceProvider getSp_id() {
		return sp_id;
	}

	public void setSp_id(ServiceProvider sp_id) {
		this.sp_id = sp_id;
	}

	public Category getCatid() {
		return catid;
	}

	public void setCatid(Category catid) {
		this.catid = catid;
	}

	
=======
	public Service1() {
		super();
	}


	

>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803
	
	
	
}
