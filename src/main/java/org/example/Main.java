package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    private static Map<Integer, Employee> employeeMap;
    private static List<Employee> duplicatedEmployees;

    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Bilun", "Kara"));
        employees.add(new Employee(2, "İclal", "Kara"));
        employees.add(new Employee(1, "Bilun", "Kara"));
        employees.add(new Employee(2, "İclal", "Kara"));
        employees.add(new Employee(3, "Hasan", "Kara"));
        employees.add(new Employee(4, "Fatih", "Bakkal"));

        System.out.println(findDuplicates(employees).size());
        System.out.println(findUniques(employees).size());
        System.out.println(removeDuplicates(employees));
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        employeeMap = new HashMap<>();
        duplicatedEmployees = new ArrayList<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("Null record");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())) {
                duplicatedEmployees.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return duplicatedEmployees;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("Null record");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> unique = findUniques(employees);
        List<Employee> onlyUnique = new LinkedList<>(unique.values());
        onlyUnique.remove(duplicates);
        return onlyUnique;
    }
}

