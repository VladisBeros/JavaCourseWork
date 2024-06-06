package com.university.departmnetmanagement.service;

import com.university.departmnetmanagement.models.Department;
import com.university.departmnetmanagement.models.Employee;
import com.university.departmnetmanagement.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeService employeeService;

    public List<Department> listDepartments() {
        return departmentRepository.findAll();
    }

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.removeById(id);
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Відділ не знайдено"));
    }

    public void addEmployeesToDepartment(Long departmentId, List<Long> employeeIds) {
        Department department = getDepartmentById(departmentId);
        if (department != null) {
            List<Employee> employees = employeeService.listEmployees();
            List<Employee> departmentEmployees = new ArrayList<>(department.getEmployees());
            employeeIds.forEach(id -> employees.stream()
                    .filter(employee -> employee.getId().equals(id))
                    .findFirst()
                    .ifPresent(departmentEmployees::add));
            department.setEmployees(departmentEmployees);
            departmentRepository.save(department);
        }
    }
}