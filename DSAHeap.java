/*
* FILE:DSAHeapEntry.java
* AUTHOR: Rivin Pathirage
* UNIT: Data Structures & Algorithms
* PURPOSE: Inserting values to Heap Tree
* REFERENCES:
*/

class DSAHeapEntry 
{
    private int risk;
    private String name;

    //Default Constructor
    public DSAHeapEntry(int risk, String name) 
    {
        this.risk = risk;
        this.name = name;
    }

    //
    //Accessors
    //
    public int getRisk() 
    {
        return risk;
    }

    public String getName() 
    {
        return name;
    }
}


/*
* FILE:DSAHeap.java
* AUTHOR: Rivin Pathirage
* UNIT: Data Structures & Algorithms
* PURPOSE: Implementing the Max heap tree
* REFERENCES:
*/
class DSAHeap 
{
    private DSAHeapEntry[] heap;
    private int size;
    private int capacity;

    //Default Constructor
    public DSAHeap() 
    {
        capacity = 10; // Initial capacity
        size = 0;
        heap = new DSAHeapEntry[capacity];
    }

    /*
    * METHOD: insert
    * PURPOSE: Inserting values to the heap Node
    * IMPORTS: risk name
    * EXPORTS: 
    */
    public void insert(int risk, String name) 
    {
        if (size == capacity) 
        {
            expandCapacity();
        }

        DSAHeapEntry entry = new DSAHeapEntry(risk, name);
        heap[size] = entry;
        size++;

        heapifyUp(size - 1);
    }

    /*
    * METHOD: removeMax
    * PURPOSE: removing the top value of heap tree
    * IMPORTS: 
    * EXPORTS: maxEntry
    */
    public DSAHeapEntry removeMax() 
    {
        if (isEmpty()) 
        {
            return null;
        }

        DSAHeapEntry maxEntry = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);

        return maxEntry;
    }

    /*
    * METHOD: isEmpty
    * PURPOSE: Giving an empty value
    * IMPORTS: 
    * EXPORTS: size
    */
    public boolean isEmpty() 
    {
        return size == 0;
    }

    /*
    * METHOD: heapifyUp
    * PURPOSE: Trickle Up the Heap tree
    * IMPORTS: index
    * EXPORTS: 
    */
    private void heapifyUp(int index) 
    {
        int parentIndex = (index - 1) / 2;

        while (index > 0 && heap[index].getRisk() > heap[parentIndex].getRisk()) 
        {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    /*
    * METHOD: heapifyDown
    * PURPOSE: Trickling down the heap tree
    * IMPORTS: index
    * EXPORTS: 
    */
    private void heapifyDown(int index) 
    {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largestIndex = index;

        if (leftChildIndex < size && heap[leftChildIndex].getRisk() > heap[largestIndex].getRisk()) 
        {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < size && heap[rightChildIndex].getRisk() > heap[largestIndex].getRisk()) 
        {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) 
        {
            swap(index, largestIndex);
            heapifyDown(largestIndex);
        }
    }


    /*
    * METHOD: swap
    * PURPOSE: Swapping two heap nodes
    * IMPORTS: i, j
    * EXPORTS: 
    */
    private void swap(int i, int j) 
    {
        DSAHeapEntry temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


    /*
    * METHOD: expandCapacity
    * PURPOSE: increasing the capacity of the heap
    * IMPORTS: 
    * EXPORTS: 
    */
    private void expandCapacity() 
    {
        capacity *= 2;
        DSAHeapEntry[] newHeap = new DSAHeapEntry[capacity];
        System.arraycopy(heap, 0, newHeap, 0, size);
        heap = newHeap;
    }


    /*
    * METHOD: displayHeap
    * PURPOSE: Displaying the heap
    * IMPORTS: 
    * EXPORTS: 
    */
    public void displayHeap() 
    {
        if (isEmpty()) 
        {
            System.out.println("Heap is empty.");
            return;
        }

        for (int i = 0; i < size; i++) 
        {
            DSAHeapEntry entry = heap[i];
            System.out.println("Index: " + i + ", Name: " + entry.getName() + ", Risk: " + entry.getRisk());
        }
    }
}