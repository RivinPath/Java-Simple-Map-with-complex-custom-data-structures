/*
 * FILE:DSAStack.java
 * AUTHOR: Rivin Pathirage
 * UNIT: Data Structures & Algorithms
 * PURPOSE: Implementation of stack
 * REFERENCES: 
 */

public class DSAStack
{
    //Class Fields
    public int count;
    static Object [] stackArray;
   
    int max_capacityVar = 5;
    //Object is keyword
    public Object stackValue;


    

    
    //DSAStack topVal;
    
    boolean emptyStack;
    boolean fullStack;
    




    //
    //Default Constructor
    //
    public DSAStack()
    {
        stackArray = new Object[max_capacityVar];
        count = 0;
        //stackArray = new DSAStack[5];

        //
        //Initializing the Object Array
        //
        /*for(int i = 0; i < 5; i++)
        {
            stackArray[i] = new DSAStack();
        }*/

    }





    //
    //Alternative Constructor
    //
    public DSAStack(int maxCap)
    {
        stackArray = new Object[maxCap];
        count = 0;
        
    }

    






    //
    //ACCESSORS
    //



    //Accessor for count

    public int getCount()
    {
        return count;
    }

    //Accessor for stack
    
    public Object getStackValue()
    {
        return stackValue;
    }

    //Accessor for checking if the Stack is Empty

    public boolean isEmpty()
    {
        if (count == 0)
        {
            emptyStack = true;
            System.out.println("The Stack is empty\n");
            return emptyStack;
        }
        else
        {
            emptyStack = false;
            System.out.println("The Stack is not empty\n");
            return emptyStack;
        }
    }


    //Accessor for checking if the Stack is full

    public boolean isFull()
    {
        if (count == stackArray.length)
        {
            fullStack = true;
            System.out.println("The Stack is full\n");
            return fullStack;
        }
        else
        {
            fullStack = false;
            System.out.println("The Stack is not full\n");
            return fullStack;
        }
    }

    /*
     * METHOD: top
     * PURPOSE: Find the top most stack
     * IMPORTS: 
     * EXPORTS: topVal
     */

    //
    //top method
    //
    public Object top()
    {
        Object topVal;
        if (emptyStack == true)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            topVal =stackArray[count-1];
        }
        return topVal;
    }

    /*
     * METHOD: push
     * PURPOSE: Adding Layers to the stack
     * IMPORTS: stackValue
     * EXPORTS: 
     */


    //
    //Push method
    //
    public void push(Object pStackValue)
    {
        if (fullStack == true)
        {
            throw new StackOverflowError();
        }
        else
        {

            stackArray[count]=pStackValue;
            count++;
        }
    }

    /*
     * METHOD: pop
     * PURPOSE: Deleting stack element
     * IMPORTS: 
     * EXPORTS: topVal
     */

    //
    //Pop Method
    //

    public Object pop()
    {
        Object topVal;
        topVal =top();
        count--;
        return topVal;

    }
}