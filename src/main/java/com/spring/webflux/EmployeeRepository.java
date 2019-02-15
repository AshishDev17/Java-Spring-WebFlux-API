package com.spring.webflux;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {
    static Map<String, Employee> employeeData;

    static {
        employeeData = new HashMap<>();
        employeeData.put("1", new Employee("1", "Employee 1"));
        employeeData.put("2", new Employee("2", "Employee 2"));
        employeeData.put("3", new Employee("3", "Employee 3"));
        employeeData.put("4", new Employee("4", "Employee 4"));
        employeeData.put("5", new Employee("5", "Employee 5"));
        employeeData.put("6", new Employee("6", "Employee 6"));
        employeeData.put("7", new Employee("7", "Employee 7"));
        employeeData.put("8", new Employee("8", "Employee 8"));
        employeeData.put("9", new Employee("9", "Employee 9"));
        employeeData.put("10", new Employee("10", "Employee 10"));
        employeeData.put("11", new Employee("11", "Employee 11"));
        employeeData.put("12", new Employee("12", "Employee 12"));
        employeeData.put("13", new Employee("13", "Employee 13"));
        employeeData.put("14", new Employee("14", "Employee 14"));
    }

    public Mono<Employee> findEmployeeById(String id){
        return Mono.just(employeeData.get(id));
    }

    public Flux<Employee> findAllEmployees(){
        return Flux.fromIterable(employeeData.values());
    }

    public Flux<Employee> deleteEmployee(String id){
        employeeData.remove(id);
        return Flux.fromIterable(employeeData.values());
    }

    public Flux<Employee> addEmployee(Employee employee){
        employeeData.put(Integer.toString(employeeData.size()), employee);
        return Flux.fromIterable(employeeData.values());
    }

    public Mono<Employee> updateEmployee(Employee employee){
        Employee existingEmployee = employeeData.get(employee.getId());

        if(existingEmployee != null){
            existingEmployee.setName(employee.getName());
        }

        return Mono.just(existingEmployee);
    }
}
