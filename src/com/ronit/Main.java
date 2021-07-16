package com.ronit;

import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Dice dice = new Dice(1);
    Player p1 = new Player(1, "PlayerName1");
    Player p2 = new Player(2, "PlayerName2");
    Queue<Player> allPlayers = new LinkedList<>();
    allPlayers.offer(p1);
    allPlayers.offer(p2);
    Snake snake1 = new Snake(10, 2);
    Snake snake2 = new Snake(99, 12);
    List<Snake> snakes = new ArrayList<>();
    snakes.add(snake1);
    snakes.add(snake2);
    Ladder ladder1 = new Ladder(5, 25);
    Ladder ladder2 = new Ladder(40, 89);
    List<Ladder> ladders = new ArrayList<>();
    ladders.add(ladder1);
    ladders.add(ladder2);
    Map<String, Integer> playersCurrentPosition = new HashMap<>();
    playersCurrentPosition.put("PlayerName1", 0);
    playersCurrentPosition.put("PlayerName2", 0);
    Board gb = new Board(100, snakes, ladders, allPlayers, dice, playersCurrentPosition);
    gb.startGame();
  }
}
