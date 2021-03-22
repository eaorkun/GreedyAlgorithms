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
            //Automated Test Code:
            Student student0 = new Student(0);
            student0.setminCost(46);
            Student student1 = new Student(1);
            student1.setminCost(77);
            Student student2 = new Student(2);
            student2.setminCost(40);
            Student student3 = new Student(3);
            student3.setminCost(99);
            Student student4 = new Student(4);
            student4.setminCost(33);
            Student student5 = new Student(5);
            student5.setminCost(44);
            Student student6 = new Student(6);
            student6.setminCost(24);
            Student student7 = new Student(7);
            student7.setminCost(92);
            Student student8 = new Student(8);
            student8.setminCost(62);
            Student student9 = new Student(9);
            student9.setminCost(22);
            Student student10 = new Student(10);
            student10.setminCost(50);
            Student student11 = new Student(11);
            student11.setminCost(95);
            Student student12 = new Student(12);
            student12.setminCost(72);
            Student student13 = new Student(13);
            student13.setminCost(72);
            Student student14 = new Student(14);
            student14.setminCost(25);
            Student student15 = new Student(15);
            student15.setminCost(52);
            Student student16 = new Student(16);
            student16.setminCost(50);
            Student student17 = new Student(17);
            student17.setminCost(7);
            Student student18 = new Student(18);
            student18.setminCost(93);
            Student student19 = new Student(19);
            student19.setminCost(48);
            Student student20 = new Student(20);
            student20.setminCost(31);
            Student student21 = new Student(21);
            student21.setminCost(63);
            Student student22 = new Student(22);
            student22.setminCost(8);
            Student student23 = new Student(23);
            student23.setminCost(13);
            Student student24 = new Student(24);
            student24.setminCost(91);
            Student student25 = new Student(25);
            student25.setminCost(31);
            Student student26 = new Student(26);
            student26.setminCost(78);
            Student student27 = new Student(27);
            student27.setminCost(87);
            Student student28 = new Student(28);
            student28.setminCost(58);
            Student student29 = new Student(29);
            student29.setminCost(75);
            Student student30 = new Student(30);
            student30.setminCost(9);
            Student student31 = new Student(31);
            student31.setminCost(19);
            Student student32 = new Student(32);
            student32.setminCost(31);
            Student student33 = new Student(33);
            student33.setminCost(89);
            Student student34 = new Student(34);
            student34.setminCost(16);
            Student student35 = new Student(35);
            student35.setminCost(98);
            Student student36 = new Student(36);
            student36.setminCost(50);
            Student student37 = new Student(37);
            student37.setminCost(23);
            Student student38 = new Student(38);
            student38.setminCost(61);
            Student student39 = new Student(39);
            student39.setminCost(47);

            ArrayList<Student> tester = new ArrayList<>();
            tester.add(student0);
            tester.add(student1);
            tester.add(student2);
            tester.add(student3);
            tester.add(student4);
            tester.add(student5);
            tester.add(student6);
            tester.add(student7);
            tester.add(student8);
            tester.add(student9);
            tester.add(student10);
            tester.add(student11);
            tester.add(student12);
            tester.add(student13);
            tester.add(student14);
            tester.add(student15);
            tester.add(student16);
            tester.add(student17);
            tester.add(student18);
            tester.add(student19);
            tester.add(student20);
            tester.add(student21);
            tester.add(student22);
            tester.add(student23);
            tester.add(student24);
            tester.add(student25);
            tester.add(student26);
            tester.add(student27);
            tester.add(student28);
            tester.add(student29);
            tester.add(student30);
            tester.add(student31);
            tester.add(student32);
            tester.add(student33);
            tester.add(student34);
            tester.add(student35);
            tester.add(student36);
            tester.add(student37);
            tester.add(student38);
            tester.add(student39);

            testProgram2.getHeap().buildHeap(tester);
            System.out.println("Initial Heap");
            System.out.println(testProgram2.getHeap()+"\n");

            System.out.println("Insert Node Test:");
            Student student40 = new Student(40);
            student40.setminCost(97);
            testProgram2.getHeap().insertNode(student40);
            System.out.println(testProgram2.getHeap());
            Student student41 = new Student(41);
            student41.setminCost(23);
            testProgram2.getHeap().insertNode(student41);
            System.out.println(testProgram2.getHeap());
            Student student42 = new Student(42);
            student42.setminCost(67);
            testProgram2.getHeap().insertNode(student42);
            System.out.println(testProgram2.getHeap());
            Student student43 = new Student(43);
            student43.setminCost(86);
            testProgram2.getHeap().insertNode(student43);
            System.out.println(testProgram2.getHeap());
            Student student44 = new Student(44);
            student44.setminCost(49);
            testProgram2.getHeap().insertNode(student44);
            System.out.println(testProgram2.getHeap());
            Student student45 = new Student(45);
            student45.setminCost(76);
            testProgram2.getHeap().insertNode(student45);
            System.out.println(testProgram2.getHeap());
            Student student46 = new Student(46);
            student46.setminCost(54);
            testProgram2.getHeap().insertNode(student46);
            System.out.println(testProgram2.getHeap());
            Student student47 = new Student(47);
            student47.setminCost(44);
            testProgram2.getHeap().insertNode(student47);
            System.out.println(testProgram2.getHeap());
            Student student48 = new Student(48);
            student48.setminCost(71);
            testProgram2.getHeap().insertNode(student48);
            System.out.println(testProgram2.getHeap());
            Student student49 = new Student(49);
            student49.setminCost(82);
            testProgram2.getHeap().insertNode(student49);
            System.out.println(testProgram2.getHeap());

            System.out.println("\nChange Key Test:");
            testProgram2.getHeap().changeKey(student31,9);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student3,95);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student23,12);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student12,91);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student33,26);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student22,48);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student20,37);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student0,44);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student2,42);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student2,4);
            System.out.println(testProgram2.getHeap());

            System.out.println("\nDelete Test:");
            testProgram2.getHeap().delete(20);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(12);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(9);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(34);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(10);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(22);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(23);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(9);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(21);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(38);
            System.out.println(testProgram2.getHeap());

            System.out.println("\nExtract Min Test:");
            Student min = testProgram2.getHeap().extractMin();
            System.out.println(min.getName());
            System.out.println(testProgram2.getHeap());
            min = testProgram2.getHeap().extractMin();
            System.out.println(min.getName());
            System.out.println(testProgram2.getHeap());
            min = testProgram2.getHeap().extractMin();
            System.out.println(min.getName());
            System.out.println(testProgram2.getHeap());
            min = testProgram2.getHeap().extractMin();
            System.out.println(min.getName());
            System.out.println(testProgram2.getHeap());
            min = testProgram2.getHeap().extractMin();
            System.out.println(min.getName());
            System.out.println(testProgram2.getHeap());
            min = testProgram2.getHeap().extractMin();
            System.out.println(min.getName());
            System.out.println(testProgram2.getHeap());
            min = testProgram2.getHeap().extractMin();
            System.out.println(min.getName());
            System.out.println(testProgram2.getHeap());
            min = testProgram2.getHeap().extractMin();
            System.out.println(min.getName());
            System.out.println(testProgram2.getHeap());
            min = testProgram2.getHeap().extractMin();
            System.out.println(min.getName());
            System.out.println(testProgram2.getHeap());
            min = testProgram2.getHeap().extractMin();
            System.out.println(min.getName());
            System.out.println(testProgram2.getHeap());
            min = testProgram2.getHeap().extractMin();
            System.out.println(min.getName());
            System.out.println(testProgram2.getHeap());
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
