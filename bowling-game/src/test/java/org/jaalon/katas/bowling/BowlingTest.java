package org.jaalon.katas.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingTest {
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void gutterGame() {
        rollMany(20, 0);
        assertThat(game.score(), is(0));
    }

    private void rollMany(int numberOfRolls, int pins) {
        for (int i = 0; i < numberOfRolls; i++) {
            game.roll(pins);
        }
    }

    @Test
    public void oneGame() {
        rollMany(20, 1);
        assertThat(game.score(), is(20));
    }

    @Test
    public void spare() {
        rollSpare();
        game.roll(3);

        rollMany(17, 0);

        assertThat(game.score(), is(16));
    }

    @Test
    public void strike() {
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertThat(game.score(), is(24));
    }

    @Test
    public void bestGame() {
        rollMany(12, 10);
        assertThat(game.score(), is(300));
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }
}
