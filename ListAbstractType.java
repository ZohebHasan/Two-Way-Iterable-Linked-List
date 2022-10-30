
public interface ListAbstractType<E> extends CollectionType<E> {
    void add(int index, E element);
    E set(int index, E element);
    E get(int index);
    void remove(int index);

}
