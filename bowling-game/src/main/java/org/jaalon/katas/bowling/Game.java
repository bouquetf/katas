package org.jaalon.katas.bowling;

class Game {
    private int rolls[] = new int[21];
    private int rollIndex = 0;

    void roll(int pins) {
        rolls[rollIndex ++] = pins;
    }

    int score() {
        int score = 0;
        int index = 0;
        for (int currentFrame = 0 ; currentFrame < 10; currentFrame++) {
            if (isStrike(rolls[index])) {
                score += 10 + strikeBonus(index);
                index ++;
            } else if (isSpare(index)) {
                score += 10 + spareBonus(index);
                index += 2;
            } else {
                score += frameScore(index);
                index += 2;
            }
        }

        return score;
    }

    private int frameScore(int index) {
        return rolls[index] + rolls[index + 1];
    }

    private int spareBonus(int index) {
        return rolls[index + 2];
    }

    private int strikeBonus(int index) {
        return rolls[index + 1] + rolls[index + 2];
    }

    private boolean isSpare(int index) {
        return rolls[index] + rolls[index+1] == 10;
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }
}
