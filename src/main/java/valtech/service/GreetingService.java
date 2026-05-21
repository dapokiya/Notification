package valtech.service;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class GreetingService {

   public String getMessage() {
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();

        if (hour < 12) {
            return "Good Morning!";
        } else if (hour < 17) {
            return "Good Afternoon!";
        } else if (hour < 21) {
            return "Good Evening!";
        } else {
            return "Good Night!";
        }
    }
}
