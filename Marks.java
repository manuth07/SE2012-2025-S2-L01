import java.util.Scanner;
public class Marks{
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    System.out.print("Enter the number of students: ");
    int numOfStudents = input.nextInt();

    int[][] marks = new int[numOfStudents][3];
    
    while(true){
        System.out.println("\n====MENU====");
        System.out.println("1.) Add student marks");
        System.out.println("2.) Update student marks");
        System.out.println("3.) Get average of a subject");
        System.out.println("4.) Get average of a student");
        System.out.println("5.) Get total mark of a student");
        System.out.println("6.) Display grades of all students");
        System.out.println("7.) exit");

        System.out.print("\nEnter your choice (1-6): ");
        int choice = input.nextInt();

        switch(choice){
            case 1: addMarks(input,marks,numOfStudents);
                    break;
            case 2: updateMarks(input,marks,numOfStudents);
                    break;
            case 3: averageSubject(input,marks,numOfStudents);
                    break;
            case 4: averageStudent(input,marks,numOfStudents);
                    break;
            case 5: totalStudent(input,marks,numOfStudents);
                    break;
            case 6: displayGrades(marks,numOfStudents);
                    break;
            case 7: 
                    System.out.println("Exiting...!");
                    return;
            default: 
                    System.out.println("Invalid choice!");
        }
    }
    
    }

    public static void addMarks(Scanner input, int[][] marks, int n){
        System.out.print("Enter student ID number 1 to "+n+": ");
        int studentId = input.nextInt();

        if(studentId>=1 && studentId<=n){
            System.out.print("Enter Math marks: ");
            marks[studentId - 1][0] = input.nextInt();
            System.out.print("Enter chemistry marks: ");
            marks[studentId - 1][1] = input.nextInt();
            System.out.print("Enter physics marks: ");
            marks[studentId - 1][2] = input.nextInt();
            System.out.println("\nMarks added successfully..!");
        }
        else{
            System.out.println("Invalid ID number!");
        }

    }

    public static void updateMarks(Scanner input, int[][] marks, int n){
        System.out.print("Enter student ID number 1 to "+n+": ");
        int studentId = input.nextInt();

        System.out.print("Enter subject ID (1=Math, 2=Chemistry, 3=physics): ");
        int subjectId = input.nextInt();

        if((studentId>=1 && studentId<=n) && (subjectId>=1 && subjectId<=3)){
            System.out.print("Enter new mark: ");
            marks[studentId-1][subjectId-1] = input.nextInt();
            System.out.print("\nMark updated successfully..!");
        }
        else{
            System.out.print("Invalid student or subjet ID!");
        }
    }

     public static void averageSubject(Scanner input, int[][] marks, int n){
        System.out.print("Enter subject (1=Math, 2=Chemistry, 3=physics): ");
        int subjectId = input.nextInt();

        int sum = 0;
        if(subjectId>=1 && subjectId<=3){
            for(int i=0; i<n; i++){
                sum += marks[i][subjectId-1];
            }
            double average = sum/3.0;
            System.out.printf("\nAverage mark for subject %d = %.2lf",subjectId,average);
        }
        else{
            System.out.println("Invalid subject ID!");
        }
     }

     public static void averageStudent(Scanner input, int[][] marks, int n){
        System.out.print("Enter student ID(1 to "+n+": ");
        int studentId = input.nextInt();

        if(studentId>=1 && studentId<=n){
            int sum = 0;
            for(int i=0; i<3; i++){
                sum += marks[studentId - 1][i];
            }
            double average = sum / 3.0;
            System.out.printf("\nAverage mark for student %d = %.2lf",studentId,average);
        }
        else{
            System.out.println("Invalid student ID!");
        }
     }

      public static void totalStudent(Scanner input, int[][] marks, int n) {
        System.out.print("Enter student ID (1 to " + n + "): ");
        int studentId = input.nextInt();

        if (studentId >= 1 && studentId <= n) {
            int total = 0;
            for (int i = 0; i < 3; i++) {
                total += marks[studentId - 1][i];
            }
            System.out.println("Total marks for student " + studentId + " = " + total);
        } else {
            System.out.println("Invalid student ID.");
        }
    }

    public static void displayGrades(int[][] marks, int n){
        System.out.println("\nStudent grade summary");
        System.out.println("--------------------------------------------------");
        System.out.println("student|\tMath|\tChemistry|\tphysics");
        System.out.println("--------------------------------------------------");

        for(int i=0; i<n; i++){
            System.out.print((i+1)+"\t");

            for(int j=0; j<3; j++){
                String grade = getGrade(marks[i][j]);
                System.out.print(grade+"\t\t");
            }
            System.out.println();
        }
    }

    public static String getGrade(int score) {
    if (score >= 90)
        return "Grade A";
    else if (score >= 80)
        return "Grade B";
    else if (score >= 70)
        return "Grade C";
    else if (score >= 60)
        return "Grade D";
    else
        return "Fail";
}

}