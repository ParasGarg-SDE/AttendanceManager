import java.util.Scanner;

public class AttendanceCalculator_Utils {

    public static int getAttendanceCalcultor(){
        System.out.println("Enter The Total Present Marked : ");
        Scanner scanner=new Scanner(System.in);
        int markedPresent = scanner.nextInt();
        return markedPresent;
    }
}
