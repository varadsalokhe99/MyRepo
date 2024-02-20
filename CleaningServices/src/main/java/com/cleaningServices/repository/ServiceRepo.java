package com.cleaningServices.repository;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803
import org.springframework.stereotype.Repository;

import com.cleaningServices.entities.*;

<<<<<<< HEAD
import jakarta.transaction.Transactional;

@Repository
public interface ServiceRepo extends JpaRepository<Service1, Integer> {

	@Query(value = "select * from services where service_id =:sid",nativeQuery = true)
	public Service1 findById(int sid);
	
	@Query(value = "select * from services where sname =:sname",nativeQuery = true)
	public Service1 getUserByUsername(String sname);
	

	@Query(value="select * from services where sp_id =:sp_id",nativeQuery = true)
	public List<Service1> findBySpId(ServiceProvider sp_id);
	
	@Modifying
	@Transactional
	@Query(value="update services s set s.status=0 where service_id =:sid",nativeQuery = true)
	public void getStatus(int sid);
	
	public Service1 findBySname(String sname);

=======
@Repository
public interface ServiceRepo extends JpaRepository<Service1, Integer> {

//	@Query(value = "select s from services s where service_id =:service_id",nativeQuery = true)
//	public Service1 getSPById(Service1 service_id);

	
	
	
	
//	@Query(value="update services set desc like :desc, price like: price ")
//	public Service1 updateService(String desc, double price);
>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803
}
