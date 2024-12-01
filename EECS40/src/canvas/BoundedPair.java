package canvas;

import java.util.Objects;

public class BoundedPair <T extends Comparable>{
    private T first;
    private T second;

    public BoundedPair() {
        this.first = null;
        this.second = null;
    }

    public BoundedPair(T first, T second) {
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
        return Objects.equals(first, ((BoundedPair<?>) obj).first) && Objects.equals(second, ((BoundedPair<?>) obj).second);
    }

    public T max(){
        if(first.compareTo(second)>0){
            return first;
        }
        else {
            return second;
        }
    }
}
