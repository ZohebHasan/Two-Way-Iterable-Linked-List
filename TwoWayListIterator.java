import java.util.Iterator;
public interface TwoWayListIterator <E> extends Iterator <E>{
    void add(E element);
    boolean hasPrevious();
    E previous();
    void set(E element);
}
