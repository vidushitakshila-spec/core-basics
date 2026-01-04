package dev.vt.core.basic;

import java.util.List;

public class WhileGuys {

  public static void main(String[] args) {
    takeWhileExample();
    dropWhileExample();
  }

  static void
      takeWhileExample() { // list has to be sorted ,if you want greater than/less than results
    List<Integer> numbers = List.of(110, 130, 300, 230, 420, 800);
    List<Integer> taken = numbers.stream().takeWhile(n -> n <= 300).toList();
    System.out.println(taken);
  }

  static void
      dropWhileExample() { // list has to be sorted ,if you want greater than/less than results
    List<Integer> numbers = List.of(110, 830, 300, 230, 420, 800);
    List<Integer> taken = numbers.stream().dropWhile(n -> n <= 300).toList();
    System.out.println(taken);
  }
}
