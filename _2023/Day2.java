package _2023;

import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int possibleGamesSum = 0;

        while (!"end".equals(input)) {
            String[] inputParts = input.split(":");

            String[] games = inputParts[1].split(";");
            int redMin = Integer.MIN_VALUE;
            int blueMin = Integer.MIN_VALUE;
            int greenMin = Integer.MIN_VALUE;

            for (String game : games) {
                String[] currRollParts = game.split(", ");
                for (String currRollPart : currRollParts) {
                    String trim = currRollPart.trim();
                    String[] params = trim.split("\\s+");
                    int cubesCount = Integer.parseInt(params[0]);
                    String cubesColor = params[1];
                    switch (cubesColor) {
                        case "blue" -> {
                            if (cubesCount > blueMin) {
                                blueMin = cubesCount;
                            }
                        }
                        case "red" -> {
                            if (cubesCount > redMin) {
                                redMin = cubesCount;
                            }
                        }
                        case "green" -> {
                            if (cubesCount > greenMin) {
                                greenMin = cubesCount;
                            }
                        }
                    }
                }
            }
            possibleGamesSum = updateSum(possibleGamesSum, redMin, blueMin, greenMin);

            input = scanner.nextLine();
        }
        System.out.println(possibleGamesSum);
    }

    private static int updateSum(int possibleGamesSum, int redMin, int blueMin, int greenMin) {
        possibleGamesSum += (redMin * greenMin * blueMin);
        redMin = Integer.MIN_VALUE;
        blueMin = Integer.MIN_VALUE;
        greenMin = Integer.MIN_VALUE;
        return possibleGamesSum;
    }
}
