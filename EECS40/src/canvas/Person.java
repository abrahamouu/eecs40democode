package canvas;

import java.util.InputMismatchException;

public class Person implements Cloneable {
    public void setName(String name) {
        this.name = name;
    }

    protected String name;
    protected String id;
    protected int age;
    private static int personCount;
    protected Address address;

    /*
    public Person() {
        System.out.println("Person is created");
    }

     */
    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    private Date enrollmentDate;

    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }

    public Person(Person other){
        this.name = other.name;
        this.id = other.id;
        this.enrollmentDate = new Date(other.enrollmentDate);
//        this.enrollmentDate = other.enrollmentDate; //causes privacy leak bc they share the same memory addr
        personCount++;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
//        age = age + 10;
//        System.out.println("age inside person: " + age);
        this.age = age;
    }


//    public Person(String name){
//        this(name, "134");
//        this.id = "234";
//    }



    public Person(String name, String id, Date enrollmentDate){
        this.name = name;
        this.id = id;
        this.enrollmentDate = enrollmentDate;
        personCount++;
    }

    public static int getPersonCount(){
        //non-static method accesses static methods and variables
        //static methods cannot access non-static methods and variables
        return personCount;
    }

//    public void accessStatic(){
//        System.out.println("access static: "  + getPersonCount());
//    }



    public void introduce() throws InputMismatchException, Exception { //derivated override class cannot have additional exceptions
        //but if base class doesn't throw anything, subclass is allowed to throw exception
        System.out.println("hi this is a person and my name is " + name + " and my id is " + id);
    }
    public void assignGrade(Student student, int grade){
        student.receiveGrade(grade, this); //this refers to the instance type of the class
        System.out.println("person " + getName() + " assigned grade " + grade + " to student " + student.getName());
    }

    public String getRoleName(){
        return "Person";
    }

    //when the object itself is called the object calls this function
    public String toString(){
        return "role: " + getRoleName() + ", name is " + name + " and my id is " + id + "enrollmentDate is " + enrollmentDate;
    }

    //checks if two objects are the same
    @Override
    public boolean equals(Object obj) {
        //check if object is directly the same
        if(this == obj) return true;
        //verify whether if this object has been verified and check class type
        if(obj == null || this.getClass() != obj.getClass()) return false;

        //once passed cast person onto object and compare their ids

        //downcasting can be checked
        /*
        if(otherObject instanceOf Person) Person otherSale = (Person)otherObject
         */


        Person person = (Person)obj; //downcasting
        return id.equals(person.id); //id is private
        //within the def of a class, private members of ANY object of the class can be accessed, not just private members of the calling object

        //error scenario trying with teacher DNW because teacher is not person
//        Teacher t = (Teacher) obj;
//        return  id.equals(t.id);
    }

    public void yell(){
        System.out.println("Person is yelling");
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person)super.clone();
    }

    public void sendMessage(Person receiver){

    }

    public void createAndDisplayFullAddress(String street, String city, String state, String zipcode){
        address = new Address(street, city, state, zipcode);
        System.out.println("Address of " + name + ": " + address.getFullAddress());

    }

    private class Address{
        private String street;
        private String city;
        private String state;
        private String zipcode;

        public Address(String street, String city, String state, String zipcode){
            this.street = street;
            this.city = city;
            this.state = state;
            this.zipcode = zipcode;
        }

        public String getFullAddress(){
            return street + ", " + city + ", " + state + ", " + zipcode;
        }


    }
}
