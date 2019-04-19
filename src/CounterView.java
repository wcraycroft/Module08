/* CounterView.java
 * Author:     Will Craycroft
 * Module:     8
 * Project:    Homework 8 - Project 1
 * Description: This View class takes in an integer value from the Model and displays it to the user.
 *
 *    Instance Variables
 *       (none)
 *
 *    Methods:
 *       display - prints the value of the counter to the console along with a timestamp
 */

import java.time.ZonedDateTime;

public class CounterView {

    public void display(int counterValue)
    {
        ZonedDateTime currentTime = ZonedDateTime.now();
        System.out.printf("%tT : %d %n" , currentTime, counterValue);
    }
}
