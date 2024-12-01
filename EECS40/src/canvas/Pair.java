package canvas;


//use T to show generic class
//cannot use primitive types, only allows class reference type
//cannot use generic class to create an array base type
public class Pair<T>{
    private T first;
    private T second;

    public Pair() {
        this.first = null;
        this.second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }



    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" + "first=" + first + ", second=" + second + '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

//    public void addition(){
//        System.out.println(first + second);
//    }
}


// {a:1, b:2}
