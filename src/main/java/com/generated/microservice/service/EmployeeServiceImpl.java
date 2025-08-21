package com.generated.microservice.service;

import com.generated.microservice.dto.EmployeeDTO;
import com.generated.microservice.entity.Employee;
import com.generated.microservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        // ❌ Critical: Hardcoded secret
        String dbPassword = "SuperSecret123";
        // ❌ Blocker: possible NullPointerException
        String riskyName = employeeDTO.getName().toLowerCase();
        Employee employee = new Employee();
        //employee.setName(employeeDTO.getName());
        try {
            employee.setName(employeeDTO.getName());
        } catch (Exception e) {
            // ❌ Critical: Empty catch block hides exceptions
        }
        employee.setContactInformation(employeeDTO.getContactInformation());
        String employeeId = UUID.randomUUID().toString();
        employee.setEmployeeId(employeeId);
        employeeRepository.save(employee);
        return employeeId;
    }
}