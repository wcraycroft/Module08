
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

    public String toString() {
        return "CounterController{" +
                "startValue=" + startValue +
                ", endValue=" + endValue +
                '}';
    }

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
