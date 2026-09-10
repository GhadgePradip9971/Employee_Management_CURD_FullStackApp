import React, { useEffect, useState } from "react"
import {listEmployees} from '../services/EmployeeService'
import { useNavigate} from 'react-router-dom'
const ListEmployeeComponent= () =>{


    const[employees,setEmployees]=useState([])
  const navigator=useNavigate()

    useEffect(()=>{
listEmployees().then((response)=>{
    setEmployees(response.data);
}).catch(error=>{
    console.error(error);
})
    },[])
    
    function addNewEmployee(){
navigator("/add-employee")

    }
    return(
        <div className='container'>
            
    <figure class="text-center">  <h2>List of Employee</h2>  </figure> 
    <button type="button" class="btn btn-primary" onClick={addNewEmployee}>Add Employee</button>
          <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                <th>Employee ID</th>
                <th>Employee First Name</th>
                <th>Employee LastName</th>
                <th>Employee Email</th></tr>
            </thead>
              
            <tbody>
                {
                    employees.map(employee=>
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                        </tr>)
                }
            </tbody>
            
            </table>
             </div>

    )

}

export default ListEmployeeComponent