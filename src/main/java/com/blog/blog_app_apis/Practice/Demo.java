package com.blog.blog_app_apis.Practice;

import com.blog.blog_app_apis.Practice.Entity.Employee;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {


    public static void main(String[] args) {

        List<Employee> employeeList = Employee.getEmployees();

//        employeeList.stream().map(Employee::getName).forEach(System.out::println);

//        employeeList.stream().filter(employee -> employee.getDepartment().equals("IT")).forEach(System.out::println);

//        List<String> employees = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
//        System.out.println(employees);

//        System.out.println(employeeList.stream().count());

//        Employee employee = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);


//        Employee minSalEmployee = employeeList.stream().min(Comparator.comparing(Employee::getSalary)).orElse(null);
//        System.out.println(minSalEmployee);

//        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

//        employeeList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

//        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).forEach(System.out::println);

//        employeeList.stream().filter(employee -> employee.getName().startsWith("A")).forEach(System.out::println);

//        Map<String, List<Employee>> employeeByDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
//        System.out.println(employeeByDepartment);

//        employeeList.stream().collect(Collectors.groupingBy(employee -> employee.getDepartment(), empl))


//        double sum = employeeList.stream().mapToDouble(Employee::getSalary).sum();

//        Map<String, List<Employee>> employeesByCity = employeeList.stream().collect(Collectors.groupingBy(Employee::getCity));
//        System.out.println(employeesByCity);

//        employeeList.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).forEach(System.out::println);

        List<String> names = Arrays.asList("Akshat","Yash", "Satyam", "Yash");
        Map<String, Long> namesWithCount = names.stream().collect(Collectors.groupingBy(name -> name, Collectors.counting()));
//        System.out.println(namesWithCount);

        names.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }




}
