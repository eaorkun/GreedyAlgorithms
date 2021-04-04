/*
 * Name: Eralp Orkun
 * EID: eao789
 */

// Implement your heap here
// Methods may be added to this file, but don't remove anything
// Include this file in your final submission

import java.util.ArrayList;
import java.util.HashMap;

public class Heap {
    private ArrayList<Student> minHeap;
    private int size; //keeps true size of heap (some elements in ArrayList are ignored)
    private HashMap<Integer, Integer> map; //maps students to their position in heap

    public Heap() {
        minHeap = new ArrayList<Student>();
        size = 0;
        map = new HashMap<>();
    }

    // Returns size of heap
    public int size() {
        return size;
    }

    // Returns the Hashmap containing the indexes for each student
    public HashMap<Integer, Integer> getMap() {
        return map;
    }

    /**
     * buildHeap(ArrayList<Student> students)
     * Given an ArrayList of Students, build a min-heap keyed on each Student's minCost
     * Time Complexity - O(nlog(n)) or O(n)
     *
     * @param students
     */
    public void buildHeap(ArrayList<Student> students) {
        minHeap.ensureCapacity(students.size()); //allocate memory
        size = 0;
        for (Integer student : map.keySet()) { // remove any previous map links (new heap)
            map.replace(student, -1);
        }
        for (Student student : students) { // insert all elements one at a time
            insertNode(student);
        }
    }

    /**
     * insertNode(Student in)
     * Insert a Student into the heap.
     * Time Complexity - O(log(n))
     *
     * @param in - the Student to insert.
     */
    public void insertNode(Student in) {
        if (minHeap.size() < size + 1) { //allocate more memory if needed
            minHeap.add(in);
        }
        else { //override old entries
            minHeap.set(size, in);
        }
        if (!map.containsKey(in.getName())) { // add to map if not there
            map.put(in.getName(), size);
        }
        else { //replace old map links
            map.replace(in.getName(), size);
        }
        heapifyUp(size); //fix heap after insertion
        ++size;
    }

    private void heapifyUp(int index) {
        if (index > 0) { //only needed if more than 1 elements in heap
            int indexP = (((index + 1) / 2) - 1); //parent
            if ((minHeap.get(index).getminCost() < minHeap.get(indexP).getminCost()) ||
                    ((minHeap.get(index).getminCost() == minHeap.get(indexP).getminCost()) && (minHeap.get(index).getName() < minHeap.get(indexP).getName()))) {
                Student temp = minHeap.get(index); //Swap
                minHeap.set(index, minHeap.get(indexP)); //update map
                minHeap.set(indexP, temp);
                map.replace(minHeap.get(index).getName(), index);
                map.replace(minHeap.get(indexP).getName(), indexP);
                heapifyUp(indexP);
            }
        }
    }

    /**
     * findMin()
     * Time Complexity - O(1)
     *
     * @return the minimum element of the heap.
     */
    public Student findMin() {
        return minHeap.get(0); //find
    }

    /**
     * extractMin()
     * Time Complexity - O(log(n))
     *
     * @return the minimum element of the heap, AND removes the element from said heap.
     */
    public Student extractMin() {
        Student minimum = minHeap.get(0); //find
        delete(0); //remove
        return minimum;
    }

    /**
     * delete(int index)
     * Deletes an element in the min-heap given an index to delete at.
     * Time Complexity - O(log(n))
     *
     * @param index - the index of the item to be deleted in the min-heap.
     */
    public void delete(int index) {
        size--;
        map.replace(minHeap.get(index).getName(), -1);
        if (index != size) { //if the deleted element was NOT the last index in heap
            int oldCost = minHeap.get(index).getminCost();
            minHeap.set(index, minHeap.get(size));
            map.replace(minHeap.get(index).getName(), index);
            int newCost = minHeap.get(index).getminCost();
            if (newCost < oldCost) {
                heapifyUp(index); //fix heap
            }
            else {
                heapifyDown(index); //fix heap
            }
        }
    }

