
const { useReducer, useState } = require("react");
import { useSelector } from "react-redux"
import { Component } from "react"
import { useNavigate } from "react-router-dom"
import { useState } from "react"


export default function AddServices(){

  const init = {
    sname :   {value:"",valid:false , touched:false , error:""},
    description :  {value:"",valid:false , touched:false , error:""},
    price :  {value:"",valid:false , touched:false , error:""}
    
}
const[sp,dispatch]=useReducer(reducer,init)
const reducer = (state,action) => {
  switch(action.type)
  {
      case 'update':
         
          const {key,value,touched,valid,error,formValid} = action.data;
          return {...state,[key]:{value,touched,valid,error},formValid}
      
      case 'reset':
          return init;        
  }
}

const[msg,setMsg]=useState("")

var navigate=useNavigate();

const submitData = (e) =>{
  e.preventDefault();

  const reqOption={
      method:"POST",
      headers:{'content-type':'application/json'},
      body:JSON.stringify({
          
          sname : sp.sname.value,
          description : sp.description.value,
          price : sp.price.value
          
      })
  };

  const unm=localStorage.getItem('myData');
  fetch("http://localhost:8073/addService",+unm,reqOption)
  .then(resp => resp.text())
  .then(str => {
      if(str=="true")
      {
        alert("Successfully added");
          navigate('/addService');

      }
      return setMsg(str)
  })
  
  

}



    return(

      
  <div>
    
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Add Services</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          
         
        </div>
      </div>
    </nav>
  
  

  <main class="flex-shrink-0">
    <div class="container">
      <h1 class="mt-5"></h1>
      <p class="lead"><code class="small"></code> <code class="small"></code></p>
      <p><a href="/docs/5.3/examples/sticky-footer/"></a> </p>
    </div>
  </main>
  
  <div class="col-md-7 col-lg-8">
        
        <form class="needs-validation" novalidate="">
          <div class="row g-3">
            <div class="col-sm-6">
              <label for="servicename" class="form-label">Service name</label>
              
              <input type="text" class="form-control" id="servicename" placeholder="Enter Service Name" name="sname"
              value={user.sname.value} onChange={(e)=>{handleChange("sname",e.target.value)}}
               />
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
      </div>
      </div>
      </form>

      <form class="needs-validation" novalidate="">
          <div class="row g-3">
            <div class="col-sm-6">
              <label for="servicename" class="form-label">Service Description</label>
              
              <input type="text" class="form-control" id="servicename" placeholder="Enter Service Description" name="description"
              value={user.description.value} onChange={(e)=>{handleChange("description",e.target.value)}}
                />
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
      </div>
      </div>
      </form>

      <form class="needs-validation" novalidate="">
          <div class="row g-3">
            <div class="col-sm-6">
              <label for="price" class="form-label">Add Price</label>
              
              <input type="text" class="form-control" id="price" placeholder="Enter price $" name="price"
              value={user.price.value} onChange={(e)=>{handleChange("price",e.target.value)}}
               />
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
      </div>
      </div>
      </form>
  <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</div>
  </div>
    )
}