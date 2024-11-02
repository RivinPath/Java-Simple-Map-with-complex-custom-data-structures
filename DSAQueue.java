/*
 * FILE:DSAQueue.java
 * AUTHOR: Rivin Pathirage
 * UNIT: Data Structures & Algorithms
 * PURPOSE: Implementation of Queue
 * REFERENCES: 
 */

import java.util.NoSuchElementException;



public class DSAQueue {
    protected int qCount;
    protected Object[] queueArray;
    protected int front;
    protected int rear;

    // Define the maximum capacity of the queue
    private static final int MAX_CAPACITY = 10;
    
    public DSAQueue() {
        queueArray = new Object[MAX_CAPACITY];
        front = 0;
        rear = -1;
        qCount = 0;
    }
    
    public DSAQueue(int pQ_Value) {
        queueArray = new Object[pQ_Value];
        front = 0;
        rear = -1;
        qCount = 0;
    }

    public int getCountQueue() {
        return qCount;
    }

    public boolean isEmpty() {
        return qCount == 0;
    }

    public boolean isFull() {
        return qCount == queueArray.length;
    }

    public void enqueue(Object pQueueValue) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % queueArray.length;
        queueArray[rear] = pQueueValue;
        qCount++;
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Object frontValue = queueArray[front];
        queueArray[front] = null;
        front = (front + 1) % queueArray.length;
        qCount--;
        return frontValue;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queueArray[front];
    }
}

