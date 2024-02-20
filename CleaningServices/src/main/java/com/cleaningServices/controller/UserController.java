package com.cleaningServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cleaningServices.Dummy.DummyService;
import com.cleaningServices.Dummy.DummyServiceProvider;
import com.cleaningServices.Dummy.Dummyuser;
import com.cleaningServices.Dummy.LoginRequest;
<<<<<<< HEAD
import com.cleaningServices.entities.Category;
=======
>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803
import com.cleaningServices.entities.Labour;
import com.cleaningServices.entities.Login;
import com.cleaningServices.entities.Role;
import com.cleaningServices.entities.Service1;
import com.cleaningServices.entities.ServiceProvider;
import com.cleaningServices.entities.User;
import com.cleaningServices.services.LabourService;
import com.cleaningServices.services.LoginService;
import com.cleaningServices.services.Role_Service;
import com.cleaningServices.services.ServiceProviderService;
import com.cleaningServices.services.Service_Service;
<<<<<<< HEAD
import com.cleaningServices.services.*;
=======
import com.cleaningServices.services.UserService;
>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	 @Autowired
	    LoginService lservice;
	 @Autowired
		UserService uservice;
	 @Autowired
		ServiceProviderService spservice;
	 @Autowired
	 	Role_Service rl;
	 @Autowired
<<<<<<< HEAD
	 	Service_Service ss;
	 @Autowired
	 	CategoryService catservice;
	 @Autowired
	 	LabourService labservice;
=======
	 LabourService ls;
	 @Autowired
	 Service_Service ss;
>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803
	 
	 
	@PostMapping("/checkLogin")
    public Login checkLogin(@RequestBody LoginRequest lr)
    {
		//System.out.println("lr"+lr);
    	
    	
    	//System.out.println(lr.getUname());
    	Login L=lservice.getLoginByUsername(lr.getUname());
    	
    	System.out.println(L.getRole().getRole_id());
    	if(L.getRole().getRole_id()==1)
    	{
    		return L;
    	}
    	else if(L.getRole().getRole_id()==2)
    	{
    		
    	}
    	else if(L.getRole().getRole_id()==3)
    	{
    		
    	}
    	//System.out.println("lgid"+L.getLoginid());
    	
    	//return L;
//    	if(L.getPassword().equals(lr.getPass()))
//    	{
//    		//return Role id of that user
//    		Role r = L.getRole();
//    		//System.out.println();
//    		//Condition for service provider whos request still not accepted
//    		
//    		
////    		if(r.getRole_id()== 2)
////    		{
////    			ServiceProvider sp = spservice.getUserByLoginId(L);
////    			System.out.println("sp "+sp);
////    			
////    		}
//    		if(r.getRole_id()== 2)
//    		{
//    			ServiceProvider sp = spservice.getUserByLoginId(L);
//    			System.out.println("sp "+sp);
//
//    			
//    		}
//    		return r.getRole_id();
       	//}
//    	else
//    	{
//    		return -1;
//    		//return "Invalid Credentials";
//    	}
    	
    	//User logged=uservice.getUserByLoginId(u.getLoginid());
    	//return logged;
    	return L; 
    }
	
	@PostMapping("/userRegister")
	public User registerCustomer(@RequestBody Dummyuser cr)
	{
    	User a=null;
    	Role r=rl.getRole(cr.getRole_id());
    	Login c=lservice.saveLogin(new Login(cr.getUsername(),cr.getPassword(),r));
    	
    	System.out.println("Email : "+cr.getEmail() + "Role_id:"+cr.getRole_id());
    	a=uservice.saveUser(new User(c,cr.getName(),cr.getEmail(),cr.getContactno(),cr.getAddress(),cr.getDob()));
    	
		System.out.println(cr.getName()+""+cr.getContactno());
	    return a;
	}
	
	@PostMapping("/spRegister")
	public ServiceProvider registerServiceProvider(@RequestBody DummyServiceProvider dr)
	{
		ServiceProvider sp=null;
    	Role r=rl.getRole(dr.getRole_id());
    	Login c=lservice.saveLogin(new Login(dr.getUsername(),dr.getPassword(),r));
    	
    	System.out.println("Email : "+dr.getEmail() + "Role_id:"+dr.getRole_id());
    	sp=spservice.saveSP(new ServiceProvider(c,dr.getName(),dr.getEmail(),dr.getContactno(),dr.getAddress(),dr.getLicense_id(),dr.getStatus()));
    	
		//System.out.println(dr.getName()+""+dr.getContactno());
	    return sp;
	}
	
<<<<<<< HEAD
	@PostMapping("/addService")
	public Service1 addServ(@RequestBody DummyService s)
	{
		Service1 s1=null;
//		Login id = lservice.getLoginByUsername(name);
    	ServiceProvider spid = spservice.getSPBySname(s.getSpname());
    	Category cat = catservice.getIdByCname(s.getCatname());
    	Labour lid = labservice.getLabourName(s.getLabour_name());
		
    	
    	s1 = ss.addService(new Service1(s.getDescription(),s.getPrice(),s.getSname(),s.getStatus(),spid,cat,lid));
    	System.out.println(s1);
	    return s1;
	}
	
