package com.misis.rpo;

import java.security.SecureRandom;
import java.util.Scanner;

public class ProgressionGame implements Game{

    private final SecureRandom random = new SecureRandom();
    private final Engine engine = new Engine();

    @Override
    public void introduce() {
        System.out.println("What number is missing in the progression?");
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            int progressionLength = random.nextInt(6) + 5;
            int start = random.nextInt(10) + 1;
            int ratio = random.nextInt(5) + 2;
            int hiddenIndex = random.nextInt(progressionLength);

            int[] progression = generateProgression(start, ratio, progressionLength);
            int correctAnswer = progression[hiddenIndex];
            progression[hiddenIndex] = -1;

            engine.checkCorrectness(progression, correctAnswer, this);
        }
    }

    public void outputTask(int[] taskArray){
        for (int j = 0; j < taskArray.length; j++) {
            if (taskArray[j] == -1) {
                System.out.print(".. ");
            } else {
                System.out.print(taskArray[j] + " ");
            }
        }
    }

    private int[] generateProgression(int start, int ratio, int length) {
        int[] progression = new int[length];
        progression[0] = start;
        for (int i = 1; i < length; i++) {
            progression[i] = progression[i - 1] * ratio;
        }
        return progression;
    }
}
