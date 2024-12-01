package canvas;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Student extends Person implements Communicator, Comparable{
    //private int[] grades;
    private ArrayList<Integer> grades;
    private int gradeIndex;

    public Student(String name, String id, Date enrollmentDate, int maxGrades) {
        super(name, id, enrollmentDate);
        //this.grades = new int[maxGrades];  //defines set number of grades
        this.grades = new ArrayList<>(maxGrades);
        System.out.println("after constructor, size of grades is: " + this.grades.size());
        this.gradeIndex = 0; //initializes grade index
    }

    //add grade method to array
    private void addGrade(int grade) {
        /*
        if(gradeIndex < grades.length) {
            grades[gradeIndex] = grade;
            gradeIndex++;
        }
        else{
            System.out.println("no more grades can be added.");
        }

         */
        this.grades.add(grade);
    }

    //helper method for add grades that checks for person type i.e. teacher only
    public void receiveGrade(int grade, Person assignedBy) {
        if(assignedBy instanceof Teacher) {
            addGrade(grade);
        }
        else if(assignedBy instanceof TeachingAssistant) {
            addGrade(grade);
        }
        else{
            System.out.println("only teacher or TA can assign grades.");
        }
    }

    public void viewGrades(){
        System.out.println("Grades for " +  getName() + ": ");
        /*
        for(int i=0;i<gradeIndex;i++){
            System.out.println(grades[i] + " ");
        }
        System.out.println();

         */
        //for each can be used iteratively for arrays and arraylists
        for(int grade: this.grades){
            System.out.print(grade + " ");
        }

    }

    public String getRoleName(){
        return "Student";
    }

    private double calculateAverage(){
        int sum = 0;
        /*
        for(int i=0;i<gradeIndex;i++){
            sum += grades[i];

         */
        for(int grade: this.grades){
            sum += grade;
        }

        //return gradeIndex == 0 ? 0 : (double)sum/gradeIndex;
        return grades.isEmpty() ? 0 : (double) sum / this.grades.size();
    }

    private String getLetterGrade(double average){
        if(average >= 90) return "A";
        if(average >= 80) return "B";
        if(average >= 70) return "C";
        if(average >= 60) return "D";
        return "F";
    }

    //showOverall to show overloading
    public void showOverall(){
        showOverall(GradingScheme.PERCENTAGE);
    }

    public void showOverall(GradingScheme gradingScheme){
        double average = calculateAverage();
        switch(gradingScheme){
            case PERCENTAGE:
                System.out.println("overall percentage for " + getName() + ": " + average + "%");
                break;
            case LETTER:
                System.out.println("overall percentage for " + getName() + ": " + getLetterGrade(average) + "%");
                break;
            default:
                System.out.println("unknown grading scheme");
                break;
        }

    }

    //covariant scenario
    public Student getSomeone(){
        return this; //returns object of this student
    }

    //binding demo
    @Override
    public void introduce() throws InputMismatchException, Exception {
        System.out.println("hi this is a student and my name is " + name + " and my id is " + id);
    }

    public void yell(){
        System.out.println("Student is yelling");
    }

    @Override
    public void sendMessage(Person receiver) {
        System.out.println("A student sends a message to: " + receiver.getName());
    }

    public void saveGradesToFile(String filename){
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(filename));
            writer.println("Grades for: " + getName() + ":");
            for(int grade: this.grades){
                writer.println(grade);
            }
            writer.close(); //flushes the buffer into txt file
        } catch (FileNotFoundException e) {
            System.out.println("Error unable to save grades to file.");
            System.exit(-1);
        }catch (IOException e){
            System.out.println("Error unable to save grades to file.");
            System.exit(-1);
        }
        finally {

        }
    }

    public void readGradesFromFile(String filename){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while((line = reader.readLine()) != null){
                if(line.startsWith("Grades for")){
                    continue;
                }
                try {
                    int grade = Integer.parseInt(line);
                    grades.add(grade);
                }catch(NumberFormatException e){
                    System.out.println("Warning skipping the invalid grade: " + line);
                }
            }
            reader.close();
            System.out.println("Grades read from " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Error unable to read grades from file.");
            System.exit(-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void talk() {

    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student) o;
        return this.id.compareTo(s.id);
    }
}
