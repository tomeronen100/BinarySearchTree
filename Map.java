package assignment9;


/**
 * A generic map implementation using a binary search tree.
 *
 * @param <T> the type of keys maintained by this map
 * @param <E> the type of mapped values
 */
public class Map<T extends Comparable<T>, E> {

    /**
     * Constructs an empty map.
     */
    public Map() {
        bst = new BinarySearchTree<>();
    }

    /**
     * Adds the key and value to the map.
     * @param key   the key to add
     * @param value the value to add
     * @return true if the key-value pair was added, false if the key already exists
     */
    public boolean add(T key, E value) {
        if (key == null || value == null) {
            return false;
        }
        return bst.add(new Entry<>(key, value));
    }

    /**
     * Getter for the value for a given key.
     * @param key the key to search for
     * @return the value associated with the key, or null if the key is not found
     */
    public E get(T key) {
        if (key == null) {
            return null;
        }
        Entry<T, E> entry = bst.get(new Entry<>(key, null));
        return (entry == null) ? null : entry.getValue();
    }

    /**
     * Getter to the number of keys in the map.
     * @return the number of keys in the map
     */
    public int size() {
        return bst.size();
    }

    /**
     * Checks if the map contains a specific key.
     * @param key the key to check for
     * @return true if the key is in the map, false otherwise
     */
    public boolean contains(T key) {
        if (key == null) {
            return false;
        }
        return bst.contains(new Entry<>(key, null));
    }


    // private variable of the Map
    private BinarySearchTree<Entry<T, E>> bst;


    /**
     * A key-value pair entry.
     *
     * @param <T> the type of keys maintained by this map
     * @param <E> the type of mapped values
     */
    public static class Entry<T extends Comparable<T>, E> implements Comparable<Entry<T, E>> {
        private T key;
        private E value;

        /**
         * Constructs a new entry with the specified key and value.
         * @param key   the key of the entry
         * @param value the value of the entry
         */
        public Entry(T key, E value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Getter to the key of this entry.
         * @return the key of this entry
         */
        public T getKey() {
            return key;
        }

        /**
         * Getter to the value of this entry.
         * @return the value of this entry
         */
        public E getValue() {
            return value;
        }

        /**
         * Compares this entry with the specified entry for order based on the key.
         * @param o the entry to be compared
         * @return Integer: negative first key smaller, zero if even, positive otherwise.
         */
        @Override
        public int compareTo(Entry<T, E> o) {
            return this.key.compareTo(o.getKey());
        }
    }
}
