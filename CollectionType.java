// Author - Zoheb Hasan - 114687894 - CSE214 HW1 - Fall 2022
package cse214hw1;
import java.lang.*;

public interface CollectionType<E> extends Iterable<E>{
    boolean add(E element);
    boolean remove(E element);
    int size();
    boolean isEmpty();
    boolean contains(E element);
}
