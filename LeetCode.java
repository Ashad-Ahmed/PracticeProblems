// Candy - Needs more optimization - Currently getting threshold exceeded

import java.util.*;

class MyArray{

    public static HashMap<Integer, Integer> candy_inc(HashMap<Integer, Integer> map, int[] arr, int n){

        // Base case
        if (n == -1) {
            //System.out.println("The End!");
            return map;
        }

        //Extreme Right Case
        if (n == arr.length-1 && arr[n] > arr[n-1] && map.get(n) <= map.get(n-1)){
            map.put(n, map.get(n-1)+1);
        }

        //Extreme Lesft Case
        if (n == 0 && arr[n] > arr[n+1] && map.get(n) <= map.get(n+1)){
            map.put(n, map.get(n+1)+1);
        }

        //Normal Case
        if (n != 0 && n != arr.length-1){

            if  (arr[n] > arr[n-1] && map.get(n) <= map.get(n-1)){
                map.put(n, map.get(n - 1) + 1);
                candy_inc(map, arr,n + 1);
            }
            else if(arr[n] > arr[n+1] && map.get(n) <= map.get(n+1)){
                map.put(n, map.get(n + 1) + 1);
                //candy_inc(map, arr,n + 1);
            }
        }

        candy_inc(map, arr, n-1);
        return map;
    }

    public static void main(String[] Args){

        int[] arr = {1,6,10,8,7,3,2};

        if (arr.length == 1){
            return;
        }

        int candy = 0;

        HashMap <Integer,Integer> map = new HashMap();

        // Initializing
        for (int i = 0; i < arr.length ; i++) {
            map.put(i, 1);
        }

        int res = 0;
        HashMap<Integer, Integer> res_res = new HashMap();

        res_res = candy_inc(map, arr,arr.length-1);

        for (int i = 0; i < arr.length; i++){
            res += res_res.get(i);
        }

        System.out.print(res);
    }
}

// Stair Climb: If we could jump either 1 or 2 steps at once. How many ways could we climb a stair (Hint: Fibonacci)

public int ClimbingStairs(int arr) {

        int[] dp = new int[arr];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<dp.length;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[dp.length-1];
    }

// Min Cost Stair Climb: If we could jump either 1 or 2 steps at once. Find min cost to climb a stair assume no cost for index 0  and 1; Below is a memoization example

public int minCostClimbingStairs(int[] arr) {

        int[] dp = new int[arr.length];
        for(int i=2;i<arr.length;i++){
            dp[i] = arr[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }

// Number of ways to place houses, this works but we get threshold time exceeded issue. Needs memoization 

import java.util.*;
import java.lang.*;
import java.io.*;

class MyArray
{
    public static int print(char str[], int index, char prev, int res, int[] mem){

        // This If statement will remove any Nodes having value 1 and with an immideate child with value 1
        if (prev == '1' && index != 1) {
            if (str[index - 1] == str[index - 2]) {
                return res;
            }
        }

        if (index == str.length){
            //System.out.println(str);
            return res+=1;
        }

        if (str[index] == '\u0000'){
            // replace '\u0000' by '0' and recurse
            str[index] = '0';
            System.out.print("First :");
            System.out.println(str);
            res = print(str, index + 1, '0', res, mem);

            // replace '\u0000' by '1' and recurse
            str[index] = '1';
            System.out.print("Second :");
            System.out.println(str);
            res = print(str, index + 1, '1', res, mem);

            // NOTE: Need to backtrack as string
            // is passed by reference to the
            // function
            str[index] = '\u0000';
        }
        else {
            //System.out.print(index);
            print(str, index + 1, 'X', res, mem);

        }
        return res;
    }

    // driver code
    public static void main (String[] args)
    {
        int num_houses = 3;

        int res = 0;
        long mod=1000000007;
        int[] mem = new int[num_houses];
        char[] str = new char[num_houses];
        res = print(str, 0, 'X', res, mem);
        System.out.print((int)(res*res)%mod);
    }
}

