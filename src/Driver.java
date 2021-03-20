// This Driver file will be replaced by ours during grading
// Do not include this file in your final submission

import java.io.File;
import java.util.*;

public class Driver {
    private static String filename; // input file name
    private static boolean testHeap; // set to true by -h flag
    private static boolean testMinStuCost; // set to true by -s flag
    private static boolean testMinClassCost; // set to true by -c flag
    private static Program2 testProgram2; // instance of your graph
    private static ArrayList<Student> students;

    private static void usage() { // error message
        System.err.println("usage: java Driver [-h] [-s] [-c] <filename>");
        System.err.println("\t-h\tTest Heap implementation");
        System.err.println("\t-s\tTest findMinimumStudentCost implementation");
        System.err.println("\t-c\tTest findMinimumClassCost implementation");
        System.exit(1);
    }

    public static void main(String[] args) throws Exception {
        students = new ArrayList<Student>();
        parseArgs(args);
        parseInputFile(filename);
        testRun();
    }

    public static void parseArgs(String[] args) {
        boolean flagsPresent = false;
        if (args.length == 0) {
            usage();
        }
        filename = "";
        testHeap = false;
        testMinStuCost = false;
        testMinClassCost = false;
        for (String s : args) {
            if (s.equals("-h")) {
                flagsPresent = true;
                testHeap = true;
            } else if (s.equals("-s")) {
                flagsPresent = true;
                testMinStuCost = true;
            } else if (s.equals("-c")) {
                flagsPresent = true;
                testMinClassCost = true;
            } else if (!s.startsWith("-")) {
                filename = s;
            } else {
                System.err.printf("Unknown option: %s\n", s);
                usage();
            }
        }

        if (!flagsPresent) {
            testHeap = true;
            testMinStuCost = true;
            testMinClassCost = true;
        }
    }

    public static void parseInputFile(String filename) throws Exception {
        int numV = 0, numE = 0;
        Scanner sc = new Scanner(new File(filename));
        String[] inputSize = sc.nextLine().split(" ");
        numV = Integer.parseInt(inputSize[0]);
        numE = Integer.parseInt(inputSize[1]);
        HashMap<Integer, ArrayList<NeighborPriceTuple>> tempNeighbors = new HashMap<>();
        testProgram2 = new Program2(numV);
        for (int i = 0; i < numV; ++i) {

            String[] pairs = sc.nextLine().split(" ");
            String[] pricePairs = sc.nextLine().split(" ");

            Integer currNode = Integer.parseInt(pairs[0]);
            Student currentStudent = new Student(currNode);
            students.add(currNode, currentStudent);
            ArrayList<NeighborPriceTuple> currNeighbors = new ArrayList<>();
            tempNeighbors.put(currNode, currNeighbors);

            for (int k = 1; k < pairs.length; k++) {
                Integer neighborVal = Integer.parseInt(pairs[k]);
                Integer priceVal = Integer.parseInt(pricePairs[k]);
                currNeighbors.add(new NeighborPriceTuple(neighborVal, priceVal));
            }
        }
        for (int i = 0; i < students.size(); ++i) {
            Student currStudent = students.get(i);
            ArrayList<NeighborPriceTuple> neighbors = tempNeighbors.get(i);
            for (NeighborPriceTuple neighbor : neighbors) {
                testProgram2.setEdge(currStudent, students.get(neighbor.neighborID), neighbor.price);
            }
        }

        testProgram2.setAllNodesArray(students);
    }

