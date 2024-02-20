import { useSelector } from "react-redux"

import { Component } from "react"

import { useNavigate } from "react-router-dom";

const { useReducer, useState } = require("react");



export default function  UpdateService(){


  const init = {
    sname :   {value:"",valid:false , touched:false , error:""},
    description :  {value:"",valid:false , touched:false , error:""},
    price: {value:"",valid:false , touched:false , error:""}
    
}

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

const [items, setItems] = useState([]);

useEffect(() => {
    fetchItems();
}, []);

const fetchItems = async () => {
    try {
        const response = await fetch('/api/items');
        const data = await response.json();
        setItems(data);
    } catch (error) {
        console.error('Error fetching items:', error);
    }
};



const[user,dispatch]=useReducer(reducer,init)
const[msg,setMsg]=useState("")

var navigate=useNavigate();
const validateData = (key,val) => {
    let valid = true;
    let error = ""
    switch(key)
    {
        case 'name':
            var pattern = /^[A-Z]/   //[a-z]{7,15}$/    // [A-Z]{1}[a-z]{1,}
            if(!pattern.test(val))
            {
                valid = false;
                error = "First Letter of Name should be capital "
            }
            break;

        case 'contactno':

            var pattern= /^\d{10}$/;
            if(!pattern.test(val))
            {
            valid = false;
            error = "Contact number should be 10 digits"
            }
            break;

        case 'pan_no':
            var pattern=/^[A-Za-z]{4}\d{5}$/;
            if(!pattern.test(val))
            {
            valid = false;
            error = "Pan number should contain 4 characters and 5 digits"
            }
            break;

    }
    return { valid: valid, error: error}
}


const handleChange = (key,value) => {
   
    const {valid, error} = validateData(key,value);

   
    let formValid = true;
    for(let k in user)
    {
       
        if(user[k].valid === false)
        {
            formValid = false;
            break;
        }
    }
    
    console.log(formValid);
    console.log("------");

   
    dispatch({type: "update",data:{key,value,touched:true,valid,error,formValid}})
}

const submitData = (e) =>{
    e.preventDefault();
   



    const reqOption={
        method:"POST",
        headers:{'content-type':'application/json'},
        body:JSON.stringify({
            
            name : user.name.value,
            contactno : user.contactno.value,
            pan_no : user.pan_no.value
        })
    };
        const unm=localStorage.getItem('myData');
    fetch("http://localhost:8081/updateService?name=",reqOption)
    .then(resp => resp.text())
    .then(str => {
        if(str=="true")
        {
            navigate('/login');
        }
        return setMsg(str)
    })
    
    

}
    
  //const mystate = useSelector(state=>state.logged)

    return(
        // <section class="vh-100 bg-image" style="background-image: ${img};">
        <section class="vh-100 bg-image" >
          {/* <p> Logged in : {mystate.loggedIn.toString()} </p> */}

        <div class="mask d-flex align-items-center h-100 gradient-custom-3">
          <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
              <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                <div class="card" >
                  <div class="card-body p-5">
                    <h2 class="text-uppercase text-center mb-5">Add Service</h2>
      
                    <form>
                    
                        
                    <div class="form-outline mb-3">
                    <label class="form-label" for="form3Example1cg">Enter Service Name</label>
                        <input type="text" id="form3Example1cg" class="form-control form-control-lg" name="name" value={user.name.value}
                onChange={(e)=>{handleChange("name",e.target.value)}} />
                {/* <div className="text-danger" style={{ display: (!user.name.valid)  ?"block":"none"}}>
                {user.name.error}
            </div> */}
                    </div>
                    <div class="form-outline mb-3">
                    <label class="form-label" for="form3Example1cg">Service Description</label>
                        <input type="text" id="form3Example1cg" class="form-control form-control-lg" name="pan_no" value={user.pan_no.value}
                onChange={(e)=>{handleChange("pan_no",e.target.value)}} />
                 {/* <div className="text-danger" style={{ display: (!user.pan_no.valid)  ?"block":"none"}}>
                {user.pan_no.error}
            </div> */}
                   
                    </div>
                    
                    <label class="form-label" for="form3Example1cg">Service Name</label>
                    <div class="form-outline mb-3">
                        <input type="number" id="form3Example1cg" class="form-control form-control-lg"  name="contactno" value={user.contactno.value}
                onChange={(e)=>{handleChange("contactno",e.target.value)}}/>
                        {/* <div className="text-danger" style={{ display: (!user.contactno.valid)  ?"block":"none"}}>
                          {user.contactno.error}
                        </div> */}
                    </div>
      
                      <div class="d-flex justify-content-center">
                        <button type="button" class="btn  btn-outline-info btn-block btn-lg gradient-custom-4 text-body" onClick={(e)=>{submitData(e)}} >Add Service</button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    )
    }
