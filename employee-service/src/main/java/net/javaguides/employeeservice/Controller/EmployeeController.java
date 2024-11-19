package net.javaguides.employeeservice.Controller;

import net.javaguides.employeeservice.Entity.Employee;
import net.javaguides.employeeservice.Payload.APIResponseDto;
import net.javaguides.employeeservice.Payload.EmployeeDto;
import net.javaguides.employeeservice.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(
            @RequestBody EmployeeDto employeeDto
    ){
        EmployeeDto saveEmployeeDto = employeeService.saveEmployee(employeeDto);

        return  new ResponseEntity<>(saveEmployeeDto, HttpStatus.CREATED);
    }

    // Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        return  ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }
}
