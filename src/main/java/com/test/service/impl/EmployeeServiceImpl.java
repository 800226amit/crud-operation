package com.test.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.test.dto.EmployeeDto;
import com.test.entity.Employee;
import com.test.exception.ResourceNotFoundException;
import com.test.mapper.EmployeeMapper;
import com.test.repository.EmployeeRepository;
import com.test.service.EmployeeService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto creatEmployee(EmployeeDto employeeDto) {
        // TODO Auto-generated method stub
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }


    @Override
    public EmployeeDto getEmployeebyId(Long employeeId) {
        // TODO Auto-generated method stub
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> new ResourceNotFoundException("Employee Dose not Exist with given Id" + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }


    @Override
    public List<EmployeeDto> getAllEmployees() {
        // TODO Auto-generated method stub

            List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }


    @Override
    public EmployeeDto updateEmployee(Long employeeID, EmployeeDto updatedEmployee) {
        // TODO Auto-generated method stub

       Employee employee = employeeRepository.findById(employeeID).orElseThrow(() -> new ResourceNotFoundException("Employee Does NOt Exit whit Given id " + employeeID));
        
        // employee.setFirstName(updatedEmployee.getFirstName());

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
        }


    @Override
    public void deleteEmployee(Long employeeId) {
        // TODO Auto-generated method stub
        
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee Does NOt Exit whit Given id " + employeeId));

        employeeRepository.deleteById(employeeId);
    }

}
