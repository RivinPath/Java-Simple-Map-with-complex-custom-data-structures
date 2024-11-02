/*
 * FILE:DSAHashTable.java
 * AUTHOR: Rivin Pathirage
 * UNIT: Data Structures & Algorithms
 * PURPOSE: Implementing a Hash Table
 * REFERENCES: 
 */

import java.util.Arrays;

public class DSAHashTable<K, V> 
{
    private static final int DEFAULT_CAPACITY = 10;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private DSAHashEntry<K, V>[] table;
    private int size;
    private double loadFactor;

    //Default Constructor
    public DSAHashTable() 
    {
        table = new DSAHashEntry[DEFAULT_CAPACITY];
        size = 0;
        loadFactor = DEFAULT_LOAD_FACTOR;
    }

    //Alternate Constructor
    public DSAHashTable(int initialCapacity, double loadFactor) 
    {
        table = new DSAHashEntry[initialCapacity];
        size = 0;
        this.loadFactor = loadFactor;
    }


    /*
    * METHOD: put
    * PURPOSE: Inserting values to the hash table
    * IMPORTS: K, V
    * EXPORTS: 
    */
    public void put(K key, V value) 
    {
        resizeIfNeeded();

        int index = getIndex(key);
        DSAHashEntry<K, V> entry = table[index];

        while (entry != null) 
        {
            if (entry.getKey().equals(key)) 
            {
                entry.setValue(value);
                return;
            }
            entry = entry.getNext();
        }

        DSAHashEntry<K, V> newEntry = new DSAHashEntry<>(key, value);
        newEntry.setNext(table[index]);
        table[index] = newEntry;
        size++;
    }

    /*
    * METHOD: get
    * PURPOSE: Getting a value from  the hash table using a key
    * IMPORTS: K
    * EXPORTS: V
    */
    public V get(K key) 
    {
        int index = getIndex(key);
        DSAHashEntry<K, V> entry = table[index];

        while (entry != null) 
        {
            if (entry.getKey().equals(key)) 
            {
                return entry.getValue();
            }
            entry = entry.getNext();
        }

        return null;
    }

    /*
    * METHOD: remove
    * PURPOSE: Deleting a value from the hash table
    * IMPORTS: K
    * EXPORTS: 
    */
    public void remove(K key) 
    {
        int index = getIndex(key);
        DSAHashEntry<K, V> entry = table[index];
        DSAHashEntry<K, V> prev = null;

        while (entry != null) 
        {
            if (entry.getKey().equals(key)) 
            {
                if (prev == null) 
                {
                    table[index] = entry.getNext();
                } 
                else 
                {
                    prev.setNext(entry.getNext());
                }
                size--;
                return;
            }
            prev = entry;
            entry = entry.getNext();
        }
    }

    //
    //Accessors
    //
    public int size() 
    {
        return size;
    }

    /*
    * METHOD: isEmpty
    * PURPOSE: cheking if empty
    * IMPORTS: 
    * EXPORTS: size == 0
    */
    public boolean isEmpty() 
    {
        return size == 0;
    }

    private int getIndex(K key) 
    {
        int hashCode = key.hashCode();
        return (hashCode & 0x7fffffff) % table.length;
    }


    /*
    * METHOD: resizeIfNeeded
    * PURPOSE: resizing the Hash Table 
    * IMPORTS: 
    * EXPORTS: 
    */
    private void resizeIfNeeded() 
    {
        if (size >= loadFactor * table.length) 
        {
            int newCapacity = table.length * 2;
            DSAHashEntry<K, V>[] newTable = new DSAHashEntry[newCapacity];

            for (DSAHashEntry<K, V> entry : table) 
            {
                while (entry != null) 
                {
                    int index = getIndex(entry.getKey());
                    DSAHashEntry<K, V> next = entry.getNext();
                    entry.setNext(newTable[index]);
                    newTable[index] = entry;
                    entry = next;
                }
            }

            table = newTable;
        }
    }


    /*
    * FILE:DSAHashEntry.java
    * AUTHOR: Rivin Pathirage
    * UNIT: Data Structures & Algorithms
    * PURPOSE: Implementing a Hash Table
    * REFERENCES: 
    */
    private static class DSAHashEntry<K, V> 
    {
        private final K key;
        private V value;
        private DSAHashEntry<K, V> next;

        //Default Constructor
        public DSAHashEntry(K key, V value) 
        {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        //
        //Accessors
        //
        public K getKey() 
        {
            return key;
        }

        public V getValue() 
        {
            return value;
        }


        //
        //Mutators
        //
        public void setValue(V value) 
        {
            this.value = value;
        }


        //Accessor
        public DSAHashEntry<K, V> getNext() 
        {
            return next;
        }

        //Mutator
        public void setNext(DSAHashEntry<K, V> next) 
        {
            this.next = next;
        }
    }


}
    
