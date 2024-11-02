/*
 * FILE:TestHarness.java
 * AUTHOR: Rivin Pathirage
 * UNIT: Data Structures & Algorithms
 * PURPOSE: Testing the Program
 * REFERENCES: 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TestHarness 
{
    public static void main(String[] args) 
    {
        Graph graph = new Graph();

        Scanner sc = new Scanner(System.in);

        //The Menu

        System.out.println("*****************************************************************************************************");
        System.out.println("MENU_________________________________________________________________________________________________");
        System.out.println("");
        System.out.println("Please Enter the number of the function you need to use______________________________________________");
        System.out.println("");
        System.out.println("1) Find and Prompt high Risk Areas\n2) Display the Graph");
        System.out.println("3) Depth Fist Search Traversal of the Graph\n4) Shortest Path between Two vertices, Example A and D");
        System.out.println("5) Itinarary Path between high risk areas");
        System.out.println("6) Hash Table stored value of Area Example B");
        System.out.println("7) Put the risk level of the area to a heap and display the heap");
        System.out.println("8) Display the Graph and Depth First traversal and Shortest path between B and D and a Standard Itinarary\n");
        System.out.println("");
        System.out.println("*****************************************************************************************************");
        System.out.println("");


        System.out.println("Enter your option: ");
        int option = sc.nextInt();


        if (option == 1)
        {
            //Read File and populate variables
            try (BufferedReader reader = new BufferedReader(new FileReader("UAVdata.txt"))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    
                    String[] tokens = line.split(" ");
                    if (tokens.length == 4 ) 
                    {
                        String vertex = tokens[0];
                        int temperature = Integer.parseInt(tokens[1]);
                        int humidity = Integer.parseInt(tokens[2]);
                        int wind_speed = Integer.parseInt(tokens[3]);
                        
                        graph.addVertex(vertex, temperature, humidity, wind_speed);
                        //graph.addVertex(destVertex, 30, 70, 15);
                        //graph.addEdge(srcVertex, destVertex, distance);

                        //warning method
                        graph.highRiskAreas(vertex, temperature, humidity, wind_speed);
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading file: " + e.getMessage());
            }


            //Read File and populate variables
            boolean firstLine = true;
            try (BufferedReader reader = new BufferedReader(new FileReader("location.txt"))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    if (firstLine) 
                    {
                        firstLine = false;
                        continue; // Skip the first line
                    }
                    String[] tokens = line.split(" ");
                    if (tokens.length == 3) 
                    {
                        String srcVertex = tokens[0];
                        String destVertex = tokens[1];
                        float distance = Float.parseFloat(tokens[2]);
                        //graph.addVertex(srcVertex, 30, 70, 15);
                        //graph.addVertex(destVertex, 30, 70, 15);
                        graph.addEdge(srcVertex, destVertex, distance);
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
        else if (option == 2)
        {
            //Read File and populate variables
            try (BufferedReader reader = new BufferedReader(new FileReader("UAVdata.txt"))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    
                    String[] tokens = line.split(" ");
                    if (tokens.length == 4 ) 
                    {
                        String vertex = tokens[0];
                        
                        int temperature = Integer.parseInt(tokens[1]);
                        int humidity = Integer.parseInt(tokens[2]);
                        int wind_speed = Integer.parseInt(tokens[3]);
                        
                        graph.addVertex(vertex, temperature, humidity, wind_speed);
                        //graph.addVertex(destVertex, 30, 70, 15);
                        //graph.addEdge(srcVertex, destVertex, distance);
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading file: " + e.getMessage());
            }


            //Read File and populate variables
            boolean firstLine = true;
            try (BufferedReader reader = new BufferedReader(new FileReader("location.txt"))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    if (firstLine) 
                    {
                        firstLine = false;
                        continue; // Skip the first line
                    }
                    String[] tokens = line.split(" ");
                    if (tokens.length == 3) 
                    {
                        String srcVertex = tokens[0];
                        String destVertex = tokens[1];
                        float distance = Float.parseFloat(tokens[2]);
                        //graph.addVertex(srcVertex, 30, 70, 15);
                        //graph.addVertex(destVertex, 30, 70, 15);
                        graph.addEdge(srcVertex, destVertex, distance);
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading file: " + e.getMessage());
            }

            // Display the graph
            System.out.println("\nThe Graph: \n");
            graph.displayGraph();
        }
        else if (option == 3 )
        {
            //Read File and populate variables
            try (BufferedReader reader = new BufferedReader(new FileReader("UAVdata.txt"))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    
                    String[] tokens = line.split(" ");
                    if (tokens.length == 4 ) 
                    {
                        String vertex = tokens[0];
                        //String destVertex = tokens[1];
                        int temperature = Integer.parseInt(tokens[1]);
                        int humidity = Integer.parseInt(tokens[2]);
                        int wind_speed = Integer.parseInt(tokens[3]);
                        //float distance = Float.parseFloat(tokens[2]);
                        graph.addVertex(vertex, temperature, humidity, wind_speed);
                        //graph.addVertex(destVertex, 30, 70, 15);
                        //graph.addEdge(srcVertex, destVertex, distance);
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading file: " + e.getMessage());
            }


            //Read File and populate variables
            boolean firstLine = true;
            try (BufferedReader reader = new BufferedReader(new FileReader("location.txt"))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    if (firstLine) 
                    {
                        firstLine = false;
                        continue; // Skip the first line
                    }
                    String[] tokens = line.split(" ");
                    if (tokens.length == 3) 
                    {
                        String srcVertex = tokens[0];
                        String destVertex = tokens[1];
                        float distance = Float.parseFloat(tokens[2]);
                        //graph.addVertex(srcVertex, 30, 70, 15);
                        //graph.addVertex(destVertex, 30, 70, 15);
                        graph.addEdge(srcVertex, destVertex, distance);
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading file: " + e.getMessage());
            }

            System.out.println("\nDepth First Search Path: \n");
            graph.dfsTraversal();
        }
        else if (option == 4 )
        {
            

            //Read File and populate variables


            try (BufferedReader reader = new BufferedReader(new FileReader("UAVdata.txt"))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    
                    String[] tokens = line.split(" ");
                    if (tokens.length == 4 ) 
                    {
                        String vertex = tokens[0];
                        //String destVertex = tokens[1];
                        int temperature = Integer.parseInt(tokens[1]);
                        int humidity = Integer.parseInt(tokens[2]);
                        int wind_speed = Integer.parseInt(tokens[3]);
                        
                        graph.addVertex(vertex, temperature, humidity, wind_speed);
                        //graph.addVertex(destVertex, 30, 70, 15);
                        //graph.addEdge(srcVertex, destVertex, distance);
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading file: " + e.getMessage());
            }


            //Read File and populate variables
            boolean firstLine = true;
            try (BufferedReader reader = new BufferedReader(new FileReader("location.txt"))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    if (firstLine) 
                    {
                        firstLine = false;
                        continue; // Skip the first line
                    }
                    String[] tokens = line.split(" ");
                    if (tokens.length == 3) 
                    {
                        String srcVertex = tokens[0];
                        String destVertex = tokens[1];
                        float distance = Float.parseFloat(tokens[2]);
                        //graph.addVertex(srcVertex, 30, 70, 15);
                        //graph.addVertex(destVertex, 30, 70, 15);
                        graph.addEdge(srcVertex, destVertex, distance);
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading file: " + e.getMessage());
            }


            /*String firstVertex;
            String endVertex;
            System.out.println("Please enter the Starting vertex: ");
            firstVertex = sc.nextLine();

            sc.nextLine();

            System.out.println("Please enter the ending vertex: ");
            endVertex = sc.nextLine();

            

            graph.bfsTraversal(firstVertex,endVertex);*/
            graph.bfsTraversal("A", "D");

            
        }
        else if (option == 8)
        {
            //Read File and populate variables
            try (BufferedReader reader = new BufferedReader(new FileReader("UAVdata.txt"))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    
                    String[] tokens = line.split(" ");
                    if (tokens.length == 4 ) 
                    {
                        String vertex = tokens[0];
                        
                        int temperature = Integer.parseInt(tokens[1]);
                        int humidity = Integer.parseInt(tokens[2]);
                        int wind_speed = Integer.parseInt(tokens[3]);
                        
                        graph.addVertex(vertex, temperature, humidity, wind_speed);
                        //graph.addVertex(destVertex, 30, 70, 15);
                        //graph.addEdge(srcVertex, destVertex, distance);
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading file: " + e.getMessage());
            }


            //Read File and populate variables
            boolean firstLine = true;
            try (BufferedReader reader = new BufferedReader(new FileReader("location.txt"))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    if (firstLine) 
                    {
                        firstLine = false;
                        continue; // Skip the first line
                    }
                    String[] tokens = line.split(" ");
                    if (tokens.length == 3) 
                    {
                        String srcVertex = tokens[0];
                        String destVertex = tokens[1];
                        float distance = Float.parseFloat(tokens[2]);
                        //graph.addVertex(srcVertex, 30, 70, 15);
                        //graph.addVertex(destVertex, 30, 70, 15);
                        graph.addEdge(srcVertex, destVertex, distance);
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading file: " + e.getMessage());
            }


            // Add vertices
            /*graph.addVertex("A", 25, 80, 10);
            graph.addVertex("B", 30, 70, 15);
            graph.addVertex("C", 28, 75, 12);
            graph.addVertex("D", 22, 85, 8);*/
        
            // Add edges
            /*graph.addEdge("A", "B", 5);
            graph.addEdge("A", "C", 7);
            graph.addEdge("B", "D", 10);
            graph.addEdge("C", "D", 8);*/
        
            // Display the graph
            graph.displayGraph();

            System.out.println("Depth First Search Path: ");
            graph.dfsTraversal();

            graph.bfsTraversal("B", "D");

            String[] pathArray = {"A", "B", "C", "D"};

            graph.displayItinerary(pathArray[0], pathArray[1], pathArray[2], pathArray[3]);

        }
        
        else if (option == 6)
        {

            DSAHashTable<String, String> hashTable = new DSAHashTable<>();
            //Read File and populate variables
            try (BufferedReader reader = new BufferedReader(new FileReader("UAVdata.txt"))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    
                    String[] tokens = line.split(" ");
                    if (tokens.length == 4 ) 
                    {
                        String vertex = tokens[0];
                        
                        int temperature = Integer.parseInt(tokens[1]);
                        int humidity = Integer.parseInt(tokens[2]);
                        int wind_speed = Integer.parseInt(tokens[3]);
                        String sTemperature = (tokens[1]);
                        String sHumidity = (tokens[2]);
                        String sWind_speed = (tokens[3]);
                        
                        graph.addVertex(vertex, temperature, humidity, wind_speed);
                        // Testing put method
                        String hashValue =  sTemperature.concat("\nHumidity- ").concat(sHumidity).concat("\nWind Speed- ").concat(sWind_speed);
                        hashTable.put(vertex, hashValue);
                        //System.out.println(hashValue);
                        
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading file: " + e.getMessage());
            }


            //Read File and populate variables
            boolean firstLine = true;
            try (BufferedReader reader = new BufferedReader(new FileReader("location.txt"))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    if (firstLine) 
                    {
                        firstLine = false;
                        continue; // Skip the first line
                    }
                    String[] tokens = line.split(" ");
                    if (tokens.length == 3) 
                    {
                        String srcVertex = tokens[0];
                        String destVertex = tokens[1];
                        float distance = Float.parseFloat(tokens[2]);
                        //graph.addVertex(srcVertex, 30, 70, 15);
                        //graph.addVertex(destVertex, 30, 70, 15);
                        graph.addEdge(srcVertex, destVertex, distance);
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading file: " + e.getMessage());
            }

            System.out.println("Details of Area B\nTemperarture-");
            System.out.println(hashTable.get("B"));
        }
        else if (option == 5 )
        {
            
            //Read File and populate variables
            try (BufferedReader reader = new BufferedReader(new FileReader("UAVdata.txt"))) 
            {
                String line;
                //int temp = 0;
                while ((line = reader.readLine()) != null) 
                {
                    
                    String[] tokens = line.split(" ");
                    if (tokens.length == 4 ) 
                    {
                        String vertex = tokens[0];
                        
                        int temperature = Integer.parseInt(tokens[1]);
                        int humidity = Integer.parseInt(tokens[2]);
                        int wind_speed = Integer.parseInt(tokens[3]);
                        
                        graph.addVertex(vertex, temperature, humidity, wind_speed);
                        
                        graph.ArrayForHighRisk(vertex, temperature, humidity, wind_speed);
                        
                        //graph.addVertex(destVertex, 30, 70, 15);
                        //graph.addEdge(srcVertex, destVertex, distance);
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading file: " + e.getMessage());
            }


            //Read File and populate variables
            boolean firstLine = true;
            try (BufferedReader reader = new BufferedReader(new FileReader("location.txt"))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    if (firstLine) 
                    {
                        firstLine = false;
                        continue; // Skip the first line
                    }
                    String[] tokens = line.split(" ");
                    if (tokens.length == 3) 
                    {
                        String srcVertex = tokens[0];
                        String destVertex = tokens[1];
                        float distance = Float.parseFloat(tokens[2]);
                        //graph.addVertex(srcVertex, 30, 70, 15);
                        //graph.addVertex(destVertex, 30, 70, 15);
                        graph.addEdge(srcVertex, destVertex, distance);
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading file: " + e.getMessage());
            }

            
            graph.displayItinerary("A", "C", "D", "E", "F", "G", "H", "J");
            

            
        }
        else if (option == 7)
        {
            DSAHeap heap = new DSAHeap();

            //Read File and populate variables
            try (BufferedReader reader = new BufferedReader(new FileReader("UAVdata.txt"))) 
            {
                String line;
                int risk;
                while ((line = reader.readLine()) != null) 
                {
                    
                    String[] tokens = line.split(" ");
                    if (tokens.length == 4 ) 
                    {
                        String vertex = tokens[0];
                        
                        int temperature = Integer.parseInt(tokens[1]);
                        int humidity = Integer.parseInt(tokens[2]);
                        int wind_speed = Integer.parseInt(tokens[3]);
                        
                        graph.addVertex(vertex, temperature, humidity, wind_speed);
                        risk = graph.riskForHeap(vertex, temperature, humidity, wind_speed);
                        //graph.addVertex(destVertex, 30, 70, 15);
                        //graph.addEdge(srcVertex, destVertex, distance);
                       
                        heap.insert(risk, vertex);
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading file: " + e.getMessage());
            }


            //Read File and populate variables
            boolean firstLine = true;
            try (BufferedReader reader = new BufferedReader(new FileReader("location.txt"))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    if (firstLine) 
                    {
                        firstLine = false;
                        continue; // Skip the first line
                    }
                    String[] tokens = line.split(" ");
                    if (tokens.length == 3) 
                    {
                        String srcVertex = tokens[0];
                        String destVertex = tokens[1];
                        float distance = Float.parseFloat(tokens[2]);
                        //graph.addVertex(srcVertex, 30, 70, 15);
                        //graph.addVertex(destVertex, 30, 70, 15);
                        graph.addEdge(srcVertex, destVertex, distance);
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading file: " + e.getMessage());
            }

            System.out.println("All area details have been entered to a heap ");
            heap.displayHeap();
        }
        else
        {
            System.out.println("Please enter a valid option. Example:- 1 or 5");
        }


            
        

        sc.close();


    }
    
    
}