    private void heapifyDown(int index) {
        int maxIndex = size - 1;
        int indexJ = 0;
        if ((2 * index + 1) > maxIndex) {
            //Terminate with H unchanged
            return;
        }
        else if ((2 * index + 1) < maxIndex) {
            int left = 2 * index + 1;
            int right = 2 * (index + 1);
            if ((minHeap.get(left).getminCost() < minHeap.get(right).getminCost()) ||
                    ((minHeap.get(left).getminCost() == minHeap.get(right).getminCost()) && (minHeap.get(left).getName() < minHeap.get(right).getName()))) {
                indexJ = left;
            }
            else {
                indexJ = right;
            }
        }
        else if ((2 * index + 1) == maxIndex) {
            indexJ = (2 * index + 1);
        }
        if ((minHeap.get(indexJ).getminCost() < minHeap.get(index).getminCost()) ||
                ((minHeap.get(indexJ).getminCost() == minHeap.get(index).getminCost()) && (minHeap.get(indexJ).getName() < minHeap.get(index).getName()))) {
            Student temp = minHeap.get(index); //swap
            minHeap.set(index, minHeap.get(indexJ));
            minHeap.set(indexJ, temp);
            map.replace(minHeap.get(index).getName(), index);
            map.replace(minHeap.get(indexJ).getName(), indexJ);
            heapifyDown(indexJ);
        }
    }

    /**
     * changeKey(Student r, int newCost)
     * Changes minCost of Student s to newCost and updates the heap.
     * Time Complexity - O(log(n))
     *
     * @param r       - the Student in the heap that needs to be updated.
     * @param newCost - the new cost of Student r in the heap (note that the heap is keyed on the values of minCost)
     */
    public void changeKey(Student r, int newCost) {
        int index = map.get(r.getName());
        int oldCost = minHeap.get(index).getminCost();
        minHeap.get(index).setminCost(newCost); //change
        if (newCost > oldCost) {
            heapifyDown(index); //fix heap
        }
        else {
            heapifyUp(index); //fix heap
        }
    }

    // for debugging (checks if the heap is a heap)
    public boolean isHeap() {
        int maxIndex = size - 1;
        int index = 0;
        boolean isHeap = true;
        boolean check = true;
        while (check) {
            if ((2 * index + 1) > maxIndex) {
                //Terminate with H unchanged
                check = false;
            }
            else if ((2 * index + 1) < maxIndex) {
                int left = 2 * index + 1;
                int right = 2 * (index + 1);
                if (!((minHeap.get(index).getminCost() < minHeap.get(left).getminCost()) ||
                        ((minHeap.get(index).getminCost() == minHeap.get(left).getminCost()) && (minHeap.get(index).getName() < minHeap.get(left).getName())) ||
                        ((minHeap.get(index).getminCost() == minHeap.get(left).getminCost()) && (minHeap.get(index).getName() == minHeap.get(left).getName())))) {
                    isHeap = false;
                    check = false;
                }
                if (!((minHeap.get(index).getminCost() < minHeap.get(right).getminCost()) ||
                        ((minHeap.get(index).getminCost() == minHeap.get(right).getminCost()) && (minHeap.get(index).getName() < minHeap.get(right).getName())) ||
                        ((minHeap.get(index).getminCost() == minHeap.get(right).getminCost()) && (minHeap.get(index).getName() == minHeap.get(right).getName())))) {
                    isHeap = false;
                    check = false;
                }

            }
            else if ((2 * index + 1) == maxIndex) {
                int left = 2 * index + 1;
                if (!((minHeap.get(index).getminCost() < minHeap.get(left).getminCost()) ||
                        ((minHeap.get(index).getminCost() == minHeap.get(left).getminCost()) && (minHeap.get(index).getName() < minHeap.get(left).getName())) ||
                        ((minHeap.get(index).getminCost() == minHeap.get(left).getminCost()) && (minHeap.get(index).getName() == minHeap.get(left).getName())))) {
                    isHeap = false;
                    check = false;
                }
            }
            index++;
        }
        return isHeap;
    }


    public String toString() {
        String output = "";
        for (int i = 0; i < size; i++) { //changed to be my heap size and not iterate over unused elements
            output += minHeap.get(i).getName() + " ";
        }
        return output;
    }

///////////////////////////////////////////////////////////////////////////////
//                           DANGER ZONE                                     //
//                everything below is used for grading                       //
//                      please do not change :)                              //
///////////////////////////////////////////////////////////////////////////////

    //Given permission by TA Ali to adjust this function

    public ArrayList<Student> toArrayList() {
        ArrayList<Student> realHeap = new ArrayList<>();
        for(int i = 0; i<size; ++i){
            realHeap.add(minHeap.get(i));
        }
        return realHeap;
    }
}
