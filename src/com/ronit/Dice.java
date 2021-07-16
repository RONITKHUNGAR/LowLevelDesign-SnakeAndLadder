package com.ronit;

public class Dice {
  private int numberOfDice;

  Dice(int numberOfDice) {
    this.numberOfDice = numberOfDice;
  }

  /**
   * @return a random integer value depending on the numberOfDice.
   * for example if numberOfDice= 1,then a random integer between 1-6,
   * if numberOfDice=2, then a random number between 2-12.
   */
  public int rollDice() {
    return ((int) (Math.random() * (6 * numberOfDice - 1 * numberOfDice))) + 1;
  }
}
