package net.javaguides.employeeservice.Repository;

import net.javaguides.employeeservice.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
