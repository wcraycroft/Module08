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
