package com.cleaningServices.services;



<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleaningServices.Dummy.DummyService;
import com.cleaningServices.entities.*;
import com.cleaningServices.repository.ServiceRepo;

import jakarta.transaction.Transactional;

=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleaningServices.entities.*;
import com.cleaningServices.repository.ServiceRepo;

>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803
@Service
public class Service_Service {
	
	@Autowired
	ServiceRepo srepo;
	
	
<<<<<<< HEAD
	
	
	public Service1 addService(Service1 service) {
		return srepo.save(service);
	}
	
	 @Transactional
	    public Service1 updateService(int s_id, DummyService updatedService) {
	       
		 Service1 existingService = srepo.findById(s_id);
	                                    

	        // Update fields
	        existingService.setSname(updatedService.getSname());
	        existingService.setDescription(updatedService.getDescription());
	        existingService.setPrice(updatedService.getPrice());
//	        existingService.setLid(srepo.find(updatedService.getLabour_name()));
	        

	        return srepo.save(existingService);
	    }
	
//	@Transactional	
//	public Service1 deleteService(Service1 id) {
//		return srepo.deleteService(id);
//	}

	public List<Service1> viewServices(ServiceProvider sid) {
		
		return srepo.findBySpId(sid);
	}


    @Transactional
	public void updateStatus(int s_id) {
		
		srepo.getStatus(s_id);
	}

	
   
=======
	public Service1 addService(Service1 service) {
		return srepo.save(service);
	}
		
	
	
>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803
	
//	public Service1 updateService(String desc, double price) {
//		
//		return srepo.updateService(desc,price);
//	}
	
	
}
