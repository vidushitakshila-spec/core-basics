package dev.vt.core.sorting;

import java.util.Map;

public class SortByMKeyValue {

  public static void main(String[] args) {
    Map<String, Integer> map = Map.of("A", 3, "B", 1, "C", 2,
            "AA", 24, "D", -1);
    System.out.println("Sort by value");
    map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .forEach(System.out::println);

    System.out.println("Sort by key");
    map.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(System.out::println);
  }
}
