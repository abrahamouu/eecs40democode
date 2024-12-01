package canvas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
//        Student s1 = new Student("Alice", "S001", new Date(9,20,2004), 5);
//        Student s2 = new Student("Joe", "S002", new Date(10,20,2004), 5);
//        Pair<Student> studentPair = new Pair<>(s1, s2);
//        studentPair.toString();
//        Pair<String> strPair = new Pair<>("Alice", "Joe");
//        System.out.println(strPair);
//
//        Pair<Integer> intPair = new Pair<>(10, 20);
//
//        Teacher teacher1 = new Teacher("Joe", "T001", new Date(9,20,2024),"EECS40");
//        TwoPair<Student, Teacher> personPair = new TwoPair<>(s1, teacher1);
//        System.out.println(personPair);
//
//        ArrayList<Pair<String>> arrayList = new ArrayList<>();
//
//        BoundedPair<Student> boundPair = new BoundedPair<>(s1, s2);
//        Student maxStudent = boundPair.max();
//        System.out.println("The max student: " + maxStudent);



        //Person p1 = new Person("Joe", "1230", new Date(10,21,2024));
//        p1.setEnrollmentDate(new Date(10,21,2024));
//        Person p2 = new Person(p1);
//        System.out.println("enrollment date of p1: " + p1.getEnrollmentDate());
//        System.out.println("enrollment date of p1: " + p2.getEnrollmentDate());
//        System.out.println("change enrollment date of p2");
//        p2.getEnrollmentDate().setDay(10);
//        System.out.println("enrollment date of p1: " + p1.getEnrollmentDate());
//        System.out.println("enrollment date of p1: " + p2.getEnrollmentDate());
//
//        p2.setName("Alice");
//        System.out.println("name of p1: " + p1.getName());
//        System.out.println("name of p2: " + p2.getName());

//        Person p2 = new Person();
//        Person p1 = new Person("Joe");

//        Person p2 = new Person("Jane", "1231");
//        System.out.println("The number of persons created is: " + Person.getPersonCount()); //getPersonCount can be called with instances of person class as well
//        p1.accessStatic();
////        System.out.println(p1.getId());

//        p1.introduce();

        //demonstrates scope of code of main and class
//        int age = 10;
//        System.out.println("main age value: " + age);
//        p1.setAge(age);
//        System.out.println("main age value: " + age);
//

        Student student = new Student("Alice",  "S001", new Date(9,20,2022), 5);
        student.createAndDisplayFullAddress("123 Main Street", "Springfield", "CA", "91791");


        Teacher teacher = new Teacher("Joe","T001", new Date(9,20,2022),"EECS40");
        Student student2 = new Student("Bob",  "C002", new Date(9,20,2022),5);
        Student student3 = new Student("Dan",  "D003", new Date(9,20,2022),5);



        /*
        students.add(student);
        students.add(student2);
        students.add(student3);

        System.out.println("Before sorting: ");
        for(Student s: students){
            System.out.println(s);
        }

        Collections.sort(students);

        System.out.println("After sorting: ");
        for(Student s: students){
            System.out.println(s);
        }

         */


        assignGradeFromInput(teacher, student);
        String filename = "grades.txt";
        //student.saveGradesToFile(filename);
//        student.readGradesFromFile(filename);
//        student.viewGrades();
//        TeachingAssistant ta = new TeachingAssistant("Bob", "D001",new Date(9,20,2022),"TA0001",5);
////        System.out.println(student);
////        System.out.println(teacher);
//////        student.introduce();
//////        teacher.introduce();
////        teacher.assignGrade(student, 100);
////        teacher.assignGrades(student, 90, 85, 35);
//        student.viewGrades();
//////        p1.assignGrade(student, 100);
//////        student.viewGrades();
//////        System.out.println(student.equals(student));
//        ta.assignGrade(student, 100);
//        ta.assignGrade(student, 95);
//        ta.assignGrade(student, 98);
//        student.showOverall();
//
//        student.showOverall(GradingScheme.PERCENTAGE);
//        student.showOverall(GradingScheme.LETTER);
//
//        System.out.println(student.getSomeone());
//        System.out.println(ta.getSomeone());
//
//        System.out.println("getClass() Person vs Student: " + (p1.getClass() == student.getClass()));
//        System.out.println("Person instance of student: " + (p1 instanceof Student));
//        System.out.println("Student instance of person: " + (student instanceof Person));
//        student.showOverall("UCI");

        //boxing and unboxing demo
//        Integer integerObject =  new Integer(42);
//        Integer integerObject = 42;
//        int i = integerObject.intValue();
//        int i = integerObject;
//        System.out.println(i);

        //Person p = new Person("Joe","P001");
        //Person p2 = new Student("Alice",  "S001", new Date(9,20,2022), 5);
        //p2.yell();
        //Student s1 = new Student("Alice",  "S001", new Date(9,20,2022), 5);
        //p2.introduce();
//        Student s1 = new Student("Alice","S001", new Date(9,20,2022), 5);
//        Person p1;
//
//        //upcasting
//        p1 = s1;
//        p1.introduce();
//        Student s2;
//        //downcasting
//        s2 = (Student) p1;
//        s2.introduce();

        //downcasting
        //compile error
        /*
        Person p1 = new Person("Joe", "P001");
        Student s1;
        s1 = (Student)p1;
        s1.introduce();

         */
        //inorder to implement cloneable have to implement cloneable interface
//        Person p1 = new Person("Joe", "P001", new Date(9,1,22));
//        try {
//            Person p2 = p1.clone();
//            System.out.println(p1);
//            p2.getEnrollmentDate().setDay(15);
//            System.out.println(p1);
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }



    }

    public static void assignGradeFromInput(Teacher teacher, Student student){
        Scanner scanner = new Scanner(System.in);
        int grade = -1;
        boolean validInput = false;

        while(!validInput){
            System.out.print("Please enter a grade for the student: ");
            try {
                grade = scanner.nextInt();
                validInput = true;
            }catch(InputMismatchException e){
                System.out.println("Invalid input. Please try again.");
                scanner.next(); //clears buffer for scanner
            }


        }

        teacher.assignGrade(student, grade);
        student.viewGrades();

        try {
            int result = divide(grade, 0);
            System.out.println("Result: " + result);
            Person p = null;
            p.introduce();
        } catch (DivisionByZero e) {

//            throw new RuntimeException(e);
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
//        finally {
//            System.out.println("Finally block is triggered.");
//        }



//        try {
//            double anotherResult = reciprocal(grade);
//        } catch (Reciprocal e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }


    }
    //if you're throwing multiple exceptions add a comma after each post ceding exception name
    private static int divide(int a, int b) throws DivisionByZero{
        if(b==0){
            DivisionByZero x = new DivisionByZero("divide() causes exception");
            throw x;
        }
        return a / b;
    }
//    private static double reciprocal(int a) throws Reciprocal{
//        if(a==0){
//            Reciprocal x = new Reciprocal("reciprocal() causes exception");
//            throw x;
//        }
//        return (double) 1.0 / a;
//    }
}
