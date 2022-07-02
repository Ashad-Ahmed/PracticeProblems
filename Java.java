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



//                                               ########################### Arrays ############################

//Problem 3.1: Find a pair that sums up to a given target.
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

//Problem 2.1: Subarray with a given sum exists or not?
// Observe difference from problem 2.2, In this problem we just want to return True or False

import java.util.HashSet;
import java.util.Set;
 
class Main
{
    // Function to check if subarray with the given sum exists in
    // the array or not
    public static boolean findSubarray(int[] nums, int target)
    {
        // create an empty set
        Set<Integer> set = new HashSet<>();
 
        // insert number 0 into the set to handle the case when a
        // subarray with the given sum starts from index 0
        set.add(0);
 
        // keep track of the sum of elements so far
        int sum_so_far = 0;
 
        // traverse the given array
        for (int i: nums)
        {
            // update `sum_so_far`
            sum_so_far += i;
 
            // if `sum_so_far - target` is seen before, we have found
            // the subarray with sum equal to `target`
            if (set.contains(sum_so_far - target)) {
                return true;
            }
 
            // otherwise, search the sum of elements so far in the set
            set.add(sum_so_far);
        }
 
        // we reach here when no subarray exists
        return false;
    }
 
    public static void main(String[] args)
    {
        // an integer array
        int[] nums = { 8, 7, 2, 5, 3, 1 };
        int target = 10;
 
        if (findSubarray(nums, target)) {
            System.out.println("Subarray with the given sum exists");
        }
        else {
            System.out.println("Subarray with the given sum does not exist");
        }
    }
}

//Problem 2.2: Find and print a subarray that sums up to a target value. (Say 0, 9 etc..)

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

// Problem: Find all subarrays summing to a given sum (0, 9 .. etc..)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MyArray
{
    // Utility function to insert <key, value> into the multimap
    private static<K, V> void insert(Map<K, List<V>> hashMap, K key, V value)
    {
        // if the key is seen for the first time, initialize the list
        hashMap.putIfAbsent(key, new ArrayList<>());
        hashMap.get(key).add(value);
    }

    // Function to print all subarrays with a zero-sum in a given array
    public static void printAllSubarrays(int[] nums, int target)
    {
        // create an empty multimap to store the ending index of all
        // subarrays having the same sum
        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        // insert (0, -1) pair into the map to handle the case when
        // subarray with zero-sum starts from index 0
        insert(hashMap, 0, -1);

        int sum = 0;

        // traverse the given array
        for (int i = 0; i < nums.length; i++)
        {
            // sum of elements so far
            sum += nums[i];

            // if the sum is seen before, there exists at least one
            // subarray with zero-sum
            if (hashMap.containsKey(sum - target))
            {
                List<Integer> list = hashMap.get(sum - target);

                // find all subarrays with the same sum
                for (Integer value: list)
                {
                    System.out.println("Subarray [" + (value + 1) + "…" +
                            i + "]");
                }
            }

            // insert (sum so far, current index) pair into the multimap
            insert(hashMap, sum, i);
        }
    }

    public static void main (String[] args)
    {
        int[] nums = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
        int target = 8;

        printAllSubarrays(nums, target);
    }
}

// Problem: Find Maximum Length SubArray

import java.util.Map;
import java.util.HashMap;

class MyArray
{
    // Find the maximum length subarray with sum `S` present in a given array
    public static void findMaxLenSubarray(int[] nums, int S)
    {
        // create an empty HashMap to store the ending index of the first
        // subarray having some sum
        Map<Integer, Integer> map = new HashMap<>();

        // insert (0, -1) pair into the set to handle the case when a
        // subarray with sum `S` starts from index 0
        map.put(0, -1);

        int target = 0;

        // `len` stores the maximum length of subarray with sum `S`
        int len = 0;

        // stores ending index of the maximum length subarray having sum `S`
        int ending_index = -1;

        // traverse the given array
        for (int i = 0; i < nums.length; i++)
        {
            // sum of elements so far
            target += nums[i];

            // if the sum is seen for the first time, insert the sum with its
            // into the map
            map.putIfAbsent(target, i);

            // update length and ending index of the maximum length subarray
            // having sum `S`
            if (map.containsKey(target - S) && len < i - map.get(target - S))
            {
                len = i - map.get(target - S);
                ending_index = i;
            }
        }

        // print the subarray
        System.out.println("[" + (ending_index - len + 1) + ", " + ending_index + "]");
    }

