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
