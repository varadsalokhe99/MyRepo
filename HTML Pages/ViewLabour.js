import { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom";

export default function ViewLabours() {
    const[emps, setEmps] = useState([]);
    let navigate = useNavigate();

    useEffect(()=> {
        fetch("http://localhost:8081/viewLabour")
        .then( resp => resp.json() )
        .then( data => setEmps(data));
    },[]);

    return (
        <div className="conatiner-fluid mt-3">
            <h1> Employee data </h1>
            <table class="table table-striped table-hover pt-2 container-m mt-3" >
                <thead>
                    <tr>
                        <th>
                            Name
                        </th>
                        <th>
                            Contact number
                        </th>
                        <th>
                            Pan number
                        </th>
                        <th>
                            Service Provider Id
                        </th>
                    </tr>
                </thead>
                <tbody>
            {
                   emps.map((v)=>{
                        return (
                            <tr>
                                <td>{v.name}</td>
                                <td>{v.contactno}</td>
                                <td>{v.pan_no}</td>
                                <td>{v.sid.sp_id}</td>
                                {/* <td>  <a onClick={()=>{navigate('/editemp',{state: v})}}>EDIT</a></td> */}
                                <td> <a onClick={()=>{navigate('/deleteemp',{state: v})}}>DELETE</a></td>
                            </tr>
                        )
                   }) 
             }
             </tbody>
            </table>
            <div class="d-flex">
                        <button type="button" class="btn  btn-outline-info btn-block btn-lg gradient-custom-4 text-body " onClick={navigate('/AddLabour')} >Add Employee</button>
                      </div>
        </div>
    )

}