// Author - Zoheb Hasan - 114687894 - CSE214 HW1 - Fall 2022
package cse214hw1;
import java.util.Iterator;
public interface TwoWayListIterator <E> extends Iterator <E>{
    void add(E element);
    boolean hasPrevious();
    E previous();
    void set(E element);
}