    public static void main (String[] args)
    {
        int[] nums = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
        int target = 8;

        findMaxLenSubarray(nums, target);
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

// ======================================================
// 2D Alphabetical Matrix to search for words [Uses Trie]
// ======================================================

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// A class to store a Trie node
class Trie
{
    // true when the node is a leaf node
    boolean isLeaf;

    Map<Character, Trie> character = new HashMap<>();

    // Constructor
    Trie() {
        isLeaf = false;
    }
}

class MyArray
{
    // `M × N` matrix
    private static int M, N;

    // Iterative function to insert a string into a Trie
    private static void insert(Trie root, String str)
    {
        // start from the root node
        Trie curr = root;

        for (char ch: str.toCharArray())
        {
            // create a new node if the path doesn't exist
            curr.character.putIfAbsent(ch, new Trie());

            // go to the next node
            curr = curr.character.get(ch);
        }

        curr.isLeaf = true;
    }

    // Below arrays detail all eight possible movements from a cell
    // (top, right, bottom, left, and four diagonal moves)
    private static int[] row = { -1, -1, -1, 0, 1, 0, 1, 1 };
    private static int[] col = { -1, 1, 0, -1, -1, 1, 0, 1 };

    // The function returns false if (x, y) is not valid matrix coordinates
    // or cell (x, y) is already processed or doesn't lead to the solution
    public static boolean isSafe(int x, int y, boolean[][] processed,
                                 char[][] board, char ch)
    {
        return (x >= 0 && x < M) && (y >= 0 && y < N) &&
                !processed[x][y] && (board[x][y] == ch);
    }

    // A recursive function to search valid words present in a boggle using trie
    public static void searchBoggle(Trie root, char[][] board, int i, int j,
                                    boolean[][] processed, String path,
                                    Set<String> result)
    {
        // if a leaf node is encountered
        if (root.isLeaf) {
            // update result with the current word
            result.add(path);
        }

        // mark the current cell as processed
        processed[i][j] = true;

        // traverse all children of the current Trie node
        for (var entry: root.character.entrySet())
        {
            // check for all eight possible movements from the current cell
            for (int k = 0; k < row.length; k++)
            {
                // skip if cell is invalid or entry is already processed
                // or doesn't lead to any path in the Trie
                if (isSafe(i + row[k], j + col[k], processed, board, entry.getKey()))
                {
                    searchBoggle(entry.getValue(), board, i + row[k], j + col[k],
                            processed, path + entry.getKey(), result);
                }
            }
        }

        // backtrack: mark the current cell as unprocessed
        processed[i][j] = false;
    }

    // Function to search for a given set of words in a boggle
    public static Set<String> searchBoggle(char[][] board, Set<String> words)
    {
        // construct a set for storing the result
        Set<String> result = new HashSet<>();

        // base case
        if (board.length == 0) {
            return result;
        }

        // `M × N` board
        int M = board.length;
        int N = board[0].length;

        // insert all words into a trie
        Trie root = new Trie();
        for (String word: words) {
            insert(root, word);
        }

        // construct a boolean matrix to store whether a cell is processed or not
        boolean[][] processed = new boolean[M][N];

        // consider each character in the matrix
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                // current character
                char ch = board[i][j];

                // proceed only if the current character is a child of the Trie root
                if (root.character.containsKey(ch))
                {
                    searchBoggle(root.character.get(ch), board, i, j,
                            processed, Character.toString(ch), result);
                }
            }
        }

        // return the result set
        return result;
    }

    public static void main(String[] args)
    {
        char[][] board =
                {
                        {'M', 'S', 'E', 'F'},
                        {'R', 'A', 'T', 'D'},
                        {'L', 'O', 'N', 'E'},
                        {'K', 'A', 'F', 'B'}
                };

        M = board.length;
        N = board[0].length;

        Set<String> words = Stream.of("KOATED")
                .collect(Collectors.toSet());

        Set<String> validWords = searchBoggle(board, words);
        System.out.println(validWords);
    }
}


