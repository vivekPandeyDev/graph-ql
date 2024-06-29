package com.vivek.learn.graph_ql.controller;

import com.vivek.learn.graph_ql.domain.CreateEmployeeInput;
import com.vivek.learn.graph_ql.domain.Department;
import com.vivek.learn.graph_ql.domain.Employee;
import com.vivek.learn.graph_ql.domain.UpdateSalaryInput;
import com.vivek.learn.graph_ql.repo.DepartmentRepository;
import com.vivek.learn.graph_ql.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.function.Function;

@RequiredArgsConstructor
@Slf4j
@Controller
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    private static final String NOT_FOUND = "cannot find %s by %d";
    private static final String DEPARTMENT = "department";
    private static final String EMPLOYEE = "employee";

    @SchemaMapping(typeName = "Mutation", field = "createEmployee")
    public Employee createEmployee(@Argument CreateEmployeeInput employeeInput) {
        var deptId = employeeInput.departmentId();
        var department = departmentRepository.findById(deptId).orElseThrow(() -> new ServiceException(NOT_FOUND.formatted(DEPARTMENT,deptId) ,ErrorType.NOT_FOUND));
        var employee = employeeMapping.apply(employeeInput);
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    @MutationMapping
    public Department createDepartment(@Argument String name) {
        var department = new Department();
        department.setName(name);
        return departmentRepository.save(department);
    }

    @MutationMapping
    public Employee updateSalary(@Argument UpdateSalaryInput updateSalaryInput) {
        var updatedEmployee = updatedEmployee(updateSalaryInput);
        return employeeRepository.save(updatedEmployee);
    }

    @QueryMapping
    public Iterable<Employee> employees(){
        return employeeRepository.findAll();
    }

    @QueryMapping
    public Employee employeeById(@Argument Integer id){
        return employeeRepository.findById(id).orElseThrow(() -> new ServiceException(NOT_FOUND.formatted(EMPLOYEE,id),ErrorType.NOT_FOUND));
    }

    @QueryMapping
    public Iterable<Employee>  employeeByName(@Argument(name = "employeeName") String name){
        return employeeRepository.findByNameIgnoreCase(name);
    }


    @QueryMapping
    public Iterable<Department> departments(){
        return departmentRepository.findAll();
    }

    @QueryMapping
    public Department departmentById(@Argument Integer id){
        return departmentRepository.findById(id).orElseThrow(() -> new ServiceException(NOT_FOUND.formatted(DEPARTMENT,id), ErrorType.NOT_FOUND));
    }

    @QueryMapping
    public Iterable<Department>  departmentByName(@Argument(name = "departmentName") String name){
        return departmentRepository.findByNameIgnoreCase(name);
    }




    public Employee updatedEmployee(UpdateSalaryInput updateSalaryInput) {
        var empId = updateSalaryInput.getEmployeeId();
        var dbEmployee = employeeRepository.findById(empId).orElseThrow(() -> new ServiceException(NOT_FOUND.formatted(EMPLOYEE,empId),ErrorType.NOT_FOUND));
        dbEmployee.setSalary(updateSalaryInput.getSalary());
        return dbEmployee;

    }



    Function<CreateEmployeeInput, Employee> employeeMapping = (
            input ->
                    Employee.builder()
                            .name(input.name())
                            .salary(input.salary())
                            .build()
    );


}
