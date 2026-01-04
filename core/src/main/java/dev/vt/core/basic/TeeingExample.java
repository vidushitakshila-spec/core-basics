package dev.vt.core.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TeeingExample {
  /*
  public static <T, A1, A2, R>
  Collector<T, ?, R> teeing(
      Collector<? super T, A1, ? extends R1> downstream1,
      Collector<? super T, A2, ? extends R2> downstream2,
      BiFunction<? super R1, ? super R2, R> merger
  )
 * */

  public static void main(String[] args) {
    minMaxByDept();
  }
  static void minMaxByDept() {
    List<Employee> employees = getEmployees();
    Map<?, ?> minMaxByDept =
            (Map<?, ?>) employees.stream()
                    .collect(Collectors.groupingBy(Employee::dept,
                            Collectors.teeing(
                                    Collectors.minBy(Comparator.comparing(Employee::salary)),
                                    Collectors.maxBy(Comparator.comparing(Employee::salary)),
                                    (min, max) ->
                                            Map.of(
                                                    "min", min.orElse(null),
                                                    "max", max.orElse(null)))));

    System.out.println(minMaxByDept);
  }




  static List<Employee> getEmployees() {
    return Arrays.asList(
            new Employee("Anurag", 28, 50000,"HR"),
            new Employee("Rahul", 32, 75000,"core"),
            new Employee("Amit", 35, 90000,"IT"),
            new Employee("Anjali", 29, 55000,"core"),
            new Employee("Anuradha", 48, 75000,"IT"),
            new Employee("Sagar", 32, 20000,"core"),
            new Employee("Ashmit", 32, 80000,"IT"),
            new Employee("Zen", 27, 58000,"HR"));
  }
}

record Employee(String name,int age, int salary,String dept) {}