//	@PostMapping("/updateService")
//	public Service1 updateServ(@RequestBody Service1 service, @RequestParam String name) {
//		
//		Service1 sp = null;
//		Login id = lservice.getLoginByUsername(name);
//    	ServiceProvider spid = spservice.getSPByLoginId(id);
//    	sp = ss.updateService(new Service1(service.getDescription(),service.getPrice(),service.getSname(),spid));
//    	
//    	return sp;
//	
//	}
	
	
	@PutMapping("/updateService")
    public ResponseEntity <Service1> updateService(@RequestBody DummyService updatedService,@RequestParam int s_id) {
        
            Service1 service = ss.updateService(s_id,updatedService);
            return ResponseEntity.ok().body(service);
           
    }
	
	
	
	
//	@PostMapping("/viewServices")
//	public List<Service1>viewServices(@RequestParam String name){
//		
//		Login login = lservice.getLoginByUsername(name);
//		System.out.println(login);
//		ServiceProvider sid = spservice.getSPByLoginId(login);
//		System.out.println(sid);
//		
//		return ss.viewServices(sid);
//	}
	
	@PutMapping("/deleteService")
	public String deleteService(@RequestParam int sid){
		
		ss.updateStatus(sid);
		return "Done";
		
	}
	
	@PutMapping("/updatePassword")
    public ResponseEntity <Login> updatePassword(@RequestBody Login updatePass,@RequestParam String uname) {
        
            Login pass = lservice.updatePass(uname,updatePass);
            return ResponseEntity.ok().body(pass);
           
    }
	
	@GetMapping("/viewCat")
	public Category viewCategory(@RequestBody String cname){
		
		
		return catservice.viewcat(cname);
	}
=======
	@GetMapping("/aproveReq")
	public List<ServiceProvider> approve()
	{
		System.out.println("before return ");
		System.out.println(spservice.approve());
		return spservice.approve();
	}
	
	//////////////////////////////////////
	@PostMapping("/acceptSP")
	public String acceptSP(@RequestBody int sp_id)
	{		
		System.out.println("userController"+sp_id);
		spservice.approveSP(sp_id);
		return "Done";
	}
	
	@PostMapping("/rejectSP")
	public void deleteSP(@RequestBody int sp_id)
	{		
		 spservice.deletebyId(sp_id);
	}
	
	@PostMapping("/getSP")
	public ServiceProvider getSp(@RequestBody int id) {
		 System.out.println("in getSp "+id);
	    ServiceProvider sp = spservice.getSp(id);
	    System.out.println(sp);
	    return sp;
	}
	//
	@PostMapping("/addLabour")
	public Labour addLabour(@RequestBody Labour l,@RequestParam String name)
	{
		Login lg = lservice.getLoginByUsername(name);
	    if (lg == null) {
	        // Handle case where Login is not found
	        throw new IllegalArgumentException("Login not found for username: " + name);
	    }

	    ServiceProvider sp = spservice.getSpByLoginId(lg);
	    if (sp == null) {
	        // Handle case where ServiceProvider is not found
	        throw new IllegalArgumentException("ServiceProvider not found for login id: " + lg.getLoginid());
	    }

	    Labour lb = ls.addLabour(new Labour(l.getName(), l.getContactno(), l.getPan_no(), sp));
	    return lb;
		
	}
	
	
	@PostMapping("/viewLabour")
	public List<Labour> viewLabours(@RequestParam String name)
	{
		 Login login = lservice.getLoginByUsername(name);
	        if (login == null) {
	            // Handle case where Login is not found
	            // You might throw an exception or return an appropriate response
	            return null;
	        }

	        // Get the ServiceProvider object by Login
	        ServiceProvider serviceProvider = spservice.getSpByLoginId(login);
	        if (serviceProvider == null) {
	            // Handle case where ServiceProvider is not found
	            // You might throw an exception or return an appropriate response
	            return null;
	        }

	        System.out.println("Service Provider : " + serviceProvider.getSp_id());

	        // Get the list of Labour objects by sp_id
	       return ls.getLabourByServiceProviderId(serviceProvider);
	        
	}
	
	
	@PostMapping("/addService")
	public Service1 addServ(@RequestBody Service1 s,@RequestParam String name)
	{
		Service1 sp=null;
		Login id = lservice.getLoginByUsername(name);
    	ServiceProvider spid = spservice.getSpByLoginId(id);
    	
    	System.out.println("Service Provider : "+spid);
    	sp = ss.addService(new Service1(s.getDescription(),s.getPrice(),s.getSname(),spid));
    	System.out.println(sp);
	    return sp;
	}
  
>>>>>>> d2eb9c01d9407f6fd09d6254532af014b67a3803
}














