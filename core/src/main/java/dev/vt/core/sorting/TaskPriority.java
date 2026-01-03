package dev.vt.core.sorting;

import java.util.*;

public class TaskPriority {

  public static void main(String[] args) {

    List<String> statusOrder = Arrays.asList("IN_PROGRESS", "NEW", "DONE", "BLOCKED");
    Map<String, Integer> orderMap = new HashMap<>();
    for (int i = 0; i < statusOrder.size(); i++) {
      orderMap.put(statusOrder.get(i), i);
    }
    getTasks()
        .sort(
            Comparator.comparingInt(
                    (Task t) ->
                        orderMap.getOrDefault(
                            t.getStatus(), Integer.MAX_VALUE)) // custom status order
                .thenComparingInt(Task::getPriority) // priority ascending
            );

    getTasks().forEach(System.out::println);
  }

  static List<Task> getTasks() {
    return new ArrayList<>(
        Arrays.asList(
            new Task("DONE", 2),
            new Task("NEW", 1),
            new Task("BLOCKED", 3),
            new Task("IN_PROGRESS", 2),
            new Task("NEW", 3),
            new Task("IN_PROGRESS", 1)));
  }
}

class Task {
  String status;
  int priority;

  Task(String status, int priority) {
    this.status = status;
    this.priority = priority;
  }

  @Override
  public String toString() {
    return status + " - " + priority;
  }

  public String getStatus() {
    return status;
  }

  public int getPriority() {
    return priority;
  }
}
