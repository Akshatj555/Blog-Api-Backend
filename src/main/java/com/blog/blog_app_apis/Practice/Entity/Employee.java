package com.blog.blog_app_apis.Practice.Entity;

import java.util.List;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private String department;
    private int age;
    private int experience;
    private String city;

    public Employee(int id, String name, double salary, String department, int age, int experience, String city) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.age = age;
        this.experience = experience;
        this.city = city;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public int getAge() { return age; }
    public int getExperience() { return experience; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + '\'' + ", salary=" + salary +
                ", department='" + department + '\'' + ", age=" + age +
                ", experience=" + experience + ", city='" + city + '\'' + '}';
    }

    public static List<Employee> getEmployees() {
        return List.of(
                new Employee(1, "Alice", 70000, "IT", 30, 5, "New York"),
                new Employee(2, "Bob", 80000, "HR", 40, 12, "Chicago"),
                new Employee(3, "Charlie", 50000, "Finance", 28, 3, "New York"),
                new Employee(4, "David", 90000, "IT", 35, 8, "San Francisco"),
                new Employee(5, "Eve", 60000, "Marketing", 26, 2, "Los Angeles"),
                new Employee(6, "Frank", 75000, "Finance", 45, 15, "Chicago"),
                new Employee(7, "Grace", 110000, "IT", 38, 10, "Boston"),
                new Employee(8, "Hank", 50000, "HR", 50, 18, "New York"),
                new Employee(9, "Ivy", 95000, "Marketing", 29, 6, "Los Angeles"),
                new Employee(10, "Jack", 105000, "Finance", 42, 20, "Boston")
        );
    }
}