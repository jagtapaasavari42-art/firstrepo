import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take alarm time input
        System.out.print("Set alarm hour (0-23): ");
        int hour = scanner.nextInt();

        System.out.print("Set alarm minute (0-59): ");
        int minute = scanner.nextInt();

        LocalTime alarmTime = LocalTime.of(hour, minute);
        System.out.println("Alarm set for: " + alarmTime);

        // Continuous loop to check time
        while (true) {
            LocalTime currentTime = LocalTime.now();

            if (currentTime.getHour() == alarmTime.getHour() &&
                currentTime.getMinute() == alarmTime.getMinute()) {

                System.out.println("⏰ Alarm! Wake up!");
                break; // stop after alarm triggers
            }

            try {
                Thread.sleep(1000); // check every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
