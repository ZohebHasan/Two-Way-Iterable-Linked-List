import java.lang.*;

public interface CollectionType<E> extends Iterable<E>{
    boolean add(E element);
    boolean remove(E element);
    int size();
    boolean isEmpty();
    boolean contains(E element);
}
