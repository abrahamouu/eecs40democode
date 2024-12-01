package canvas;

import java.awt.*;

public class DivisionByZero extends Exception{
    public DivisionByZero(){
        super("Division by zero is not allowed");

    }
    public DivisionByZero(String message){
        super(message);
    }


    //catch more specific expception first
//    catch(Exception e){
//
//    }
//    catch(NegativeNumberException e){
//
//    }
    //NegativeNumberException is a type of exception therefore in this order it won't be called at all. Exception will be called first
}

class Reciprocal extends Exception{
    public Reciprocal(){
        super("Reciprocal is not allowed");
    }
    public Reciprocal(String message){
        super(message);
    }
}
