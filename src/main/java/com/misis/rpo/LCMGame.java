package com.misis.rpo;

import java.security.SecureRandom;
import java.util.Scanner;

public class LCMGame implements Game{

    private final SecureRandom random = new SecureRandom();
    private final Engine engine = new Engine();

    @Override
    public void introduce() {
        System.out.println("Find the smallest common multiple of given numbers.");
    }

    @Override
    public void run() {
        int[] taskArray = new int[3];

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                taskArray[0] = random.nextInt(20) + 1;
                taskArray[1] = random.nextInt(20) + 1;
                taskArray[2] = random.nextInt(20) + 1;
            }

            int correctAnswer = lcm(taskArray[0], lcm(taskArray[1], taskArray[2]));
            engine.checkCorrectness(taskArray,correctAnswer, this);
        }
    }

    @Override
    public void outputTask(int[] taskArray) {
        for (int i : taskArray)
            System.out.print(i + " ");
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

}
