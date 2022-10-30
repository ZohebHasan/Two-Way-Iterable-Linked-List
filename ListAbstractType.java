// Author - Zoheb Hasan - 114687894 - CSE214 HW1 - Fall 2022
package cse214hw1;

public interface ListAbstractType<E> extends CollectionType<E> {
    void add(int index, E element);
    E set(int index, E element);
    E get(int index);
    void remove(int index);

}
