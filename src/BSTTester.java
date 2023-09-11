/* CS 314 STUDENTS: FILL IN THIS HEADER.
 *
 * Student information for assignment:
 *
 *  On my honor, Mohammad Kashif, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: mnk665
 *  email address: mohammadnkashif@utexas.edu
 *  TA name: Pranav Chandupatla
 *  Number of slip days I am using: 2
 */

/* BST Experiments:
 * Create an empty binary search tree and insert 1000 randomly generated Integer objects*
     * Average Time: 0.00031784 seconds
     * Average Height: 20.60
     * Average Size: 1000
     *
 * Repeat the experiment 10 times for the following values of N:
     * N= 2000:
     * Average Time: 0.00107731
     * Average Height: 24.00000000
     * Average Size: 2000.00000000
     *
     * N= 4000:
     * Average Time: 0.00112271
     * Average Height: 24.85000000
     * Average Size: 3000.00000000
     *
     * N= 8000:
     * Average Time: 0.00161022
     * Average Height: 26.30000000
     * Average Size: 4666.66666667
     *
     * N= 16000:
     * Average Time: 0.00278845
     * Average Height: 27.70000000
     * Average Size: 7499.97500000
     *
     * N= 32000:
     * Average Time: 0.00504934
     * Average Height: 29.06000000
     * Average Size: 12399.96000000
     *
     * N= 64000:
     * Average Time: 0.01047854
     * Average Height: 30.35000000
     * Average Size: 20999.88333333
     *
     * N= 128000:
     * Average Time: 0.02151535
     * Average Height: 31.72857143
     * Average Size: 36285.32857143
     *
     * N= 256000:
     * Average Time: 0.04079408
     * Average Height: 33.20000000
     * Average Size: 63748.65000000
     *
     * N= 512000:
     * Average Time: 0.08447901
     * Average Height: 34.64444444
     * Average Size: 113550.97777778
     *
     * N= 1024000:
     * Average Time: 0.18769535
     * Average Height: 36.13000000
     * Average Size: 204583.38000000
     *
     * For each value of N what is the minimum possible tree height,
     * assuming N unique values are inserted into the tree?
     *
     * N = 1,000: log2(1,000) = 9.966 (rounded up to 10)
     * N = 2,000: log2(2,000) = 10.965 (rounded up to 11)
     * N = 4,000: log2(4,000) = 11.965 (rounded up to 12)
     * N = 8,000: log2(8,000) = 12.965 (rounded up to 13)
     * N = 16,000: log2(16,000) = 13.965 (rounded up to 14)
     * N = 32,000: log2(32,000) = 14.965 (rounded up to 15)
     * N = 64,000: log2(64,000) = 15.965 (rounded up to 16)
     * N = 128,000: log2(128,000) = 16.965 (rounded up to 17)
     * N = 256,000: log2(256,000) = 17.965 (rounded up to 18)
     * N = 512,000: log2(512,000) = 18.965 (rounded up to 19)
     * N = 1,024,000: log2(1,024,000) ≈ 19.965 (rounded up to 20)
     *
     * Repeat the experiment using random integers, but use the java TreeSet class:
     *
     * N= 1000:
     * Average Time: 0.00049232
     * N= 2000:
     * Average Time: 0.00045398
     * N= 4000:
     * Average Time: 0.00055496
     * N= 8000:
     * Average Time: 0.00075482
     * N= 16000:
     * Average Time: 0.00126527
     * N= 32000:
     * Average Time: 0.00261424
     * N= 64000:
     * Average Time: 0.00575648
     * N= 128000:
     * Average Time: 0.01308895
     * N= 256000:
     * Average Time: 0.02879239
     * N= 512000:
     * Average Time: 0.06263019
     * N= 1024000:
     * Average Time: 0.13235059
     *
     * How do they compare to your BinarySearchTree?
     *
     * The average time taken with the TreeSet class is generally lower than the average time
     * of the Binary Search Tree for sizes 1,000 to 1,024,000. This indicates the balanced search
     * tree implemented in the Java TreeSet offers more efficient operations in comparison to
     * the unbalanced tree formed from a binary search tree.
     *
     * Create an empty binary search tree class and insert the 1000 sorted integers into it:
     *
     * N= 1000:
     * Average Time: 0.00203495
     * Average Height: 1000
     * Average Size: 1000.00000000
     *
     * N= 2000:
     * Average Time: 0.00895079
     * Average Height: 2000
     * Average Size: 2000.00000000
     *
     * N= 4000:
     * Average Time: 0.03473668
     * Average Height: 40000
     * Average Size: 4000.00000000
     *
     * N= 8000:
     * Average Time: 0.15806607
     * Average Height: 8000
     * Average Size: 8000.00000000
     *
     * N= 16000:
     * Average Time: 0.44709036
     * Average Height: 16000
     *  Size: 16000.00000000
     *
     * N= 32000:
     * Average Time: 1.81323919
     * Average Height: 32000
     * Average Size: 32000.00000000
     *
     * N= 64000:
     * Average Time: 7.38466767
     * Average Height: 64000
     * Average Size: 64000.00000000
     *
     * Repeat the experiment using integers in sorted order, but use the java TreeSet class:
     *
     * N= 1000:
     * Average Time: 0.00045646
     * N= 2000:
     * Average Time: 0.00026860
     * N= 4000:
     * Average Time: 0.00078155
     * N= 8000:
     * Average Time: 0.00111482
     * N= 16000:
     * Average Time: 0.00234151
     * N= 32000:
     * Average Time: 0.00673418
     * N= 64000:
     * Average Time: 0.01701783
     * N= 128000:
     * Average Time: 0.04139719
     * N= 256000:
     * Average Time: 0.09811199
     * N= 512000:
     * Average Time: 0.18718375
     * N= 1024000:
     * Average Time: 0.34776409
     *
     * How do these times compare to the times it took for you BinarySearchTree class when
     * inserting integers in sorted order?
     * What do you think is the cause for these differences?
     *
     * We once again see that the TreeSet is significantly faster than the binary search tree
     * when it comes to adding elements. This is because the balanced search tree implemented in
     * TreeSet provides a more efficient alternative to the unbalanced approach of the standard
     * Binary Search Tree.
 */

