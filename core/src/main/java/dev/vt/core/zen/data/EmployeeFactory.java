package dev.vt.core.zen.data;

public final class EmployeeFactory {

  private EmployeeFactory() {
  }

  public static Employee of(long id, String name, String dept, double salary, int experience) {
    return new Employee(id, name, dept, salary, experience);
  }
}
