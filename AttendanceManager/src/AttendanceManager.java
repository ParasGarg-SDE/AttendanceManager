import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AttendanceManager {
    static Map<String, Student> StudentIdToStudentMap = new HashMap<>();
    static Map<String, Student> StudentIdStudentEntry = new HashMap<>();
    static AttendanceCalculator_Utils attendanceCalculator_utils;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String command;
        while (!(command=scanner.next()).equalsIgnoreCase("exit")){
            System.out.println("command : "+command);
            processCommand(command);
        }

    }
    private static void processCommand(String command){
        if (command.startsWith("in_")) {
            String studentId = command.replace("in_", "");
            StudentIdStudentEntry.put(studentId, new Student());


            Student student = StudentIdToStudentMap.get(studentId);
            if (student == null) {
                student = new Student();
                student.setAttendance(100);
                int gettingAttendance = student.getAttendance();
                attendanceCalculator_utils = new AttendanceCalculator_Utils();
                attendanceCalculator_utils.getAttendanceCalcultor();
            }
            StudentIdToStudentMap.put(studentId, student);
        }
        else if (command.startsWith("check_")){
            String studentId = command.replace("check_","");
            Student student=StudentIdStudentEntry.get(studentId);

            if (student==null){
                System.out.println("No studentId found, plz contact the authority");
            }
            else {

                StudentIdStudentEntry.remove(student);
                StudentIdToStudentMap.put(studentId, student);
            }
        }
        else if(command.startsWith("record")) {
            for (Map.Entry<String, Student> stringStudentEntry : StudentIdToStudentMap.entrySet()) {
                String studentId = stringStudentEntry.getKey();
                Student student = stringStudentEntry.getValue();

                int attendance = AttendanceCalculator_Utils.getAttendanceCalcultor();
                Student markedPresent = StudentIdToStudentMap.get(studentId);
                int TotalAttendance = student.getAttendance() - attendance;
                student.setAttendance(TotalAttendance);

                System.out.println("Student id : " + studentId + " with attendance : " + student.getAttendance());
            }

        }
    }
}
