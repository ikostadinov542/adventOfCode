package _2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Integer> list = new ArrayList<>();

        int sum = 0;

        while (!"end".equals(input)) {
            String regexDigit = "one|two|three|four|five|six|seven|eight|nine|[0-9]";
            Pattern pattern = Pattern.compile(regexDigit, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String currMatch = matcher.group();
                if (currMatch.length() == 1) {
                    list.add(Integer.valueOf(currMatch));
                } else {
                    list.add(getNum(currMatch));
                }
            }

            if (list.size() > 1) {
                String firstIndexAsString = String.valueOf(list.get(0));
                String secondIndexAsString = String.valueOf(list.get(list.size() - 1));
                String concat = firstIndexAsString + secondIndexAsString;
                int value = Integer.parseInt(concat);
                sum += value;
                list.clear();
            } else {
                String firstIndexAsString = String.valueOf(list.get(0));
                int value = Integer.parseInt(firstIndexAsString);
                sum += value;
                list.clear();
            }

            input = scanner.nextLine();
        }

        System.out.println(sum);
    }

    private static int getNum(String input) {
        if (input.contains("one")) {
            return 1;
        } else if (input.contains("two")) {
            return 2;
        } else if (input.contains("three")) {
            return 3;
        } else if (input.contains("four")) {
            return 4;
        } else if (input.contains("five")) {
            return 5;
        } else if (input.contains("six")) {
            return 6;
        } else if (input.contains("seven")) {
            return 7;
        } else if (input.contains("eight")) {
            return 8;
        } else if (input.contains("nine")) {
            return 9;
        }
        return -1;
    }

}
