import './App.css';
import RegiStration from './Component/CustomerRegister';
import { Link, Route, Routes } from 'react-router-dom';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import Login from './Component/Login';
import Order from './Component/Order';
import OrderStatus from './Component/OrderStatus';
import Services from './Component/Services';
import Feedback from './Component/Feedback';
import { Logout } from './Component/Logout';
import { useSelector } from "react-redux"
import EditProfile from './WebPages/EditProfile';
import Welcome from './WebPages/WelcomePage';
import SPWelcome from './WebPages/SPHome';
import Home from './WebPages/Home';
import CustWelcome from './WebPages/CustHome';
import AdminWelcome from './WebPages/AdminHome';
import RegiStrationS from './Component/ServiceProviderRegister';
import AddLabour from './Component/AddLabour';
import ViewLabours from './Component/ViewLabour';
import AddServices from './Component/AddService';

function App() {
  const mystate = useSelector(state=>state.logged)
  
 

  return (

    <Services/>
 
  //   <div>
  //     <div className='nav navbar container mt-3'>
  //       <ul className='nav container nav nav-tabs nav justify-content-end' style={{ backgroundColor: 'white', color:'red' }}>

          
  //           {/* <li className="nav-item"  style={{display: mystate.loggedIn ?"none":"block"}} >
  //               <Link to="/reg" className="nav-link">REGISTER</Link>
  //           </li>
  //           <li className="nav-item"  style={{display: mystate.loggedIn ?"none":"block"}} >
  //               <Link to="/regs" className="nav-link">REGISTER AS SERVICE PROVIDER</Link>
  //           </li> */}
  //           <li className="nav-item" style={{display: mystate.loggedIn ?"none":"block"}} >
  //               <Link to="/login" className="nav-link">LOGIN</Link>
  //           </li>
  //           <li className="nav-item" >
  //               <Link to="/services" className="nav-link">Services</Link>
  //           </li>

            

  //           <li className="nav-item" style={{display: mystate.loggedIn ?"block":"none"}}>
  //               <Link to="/order" className="nav-link">Order</Link>
  //           </li>
  //           <li className="nav-item"  style={{display: mystate.loggedIn ?"block":"none"}}>
  //               <Link to="/orderStatus" className="nav-link">Order Status</Link>
  //           </li>
  //           <li className="nav-item"  style={{display: mystate.loggedIn ?"block":"none"}}>
  //               <Link to="/feedback" className="nav-link">FeedBack</Link>
  //           </li>
  //           <li className="nav-item"  style={{display: mystate.loggedIn ?"block":"none"}}>
  //               <Link to="/logout" className="nav-link">Logout</Link>
  //           </li>
          
          
  //       </ul>
  //     </div>
  //     <Routes>
  //       <Route path="/login" element={<Login/> }/> 
  //       <Route path="/reg" element={<RegiStration/> }/> 
  //       <Route path="/regs" element={<RegiStrationS/> }/> 
  //       <Route path="/sphome" element={<SPWelcome/>}/>
  //       <Route path="/services" element={<Services/> }/> 
  //       <Route path="/feedback" element={<Feedback/> }/>

  //       <Route path="/order" element={<Order/>} />    
  //       <Route path="/orderStatus" element={<OrderStatus/>} />    
  //       <Route path="/logout" element={<Logout/>} />    

  //     </Routes> 
  //   </div>

     
    
    

    
 );
}

export default App;
