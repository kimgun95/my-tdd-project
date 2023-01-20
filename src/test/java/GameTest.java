import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }
    private void rollMany(int frames, int pins) {
        for (int i = 0; i < frames; i++) {
            game.roll(pins);
        }
    }
    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }
    private void rollStrike() {
        game.roll(10);
    }
    @Test
    public void canRoll() {
        game.roll(0);
    }
    @Test
    public void gutterGame() {
        rollMany(20, 0);
        assertThat(game.getScore(), is(0));
    }
    @Test
    public void allOnes() {
        rollMany(20, 1);
        assertThat(game.getScore(), is(20));
    }
    @Test
    public void oneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertThat(game.getScore(), is(16));
    }
    @Test
    public void oneStrike() {
        rollStrike();
        game.roll(5);
        game.roll(3);
        rollMany(16, 0);
        assertThat(game.getScore(), is(26));
    }
    @Test
    public void perfectGame() {
        rollMany(10, 10);
        game.roll(10);
        game.roll(10);
        assertThat(game.getScore(), is(300));
    }
}
