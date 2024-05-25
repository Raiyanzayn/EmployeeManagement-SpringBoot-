package org.codingwallah.emproject;

import java.util.List;

public interface  EmployeeService { // CRUD operation write under the interface , we have to implement this , we implement in employeeserviceimp
   String createEmployee(Employee employee); // create a employee
   List<Employee> readEmployees();  // for read , i need list of employee to read an employee
    boolean deleteEmployee(Long id); // for removing the data 
     String updateEmployee(Long id , Employee employee); // kis employee ku update kar na hai us k liye id , aur uska data(Employee employee) hoga 
                             //  us data ku update kar ne k liye 
      // pehecha ne k liye id , save kar k liye data
      Employee readEmployee(Long id);
}
