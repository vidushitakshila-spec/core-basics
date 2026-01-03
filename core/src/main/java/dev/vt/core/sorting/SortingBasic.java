package dev.vt.core.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingBasic {

  public static void main(String[] args) {

    getEmployees().stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed())
        .forEach(
            n ->
                System.out.println(
                    "  |name :" + n.name + "   |salary :" + n.salary + "   |age : " + n.age));
    System.out.println("_________________");
    getEmployees().stream()
        .sorted(
            Comparator.comparing(Employee::getSalary)
                .reversed()
                .thenComparing(Comparator.comparing(Employee::getAge)))
        .forEach(
            n ->
                System.out.println(
                    "  |name :" + n.name + "   |salary :" + n.salary + "   |age : " + n.age));
    System.out.println("_________________");

    getEmployees().stream()
        .sorted(
            Comparator.comparing(Employee::getSalary)
                .thenComparing(Comparator.comparing(Employee::getAge))
                .reversed())
        .forEach(
            n ->
                System.out.println(
                    "  |name :" + n.name + "   |salary :" + n.salary + "   |age : " + n.age));

    System.out.println("_________________");
    getEmployees().stream()
        .sorted(
            Comparator.comparing(Employee::getSalary)
                .thenComparing(Comparator.comparing(Employee::getAge)))
        .forEach(
            n ->
                System.out.println(
                    "  |name :" + n.name + "   |salary :" + n.salary + "   |age : " + n.age));

    System.out.println("_________________");
    getEmployees().stream()
        .sorted(Comparator.comparing(Employee::getSalary))
        .forEach(
            n ->
                System.out.println(
                    "  |name :" + n.name + "   |salary :" + n.salary + "   |age : " + n.age));
  }

  static List<Employee> getEmployees() {
    return Arrays.asList(
        new Employee("Anurag", 28, 50000),
        new Employee("Rahul", 32, 75000),
        new Employee("Amit", 35, 80000),
        new Employee("Anjali", 29, 55000),
        new Employee("Anuradha", 48, 75000),
        new Employee("Sagar", 32, 20000),
        new Employee("Ashmit", 32, 80000),
        new Employee("Zen", 27, 58000));
  }
}

class Employee {
  String name;
  int age;
  double salary;

  Employee(String name, int age, double salary) {
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  public int getAge() {
    return age;
  }

  public double getSalary() {
    return salary;
  }
}
