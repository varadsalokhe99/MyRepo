package com.cleaningServices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleaningServices.entities.User;
import com.cleaningServices.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository urepo;
    
   
	public User saveUser(User u)
	{
		return urepo.save(u);
	}
	
	public User getUserById(int id)
	{
		System.out.println(id);
		 Optional<User> or=urepo.findById(id);
		 User r=null;
		 try
		 {
			 if(or!=null)
			 {
				 r=or.get();
			 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 
		 }
		 return r;
	}

	public User getUserByLoginId(int id) {
		return urepo.getUserByLoginId(id);
	}

//	public List<User> getAllVendors() {
//		
//		return urepo.findAllVendors();
//	}
//
//
//	public String[] getVendEmails() {
//		
//		return urepo.getVendorEmails();
//	}
//
//	public String[] getCustEmails() {
//		// TODO Auto-generated method stub
//		return urepo.getCustomerEmails();
//	}
//
//	public List<User> getAllCustomers() {
//		
//		return urepo.findAllCustomers();
//	}

}
