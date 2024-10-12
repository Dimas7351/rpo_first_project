package com.misis.rpo;

import java.util.Scanner;

public class Engine {

    private final Scanner scanner = new Scanner(System.in);

    public void greeting() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games! May I have your name?");
        String name = sc.nextLine();
        System.out.println("Hello, " + name + "!");
        chooseGame();
    }

    public void chooseGame() {
        Game game = null;
        System.out.println("What game do you want to play? (Choose number):\n" +
                "1.LCMGame\n" +
                "2.ProgressionGame");
        int choice = scanner.nextInt();
        game = switch (choice) {
            case 1 -> new LCMGame();
            case 2 -> new ProgressionGame();
            default -> game;
        };
        if (game != null)
            playGame(game);
    }

    public void playGame(Game game) {
        game.introduce();
        game.run();
        wantPlayOneMoreTime(game);
    }

    public void checkCorrectness(int[] taskArray, int correctAnswer, Game game) {

        System.out.print("Question: ");

        game.outputTask(taskArray);

        System.out.print("\nYour answer: ");
        int userAnswer = scanner.nextInt();

        if (userAnswer == correctAnswer) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                    + correctAnswer + "'. Let's try again.");
        }
    }

    public void wantPlayOneMoreTime(Game game) {
        boolean isCorrectedLetter = false;
        Scanner sc = new Scanner(System.in);
        while (!isCorrectedLetter) {
            System.out.println("\nХотите ли вы сыграть еще раз? y/n");
            String input = sc.nextLine();
            if ("y".equalsIgnoreCase(input)) {
                System.out.println("\nХотите ли вы выбрать другую игру? y/n");
                String input2 = sc.nextLine();
                if ("y".equalsIgnoreCase(input2)) {
                    chooseGame();
                    isCorrectedLetter = true;
                } else if ("n".equalsIgnoreCase(input2)) {
                    playGame(game);
                    isCorrectedLetter = true;
                } else {
                    System.out.println("Некорректный ввод. Попробуйте еще раз:");
                }
            } else if ("n".equalsIgnoreCase(input)) {
                System.out.println("До скорой встречи!");
                isCorrectedLetter = true;
            } else {
                System.out.println("Некорректный ввод. Попробуйте еще раз:");
            }
        }
    }

}
