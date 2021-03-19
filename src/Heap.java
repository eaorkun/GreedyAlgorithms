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
    private int size;
    private HashMap<Integer, Integer> map;

    public Heap() {
        minHeap = new ArrayList<Student>();
        size = 0;
        map = new HashMap<>();
    }

    public int size(){
        return size;
    }

    public HashMap<Integer, Integer> getMap(){
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
        minHeap.ensureCapacity(students.size());
        size = 0;
        for(Integer student : map.keySet()){
            map.replace(student, -1);
        }
        for (Student student : students) {
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
        // TODO: implement this method
        if(minHeap.size() < size + 1){
            minHeap.add(in);
        }
        else{
            minHeap.set(size, in);
        }
        if(!map.containsKey(in.getName())){
            map.put(in.getName(), size);
        }
        else{
            map.replace(in.getName(), size);
        }

        heapifyUp(size);
        ++size;
    }

    private void heapifyUp(int index){
        if(index>0){
            int indexP = (index/2);
            if((minHeap.get(index).getminCost() < minHeap.get(indexP).getminCost()) ||
                    ((minHeap.get(index).getminCost() == minHeap.get(indexP).getminCost()) && (minHeap.get(index).getName() < minHeap.get(indexP).getName()))){
                Student temp = minHeap.get(index);
                minHeap.set(index, minHeap.get(indexP));
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
        // TODO: implement this method
        return minHeap.get(0);
    }

    /**
     * extractMin()
     * Time Complexity - O(log(n))
     *
     * @return the minimum element of the heap, AND removes the element from said heap.
     */
    public Student extractMin() {
        // TODO: implement this method

        Student minimum = minHeap.get(0);
        delete(0);

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
        // TODO: implement this method
        size--;
        map.replace(minHeap.get(index).getName(), -1);
        minHeap.set(index, minHeap.get(size));
        map.replace(minHeap.get(index).getName(), index);
        heapifyDown(index);
    }

    private void heapifyDown(int index){
        int length = size -1;
        int indexJ = 0;
        if(2*index > length){
            //Terminate with H unchanged
            return;
        }
        else if (2*index < length){
            int left = 2*index;
            int right = 2*index + 1;
            if((minHeap.get(left).getminCost() < minHeap.get(right).getminCost()) ||
                    ((minHeap.get(left).getminCost() == minHeap.get(right).getminCost()) && (minHeap.get(left).getName() < minHeap.get(right).getminCost()))){
                indexJ = left;
            }
            else{
                indexJ = right;
            }
        }
        else if (2*index == length){
            indexJ=2*index;
        }
        if((minHeap.get(indexJ).getminCost() < minHeap.get(index).getminCost()) ||
                ((minHeap.get(indexJ).getminCost() == minHeap.get(index).getminCost())&&(minHeap.get(indexJ).getName() < minHeap.get(index).getName()))){
            Student temp = minHeap.get(index);
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
        // TODO: implement this method
        int index = map.get(r.getName());
        int oldCost = minHeap.get(index).getminCost();
        minHeap.get(index).setminCost(newCost);
        if(newCost>oldCost){
            heapifyDown(index);
        }
        else{
            heapifyUp(index);
        }
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < size; i++) {
            output += minHeap.get(i).getName() + " ";
        }
        return output;
    }

///////////////////////////////////////////////////////////////////////////////
//                           DANGER ZONE                                     //
//                everything below is used for grading                       //
//                      please do not change :)                              //
///////////////////////////////////////////////////////////////////////////////

    public ArrayList<Student> toArrayList() {
        return minHeap;
    }
}
