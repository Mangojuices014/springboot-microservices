package net.javaguides.employeeservice.Service;

import net.javaguides.employeeservice.Payload.APIResponseDto;
import net.javaguides.employeeservice.Payload.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);

}
