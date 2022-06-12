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


// ==========================================
// 2D Matrix Traversal using BFS [Uses Queue]
// ==========================================

import java.util.Queue;
import java.util.LinkedList;

class MyArray{

    static class pair
    {
        int first, second;

        public pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }

    static final int ROW = 4;
    static final int COL = 4;

    // Direction vectors
    static int dRow[] = {0, 1, 0, -1};
    static int dCol[] = {-1, 0, 1,  0};

    // Function to check if a cell
    // is be visited or not
    static boolean isValid(boolean vis[][],
                           int row, int col)
    {

        // If cell lies out of bounds
        if (row < 0 || col < 0 ||
                row >= ROW || col >= COL)
            return false;

        // If cell is already visited
        if (vis[row][col])
            return false;

        // Otherwise
        return true;
    }

    // Function to perform the BFS traversal
    static void BFS(int row, int col, int grid[][], boolean vis[][])
    {

        // Stores indices of the matrix cells
        Queue<pair> q = new LinkedList<>();

        // Mark the starting cell as visited
        // and push it into the queue
        q.add(new pair(row, col));
        vis[row][col] = true;

        // Iterate while the queue
        // is not empty
        while (!q.isEmpty())
        {
            pair cell = q.peek();
            row = cell.first;
            col = cell.second;

            System.out.print(grid[row][col] + " ");

            q.remove();

            // Go to the adjacent cells
            for(int i = 0; i < 4; i++)
            {
                int adjx = row + dRow[i];
                int adjy = col + dCol[i];

                if (isValid(vis, adjx, adjy))
                {
                    q.add(new pair(adjx, adjy));
                    vis[adjx][adjy] = true;
                }
            }
        }
    }

    // Driver Code
    public static void main(String[] args)
    {

        // Given input matrix
        int grid[][] = { { 1,   2,   3,  4 },
                         { 5,   6,   7,  8 },
                         { 9,  10,  11, 12 },
                        {  13, 14,  15, 16 } };

        // Declare the visited array
        boolean vis[][] = new boolean[ROW][COL];
        for(int i = 0; i < ROW; i++)
        {
            for(int j = 0; j < COL; j++)
            {
                vis[i][j] = false;
            }
        }

        BFS(0,0,grid, vis);
    }
}


// ==========================================
// 2D Matrix Traversal using DFS [Uses Stack]
// ==========================================

import java.util.Stack;

class MyArray{

    static int ROW = 4;
    static int COL = 4;

    // Initialize direction vectors
    // Direction vectors
    static int dRow[] = { 0, 0, 1, -1 };
    static int dCol[] = { -1, 1, 0, 0 };

    static class pair
    {
        public int first;
        public int second;

        public pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }

    static Boolean isValid(Boolean vis[][], int row, int col)
    {

        // If cell is out of bounds
        if (row < 0 || col < 0 ||
                row >= ROW || col >= COL)
            return false;

        // If the cell is already visited
        if (vis[row][col])
            return false;

        // Otherwise, it can be visited
        return true;
    }

    // Function to perform DFS
    // Traversal on the matrix grid[]
    static void DFS(int row, int col, int grid[][], Boolean vis[][])
    {

        // Initialize a stack of pairs and
        // push the starting cell into it
        Stack<pair> st = new Stack<pair>();
        st.push(new pair(row, col));

        // Iterate until the
        // stack is not empty
        while (!st.empty())
        {
            // Pop the top pair
            pair curr = st.pop();

            row = curr.first;
            col = curr.second;

            // Check if the current popped
            // cell is a valid cell or not
            if (!isValid(vis, row, col))
                continue;

            vis[row][col] = true;
            // Print the element at
            // the current top cell
            System.out.print(grid[row][col] + " ");

            // Push all the adjacent cells
            for(int i = 0; i < 4; i++)
            {
                int adjx = row + dRow[i];
                int adjy = col + dCol[i];
                st.push(new pair(adjx, adjy));

                // Mark the current
                // cell as visited
            }
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        // Given input matrix
        int grid[][] = { { 1,   2,   3,  4 },
                         { 5,   6,   7,  8 },
                         { 9,  10,  11, 12 },
                        {  13, 14,  15, 16 } };

        Boolean vis[][] = new Boolean[ROW][COL];
        for(int i = 0; i < ROW; i++)
        {
            for(int j = 0; j < COL; j++)
            {
                vis[i][j] = false;
            }
        }

        // Function call
        DFS(0, 0, grid, vis);
    }
}
