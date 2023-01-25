package bowling;

public class Bowling {

  private int[] rolls = new int[21];
  private int currentRoll = 0;

  public void roll(int pins) {
    rolls[currentRoll++] = pins;
  }
  public Integer score() {
    int score = 0;
    int curRoll = 0;
    for (int frame = 0; frame < 10; frame++) {
      if (rolls[curRoll] + rolls[curRoll + 1] == 10) {//spare
        score += 10 + rolls[curRoll + 2];
        curRoll += 2;
      } else {
        score += rolls[curRoll] + rolls[curRoll + 1];
        curRoll += 2;
      }
    }
    return score;
  }
}
