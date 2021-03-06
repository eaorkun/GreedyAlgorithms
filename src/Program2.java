/*
 * Name: Eralp Orkun
 * EID: eao789
 */

// Implement your algorithms here
// Methods may be added to this file, but don't remove anything
// Include this file in your final submission

import java.util.ArrayList;

public class Program2 {
    private ArrayList<Student> students;    // this is a list of all Students, populated by Driver class
    private Heap minHeap;

    // additional constructor fields may be added, but don't delete or modify anything already here
    public Program2(int numStudents) {
        minHeap = new Heap();
        students = new ArrayList<Student>();
    }

    /**
     * findMinimumStudentCost(Student start, Student dest)
     *
     * @param start - the starting Student.
     * @param dest  - the end (destination) Student.
     * @return the minimum cost possible to get from start to dest.
     * Assume the given graph is always connected.
     */
    public int findMinimumStudentCost(Student start, Student dest) {
        initializeSingleSource(start);
        minHeap.buildHeap(students); //build heap from array of studente keyed by minCost
        while (minHeap.size() != 0) { //while heap size does not equal 0.
            Student minimum = minHeap.extractMin();
            if (minimum.getName() == dest.getName()) {
                return minimum.getminCost();
            }
            for (int i = 0; i < minimum.getNeighbors().size(); ++i) { //for each vertex v in m's adjacency list
                relax(minimum, minimum.getNeighbors().get(i), i); //relax
            }
        }
        return -1; //error message
    }

    private void initializeSingleSource(Student start) {
        for (int i = 0; i < students.size(); ++i) { // for each vertex v in the Graph
            students.get(i).setminCost(Integer.MAX_VALUE);
        }
        start.setminCost(0);
    }

    private void relax(Student u, Student v, int i) {
        if (v.getminCost() > u.getminCost() + u.getPrices().get(i)) {
            minHeap.changeKey(v, u.getminCost() + u.getPrices().get(i));
        }
    }

    /**
     * findMinimumClassCost()
     *
     * @return the minimum total cost required to connect (span) each student in the class.
     * Assume the given graph is always connected.
     */
    public int findMinimumClassCost() {
        for (int i = 0; i < students.size(); ++i) { //for Each vertex v in the Graph
            students.get(i).setminCost(Integer.MAX_VALUE);
        }
        Student r = students.get(0); //set minCost of the first student in array to 0
        r.setminCost(0);
        minHeap.buildHeap(students); //build heap from array of students keyed by minCost
        int minimumCost = 0; //counter variable
        while (minHeap.size() != 0) {
            Student minimum = minHeap.extractMin();
            minimumCost = minimumCost + minimum.getminCost(); //update
            for (int i = 0; i < minimum.getNeighbors().size(); ++i) { //for each vertex v in m's adjacency list
                if ((minHeap.getMap().get(minimum.getNeighbors().get(i).getName()) != -1) //if v is in heap
                        && minimum.getPrices().get(i) < minimum.getNeighbors().get(i).getminCost()) {
                    minHeap.changeKey(minimum.getNeighbors().get(i), minimum.getPrices().get(i)); //set and update
                }
            }
        }
        return minimumCost;
    }

    //returns edges and prices in a string.
    public String toString() {
        String o = "";
        for (Student v : students) {
            boolean first = true;
            o += "Student ";
            o += v.getName();
            o += " has neighbors ";
            ArrayList<Student> ngbr = v.getNeighbors();
            for (Student n : ngbr) {
                o += first ? n.getName() : ", " + n.getName();
                first = false;
            }
            first = true;
            o += " with prices ";
            ArrayList<Integer> wght = v.getPrices();
            for (Integer i : wght) {
                o += first ? i : ", " + i;
                first = false;
            }
            o += System.getProperty("line.separator");

        }

        return o;
    }

///////////////////////////////////////////////////////////////////////////////
//                           DANGER ZONE                                     //
//                everything below is used for grading                       //
//                      please do not change :)                              //
///////////////////////////////////////////////////////////////////////////////

    public Heap getHeap() {
        return minHeap;
    }

    public ArrayList<Student> getAllstudents() {
        return students;
    }

    // used by Driver class to populate each Student with correct neighbors and corresponding prices
    public void setEdge(Student curr, Student neighbor, Integer price) {
        curr.setNeighborAndPrice(neighbor, price);
    }

    // used by Driver.java and sets students to reference an ArrayList of all Students
    public void setAllNodesArray(ArrayList<Student> x) {
        students = x;
    }
}