    // feel free to alter this method however you wish, we will replace it with our own version during grading
    public static void testRun() {
        if (testHeap) {
            /*

            // test out Heap.java here
            Student zero = new Student(0);
            zero.setminCost(27);
            Student one = new Student(1);
            one.setminCost(11);
            Student two = new Student(2);
            two.setminCost(27);
            Student three = new Student(3);
            three.setminCost(27);
            Student four = new Student(4);
            four.setminCost(18);
            Student five = new Student(5);
            five.setminCost(27);
            Student six = new Student(6);
            six.setminCost(50);
            Student seven = new Student(7);
            seven.setminCost(95);
            Student eight = new Student(8);
            eight.setminCost(67);
            Student nine = new Student(9);
            nine.setminCost(23);
            Student ten = new Student(10);
            ten.setminCost(93);

            ArrayList<Student> tester = new ArrayList<>();
            tester.add(two);
            tester.add(zero);
            tester.add(one);
            tester.add(three);
            tester.add(four);
            tester.add(five);
            tester.add(six);
            tester.add(seven);
            tester.add(eight);
            tester.add(nine);
            tester.add(ten);
            testProgram2.getHeap().buildHeap(tester);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(nine, 100);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(one, 1000);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(6);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(6);
            System.out.println(testProgram2.getHeap());

            Student minimum;
            minimum = testProgram2.getHeap().extractMin();
            System.out.println(minimum.getName() + ": " + minimum.getminCost());
            System.out.println(testProgram2.getHeap());
            minimum = testProgram2.getHeap().extractMin();
            System.out.println(minimum.getName() + ": " + minimum.getminCost());
            System.out.println(testProgram2.getHeap());
            minimum = testProgram2.getHeap().extractMin();
            System.out.println(minimum.getName() + ": " + minimum.getminCost());
            System.out.println(testProgram2.getHeap());
            minimum = testProgram2.getHeap().extractMin();
            System.out.println(minimum.getName() + ": " + minimum.getminCost());
            System.out.println(testProgram2.getHeap());
            minimum = testProgram2.getHeap().extractMin();
            System.out.println(minimum.getName() + ": " + minimum.getminCost());
            System.out.println(testProgram2.getHeap());
            minimum = testProgram2.getHeap().extractMin();
            System.out.println(minimum.getName() + ": " + minimum.getminCost());
            System.out.println(testProgram2.getHeap());
            minimum = testProgram2.getHeap().extractMin();
            System.out.println(minimum.getName() + ": " + minimum.getminCost());
            System.out.println(testProgram2.getHeap());
            minimum = testProgram2.getHeap().extractMin();
            System.out.println(minimum.getName() + ": " + minimum.getminCost());
            System.out.println(testProgram2.getHeap());
            minimum = testProgram2.getHeap().extractMin();
            System.out.println(minimum.getName() + ": " + minimum.getminCost());
            System.out.println(testProgram2.getHeap());

            testProgram2.getHeap().buildHeap(tester);
            System.out.println(testProgram2.getHeap());

            tester.clear();
            testProgram2.getHeap().buildHeap(tester);
            System.out.println(testProgram2.getHeap());

            tester.add(one);
            tester.add(six);
            tester.add(seven);
            tester.add(nine);
            tester.add(two);
            testProgram2.getHeap().buildHeap(tester);
            System.out.println(testProgram2.getHeap());

            tester.clear();
            tester.add(one);
            tester.add(zero);
            tester.add(ten);
            testProgram2.getHeap().buildHeap(tester);
            System.out.println(testProgram2.getHeap());

            minimum = testProgram2.getHeap().findMin();
            System.out.println(minimum.getName() + ": " + minimum.getminCost());
            minimum = testProgram2.getHeap().findMin();
            System.out.println(minimum.getName() + ": " + minimum.getminCost());

            testProgram2.getHeap().insertNode(nine);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().insertNode(two);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(0);
            testProgram2.getHeap().delete(3);


            System.out.println(testProgram2.getHeap());
            minimum = testProgram2.getHeap().extractMin();
            System.out.println(minimum.getName() + ": " + minimum.getminCost());

            minimum = testProgram2.getHeap().extractMin();
            System.out.println(minimum.getName() + ": " + minimum.getminCost());

            minimum = testProgram2.getHeap().extractMin();
            System.out.println(minimum.getName() + ": " + minimum.getminCost());

             */
        }

        if (testMinStuCost) {
            // test out Program2.java findMinimumStudentCost here
            System.out.println("\nGiven wire configuration: ");
            System.out.println(testProgram2);
            for(int i = 0; i < testProgram2.getAllstudents().size(); ++i){
                for(int j = 0; j < testProgram2.getAllstudents().size(); ++j){
                    System.out.println("Minimum student cost from " + i + " to " + (j+i)%testProgram2.getAllstudents().size()
                            + ": " + testProgram2.findMinimumStudentCost(students.get(i), students.get((j+i)%testProgram2.getAllstudents().size())));
                }
            }
        }

        if (testMinClassCost) {
            // test out Program2.java findMinimumClassCost here
            System.out.println("\nGiven wire configuration: ");
            System.out.println(testProgram2);
            System.out.println("Minimum class cost: \n" + testProgram2.findMinimumClassCost());
        }
    }

    private static class NeighborPriceTuple {
        public Integer neighborID;
        public Integer price;

        NeighborPriceTuple(Integer neighborID, Integer price) {
            this.neighborID = neighborID;
            this.price = price;
        }
    }
}
