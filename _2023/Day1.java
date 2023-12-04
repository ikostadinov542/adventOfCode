package _2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.getInteger;

public class Day1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> list = new ArrayList<>();
        int sum = 0;

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String regex = "\\d";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find() || isContainDigitAsWord(input) != -1) {
                int indexOfString = isContainDigitAsWord(input);
                int digit = getNum(input);
                if (matcher.find()) {
                    int indexOfDigit = input.indexOf(matcher.group());
                    if (indexOfDigit < indexOfString) {
                        list.add(Integer.valueOf(matcher.group()));
                        list.add(digit);
                    } else {
                        list.add(digit);
                        list.add(Integer.valueOf(matcher.group()));
                    }
                } else {
                    list.add(digit);
                }

            }
            String firstIndexAsString = String.valueOf(list.get(0));
            String secondIndexAsString = String.valueOf(list.get(list.size() - 1));
            String concat = firstIndexAsString + secondIndexAsString;
            int value = Integer.parseInt(concat);
            sum += value;
            list.clear();

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

    private static int isContainDigitAsWord(String input) {

        if (input.contains("one")) {
            return input.indexOf("one");
        } else if (input.contains("two")) {
            return input.indexOf("two");
        } else if (input.contains("three")) {
            return input.indexOf("three");
        } else if (input.contains("four")) {
            return input.indexOf("four");
        } else if (input.contains("five")) {
            return input.indexOf("five");
        } else if (input.contains("six")) {
            return input.indexOf("six");
        } else if (input.contains("seven")) {
            return input.indexOf("seven");
        } else if (input.contains("eight")) {
            return input.indexOf("eight");
        } else if (input.contains("nine")) {
            return input.indexOf("nine");
        }

        return -1;
    }

    private static int getSum(List<Integer> list, int sum) {

        return sum;
    }
}
