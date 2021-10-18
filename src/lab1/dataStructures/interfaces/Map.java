package lab1.dataStructures.interfaces;

public interface Map<K, V> {
    void put(K key, V value);

    V get(Object key);

    V get(Object key, V byDefault);

    V remove(Object key);

    boolean keyContains(Object key);

    List<K> getKeys();

    List<V> getValues();

    List<Entry<K, V>> getEntries();

    int size();

    boolean isEmpty();

    class Entry<K, T> {
        public K key;
        public T value;

        public Entry(K key, T value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" + "key: " + key + ", value: " + value + '}';
        }
    }
}
