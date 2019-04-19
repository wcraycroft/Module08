/* CounterModel.java
 * Author:     Will Craycroft
 * Module:     8
 * Project:    Homework 8 - Project 1
 * Description: This Model class takes in a start value from the Controller, increments it if called, and sends the
 *      information to be displayed to the View.
 *
 *    Instance Variables
 *       counterView (CounterView) - instance of the View class used to display the current count.
 *       counter (int) - stores the value of the counter.
 *
 *    Methods:
 *       CounterModel - creates a new CounterModel set at the initial value
 *       increment - increments the counter by 1 and send the new value to be displayed by the View
 *       getCounter - returns current counter value
 *       setCounter - sets the current counter value
 *       toString - returns a string representation of the CounterModel
 *       equals - returns true if the two counters are equal
 */

public class CounterModel {

    private CounterView counterView;
    private int counter;

    public CounterModel(int initialValue) {
        counterView = new CounterView();
        setCounter(initialValue);
    }

    // Increments the counter by 1 and send the new value to be displayed by the View
    public void increment() {
        counterView.display(counter++);
    }

    // Returns current counter value
    public int getCounter() {
        return counter;
    }

    // Sets the current counter value
    public void setCounter(int value) {
        counter = value;
    }

    // Returns a string representation of the Counter (e.g. CounterModel{counter=11})
    public String toString() {
        return "CounterModel{" +
                "counter=" + counter +
                '}';
    }

    // Returns true if the value of the counters are equal
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CounterModel that = (CounterModel) o;
        return counter == that.counter;
    }
}
