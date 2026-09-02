import React, { useEffect, useState } from "react"
import { listEmployees } from "../services/EmployeeService"
const ListEmployeeComponent= () =>{


    const[employees,setEmployees]=useState([])

    useEffect(()=>{
listEmployees().then((response)=>{
    setEmployees(response.data);
}).catch(error=>{
    console.error(error);
})
    },[])
    
    return(
        <div className='container'>
            
       <h2>List of Employee</h2>     
          <table className='table table-striped table-bordered'>
            <thead>
                <tr>
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