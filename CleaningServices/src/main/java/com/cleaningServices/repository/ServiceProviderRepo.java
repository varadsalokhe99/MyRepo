package com.cleaningServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cleaningServices.entities.Login;
import com.cleaningServices.entities.ServiceProvider;
import java.util.List;


import jakarta.transaction.Transactional;


@Repository
public interface ServiceProviderRepo extends JpaRepository<ServiceProvider , Integer> {

<<<<<<< HEAD
//	@Query("select sp from ServiceProvider sp where name =:sname")
//	public ServiceProvider getSPBySname(String sname);
	
	public ServiceProvider findByName(String name);
=======
	@Query("select sp from ServiceProvider sp where sp.login_id = :login_id")
	public ServiceProvider getSPByLoginId(Login login_id);
	
//	@Query("select sp from ServiceProvider sp where sp.loginid.loginid = :login_id")
//	public ServiceProvider getSPByLoginId(int login_id);
	


	@Query("select sp from ServiceProvider sp where status = 0")
	public List<ServiceProvider> getApprove();

	@Modifying
	@Transactional
	@Query("UPDATE ServiceProvider sp SET sp.status = 1 WHERE sp.sp_id = :id")
	public void approveSp(int id);


	
	@Query("select sp from ServiceProvider sp where sp.login_id.loginid = :id")
	public ServiceProvider getSP(Integer id);  
	

	
	
	

>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803
}
