package com.test.service;

import java.util.List;

import com.test.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto creatEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeebyId ( Long employeeId);
    
    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeID, EmployeeDto updatedEmployee);

    void deleteEmployee(Long employeeId);
}
