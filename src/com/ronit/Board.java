package com.ronit;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Board {
  private final int size;
  private final List<Snake> snakes;
  private final List<Ladder> ladder;
  private final Queue<Player> numberOfPlayers;
  private final Dice dice;
  private final Map<String, Integer> playerPositions;

  public Board(int size,
               List<Snake> snakes,
               List<Ladder> ladder,
               Queue<Player> numberOfPlayers,
               Dice dice,
               Map<String, Integer> playerPositions) {
    this.size = size;
    this.snakes = snakes;
    this.ladder = ladder;
    this.numberOfPlayers = numberOfPlayers;
    this.dice = dice;
    this.playerPositions = playerPositions;
  }

  /**
   * Business logic of the SNAKE and LADDER GAME
   */
  public void startGame() {
    while (numberOfPlayers.size() > 1) {
      Player player = numberOfPlayers.poll();
      String playerName = player.playerName;
      int roll = dice.rollDice();
      int playerCurrentPosition = playerPositions.get(playerName);
      int playerNextPosition = playerCurrentPosition + roll;
      if (playerNextPosition == size) {
        System.out.println(playerName + " has completed the game");
        playerPositions.put(playerName, size);
      } else if (playerNextPosition > size) {
        System.out.println(playerName + " will have to skip his turn");
      } else {
        for (Snake snake : snakes) {
          if (snake.start == playerNextPosition) {
            System.out.println(playerName + " bitten by snake at position " + playerNextPosition);
            playerNextPosition = snake.end;
            break;
          }
        }
        for (Ladder ladder : ladder) {
          if (ladder.start == playerNextPosition) {
            System.out.println(playerName + " climbing a ladder at position " + playerNextPosition);
            playerNextPosition = ladder.end;
            break;
          }
        }
        System.out.println(playerName + " is now at position " + playerNextPosition);
        playerPositions.put(playerName, playerNextPosition);
        numberOfPlayers.add(player);
      }
    }
    System.out.println("Game Over");
  }
}
