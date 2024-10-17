
import java.util.Scanner;

public class StudentMenu {

    public static void main(String args[]) {
        StudentService studentService = new StudentService();
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("1.Add\n2.Read\n3.Exit\nEnter Your Choice:");
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    studentService.createStudent();
                    break;

                case 2:
                    studentService.readStudent();
                    break;

                case 3:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice Try Again!!");
            }
        }
        while (ch != 3);
    }


}

