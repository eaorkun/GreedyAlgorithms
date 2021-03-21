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
            student0.setminCost(25);
            Student student1 = new Student(1);
            student1.setminCost(80);
            Student student2 = new Student(2);
            student2.setminCost(99);
            Student student3 = new Student(3);
            student3.setminCost(34);
            Student student4 = new Student(4);
            student4.setminCost(24);
            Student student5 = new Student(5);
            student5.setminCost(81);
            Student student6 = new Student(6);
            student6.setminCost(61);
            Student student7 = new Student(7);
            student7.setminCost(35);
            Student student8 = new Student(8);
            student8.setminCost(66);
            Student student9 = new Student(9);
            student9.setminCost(1);
            Student student10 = new Student(10);
            student10.setminCost(63);
            Student student11 = new Student(11);
            student11.setminCost(36);
            Student student12 = new Student(12);
            student12.setminCost(43);
            Student student13 = new Student(13);
            student13.setminCost(87);
            Student student14 = new Student(14);
            student14.setminCost(90);
            Student student15 = new Student(15);
            student15.setminCost(74);
            Student student16 = new Student(16);
            student16.setminCost(68);
            Student student17 = new Student(17);
            student17.setminCost(15);
            Student student18 = new Student(18);
            student18.setminCost(79);
            Student student19 = new Student(19);
            student19.setminCost(44);
            Student student20 = new Student(20);
            student20.setminCost(18);
            Student student21 = new Student(21);
            student21.setminCost(12);
            Student student22 = new Student(22);
            student22.setminCost(17);
            Student student23 = new Student(23);
            student23.setminCost(65);
            Student student24 = new Student(24);
            student24.setminCost(66);
            Student student25 = new Student(25);
            student25.setminCost(91);
            Student student26 = new Student(26);
            student26.setminCost(63);
            Student student27 = new Student(27);
            student27.setminCost(70);
            Student student28 = new Student(28);
            student28.setminCost(26);
            Student student29 = new Student(29);
            student29.setminCost(17);
            Student student30 = new Student(30);
            student30.setminCost(15);
            Student student31 = new Student(31);
            student31.setminCost(7);
            Student student32 = new Student(32);
            student32.setminCost(88);
            Student student33 = new Student(33);
            student33.setminCost(67);
            Student student34 = new Student(34);
            student34.setminCost(97);
            Student student35 = new Student(35);
            student35.setminCost(16);
            Student student36 = new Student(36);
            student36.setminCost(57);
            Student student37 = new Student(37);
            student37.setminCost(80);
            Student student38 = new Student(38);
            student38.setminCost(24);
            Student student39 = new Student(39);
            student39.setminCost(49);
            Student student40 = new Student(40);
            student40.setminCost(57);
            Student student41 = new Student(41);
            student41.setminCost(26);
            Student student42 = new Student(42);
            student42.setminCost(70);
            Student student43 = new Student(43);
            student43.setminCost(5);
            Student student44 = new Student(44);
            student44.setminCost(52);
            Student student45 = new Student(45);
            student45.setminCost(54);
            Student student46 = new Student(46);
            student46.setminCost(43);
            Student student47 = new Student(47);
            student47.setminCost(43);
            Student student48 = new Student(48);
            student48.setminCost(22);
            Student student49 = new Student(49);
            student49.setminCost(44);
            Student student50 = new Student(50);
            student50.setminCost(85);
            Student student51 = new Student(51);
            student51.setminCost(48);
            Student student52 = new Student(52);
            student52.setminCost(65);
            Student student53 = new Student(53);
            student53.setminCost(97);
            Student student54 = new Student(54);
            student54.setminCost(30);
            Student student55 = new Student(55);
            student55.setminCost(40);
            Student student56 = new Student(56);
            student56.setminCost(5);
            Student student57 = new Student(57);
            student57.setminCost(80);
            Student student58 = new Student(58);
            student58.setminCost(45);
            Student student59 = new Student(59);
            student59.setminCost(11);
            Student student60 = new Student(60);
            student60.setminCost(90);
            Student student61 = new Student(61);
            student61.setminCost(69);
            Student student62 = new Student(62);
            student62.setminCost(46);
            Student student63 = new Student(63);
            student63.setminCost(8);
            Student student64 = new Student(64);
            student64.setminCost(96);
            Student student65 = new Student(65);
            student65.setminCost(96);
            Student student66 = new Student(66);
            student66.setminCost(30);
            Student student67 = new Student(67);
            student67.setminCost(85);
            Student student68 = new Student(68);
            student68.setminCost(65);
            Student student69 = new Student(69);
            student69.setminCost(77);
            Student student70 = new Student(70);
            student70.setminCost(67);
            Student student71 = new Student(71);
            student71.setminCost(80);
            Student student72 = new Student(72);
            student72.setminCost(27);
            Student student73 = new Student(73);
            student73.setminCost(17);
            Student student74 = new Student(74);
            student74.setminCost(41);
            Student student75 = new Student(75);
            student75.setminCost(75);
            Student student76 = new Student(76);
            student76.setminCost(29);
            Student student77 = new Student(77);
            student77.setminCost(10);
            Student student78 = new Student(78);
            student78.setminCost(43);
            Student student79 = new Student(79);
            student79.setminCost(64);
            Student student80 = new Student(80);
            student80.setminCost(15);
            Student student81 = new Student(81);
            student81.setminCost(65);
            Student student82 = new Student(82);
            student82.setminCost(64);
            Student student83 = new Student(83);
            student83.setminCost(39);
            Student student84 = new Student(84);
            student84.setminCost(5);
            Student student85 = new Student(85);
            student85.setminCost(94);
            Student student86 = new Student(86);
            student86.setminCost(75);
            Student student87 = new Student(87);
            student87.setminCost(69);
            Student student88 = new Student(88);
            student88.setminCost(53);
            Student student89 = new Student(89);
            student89.setminCost(50);
            Student student90 = new Student(90);
            student90.setminCost(80);
            Student student91 = new Student(91);
            student91.setminCost(73);
            Student student92 = new Student(92);
            student92.setminCost(36);
            Student student93 = new Student(93);
            student93.setminCost(80);
            Student student94 = new Student(94);
            student94.setminCost(59);
            Student student95 = new Student(95);
            student95.setminCost(32);
            Student student96 = new Student(96);
            student96.setminCost(3);
            Student student97 = new Student(97);
            student97.setminCost(75);
            Student student98 = new Student(98);
            student98.setminCost(34);
            Student student99 = new Student(99);
            student99.setminCost(12);

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
            tester.add(student40);
            tester.add(student41);
            tester.add(student42);
            tester.add(student43);
            tester.add(student44);
            tester.add(student45);
            tester.add(student46);
            tester.add(student47);
            tester.add(student48);
            tester.add(student49);
            tester.add(student50);
            tester.add(student51);
            tester.add(student52);
            tester.add(student53);
            tester.add(student54);
            tester.add(student55);
            tester.add(student56);
            tester.add(student57);
            tester.add(student58);
            tester.add(student59);
            tester.add(student60);
            tester.add(student61);
            tester.add(student62);
            tester.add(student63);
            tester.add(student64);
            tester.add(student65);
            tester.add(student66);
            tester.add(student67);
            tester.add(student68);
            tester.add(student69);
            tester.add(student70);
            tester.add(student71);
            tester.add(student72);
            tester.add(student73);
            tester.add(student74);
            tester.add(student75);
            tester.add(student76);
            tester.add(student77);
            tester.add(student78);
            tester.add(student79);
            tester.add(student80);
            tester.add(student81);
            tester.add(student82);
            tester.add(student83);
            tester.add(student84);
            tester.add(student85);
            tester.add(student86);
            tester.add(student87);
            tester.add(student88);
            tester.add(student89);
            tester.add(student90);
            tester.add(student91);
            tester.add(student92);
            tester.add(student93);
            tester.add(student94);
            tester.add(student95);
            tester.add(student96);
            tester.add(student97);
            tester.add(student98);
            tester.add(student99);

            testProgram2.getHeap().buildHeap(tester);
            System.out.println("Initial Heap");
            System.out.println(testProgram2.getHeap()+"\n");

            System.out.println("Insert Node Test:");
            Student student100 = new Student(100);
            student100.setminCost(75);
            testProgram2.getHeap().insertNode(student100);
            System.out.println(testProgram2.getHeap());
            Student student101 = new Student(101);
            student101.setminCost(7);
            testProgram2.getHeap().insertNode(student101);
            System.out.println(testProgram2.getHeap());
            Student student102 = new Student(102);
            student102.setminCost(98);
            testProgram2.getHeap().insertNode(student102);
            System.out.println(testProgram2.getHeap());
            Student student103 = new Student(103);
            student103.setminCost(53);
            testProgram2.getHeap().insertNode(student103);
            System.out.println(testProgram2.getHeap());
            Student student104 = new Student(104);
            student104.setminCost(80);
            testProgram2.getHeap().insertNode(student104);
            System.out.println(testProgram2.getHeap());
            Student student105 = new Student(105);
            student105.setminCost(97);
            testProgram2.getHeap().insertNode(student105);
            System.out.println(testProgram2.getHeap());
            Student student106 = new Student(106);
            student106.setminCost(23);
            testProgram2.getHeap().insertNode(student106);
            System.out.println(testProgram2.getHeap());
            Student student107 = new Student(107);
            student107.setminCost(75);
            testProgram2.getHeap().insertNode(student107);
            System.out.println(testProgram2.getHeap());
            Student student108 = new Student(108);
            student108.setminCost(38);
            testProgram2.getHeap().insertNode(student108);
            System.out.println(testProgram2.getHeap());
            Student student109 = new Student(109);
            student109.setminCost(27);
            testProgram2.getHeap().insertNode(student109);
            System.out.println(testProgram2.getHeap());

            System.out.println("\nChange Key Test:");
            testProgram2.getHeap().changeKey(student97,65);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student87,58);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student93,3);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student53,1);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student37,2);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student70,69);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student95,48);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student48,59);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student33,36);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().changeKey(student104,19);
            System.out.println(testProgram2.getHeap());

            System.out.println("\nDelete Test:");
            testProgram2.getHeap().delete(36);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(21);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(11);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(17);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(59);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(9);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(15);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(34);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(74);
            System.out.println(testProgram2.getHeap());
            testProgram2.getHeap().delete(96);
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
