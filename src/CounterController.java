/* CounterController.java
 * Author:     Will Craycroft
 * Module:     8
 * Project:    Homework 8 - Project 1
 * Description: This Controller class takes in a start value and end value from the user, sends the start value to the
 *      Model, and increments the Model every 1 second until the end value is reached.
 *
 *    Instance Variables
 *       counterModel (CounterModel) - instance of the Model class used to store the current count.
 *       startValue (int) - starting value of the counter
 *       endValue (int) - inclusive end value of the counter
 *
 *    Methods:
 *       CounterController - creates a new CounterController given a start and an end value
 *       start - sends the start value to the Model, then increments the Model every 1 second until the end value is reached.
 *       getStartValue - returns the start value
 *       getEndValue - returns the end value
 *       setStartValue - sets the start value
 *       setEndValue - ets the end value
 *       toString - returns a string representation of the CounterController
 *       equals - returns true if the two start and end values are equal
 */

public class CounterController {

    private CounterModel counterModel;
    private int startValue;
    private int endValue;

    public CounterController(int startValue, int endValue)
    {
        counterModel = new CounterModel(startValue);
        setStartValue(startValue);
        setEndValue(endValue);
    }

    public int getStartValue() {
        return startValue;
    }
    public int getEndValue() {
        return  endValue;
    }

    public void setStartValue(int startValue) {
        this.startValue = startValue;
    }
    public void setEndValue(int endValue) {
        this.endValue = endValue;
    }

    public void start() {

        for (int i = startValue; i < endValue + 1; i++) {
            counterModel.increment();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    // Returns a string representation of the CounterController
    public String toString() {
        return "CounterController{" +
                "startValue=" + startValue +
                ", endValue=" + endValue +
                '}';
    }

    // Returns true if the two start and end values are equal
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CounterController that = (CounterController) o;
        return startValue == that.startValue &&
                endValue == that.endValue;
    }
}
