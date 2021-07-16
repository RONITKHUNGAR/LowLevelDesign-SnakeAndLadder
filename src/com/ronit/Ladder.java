package com.ronit;

public class Ladder extends Jumper {
  public Ladder(int start, int end) throws Exception {
    super(start, end);
    if (start > end) {
      throw new Exception();
    }
  }
}
