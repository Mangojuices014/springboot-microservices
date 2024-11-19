package net.javaguides.employeeservice.Service;

import net.javaguides.employeeservice.Payload.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("DEPARTMENT-SERVICE")
public interface APIClient {
    // Build get department rest api
    @GetMapping("/api/v1/department/{code}")
    DepartmentDto getDepartment(@PathVariable("code") String departmentCode);
}
