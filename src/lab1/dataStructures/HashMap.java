package lab1.dataStructures;

import lab1.dataStructures.interfaces.List;
import lab1.dataStructures.interfaces.Map;

import java.util.Objects;
import java.util.function.Predicate;

public class HashMap<K, V> implements Map<K, V> {
    private static final int BASIC_CAPACITY = 1024;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 16;
    private final List<Entry<K, V>>[] buckets;
    private final List<K> keys;
    private final int capacity;
    private int size = 0;

    public HashMap() {
        this(BASIC_CAPACITY);
    }

    public HashMap(int capacity) {
        if (capacity < 0 || capacity > MAX_CAPACITY)
            capacity = BASIC_CAPACITY;
        this.capacity = capacity;
        buckets = new List[capacity];
        keys = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    @Override
    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value);
        int hashIndex = hash(key);
        Predicate<Entry<K, V>> containsKey = x -> Objects.equals(x.key, key);
        int bucketIndex = buckets[hashIndex].indexByPredicate(containsKey);
        if (bucketIndex >= 0) {
            buckets[hashIndex].set(bucketIndex, entry);
        } else {
            buckets[hashIndex].add(entry);
            keys.add(key);
            size++;
        }
    }

    @Override
    public V get(Object key) {
        int hashIndex = hash(key);
        Predicate<Entry<K, V>> containsKey = x -> Objects.equals(x.key, key);
        int bucketIndex = buckets[hashIndex].indexByPredicate(containsKey);
        if (bucketIndex >= 0) {
            return buckets[hashIndex].get(bucketIndex).value;
        }
        return null;
    }

    @Override
    public V get(Object key, V byDefault) {
        V res = get(key);
        return (res != null) ? res : byDefault;
    }

    @Override
    public V remove(Object key) {
        int hashIndex = hash(key);
        Predicate<Entry<K, V>> containsKey = x -> Objects.equals(x.key, key);
        int bucketIndex = buckets[hashIndex].indexByPredicate(containsKey);
        Entry<K, V> removedEntry = buckets[hashIndex].remove(bucketIndex);
        if (removedEntry != null) {
            return removedEntry.value;
        }
        return null;
    }

    @Override
    public boolean keyContains(Object key) {
        int hashIndex = hash(key);
        Predicate<Entry<K, V>> containsKey = x -> Objects.equals(x.key, key);
        int bucketIndex = buckets[hashIndex].indexByPredicate(containsKey);
        return bucketIndex >= 0;
    }

    @Override
    public List<K> getKeys() {
        return keys;
    }

    @Override
    public List<V> getValues() {
        List<V> res = new ArrayList<>();
        for (int i = 0; i < keys.size(); ++i) {
            res.add(get(keys.get(i)));
        }
        return res;
    }

    @Override
    public List<Entry<K, V>> getEntries() {
        List<Entry<K, V>> res = new ArrayList<>();
        for (int i = 0; i < keys.size(); ++i) {
            K key = keys.get(i);
            Entry<K, V> entry = new Entry<>(key, get(key));
            res.add(entry);
        }
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Object key) {
        int hashCode = Objects.hash(key);
        int index = hashCode % capacity;
        return Math.abs(index);
    }
}
