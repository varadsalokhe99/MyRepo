package com.cleaningServices.repository;

<<<<<<< HEAD
=======
import java.util.List;
import java.util.Optional;

>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cleaningServices.entities.Labour;
<<<<<<< HEAD
import java.util.List;



@Repository
public interface LabourRepository extends JpaRepository<Labour, Integer> {
	
//	@Query(value = "select labour_id from labour where name =:lname",nativeQuery = true)
//	public Labour findById(String lname);
	
	public Labour findByLname(String name);
}
=======
import com.cleaningServices.entities.ServiceProvider;


@Repository
public interface LabourRepository extends JpaRepository<Labour, Integer>{

	@Query("select l from Labour l where sp_id=:sp_id")
	public List<Labour> findBySpId(ServiceProvider sp_id);
	
	
	}

//	@Query(value="select * from labour  where sp_id =:spid", nativeQuery = true)
//	Labour getLabourBySpId(int spid);

//	@Query("select l from labour l where sp_id =:sp")
//	Labour getLabourById(ServiceProvider sp);

	
	


>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803