import java.util.*;

/**
 * Some test cases for CS314 Binary Search Tree assignment.
 *
 */
public class BSTTester {

    /**
     * The main method runs the tests.
     * @param args Not used
     */
    public static void main(String[] args) {
        studentTests();

        ArrayList<Double> times = new ArrayList<>();
        ArrayList<Integer> heights = new ArrayList<>();
        ArrayList<Integer> sizes = new ArrayList<>();

        for (int f = 1000; f <= 1024000; f*= 2) {
            times.clear();
            heights.clear();
            sizes.clear();
            for (int j = 0; j < 10; j++) {
                Stopwatch time = new Stopwatch();
                time.start();
                TreeSet<Integer> b = new TreeSet<>();
                for (int i = 0; i < f; i++) {
                    b.add(i);
                }
                time.stop();
                times.add(time.time());
                //heights.add(b.height());
                sizes.add(b.size());
            }

            System.out.println("\nN= " + f + ": ");
            double total = 0;
            for (int i = 0; i < times.size(); i++) {
                total += times.get(i);
            }
            System.out.printf("Average Time: %.8f", total / times.size());
//            total = 0;
//            for (int i = 0; i < heights.size(); i++) {
//                total += heights.get(i);
//            }
//            System.out.printf("\nAverage Height: %.8f", total / heights.size());
//            total = 0;
//            for (int i = 0; i < sizes.size(); i++) {
//                total += sizes.get(i);
//            }
//            System.out.printf("\nAverage Size: %.8f\n", total / sizes.size());
        }

    }

