// Below code generates all binary numbers of a given length

class MyArray{
    public static String rec(int n, String str, String chr, String chr_prev){

        //if (chr_prev != "" && chr_prev == chr){return "";}

        if (n == 0) {
            System.out.println(str + chr);
            return str + chr;}

        str += chr;
        rec(n - 1, str, "0", chr); // Passing current chr to be used further as previous character.
        rec(n - 1, str, "1", chr); // Passing current chr to be used further as previous character.

        return "End";
    }

    public static void main(String[] Args){
        String str = "";
        System.out.println(rec(3, str, "", ""));
    }
}

// Below is the tabulation code for Fibonacci : keeping arr[0] = 1, arr[1] = 1 it can solve climbing stair problem. Keeping arr[0] = 1, arr[1] = 2 can solve Number of ways house can be placed problem
// arr[i-1] + arr[i-2] means we've two options, either consume one input at once or consuming two (adjescent) inputs at once. Consuming inputs might mean "Selecting". 


class Solution {
    public int fib(int n) {
        int[] arr=new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i <= n; i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}

// Below is a generic template which tells how to solve any backtracking problem

void findSolutions(n, other params) :
    if (found a solution) :
        solutionsFound = solutionsFound + 1;
        displaySolution();
        if (solutionsFound >= solutionTarget) : 
            System.exit(0);
        return

    for (val = first to last) :
        if (isValid(val, n)) :
            applyValue(val, n);
            findSolutions(n+1, other params);
            removeValue(val, n);

// Below is an example problem to find all subsets of a superset which sum to a target values:

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> temp = new ArrayList<>();
        combinations(candidates, target,0, res, temp);
        return res;
    }

    static void combinations(int[] arr, int target, int i, List<List<Integer>> res, List<Integer> temp){

        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(target < 0){
            return;
        }

        for(int j=i;j<arr.length;j++){
            temp.add(arr[j]);
            combinations(arr, target - arr[j], j, res, temp);
            temp.remove(temp.size()-1);
        }
    }
}


COMBINATION SUM 2 -
    vector<vector<int>> res;
    void helper(int i, vector<int>& arr, int target, vector<int>& temp) {
        if(target == 0) {
            res.push_back(temp);
            return;
        }
        
        if(target < 0) {
            return;
        }
        
        for(int j=i; j<arr.size(); j++) {
            if(j > i && arr[j] == arr[j-1]) continue;
            temp.push_back(arr[j]);
            helper(j+1,arr,target-arr[j],temp);
            temp.pop_back();
        }
        
    }
    vector<vector<int>> combinationSum2(vector<int>& arr, int target) {
        vector<int> temp;
        sort(arr.begin(),arr.end());
        helper(0,arr,target,temp);
        return res;
    }



COMBINATION SUM 3  (essentially the question becomes to find combinations of arrays with size k with numbers from the array {1,2,3,4,5,6,7,8,9} with sum == target (or n) )
vector<vector<int>> res;
    void helper(int i, vector<int>& arr, int target, vector<int> temp, int k) {
        if(temp.size() == k) {
            if(target == 0) res.push_back(temp);
            return;
        }
        
        for(int j=i; j < arr.size(); j++) {
            temp.push_back(arr[j]);
            helper(j+1,arr,target-arr[j],temp,k);
            temp.pop_back();
        }
    }
    
    vector<vector<int>> combinationSum3(int k, int target) {
        vector<int> temp;
        vector<int> arr = {1,2,3,4,5,6,7,8,9};
        helper(0,arr,target,temp,k);
        return res;
    }

