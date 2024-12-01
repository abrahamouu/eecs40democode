package canvas;

interface Comm{
    void talk();
}


//if you implement an interface, you have to implement the method that's defined
public interface Communicator extends Comm{
    void sendMessage(Person receiver);
    static void test(){
        System.out.println("test");
    }

}