    private static void studentTests() {
        // Test 1: Default Constructor
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        if (tree.size() == 0) {
            System.out.println("Passed Test 1: Default Constructor.");
        }
        else {
            System.out.println("Failed Test 1: Default Constructor.");
        }

        // Test 2: Default Constructor
        if (tree.height() == -1 && tree.max() == null && tree.min() == null) {
            System.out.println("Passed Test 2: Default Constructor.");
        }
        else {
            System.out.println("Failed Test 2: Default Constructor.");
        }

        // Test 3: Add Method
        tree.add(50);
        List<Integer> exp = new ArrayList<>();
        exp.add(50);
        if (tree.size() == 1 && tree.getAll().equals(exp)) {
            System.out.println("Passed Test 3: Add Method.");
        }
        else {
            System.out.println("Failed Test 3: Add Method.");
        }

        // Test 4: Add Method
        tree.add(25);
        exp.add(0, 25);
        if (tree.size() == 2 && tree.getAll().equals(exp)) {
            System.out.println("Passed Test 4: Add Method.");
        }
        else {
            System.out.println("Failed Test 4: Add Method");
        }

        // Test 5: Remove Method
        tree.remove(25);
        exp.remove(0);
        if (tree.getAll().equals(exp)) {
            System.out.println("Passed Test 5: Remove Method.");
        }
        else {
            System.out.println("Failed Test 5: Remove Method.");
        }

        // Test 6: Remove Method
        tree.remove(50);
        exp.remove(0);
        if (tree.getAll().equals(exp)) {
            System.out.println("Passed Test 6: Remove Method.");
        }
        else {
            System.out.println("Failed Test 6: Remove Method.");
        }

        // Test 7: isPresent Method
        if (!tree.isPresent(100)) {
            System.out.println("Passed Test 7: isPresent Method.");
        }
        else {
            System.out.println("Failed Test 7: isPresent Method");
        }

        // Test 8: isPresent Method
        tree.add(100);
        if (tree.isPresent(100)) {
            System.out.println("Passed Test 8: isPresent Method.");
        }
        else {
            System.out.println("Failed Test 8: isPresent Method");
        }

        // Test 9: Size Method
        if (tree.size() == 1) {
            System.out.println("Passed Test 9: Size Method.");
        }
        else {
            System.out.println("Failed Test 9: Size Method");
        }

        // Test 10: Size Method
        tree.add(50);
        tree.add(10);
        tree.add(150);
        tree.add(160);
        if (tree.size() == 5) {
            System.out.println("Passed Test 10: Size Method.");
        }
        else {
            System.out.println("Failed Test 10: Size Method");
        }

        // Test 11: Height Method
        if (tree.height() == 2) {
            System.out.println("Passed Test 11: Height Method.");
        }
        else {
            System.out.println("Failed Test 11: Height Method");
        }

        // Test 12: Height Method
        tree.add(25);
        tree.add(125);
        if (tree.height() == 3) {
            System.out.println("Passed Test 12: Height Method.");
        }
        else {
            System.out.println("Failed Test 12: Height Method");
        }

        // Test 13: getAll Method
        exp.add(10);
        exp.add(25);
        exp.add(50);
        exp.add(100);
        exp.add(125);
        exp.add(150);
        exp.add(160);
        if (tree.getAll().equals(exp)) {
            System.out.println("Passed Test 13: getAll Method");
        }
        else {
            System.out.println("Failed Test 13: getAll Method");
        }

        // Test 14: getAll Method
        tree.remove(160);
        exp.remove(6);
        if (tree.getAll().equals(exp)) {
            System.out.println("Passed Test 14: getAll Method");
        }
        else {
            System.out.println("Failed Test 14: getAll Method");
        }

        // Test 15: max Method
        if (tree.max() == 150) {
            System.out.println("Passed Test 15: Max Method.");
        }
        else {
            System.out.println("Failed Test 15: Max Method.");
        }

        // Test 16: max Method
        tree.add(200);
        if (tree.max() == 200) {
            System.out.println("Passed Test 16: Max Method.");
        }
        else {
            System.out.println("Failed Test 16: Max Method.");
        }

        // Test 17: min Method
        if (tree.min() == 10) {
            System.out.println("Passed Test 17: Min Method.");
        }
        else {
            System.out.println("Failed Test 17: Min Method.");
        }

        // Test 18: min Method
        tree.add(5);
        if (tree.min() == 5) {
            System.out.println("Passed Test 18: Min Method.");
        }
        else {
            System.out.println("Failed Test 18: Min Method.");
        }

        // Test 19: Iterative Add Method
        tree.iterativeAdd(20);
        exp.add(6, 200);
        exp.add(2, 20);
        exp.add(0, 5);
        if (tree.getAll().equals(exp)) {
            System.out.println("Passed Test 19: Test Iterative Add Method.");
        }
        else {
            System.out.println("Failed Test 19: Iterative Add Method");
        }

        // Test 20: Iterative Add Method
        if (tree.iterativeAdd(150)) {
            System.out.println("Passed Test 20: Test Iterative Add Method.");
        }
        else {
            System.out.println("Failed Test 20: Iterative Add Method");
        }

        // Test 21: Get Method
        if (tree.get(0) == 5) {
            System.out.println("Passed Test 21: Get Method.");
        }
        else {
            System.out.println("Failed Test 21: Get Method.");
        }

        // Test 22: Get Method
        if (tree.get(5) == 100) {
            System.out.println("Passed Test 22: Get Method.");
        }
        else {
            System.out.println("Failed Test 22: Get Method.");
        }

        // Test 23: getAllLessThan Method
        exp.clear();
        exp.add(5);
        exp.add(10);
        exp.add(20);
        if (tree.getAllLessThan(25).equals(exp)) {
            System.out.println("Passed Test 23: getAllLessThan Method.");
        }
        else {
            System.out.println("Failed Test 23: getAllLessThan Method.");
        }

        // Test 24: getAllLessThan Method
        exp.clear();
        if (tree.getAllLessThan(5).equals(exp)) {
            System.out.println("Passed Test 23: getAllLessThan Method.");
        }
        else {
            System.out.println("Failed Test 23: getAllLessThan Method.");
        }

        // Test 25: getAllGreaterThan Method
        exp.add(100);
        exp.add(125);
        exp.add(150);
        exp.add(200);
        if (tree.getAllGreaterThan(50).equals(exp)) {
            System.out.println("Passed Test 25: getAllGreaterThan Method.");
        }
        else {
            System.out.println("Failed Test 25: getAllGreaterThan Method.");
        }

        // Test 26: getAllGreaterThan Method
        exp.clear();
        exp.add(200);
        if (tree.getAllGreaterThan(199).equals(exp)) {
            System.out.println("Passed Test 26: getAllGreaterThan Method.");
        }
        else {
            System.out.println("Failed Test 26: getAllGreaterThan Method.");
        }

        // Test 27: numNodesAtDepth Method
        if (tree.numNodesAtDepth(1) == 2) {
            System.out.println("Passed Test 27: numNodesAtDepth Method.");
        }
        else {
            System.out.println("Failed Test 27: numNodesAtDepth Method.");
        }

        // Test 28: numNodesAtDepth Method
        if (tree.numNodesAtDepth(4) == 3) {
            System.out.println("Passed Test 28: numNodesAtDepth Method.");
        }
        else {
            System.out.println("Failed Test 28: numNodesAtDepth Method.");
        }

    }
}
