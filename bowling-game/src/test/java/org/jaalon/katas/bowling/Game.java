package org.jaalon.katas.bowling;

class Game {
    private int rolls[] = new int[21];
    private int currentRoll = 0;

    void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    int score() {
        int score = 0;
        int frameIndex = 0;

        for (int frame = 0 ; frame < 10 ; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex ++;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }

        return score;
    }

    private int sumOfBallsInFrame(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }

    private int spareBonus(int rollIndex) {
        return rolls[rollIndex+2];
    }

    private int strikeBonus(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    }

    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex+1] == 10;
    }
}
