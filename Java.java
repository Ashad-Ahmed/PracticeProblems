// Problem 1: Check if the nodes of a given BST lie within a given range of Min and Max
// A problem to traverse the entire BST and check if the nodes satisfy a given condition.
// Key: While traversing the tree, replace the "Print" statement with a logic to check for the given condition.
// Variants: return true/false, return number of nodes satisfying/not satisfying above condition.

class Node{
    int data;
    Node left, right;
    Node(int data){this.data = data;}
}

class BST{
    Node root;

    BST(){root = null;}
    BST(int key){root = new Node(key);}
    int result = 0;

    public void Insert(int key){root = InsertBST(root, key);}
    public Node InsertBST(Node root, int key){
        if (root == null){
            root = new Node(key);
            return root;
        }
        if (key < root.data){
            root.left = InsertBST(root.left, key);
        } else if (key > root.data) {
            root.right = InsertBST(root.right, key);
        }
        return root;
    }

    public void Print(){PrintBST(root);}
    public void PrintBST(Node root){
        if (root != null){
            PrintBST(root.left);
            System.out.print(root.data + " ");
            PrintBST(root.right);
        }
    }

    public int isRange(int Min, int Max){ return RangeCheck(root, Min, Max);}
    public int RangeCheck(Node root, int Min, int Max){

        if (root != null) {
            RangeCheck(root.left, Min, Max);

            if ((root.data >= Min) && (root.data <= Max)) {
                result += 1 ;
            }

            RangeCheck(root.right, Min, Max);
        }
    return result;
    }
}

class MyArray{
    public static void main(String[] Args){
    BST tree = new BST();
    tree.Insert(20);
    tree.Insert(2);
    tree.Insert(100);
    tree.Insert(21);
    tree.Insert(55);
    tree.Print();
    System.out.print(tree.isRange(20, 44));
    }
}


//Problem 2: Find a pair that sums up to a given target.
// Notice the problem solving approach, this approach can be extended to problems where we find subarray that sums up to a value. (Problem3)

import java.util.HashMap;
import java.util.Map;

class MyArray
{
    // Function to find a pair in an array with a given sum using hashing
    public static void findPair(int[] nums, int target)
    {
        // create an empty HashMap
        Map<Integer, Integer> map = new HashMap<>();

        // do for each element
        for (int i = 0; i < nums.length; i++)
        {
            // check if pair (nums[i], target-nums[i]) exists

            // if the difference is seen before, print the pair
            if (map.containsKey(target - nums[i]))
            {
                System.out.printf("Pair found (%d, %d)",
                        nums[map.get(target - nums[i])], nums[i]);
                return;
            }

            // store index of the current element in the map
            map.put(nums[i], i);
        }

        // we reach here if the pair is not found
        System.out.println("Pair not found");
    }

    public static void main (String[] args)
    {
        int[] nums = { 8, 7, 2, 5, 3, 1 };
        int target = 10;

        findPair(nums, target);
    }
}

//Problem 3: Find a subarray that sums up to a target value. (Say 0, 9 etc..)

import java.util.HashMap;
import java.util.Map;

class MyArray
{
    // Function to print subarray having a given sum using hashing
    public static void findSubarray(int[] nums, int target)
    {
        // create an empty map
        Map<Integer, Integer> map = new HashMap<>();

        // insert (0, -1) pair into the set to handle the case when a
        // subarray with the given sum starts from index 0
        map.put(0, -1);

        // keep track of the sum of elements so far
        int sum_so_far = 0;

        // traverse the given array
        for (int i = 0; i < nums.length; i++)
        {
            // update `sum_so_far`
            sum_so_far += nums[i];

            // if `sum_so_far - target` is seen before, we have found
            // the subarray with sum equal to `target`
            if (map.containsKey(sum_so_far - target))
            {
                System.out.println("Subarray found [" +
                                (map.get(sum_so_far - target) + 1) +
                                "–" + i + "]");
                return;
            }

            // insert (current sum, current index) pair into the map
            map.put(sum_so_far, i);
        }
    }

    public static void main(String[] args)
    {
        // an integer array
        int[] nums = { 5, -7, 3, -4, 8, 2, 6, 1, 4, 1, 10 };
        int target = 9;

        findSubarray(nums, target);
    }
}


