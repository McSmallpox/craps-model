package edu.cnm.deepdive.craps.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *class that executes the craps game step-by-step
 */
public class Game {

  private int pointValue;
  private State state;
  private Random rng;
  private List<int[]> rolls;
  private long wins;
  private long losses;

  /**
   *  initializing rng and a list in which to store die rolls.
   * @param rng initializing the method we will use to generate our die rolls.
   */
  public Game(Random rng) {
    this.rng = rng;
    rolls = new LinkedList<>();
  }

  /**
   *resetting the game to its initial state, @link{State#COME_OUT}
   */
  public void reset() {
    state = State.COME_OUT;
    pointValue = 0;
    rolls.clear();
  }
  private void roll() {
    int die0 = rng.nextInt(6) + 1;
    int die1 = rng.nextInt(6) + 1;
    int sum = die0 + die1;
    State newState = state.change(sum, pointValue);
    if (state == State.COME_OUT && newState == State.POINT) {
      pointValue = sum;
    }
    state = newState;
    int[] diceRoll = {die0, die1};
    rolls.add(diceRoll);
  }

  /**
   * Returns current state of game. will keep tallies based off how many times the game is played
   * and how many wins or losses the user has.
   * @return
   */
  public State play() {
    while (state != State.WIN && state != State.LOSS) {
      roll();
    }
    if (state == State.WIN) {
      wins++;
    } else {
      losses++;
    }
    return state;
  }

  public int getPointValue() {
    return pointValue;
  }

  public State getState() {
    return state;
  }

  public List<int[]> getRolls() {
    List<int[]> copy = new LinkedList<>();
    for (int[] roll : rolls) {
      copy.add(Arrays.copyOf(roll, 2));
    }
    return copy;
  }

  public long getWins() {
    return wins;
  }

  public long getLosses() {
    return losses;
  }
}