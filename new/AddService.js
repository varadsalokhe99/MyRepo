import { useReducer, useState,useEffect } from "react";
import { useNavigate } from "react-router-dom";

export default function AddService() {
  const[cat, setCat] = useState([]);
  useEffect(() => {
    fetch("http://localhost:8081/viewAllCat")
      .then(resp => resp.json())
      .then(data => setCat(data));
  }, []);

  const[lab, setLab] = useState([]);
  useEffect(() => {
    fetch("http://localhost:8081/viewLabour")
      .then(resp => resp.json())
      .then(data => setLab(data));
  }, []);

    const init = {
        
        sp_id: { value: "", valid: false, touched: false, error: "" },
        sname: { value: "", valid: false, touched: false, error: "" },
        description: { value: "", valid: false, touched: false, error: "" },
        category: { value: "", valid: false, touched: false, error: "" },
        price: { value: "", valid: false, touched: false, error: "" },
        labour_name:{ value: "", valid: false, touched: false, error: "" }
    };

    const reducer = (state, action) => {
        switch (action.type) {
            case 'update':
                const { key, value, touched, valid, error, formValid } = action.data;
                return { ...state, [key]: { value, touched, valid, error }, formValid };

            case 'reset':
                return init;
        }
    };

    const [user, dispatch] = useReducer(reducer, init);
    const [msg, setMsg] = useState("");
    const navigate = useNavigate();

    const validateData = (key, val) => {
        let valid = true;
        let error = "";
        switch (key) {
            case 'name':
                var pattern = /^[A-Z]/;
                if (!pattern.test(val)) {
                    valid = false;
                    error = "First Letter of Name should be capital ";
                }
                break;

            case 'contactno':
                var pattern = /^\d{10}$/;
                if (!pattern.test(val)) {
                    valid = false;
                    error = "Contact number should be 10 digits";
                }
                break;

            
        }
        return { valid, error };
    };

    const handleChange = (key, value) => {
        const { valid, error } = validateData(key, value);
        let formValid = true;
        for (let k in user) {
            if (user[k].valid === false) {
                formValid = false;
                break;
            }
        }
        dispatch({ type: "update", data: { key, value, touched: true, valid, error, formValid } });
    };

    const onClick = (e) => {
      e.preventDefault();
      const reqOption = {
        method: "POST",
        headers: { 'content-type': 'application/json' },
        body: JSON.stringify({
          catid: user.catid.value,
          catname: user.catname.value
        })
      };
    
      // Set catname value in localStorage
      //localStorage.setItem('catname', user.catname.value);
    
      // Fetch categories data using useEffect hook
     
    };









    const submitData = (e) => {
        e.preventDefault();

        const reqOption = {
            method: "POST",
            headers: { 'content-type': 'application/json' },
            body: JSON.stringify({
                sp_id:user.sp_id.value,
                sname: user.sname.value,
                description: user.description.value,
               //category: user.category.value,
                price: user.price.value
            })
        };

        // Assuming `unm` is defined somewhere
      // const sp_id = user.sp_id.value;
      // const category = user.category.value;
    
        fetch("http://localhost:8073/addService", reqOption)
            .then(resp => resp.text())
            .then(str => {
                if (str === "true") {
                    navigate('/login');
                    alert("Add Successfully")
                }
                return setMsg(str);
            });
    };

    return (
        <section className="vh-100 bg-image">
            <div className="mask d-flex align-items-center h-100 gradient-custom-3">
                <div className="container h-100">
                    <div className="row d-flex justify-content-center align-items-center h-100">
                        <div className="col-12 col-md-9 col-lg-7 col-xl-6">
                            <div className="card">
                                <div className="card-body p-5">
                                    <h2 className="text-uppercase text-center mb-5">Add Packages</h2>
                                    <form>
                                        <div className="form-outline mb-3">
                                            <label className="form-label" htmlFor="packageName">Package Name</label>
                                            <input type="text" id="serviceName" className="form-control form-control-lg" name="sname" value={user.sname.value}
                                                onChange={(e) => { handleChange("sname", e.target.value) }} />
                                            {/* <div className="text-danger" style={{ display: (!user.name.valid) ? "block" : "none" }}>
                                                {user.name.error}
                                            </div> */}
                                        </div>
                                        <div className="form-outline mb-3">
                                            <label className="form-label" htmlFor="packageDescription">Package Description</label>
                                            <input type="text" id="serviceDescription" className="form-control form-control-lg" name="description" value={user.description.value}
                                                onChange={(e) => { handleChange("description", e.target.value) }} />
                                            {/* <div className="text-danger" style={{ display: (!user.description.valid) ? "block" : "none" }}>
                                                {user.description.error}
                                            </div> */}
                                        </div>
                                        <div className="form-outline mb-3">
                                            <label className="form-label" htmlFor="price">Package Price</label>
                                            <input type="text" id="price" className="form-control form-control-lg" name="price" placeholder="₹" value={user.price.value}
                                                onChange={(e) => { handleChange("price", e.target.value) }} />
                                            {/* <div className="text-danger" style={{ display: (!user.contactno.valid) ? "block" : "none" }}>
                                                {user.contactno.error}
                                            </div> */}
                                        </div>
                                        
                                        <div className="form-outline mb-3">
                                            <label className="form-label" htmlFor="category">Package Category</label>

                                            <select type="text" id="price" className="form-control form-control-lg" name="category" placeholder="Select Category" value={user.category.value}
                                                onChange={(e) => { handleChange("category", e.target.value) }} >
                                                  
                                                <option value="">Add Package</option>
                                                {
                                                cat.map((v)=>{
                                                          return (
                                                            <option value={v.catname}>{v.catname}</option>
                                                          )
                                                          })
                                                          }
                                                </select>
                                            {/* <div className="text-danger" style={{ display: (!user.contactno.valid) ? "block" : "none" }}>
                                                {user.contactno.error}
                                            </div> */}
                                            </div>

                                            <div className="form-outline mb-3">
                                            <label className="form-label" htmlFor="labour_name">Allocate Labour</label>

                                            <select type="text" id="price" className="form-control form-control-lg" name="labour_name" placeholder="Select labour" value={user.labour_name.value}
                                                onChange={(e) => { handleChange("labour_name", e.target.value) }} >
                                                  
                                                <option value="">Select Labour</option>
                                                {
                                                lab.map((v)=>{
                                                          return (
                                                            <option value={v.name}>{v.name}</option>
                                                          )
                                                          })
                                                          }
                                                </select>
                                            {/* <div className="text-danger" style={{ display: (!user.contactno.valid) ? "block" : "none" }}>
                                                {user.contactno.error}
                                            </div> */}
                                            </div>
                                        <div className="d-flex justify-content-center">
                                            <button type="button" className="btn btn-outline-info btn-block btn-lg gradient-custom-4 text-body" onClick={(e) => { submitData(e) }}>Add Package </button>
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