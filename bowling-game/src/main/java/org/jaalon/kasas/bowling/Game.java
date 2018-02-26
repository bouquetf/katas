package org.jaalon.kasas.bowling;

public class Game {
    int rollNumber = 0;
    int rolls[] = new int[21];
    public void roll(int pins) {
        rolls[rollNumber++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10 ; frame ++) {
            if (isStrike(frameIndex)) {
                score += strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex+=2;
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private int sumOfBallsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex+1];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex+2];
    }

    private int strikeBonus(int frameIndex) {
        return 10 + rolls[frameIndex+1] + rolls[frameIndex+2];
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex+1] == 10;
    }
}
