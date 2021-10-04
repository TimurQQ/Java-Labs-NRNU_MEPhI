package dataStructures;

import dataStructures.interfaces.List;

import java.util.Arrays;
import java.util.function.Predicate;


public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 16;
    protected int size = 0;//the number of elements
    protected Object[] items;//storage for elements

    public ArrayList() {
        this.items = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        if (capacity < 0 || capacity > MAX_ARRAY_SIZE)
            capacity = DEFAULT_CAPACITY;
        this.items = new Object[capacity];
    }

    @Override
    public void add(T element) {
        resizeBufferIfNeeded(size + 1);
        items[size++] = element;
    }

    @Override
    public void add(int index, T element) {
        if (index >= size) {
            add(element);
            return;
        } else if (index < 0) {
            index = 0;
        }

        resizeBufferIfNeeded(size + 1);
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = element;
        size++;
    }

    @Override
    public void addAll(List<T> elements) {
        if (elements == null) return;
        for (int i = 0; i < elements.size(); ++i) {
            add(elements.get(i));
            System.out.println("ADD " + elements.get(i));
        }
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) return null;

        return (T) items[index];
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0) return null;

        T oldValue = (T) items[index];

        int cntMoved = size - index - 1;
        if (cntMoved > 0)
            System.arraycopy(items, index + 1, items, index, cntMoved);
        items[--size] = null; // clear to let GC do its work

        return oldValue;
    }

    @Override
    public boolean remove(T byValue) {
        int removableIndex = indexOf(byValue);
        return remove(removableIndex) != null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T set(int index, T element) {
        if (index >= size) {
            add(element);
            return null;
        } else if (index < 0) {
            index = 0;
        }

        T oldValue = (T) items[index];
        items[index] = element;
        return oldValue;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override
    public int indexOf(Object obj) {
        if (obj == null) {
            for (int i = 0; i < size; ++i)
                if (items[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; ++i)
                if (obj.equals(items[i]))
                    return i;
        }
        return -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public int indexByPredicate(Predicate<T> predicate) {
        for (int i = 0; i < size; ++i) {
            if (predicate.test((T) items[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    public int capacity() {
        return items.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resizeBufferIfNeeded(int minCapacity) {
        if (size == 0) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        if (minCapacity - items.length > 0)
            resizeBuffer(minCapacity);
    }

    private void resizeBuffer(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = items.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        items = Arrays.copyOf(items, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; ++i)
            sb.append(items[i]).append(", ");
        sb.append("]");

        return sb.toString();
    }
}
