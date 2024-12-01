package canvas;

public class Teacher extends Person implements Communicator, Comparable{
    private String subject;

    public Teacher(String name, String id, Date enrollmentDate, String subject){
        super(name, id, enrollmentDate);
        this.subject = subject;
    }


    public void introduce(){
        System.out.println("hi my name is " + getName() + " and my id is " + getId());
    }

    public void assignGrade(Student student, int grade){
        student.receiveGrade(grade, this); //this refers to the instance type of the class
        System.out.println("teacher " + getName() + " assigned grade " + grade + " to student " + student.getName());
    }

    //pass into ... of elements in parameter
    public void assignGrades(Student student, int... grades){
//        student.receiveGrade(grade, this); //this refers to the instance type of the class
//        System.out.println("teacher " + getName() + " assigned grade " + grade + " to student " + student.getName());
        for(int grade:grades){
            student.receiveGrade(grade, this);
        }
    }


    public String getRoleName(){
        return "Teacher";
    }

    @Override
    public void sendMessage(Person receiver) {
        System.out.println("A teacher sends a message to: " + receiver.getName());
    }

    @Override
    public void talk() {

    }

    @Override
    //cannot compare a student to a teacher, triggers exception
    public int compareTo(Object o) {
        Teacher t = (Teacher) o;
        return this.id.compareTo(t.id);
    }
}
