package com.cleaningServices.services;

<<<<<<< HEAD

=======
import java.util.List;
import java.util.Optional;
>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleaningServices.entities.Labour;
<<<<<<< HEAD
=======
import com.cleaningServices.entities.ServiceProvider;
>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803
import com.cleaningServices.repository.LabourRepository;

@Service
public class LabourService {
<<<<<<< HEAD

	@Autowired
		LabourRepository lrepo;
	public Labour getLabourName(String lname) {
		
		return lrepo.findByLname(lname);
	}

=======
	
	@Autowired
	LabourRepository lrepo;
	
	
	public Labour addLabour(Labour l)
	{
		return lrepo.save(l);
	}


	public Optional<Labour> getLabour(int id) 
	{
		System.out.println(id);
		Optional<Labour> or=lrepo.findById(id);
//		 
		 try
		 {
			 
			 if(or!=null)
			 {
				 or.get();
				 System.out.println("hi");
			 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 
		 }
		 return or;
		
	}


	public List<Labour> getLabourByServiceProviderId(ServiceProvider sp_id) {
		
		return lrepo.findBySpId(sp_id);
	}


//	public Labour getLabourBySpId(int spid) {
//		
//		return lrepo.getLabourBySpId(spid);
//	}


//	public Labour getLabourById(ServiceProvider sp) {
//		
//		
//		return lrepo.getLabourById(sp);
//	}




	

>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803
}
