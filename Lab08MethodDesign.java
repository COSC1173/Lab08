/*
 * COSC 1173 Programming Lab - Lab 08: Method Design and Overloading
 * Textbook reference: Liang, Chapter 6 (Overloading, Stepwise Refinement)
 *
 * Student name: [TYPE YOUR NAME HERE]
 * Date:         [TYPE TODAY'S DATE HERE]
 *
 * DO NOT change any method name, parameter list, or return type.
 * REQUIREMENT: every executable statement you write must carry a line comment.
 */
public class Lab08MethodDesign {

    /*
     * STEPS 1-3 - THREE OVERLOADED METHODS.
     * All three are named describe. The compiler chooses one based on the argument
     * type. This is compile-time (static) binding, not a runtime decision.
     */

    /** STEP 1 - TODO: return the text  int: 5  for the argument 5. */
    public static String describe(int value) {
        return ""; // placeholder
    }

    /** STEP 2 - TODO: return the text  double: 5.5  for the argument 5.5. */
    public static String describe(double value) {
        return ""; // placeholder
    }

    /** STEP 3 - TODO: return the text  String: hello  for the argument "hello". */
    public static String describe(String value) {
        return ""; // placeholder
    }

    /**
     * STEP 4 - Greatest common divisor of two positive integers.
     * TODO: use Euclid's algorithm with a while loop:
     * while b is not 0, replace the pair (a, b) with (b, a % b); the answer is a.
     * Return 0 if either argument is negative.
     */
    public static int gcd(int a, int b) {
        return 0; // placeholder
    }

    /**
     * STEP 5 - Returns the digits of a non-negative integer in reverse order.
     * 1234 becomes 4321; 1200 becomes 21 (leading zeros disappear); 0 stays 0.
     * TODO: repeatedly take n % 10 as the next digit and n / 10 to shorten the number.
     * Return -1 when n is negative.
     */
    public static int reverseDigits(int n) {
        return 0; // placeholder
    }

    /**
     * STEP 6 - Counts the vowels (a, e, i, o, u, either case) in a string.
     * TODO: loop over the characters. Convert each to lower case with
     * Character.toLowerCase before testing. Return 0 when text is null or empty.
     */
    public static int countVowels(String text) {
        return 0; // placeholder
    }

    /**
     * STEP 7 - Reports whether a string reads the same forwards and backwards,
     * ignoring letter case. Compare the character at index i with the character
     * at index length - 1 - i, moving inward. Treat null as not a palindrome.
     */
    public static boolean isPalindrome(String text) {
        return false; // placeholder
    }

    /** STEP 8 - TODO: demonstrate each method above with a labeled printout. */
    public static void main(String[] args) {
        System.out.println(describe(5)); // example call
    }
}
