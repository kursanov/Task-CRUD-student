import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Student[]students = new Student[]{};


        while (true){
        System.out.println("""
                1.Add student
                2.Get all student
                3.Update student
                4.Delete student
                """);

        int s = scanner.nextInt();
        scanner.nextLine();
        switch (s){
            case 1 ->{
                students = add(students);
            }
            case 2 ->{
                getAll(students);
            }
            case 3 ->{
                for (Student student : students) {
                    System.out.println("Available ids " + student.getId());
                }
                update(students,scanner.nextInt());
            }
            case 4 ->{
                for (Student student : students) {
                    System.out.println("Available ids " + student.getId());
                }
                students = delete(students,scanner.nextInt());
            }
        }}




    }
    public static Student[] add(Student[]students){
        Student student = new Student();
        student.setId(GeneratorId.idGeneratorStudent());
        System.out.println("Write student name: ");
        student.setName(scanner.nextLine());
        System.out.println("Write student age: ");
        student.setAge(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Write emil: " + "The email must contain \"@\"");
        student.setEmail(scanner.nextLine());

        Student[] newMassiwStudent = new Student[students.length +1];

        for (int i = 0; i < students.length; i++) {
            newMassiwStudent[i] = students[i];
        }

        newMassiwStudent[students.length] = student;
        System.out.println("Student success added!");
        return newMassiwStudent;

    }
    public static void getAll(Student[] students){
        System.out.println(Arrays.toString(students));
    }

    public static void update(Student[] students, int id){

        for (Student student : students) {
            if (student.getId() == id){
                System.out.println(id + " from write new name: ");
                student.setName(new Scanner(System.in).nextLine());
                System.out.println(id + " from write new age: ");
                student.setAge(new Scanner(System.in).nextInt());
                System.out.println(id + " from write new email: ");
                student.setEmail(new Scanner(System.in).nextLine());
                System.out.println("Success updated!");
            }
        }
    }
    public static Student[] delete(Student[] students,int id){
        Student[] newStudent = new Student[students.length -1];
        int index = 0;
        for (Student student : students) {
            if (student.getId() != id){
                newStudent[index++] = student;

            }
        }
        System.out.println("Deleted success!");
        return newStudent;
    }

}