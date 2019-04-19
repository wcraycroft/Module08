/* CounterDemo.java
 * Author:  William Craycroft
 * Module:  8
 * Project: Homework 8 - Project 1
 * Problem Statement: This class demonstrates the functionality of a Model-View-Controller counter. It will prompt the
 *      user for a start and end value and start a counter with timestamps.
 *
 * Algorithm / Plan:
 *      1. Prompt user for start and end values
 *      2. Create a new CounterController object using those values
 *      3. Call the CounterController start() method.
 */

import java.util.Scanner;

public class CounterDemo {

    public static void main(String[] args) {

        int startValue, endValue;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter a start value: ");
        startValue = keyboard.nextInt();

        System.out.print("Enter an end value: ");
        endValue = keyboard.nextInt();

        System.out.println();

        CounterController counter = new CounterController(startValue, endValue);
        counter.start();

    }
}
