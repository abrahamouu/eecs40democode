package canvas;

public class TeachingAssistant extends Student {

    private String taId;
    private static int taCount = 0;

    public TeachingAssistant(String name, String id, Date enrollmentDate, String taId, int maxGrades) {
        super(name, id, enrollmentDate, maxGrades);
        this.taId = taId;
        taCount++;
    }

    public void assignGrade(Student student, int grade){
        student.receiveGrade(grade, this); //this refers to the instance type of the class
        System.out.println("TA " + getName() + " assigned grade " + grade + " to student " + student.getName());
    }

    public String getRoleName(){
        return "TeachingAssistant";
    }

    //covariant scenario
    public TeachingAssistant doSomeone(){
        return this;
    }
}
