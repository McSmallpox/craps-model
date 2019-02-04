package edu.cnm.deepdive.craps.model;

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

  public State change(int roll, int pointValue) {
    return this;

  }
}
