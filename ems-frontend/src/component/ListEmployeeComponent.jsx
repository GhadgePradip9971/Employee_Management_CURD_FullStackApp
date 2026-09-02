import React from "react"
const ListEmployeeComponent= () =>{

    const dummyData=[{
        "id":1,
        "firstName":"rahul",
        "lastName":"rane",
        "email":"rahulrane@gmail.com"
    }
,
       {
        "id":2,
        "firstName":"rmesh",
        "lastName":"rathi",
        "email":"rameshrathi@gmail.com"
    },
     {
        "id":3,
        "firstName":"raj",
        "lastName":"shinde",
        "email":"rajshinde@gmail.com"
}


    ]
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
                    dummyData.map(employee=>
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