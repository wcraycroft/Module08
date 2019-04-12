import java.time.ZonedDateTime;

public class CounterView {

    public void display(int counterValue)
    {
        ZonedDateTime currentTime = ZonedDateTime.now();
        System.out.printf("%tT : %d %n" , currentTime, counterValue);
    }
}
