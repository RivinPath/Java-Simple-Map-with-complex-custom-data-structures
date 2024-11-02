/*
 * FILE:Graph.java
 * AUTHOR: Rivin Pathirage
 * UNIT: Data Structures & Algorithms
 * PURPOSE: Implementing the Graph
 * REFERENCES: Practicle 3(DSAStack, DSAQueue), Practicle 4 (DSALinkedList), Practicle 7 (DSAHashTable), Practicle 8 (DSAHeap)
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.*;

public class Graph 
{
    private DSALinkedList vertices;

    //Default Constructor
    public Graph() 
    {
        vertices = new DSALinkedList();
    }


    /*
    * METHOD: addVertex
    * PURPOSE: Inserting a vertex to the graph
    * IMPORTS: name, temperature, humidity, windspeed
    * EXPORTS: 
    */
    public void addVertex(String name, int temperature, int humidity, int windSpeed) 
    {
        GraphNode vertex = new GraphNode(name, temperature, humidity, windSpeed);
        vertices.insertLast(vertex);
    }

    

    
    /*
    * METHOD: addEdge
    * PURPOSE: Wrapper Method for GraphEdge's addEdge method
    * IMPORTS: srcVertex, destVertex, distance
    * EXPORTS: 
    */
    public void addEdge(String srcVertex, String destVertex, float distance) 
    {
        GraphNode srcNode = findNode(srcVertex);
        GraphNode destNode = findNode(destVertex);

        if (srcNode == null || destNode == null) 
        {
            throw new IllegalArgumentException("One or both vertices not found");
        }

        GraphEdge edge = new GraphEdge(destNode, distance);
        srcNode.addEdge(edge);
    }

    
    /*
    * METHOD: findNode
    * PURPOSE: Searching and finding a vertex in the Graph
    * IMPORTS: vertexName
    * EXPORTS: GraphNode
    */
    private GraphNode findNode(String vertexName) 
    {
        Iterator<?> iter = vertices.iterator();
        while (iter.hasNext()) 
        {
            GraphNode node = (GraphNode) iter.next();
            if (node.getName().equals(vertexName)) 
            {
                return node;
            }
        }
        return null;
    }

    

    
    /*
    * METHOD: displayGraph
    * PURPOSE: Displaying the graph in Adjacency List manner
    * IMPORTS:
    * EXPORTS: 
    */
    public void displayGraph() 
    {
        Iterator<?> iter = vertices.iterator();
        while (iter.hasNext()) 
        {
            GraphNode node = (GraphNode) iter.next();
            System.out.print(node.getName() + ": ");
            Iterator<?> edgeIter = node.getEdges().iterator();
            while (edgeIter.hasNext()) 
            {
                GraphEdge edge = (GraphEdge) edgeIter.next();
                System.out.print(edge.getDestination().getName() + " (Distance - " + edge.getDistance() + ") ");
            }
            System.out.println();
        }
    }

    

    /*
    * METHOD: dfsTraversal
    * PURPOSE: Wrapper method for dfs
    * IMPORTS: 
    * EXPORTS: 
    */
    public void dfsTraversal() 
    {
        Iterator<?> iter = vertices.iterator();
        while (iter.hasNext()) 
        {
            GraphNode node = (GraphNode) iter.next();
            if (!node.isVisited()) 
            {
                dfs(node);
            }
        }
    }

    /*
    * METHOD: dfs
    * PURPOSE: traversing through the graph in Depth First Search order
    * IMPORTS: node
    * EXPORTS: 
    */
    private void dfs(GraphNode node) 
    {
        DSAStack stack = new DSAStack();
        stack.push(node);
        node.setVisited(true);

        while (!stack.isEmpty()) 
        {
            GraphNode current = (GraphNode) stack.pop();
            System.out.print(current.getName() + " ");

            Iterator<?> edgeIter = current.getEdges().iterator();
            while (edgeIter.hasNext()) 
            {
                GraphEdge edge = (GraphEdge) edgeIter.next();
                GraphNode nextNode = edge.getDestination();
                if (!nextNode.isVisited()) 
                {
                    stack.push(nextNode);
                    nextNode.setVisited(true);
                }
            }
        }
    }

    /*
    * METHOD: bfsTraversal
    * PURPOSE: traversing through the graph and finding the distance between 2 vertices in Bredth First Search order
    * IMPORTS: startVertex, targetVertex
    * EXPORTS: 
    */
    public void bfsTraversal(String startVertex, String targetVertex) 
    {
        GraphNode startNode = findNode(startVertex);
        GraphNode targetNode = findNode(targetVertex);

        if (startNode == null || targetNode == null) 
        {
            throw new IllegalArgumentException("One or both vertices not found");
        }

        // Create a queue for BFS traversal
        DSAQueue queue = new DSAQueue();

        // Mark all vertices as not visited
        Iterator<?> iter = vertices.iterator();
        while (iter.hasNext()) 
        {
            GraphNode node = (GraphNode) iter.next();
            node.setVisited(false);
        }

        // Enqueue the start vertex and mark it as visited
        queue.enqueue(startNode);
        startNode.setVisited(true);

        boolean pathFound = false;

        // BFS traversal
        while (!queue.isEmpty()) 
        {
            GraphNode current = (GraphNode) queue.dequeue();
            System.out.print(current.getName() + " ");

            // Check if the current vertex is the target vertex
            if (current == targetNode) 
            {
                pathFound = true;
                break;
            }

            // Enqueue all adjacent vertices of the current vertex
            Iterator<?> edgeIter = current.getEdges().iterator();
            while (edgeIter.hasNext()) 
            {
                GraphEdge edge = (GraphEdge) edgeIter.next();
                GraphNode nextNode = edge.getDestination();
                if (!nextNode.isVisited()) 
                {
                    queue.enqueue(nextNode);
                    nextNode.setVisited(true);
                }
            }
        }

        if (pathFound) 
        {
            System.out.println("\nPath found from " + startVertex + " to " + targetVertex);
        } 
        else 
        {
            System.out.println("\nPath not found from " + startVertex + " to " + targetVertex);
        }
    }

    

    /*
    * METHOD: displayItinarary
    * PURPOSE: Getting the itinarary path of entered vertices and displaying the path
    * IMPORTS: vertexNames
    * EXPORTS: 
    */
    public void displayItinerary(String... vertexNames) 
    {
        List<GraphNode> itinerary = new ArrayList<>();
    
        for (String vertexName : vertexNames) 
        {
            GraphNode node = findNode(vertexName);
            if (node != null) 
            {
                itinerary.add(node);
            } 
            else 
            {
                System.out.println("Vertex '" + vertexName + "' not found");
                return;
            }
        }
    
        if (itinerary.size() < 2) 
        {
            System.out.println("At least two vertices are required for an itinerary");
            return;
        }
    
        float totalDistance = 0;
    
        System.out.println("Itinerary:");
    
        for (int i = 0; i < itinerary.size() - 1; i++) 
        {
            GraphNode current = itinerary.get(i);
            GraphNode next = itinerary.get(i + 1);
    
            GraphEdge edge = findEdge(current, next);
            if (edge != null) 
            {
                totalDistance += edge.getDistance();
                System.out.println(current.getName() + " -> " + next.getName() + " (Distance: " + edge.getDistance() + ")");
            } 
            else 
            {
                System.out.println("No edge found between '" + current.getName() + "' and '" + next.getName() + "'");
                return;
            }
        }
    
        System.out.println("Total Distance: " + totalDistance);
    }
    

    /*
    * METHOD: findEdge
    * PURPOSE: finding an Edge
    * IMPORTS: srcNode, destNode
    * EXPORTS: GraphEdge
    */
    private GraphEdge findEdge(GraphNode srcNode, GraphNode destNode) 
    {
        Iterator<?> iter = srcNode.getEdges().iterator();
        while (iter.hasNext()) 
        {
            GraphEdge edge = (GraphEdge) iter.next();
            if (edge.getDestination() == destNode) 
            {
                return edge;
            }
        }
        return null;
    }


    /*
    * METHOD: highRiskAreas
    * PURPOSE: Displaying The risk levels of areas
    * IMPORTS: pVertex, pTemperature, pHumidity, pWindSpeed
    * EXPORTS: 
    */
    public static void highRiskAreas(String pVertex, int pTemperature, int pHumidity, int pWindSpeed)
    {

        System.out.println("Area: "+pVertex+"");

        if (pTemperature > 40)
        {
            System.out.println(" High Risk due to high temperatures\n");
        }
        else if (pTemperature > 32)
        {
            System.out.println(" Medium Risk due to medium temperatures\n");
        }
        else if (pHumidity < 30)
        {
            System.out.println("High Risk due to Low humidity\n");
            
        }
        else if (pHumidity < 50)
        {
            System.out.println(" Medium Risk due to medium humidity\n");
        }
        else if (pWindSpeed > 55)
        {
            System.out.println("High Risk due to high wind Speeds\n");
        }
        else if (pWindSpeed > 41)
        {
            System.out.println(" Medium Risk due to medium wind speeds\n");
        }
        else
        {
            System.out.println(" This Area is completely safe\n");
        }
    }


    /*
    * METHOD: ArrayForHighRisk
    * PURPOSE: Displaying The High areas
    * IMPORTS: pVertex, pTemperature, pHumidity, pWindSpeed
    * EXPORTS: 
    */
    public static void ArrayForHighRisk(String pVertex, int pTemperature, int pHumidity, int pWindSpeed)
    {

        System.out.println("Area: "+pVertex+"");
        

        if (pTemperature > 40 || pHumidity < 30 || pWindSpeed > 55)
        {
            System.out.println(" High Risk area\n");
        }
        else
        {
            System.out.println("Not a high Risk area\n");
        }
        

        
    }


    /*
    * METHOD: riskForHeap
    * PURPOSE: Exporting the Risk levels of an area
    * IMPORTS: pVertex, pTemperature, pHumidity, pWindSpeed
    * EXPORTS: risk
    */
    public static int riskForHeap(String pVertex, int pTemperature, int pHumidity, int pWindSpeed)
    {
        int risk = 0;

        //System.out.println("Area: "+pVertex+"");

        if (pTemperature > 40)
        {
            risk = risk+3;

            if (pHumidity < 30)
            {
                
                risk = risk + 3;

                if (pWindSpeed > 55)
                {
                    risk = risk + 3;
                }
                else if(pWindSpeed > 41)
                {
                    risk = risk + 2;
                }
            
            }
            else if (pHumidity < 50)
            {
                risk = risk + 2;

                if (pWindSpeed > 55)
                {
                    risk = risk + 3;
                }
                else if(pWindSpeed > 41)
                {
                    risk = risk + 2;
                }
            }

            if (pWindSpeed > 55)
            {
               risk = risk + 3;
            }
            else if(pWindSpeed > 41)
            {
                risk = risk + 2;
            }

            return risk;
        }
        else if (pTemperature > 32)
        {
            risk = risk + 2;

            if (pHumidity < 30)
            {
                
                risk = risk + 3;

                if (pWindSpeed > 55)
                {
                    risk = risk + 3;
                }
                else if(pWindSpeed > 41)
                {
                    risk = risk + 2;
                }
            
            }
            else if (pHumidity < 50)
            {
                risk = risk + 2;

                if (pWindSpeed > 55)
                {
                    risk = risk + 3;
                }
                else if(pWindSpeed > 41)
                {
                    risk = risk + 2;
                }
            }

            if (pWindSpeed > 55)
            {
               risk = risk + 3;

               return risk;
            }
            else if(pWindSpeed > 41)
            {
                risk = risk + 2;

                return risk;
            }

            return risk;
        }
        else if (pHumidity < 30)
        {
            risk = risk + 3;

            if (pTemperature > 40)
            {
                
                risk = risk + 3;

                if (pWindSpeed > 55)
                {
                    risk = risk + 3;
                }
                else if(pWindSpeed > 41)
                {
                    risk = risk + 2;
                }
            
            }
            else if (pTemperature > 32)
            {
                risk = risk + 2;

                if (pWindSpeed > 55)
                {
                    risk = risk + 3;
                }
                else if(pWindSpeed > 41)
                {
                    risk = risk + 2;
                }
            }

            if (pWindSpeed > 55)
            {
               risk = risk + 3;
            }
            else if(pWindSpeed > 41)
            {
                risk = risk + 2;
            }

            return risk;
            
        }
        else if (pHumidity < 50)
        {
            risk = risk + 2;

            if (pTemperature > 40)
            {
                
                risk = risk + 3;

                if (pWindSpeed > 55)
                {
                    risk = risk + 3;
                }
                else if(pWindSpeed > 41)
                {
                    risk = risk + 2;
                }
            
            }
            else if (pTemperature > 32)
            {
                risk = risk + 2;

                if (pWindSpeed > 55)
                {
                    risk = risk + 3;
                }
                else if(pWindSpeed > 41)
                {
                    risk = risk + 2;
                }
            }

            if (pWindSpeed > 55)
            {
               risk = risk + 3;
            }
            else if(pWindSpeed > 41)
            {
                risk = risk + 2;
            }

            return risk;
        }
        else if (pWindSpeed > 55)
        {
            risk = risk + 3;

            if (pTemperature > 40)
            {
                
                risk = risk + 3;

                if (pHumidity < 30)
                {
                    risk = risk + 3;
                }
                else if(pHumidity < 50)
                {
                    risk = risk + 2;
                }
            
            }
            else if (pTemperature > 32)
            {
                risk = risk + 2;

                if (pHumidity < 30)
                {
                    risk = risk + 3;
                }
                else if(pHumidity < 50)
                {
                    risk = risk + 2;
                }
            }

            if (pHumidity < 30)
            {
               risk = risk + 3;
            }
            else if(pHumidity < 50)
            {
                risk = risk + 2;
            }
            //l

            return risk;
        }
        else if (pWindSpeed > 41)
        {
            risk = risk + 2;

            if (pTemperature > 40)
            {
                
                risk = risk + 3;

                if (pHumidity < 30)
                {
                    risk = risk + 3;
                }
                else if(pHumidity < 50)
                {
                    risk = risk + 2;
                }
            
            }
            else if (pTemperature > 32)
            {
                risk = risk + 2;

                if (pHumidity < 30)
                {
                    risk = risk + 3;
                }
                else if(pHumidity < 50)
                {
                    risk = risk + 2;
                }
            }

            if (pHumidity < 30)
            {
               risk = risk + 3;
            }
            else if(pHumidity < 50)
            {
                risk = risk + 2;
            }

            return risk;
        }
        

        return risk;
    }

    
    /*
     * FILE:GraphNode.java
     * AUTHOR: Rivin Pathirage
     * UNIT: Data Structures & Algorithms
     * PURPOSE: Implementing the GraphNode (Vertex)
     * REFERENCES:
     */
    private class GraphNode 
    {
        private String name;
        private int temperature;
        private int humidity;
        private int windSpeed;
        private DSALinkedList edges;

        private boolean visited;

        //Default Constructor
        public GraphNode(String name, int temperature, int humidity, int windSpeed) 
        {
            this.name = name;
            this.temperature = temperature;
            this.humidity = humidity;
            this.windSpeed = windSpeed;
            edges = new DSALinkedList();
            visited = false;
        }


        //Accessor
        public boolean isVisited() 
        {
            return visited;
        }

        //Mutator
        public void setVisited(boolean visited) 
        {
            this.visited = visited;
        }

        //
        //Accessors
        //
        public String getName() 
        {
            return name;
        }

        public int getTemperature() 
        {
            return temperature;
        }

        public int getHumidity() 
        {
            return humidity;
        }

        public int getWindSpeed() 
        {
            return windSpeed;
        }

        public DSALinkedList getEdges() 
        {
            return edges;
        }


        /*
        * METHOD: addEdge
        * PURPOSE: adding an edge between two vertices
        * IMPORTS: pVertex, edge
        * EXPORTS: 
        */
        public void addEdge(GraphEdge edge) 
        {
            edges.insertLast(edge);
        }
    }

    /*
     * FILE:GraphEdge.java
     * AUTHOR: Rivin Pathirage
     * UNIT: Data Structures & Algorithms
     * PURPOSE: Implementing the GraphEdge (an Edge)
     * REFERENCES:
     */
    private class GraphEdge 
    {
        private GraphNode destination;
        private float distance;

        //Default Constructor
        public GraphEdge(GraphNode destination, float distance) 
        {
            this.destination = destination;
            this.distance = distance;
        }

        //
        //Accessors
        //
        public GraphNode getDestination() 
        {
            return destination;
        }

        public float getDistance() 
        {
            return distance;
        }
    }
}
