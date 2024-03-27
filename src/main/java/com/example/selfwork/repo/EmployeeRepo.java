package com.example.selfwork.repo;

import com.example.selfwork.entity.Employee;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

  void deleteEmployeeById(Long id);

  Optional<Employee> findEmployeeById(Long id);
}
