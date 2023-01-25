package bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BowlingGameTest {

  private Bowling bowling;

  @BeforeEach
  void setUp() {
    bowling = new Bowling();
  }
  private void rollMany(int rolls, int pins) {
    for (int i = 0; i < rolls; i++) {
      bowling.roll(pins);
    }
  }
  private void rollSpare() {
    bowling.roll(5);
    bowling.roll(5);
  }
  @Test
  public void canRoll() {
    Bowling bowling = new Bowling();
    bowling.roll(0);
  }
  @Test
  public void gutterGame() {
    rollMany(20, 0);
    assertThat(bowling.score(), is(0));
  }
  @Test
  public void allOnes() {
    rollMany(20, 1);
    assertThat(bowling.score(), is(20));
  }
  @Test
  public void oneSpare() {
    rollSpare();
    bowling.roll(3);
    rollMany(17, 0);
    assertThat(bowling.score(), is(16));
  }
  @Test
  public void oneStrike() {
  }
  @Test
  public void perfectGame() {

  }
}