// ==================================================================================================
// Finding Shortest Path from source (i,j) to dest co-ordinate (x,y) in a 2D- Matrix [Uses Recursion]
// ==================================================================================================

class MyArray
{
    // Check if it is possible to go to (x, y) from the current position. The
    // function returns false if the cell is invalid, has value 0, or already visited
    private static boolean isSafe(int[][] mat, boolean[][] visited, int x, int y) {
        return (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length) &&
                mat[x][y] == 1 && !visited[x][y];
    }

    // Find the shortest possible route in a matrix `mat` from source cell (i, j)
    // to destination cell (x, y).
    // `min_dist` stores the length of the longest path from source to a destination
    // found so far, and `dist` maintains the length of the path from a source cell
    // to the current cell (i, j).
    public static int findShortestPath(int[][] mat, boolean[][] visited,
                                       int i, int j, int x, int y, int min_dist, int dist)
    {
        // if the destination is found, update `min_dist`
        if (i == x && j == y) {
            return Integer.min(dist, min_dist);
        }

        // set (i, j) cell as visited
        visited[i][j] = true;

        // go to the bottom cell
        if (isSafe(mat, visited, i + 1, j))
        {
            min_dist = findShortestPath(mat, visited, i + 1, j, x, y,
                    min_dist, dist + 1);
        }

        // go to the right cell
        if (isSafe(mat, visited, i, j + 1))
        {
            min_dist = findShortestPath(mat, visited, i, j + 1, x, y,
                    min_dist, dist + 1);
        }

        // go to the top cell
        if (isSafe(mat, visited, i - 1, j))
        {
            min_dist = findShortestPath(mat, visited, i - 1, j, x, y,
                    min_dist, dist + 1);
        }

        // go to the left cell
        if (isSafe(mat, visited, i, j - 1))
        {
            min_dist = findShortestPath(mat, visited, i, j - 1, x, y,
                    min_dist, dist + 1);
        }

        // backtrack: remove (i, j) from the visited matrix
        visited[i][j] = false;

        return min_dist;
    }

    // Wrapper over findShortestPath() function
    public static int findShortestPathLength(int[][] mat, int i, int j, int x, int y)
    {
        // base case: invalid input
        if (mat == null || mat.length == 0 || mat[i][j] == 0 || mat[x][y] == 0) {
            return -1;
        }

        // `M × N` matrix
        int M = mat.length;
        int N = mat[0].length;

        // construct an `M × N` matrix to keep track of visited cells
        boolean[][] visited = new boolean[M][N];

        int min_dist = findShortestPath(mat, visited, i, j, x, y, Integer.MAX_VALUE, 0);
        if (min_dist != Integer.MAX_VALUE) {
            return min_dist;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int mat[][] =
                {
                        { 1, 0, 1, 1, 1},
                        { 1, 0, 1, 0, 1},
                        { 1, 1, 1, 1, 1},
                        { 1, 0, 1, 0, 1},
                        { 1, 1, 1, 0, 1},

                };

        int min_dist = findShortestPathLength(mat, 0, 0, 4, 4);

        if (min_dist != -1) {
            System.out.println("The shortest path from source to destination " +
                    "has length " + min_dist);
        } else {
            System.out.println("Destination cannot be reached from source");
        }
    }
}


// My Kind of Sorting, but it doesn't work as the size of array increases, repeating the operation several times seems to work

class MyArray{

    static void swap(int[] arr, int i, int j) {

        int temp;

        if (i < j){
            temp = i;
            j = i;
            i = temp;
        }

        temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    static void sort(int[] arr){
        for (int i = 0, j = arr.length-1; i < arr.length-1; i++, j--) {

            // Case-1
            if (arr[i] > arr[i + 1]) {
                swap(arr, i + 1, i);
            }

            if (arr[j - 1] > arr[j]) {
                swap(arr, j, j - 1);
            }

            //Case-2
            if (arr[i] > arr[j - 1]) {
                swap(arr, j - 1, i);
            }

            if (arr[i + 1] > arr[j]) {
                swap(arr, j, i + 1);
            }
        }

        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }

    public static void main(String[] Args){

        int[] arr = {-4,0,7,4,9,-5,-1,0,-7,-1};
        sort(arr);

    }
}

