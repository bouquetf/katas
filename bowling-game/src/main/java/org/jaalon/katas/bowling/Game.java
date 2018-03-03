package org.jaalon.katas.bowling;

class Game {
    private int rolls[] = new int[21];
    private int rollIndex;

    void roll(int pins) {
        rolls[rollIndex++] = pins;
    }

    int score() {
        int score = 0;
        int index = 0;
        for (int frameIndex=0; frameIndex<10; frameIndex++) {
            if(isStrike(index)) {
                score += 10 + strikeBonus(index);
                index ++;
            } else if (isSpare(index)) {
                score += 10 + spareBonus(index);
                index += 2;
            } else {
                score += rolls[index] + rolls[index+1];
                index += 2;
            }
        }
        return score;
    }

    private int strikeBonus(int index) {
        return rolls[index + 1] + rolls[index + 2];
    }

    private boolean isStrike(int index) {
        return rolls[index] == 10;
    }

    private int spareBonus(int index) {
        return rolls[index+2];
    }

    private boolean isSpare(int i) {
        return rolls[i] + rolls[i+1] == 10;
    }
}
