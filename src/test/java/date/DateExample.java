package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        // Get the current date
        Date currentDate = new Date();

        // Create a Calendar instance
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        // Add 5 days to the current date
        calendar.add(Calendar.DAY_OF_MONTH, 5);

        // Get the updated date
        Date updatedDate = calendar.getTime();

        // Format the date as desired (e.g., MM/dd/yyyy)
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = dateFormat.format(updatedDate);

        System.out.println("Current date: " + dateFormat.format(currentDate));
        System.out.println("Date after adding 5 days: " + formattedDate);
    }

    public static String getCurrentDate(int day) {
        // Get the current date
        Date currentDate = new Date();

        // Create a Calendar instance
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        // Add 5 days to the current date
        calendar.add(Calendar.DAY_OF_MONTH, day);

        // Get the updated date
        Date updatedDate = calendar.getTime();

        // Format the date as desired (e.g., MM/dd/yyyy)
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(updatedDate);

        System.out.println("Current date: " + dateFormat.format(currentDate));
        System.out.println("Date after adding 5 days: " + formattedDate);
        
        return formattedDate; 
    }

	

}
