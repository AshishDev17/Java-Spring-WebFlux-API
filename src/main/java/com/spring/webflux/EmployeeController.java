package com.spring.webflux;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController (EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{id}")
    private Mono<Employee> getEmployeeById(@PathVariable String id){
        return employeeRepository.findEmployeeById(id);
    }

    @GetMapping
    private Flux<Employee> getEmployee(){
        return employeeRepository.findAllEmployees();
    }

    @PostMapping
    @RequestMapping(value="/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    private Flux<Employee> addEmployee(@RequestBody Employee employee){
        return employeeRepository.addEmployee(employee);
    }

    @PutMapping("/update")
    @RequestMapping(value="/update", consumes={MediaType.APPLICATION_JSON_VALUE})
    private Mono<Employee> updateEmployee(@RequestBody Employee employee){
        return employeeRepository.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    private Flux<Employee> deleteEmployee(@PathVariable String id){
        return employeeRepository.deleteEmployee(id);
    }
}

