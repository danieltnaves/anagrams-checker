package com.github.danieltnaves;

import java.text.MessageFormat;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    private static final int OPTION_CHECK_ANAGRAMS = 1;
    private static final int OPTION_GET_ANAGRAMS = 2;
    private static final int OPTION_RESET = 3;
    private static final int OPTION_EXIT = 4;

    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {
            var message = """
                    [1] - To check if two strings are anagrams.
                    [2] - To get all anagrams of a given string.
                    [3] - Reset
                    [4] - Exit
                    """;
            var anagramChecker = new AnagramChecker();

            while (true) {
                out.println(message);
                var option = getOption(keyboard);
                switch (option) {
                    case OPTION_CHECK_ANAGRAMS -> checkAnagrams(keyboard, anagramChecker);
                    case OPTION_GET_ANAGRAMS -> getAnagrams(keyboard, anagramChecker);
                    case OPTION_RESET -> anagramChecker.reset();
                    case OPTION_EXIT -> {
                        out.println("Goodbye!");
                        return;
                    }
                    default -> out.println("Invalid option");
                }
            }
        }
    }

    private static int getOption(Scanner keyboard) {
        int option;
        while (true) {
            try {
                option = Integer.parseInt(keyboard.nextLine());
                break;
            } catch (NumberFormatException e) {
                out.println("Invalid input. Enter a valid option.");
            }
        }
        return option;
    }

    private static void getAnagrams(Scanner keyboard, AnagramChecker anagramChecker) {
        out.print("Enter the string to query the anagrams: ");
        var key = keyboard.nextLine();
        out.println(MessageFormat.format("Anagrams of [{0}] = {1}", key, anagramChecker.getAnagrams(key)));
    }

    private static void checkAnagrams(Scanner keyboard, AnagramChecker anagramChecker) {
        out.print("Enter the first string: ");
        var first = keyboard.nextLine();

        out.print("Enter the second string: ");
        var second = keyboard.nextLine();

        out.println(MessageFormat.format("Is {0} an anagram of {1} ? {2}", first, second, anagramChecker.isAnagram(first, second)));
    }
}
