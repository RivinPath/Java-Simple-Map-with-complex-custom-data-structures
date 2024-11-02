/*
* FILE:DSALinkedList.java
* AUTHOR: Rivin Pathirage
* UNIT: Data Structures & Algorithms
* PURPOSE: Implementing a Linked List
* REFERENCES:
*/

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DSALinkedList implements Serializable 
{
    private static final long serialVersionUID = 1L;

    private DSAListNode head;
    private DSAListNode tail;

    /*
    * METHOD: isEmpty
    * PURPOSE: Checking if empty
    * IMPORTS:
    * EXPORTS: boolean
    */
    public boolean isEmpty() 
    {
        return head == null && tail == null;
    }

    /*
    * METHOD: isFull
    * PURPOSE: Checking if Full
    * IMPORTS:
    * EXPORTS: boolean
    */
    public boolean isFull() 
    {
        return head != null && tail != null;
    }

    /*
    * METHOD: peekFirst
    * PURPOSE: Return the first node of the LinkedList
    * IMPORTS:
    * EXPORTS: data
    */
    public Object peekFirst() 
    {
        if (isEmpty()) 
        {
            throw new NoSuchElementException("The list is empty");
        }
        return head.data;
    }

    /*
    * METHOD: peekLast
    * PURPOSE: Return the Last node of the LinkedList
    * IMPORTS:
    * EXPORTS: data
    */
    public Object peekLast() 
    {
        if (isEmpty()) 
        {
            throw new NoSuchElementException("The list is empty");
        }
        return tail.data;
    }

    /*
    * METHOD: insertFirst
    * PURPOSE: insert the first node of the LinkedList
    * IMPORTS: data
    * EXPORTS: 
    */
    public void insertFirst(Object data) 
    {
        DSAListNode newNode = new DSAListNode(data);

        if (isEmpty()) 
        {
            head = tail = newNode;
        } 
        else 
        {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    /*
    * METHOD: insertLast
    * PURPOSE: insert the Last node of the LinkedList
    * IMPORTS: data
    * EXPORTS: 
    */
    public void insertLast(Object data) 
    {
        DSAListNode newNode = new DSAListNode(data);

        if (isEmpty()) 
        {
            head = tail = newNode;
        } 
        else 
        {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    /*
    * METHOD: removeFirst
    * PURPOSE: Remove the first node of the LinkedList
    * IMPORTS:
    * EXPORTS: data
    */
    public Object removeFirst() 
    {
        if (isEmpty()) 
        {
            throw new NoSuchElementException("The list is empty");
        }

        Object data = head.data;
        if (head == tail) 
        {
            head = tail = null;
        } 
        else 
        {
            head = head.next;
            head.prev = null;
        }
        return data;
    }

    /*
    * METHOD: removeLast
    * PURPOSE: Remove the last node of the LinkedList
    * IMPORTS:
    * EXPORTS: data
    */
    public Object removeLast() 
    {
        if (isEmpty()) 
        {
            throw new NoSuchElementException("The list is empty");
        }

        Object data = tail.data;
        if (head == tail) 
        {
            head = tail = null;
        } 
        else 
        {
            tail = tail.prev;
            tail.next = null;
        }
        return data;
    }

    /*
    * METHOD: removeNode
    * PURPOSE: Remove a node of the LinkedList
    * IMPORTS: node
    * EXPORTS: 
    */
    public void removeNode(DSAListNode node) 
    {
        if (isEmpty()) 
        {
            throw new NoSuchElementException("The list is empty");
        }

        if (node == head && node == tail) 
        {
            // Only one node in the list
            head = tail = null;
        } 
        else if (node == head) 
        {
            // Node is the head of the list
            head = head.next;
            head.prev = null;
        } 
        else if (node == tail) 
        {
            // Node is the tail of the list
            tail = tail.prev;
            tail.next = null;
        } 
        else 
        {
            // Node is somewhere in the middle
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    /*
    * METHOD: displayNode
    * PURPOSE: Display the Linked List
    * IMPORTS:
    * EXPORTS: 
    */
    public void displayNode() 
    {
        DSAListNode current = head;
        while (current != null) 
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    //Iterator Method
    public Iterator<Object> iterator() 
    {
        return new DSALinkedListIterator();
    }


    /*
    * FILE:DSALinkedListIterator.java
    * AUTHOR: Rivin Pathirage
    * UNIT: Data Structures & Algorithms
    * PURPOSE: Implementing the iterator
    * REFERENCES:
    */
    private class DSALinkedListIterator implements Iterator<Object> 
    {
        private DSAListNode current = head;


        /*
        * METHOD: hasNext
        * PURPOSE: Check whether there's a next node in the LinkedList
        * IMPORTS:
        * EXPORTS: boolean
        */
        public boolean hasNext() 
        {
            return current != null;
        }

        /*
        * METHOD: next
        * PURPOSE: Get the next value
        * IMPORTS:
        * EXPORTS: data
        */
        public Object next() 
        {
            if (current == null) 
            {
                throw new NoSuchElementException();
            }

            Object data = current.data;
            current = current.next;
            return data;
        }


        /*
        * METHOD: remove
        * PURPOSE: remove an item from the iteration
        * IMPORTS:
        * EXPORTS: 
        */
        public void remove() 
        {
            throw new UnsupportedOperationException();
        }
    }

    /*
    * FILE:DSAListNode.java
    * AUTHOR: Rivin Pathirage
    * UNIT: Data Structures & Algorithms
    * PURPOSE: Implementing the Linked List Node
    * REFERENCES:
    */
    private class DSAListNode 
    {
        private Object data;
        private DSAListNode next;
        private DSAListNode prev;


        //Default Constructor
        public DSAListNode(Object data) 
        {
            this.data = data;
        }
    }
}

