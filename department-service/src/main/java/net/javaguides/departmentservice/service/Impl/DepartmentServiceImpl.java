package net.javaguides.departmentservice.service.Impl;

import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.exception.ResourceNotFoundException;
import net.javaguides.departmentservice.reponsitory.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper mapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, ModelMapper mapper) {
        this.departmentRepository = departmentRepository;
        this.mapper = mapper;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = mapper.map(departmentDto, Department.class);
        Department saveDepartment = departmentRepository.save(department);
        return mapper.map(saveDepartment, DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        try {
            Department department = departmentRepository.findByDepartmentCode(departmentCode);
            return mapper.map(department, DepartmentDto.class);
        }catch (Exception e){
            new ResourceNotFoundException("Department", "Code", departmentCode);
        }
        return null;
    }
}
