package org.codingwallah.emproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EmplyeeRespository extends JpaRepository<EmployeeEntity , Long> {
    
}
