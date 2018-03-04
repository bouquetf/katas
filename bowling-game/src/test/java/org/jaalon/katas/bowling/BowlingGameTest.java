package org.jaalon.katas.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void zeroGameTest() {
        rollMany(20, 0);
        assertThat(game.score(), is(0));
    }

    @Test
    public void normalGame() {
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
    public void perfectGame() {
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

    private void rollMany(int numberOfRolls, int pins) {
        for (int i = 0; i < numberOfRolls; i++) {
            game.roll(pins);
        }
    }
}
