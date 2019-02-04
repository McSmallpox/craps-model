package edu.cnm.deepdive.craps.model;

/**
 * class designating keywords that we refer to when determining game state.
 */
public enum State {
  COME_OUT {
    @Override
    public State change(int roll, int poinValue) {
      switch (roll) {
        case 2:  //cases must be defined and constant upon compile time, ie straight values. No methods can be invoked
          //in a case.
        case 3:
        case 12:
          return LOSS;
        case 7:
        case 11:
          return WIN;
        default:
          return POINT;
      }
    }
  },
  POINT{
    @Override
    public State change(int roll, int pointValue) {
     if (roll == 7) {
       return LOSS;
      }
     if (roll == pointValue) {
       return WIN;
     }
     return this;
    }
  },
  WIN,
  LOSS;

  /**
   *
   * @param roll method that generates two random numbers as if throwing two six-sided dice.
   * @param pointValue sum of two separate die rolls
   * @return
   */
  public State change(int roll, int pointValue) {
    return this;

  }
}
