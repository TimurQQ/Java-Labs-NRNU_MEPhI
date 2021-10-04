package dataStructures.interfaces;

import java.util.function.Predicate;

public interface List<T> {
    void add(T element);

    void add(int index, T obj);

    void addAll(List<T> elements);

    T get(int index);

    T remove(int index);

    boolean remove (T byValue);

    T set(int index, T element); // Index < 0 -> Index = 0; Index >= size -> Index = size

    boolean contains(Object obj);

    int indexOf(Object obj);

    int indexByPredicate(Predicate<T> predicate);

    int size();

    boolean isEmpty();
}
