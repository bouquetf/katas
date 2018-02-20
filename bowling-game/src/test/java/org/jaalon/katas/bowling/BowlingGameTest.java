package org.jaalon.katas.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {

    private Game g;

    @Before
    public void setUp() {
        g = new Game();
    }

    @Test
    public void testNullGame() {
        rollMany(20, 0);

        assertThat(g.score(), is(0));
    }

    @Test
    public void testRollOne() {
        rollMany(20, 1);

        assertThat(g.score(), is(20));
    }

    @Test
    public void testSpare() {
        rollSpare();
        g.roll(3);
        rollMany(17, 0);

        assertThat(g.score(), is(16));
    }

    @Test
    public void testStrike() {
        rollStrike();
        g.roll(3);
        g.roll(4);

        rollMany(16, 0);

        assertThat(g.score(), is(24));
    }

    @Test
    public void testPerfectGame() {
        rollMany(12, 10);
        assertThat(g.score(), is(300));
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            g.roll(pins);
        }
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }

    private void rollStrike() {
        g.roll(10);
    }
}
