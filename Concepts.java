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
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> list = new ArrayList<>();
         List<Integer> tempList = new ArrayList<>();
         sum(candidates,target,tempList,list,0);
         return list;
    } 
    public void sum(int[] candidates,int target,List<Integer> tempList,List<List<Integer>> list,int index)
    {
        if(index == candidates.length){
            if(target == 0){
               list.add(new ArrayList(tempList));
            }
            return;
        }
        
        if(target >= candidates[index])
        {
            tempList.add(candidates[index]);
            sum(candidates,target-candidates[index],tempList,list,index);
            tempList.remove(tempList.size()-1);
        }
         sum(candidates,target,tempList,list,index+1);         
    }
}

