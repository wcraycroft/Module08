import java.util.Objects;

public class CounterModel {

    private CounterView counterView;
    private int counter;

    public CounterModel(int initialValue) {
        counterView = new CounterView();
        setCounter(initialValue);
    }

    public void increment() {
        counterView.display(counter++);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int value) {
        counter = value;
    }


    public String toString() {
        return "CounterModel{" +
                "counter=" + counter +
                '}';
    }

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
