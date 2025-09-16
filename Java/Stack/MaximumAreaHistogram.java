package Stack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import Helper.Pair;

public class MaximumAreaHistogram {
    /*
     * an input array will be given 
     * elements of the array will be height of the building
     * we have to find maximum area that can be created
     * 
     * eg: [6,2,5,4,5,1,6]
     * 
     *   6 2 5 4 5 1 6
     *   _           _ 
     *  | |  _   _  | |
     *  | | | |_| | | |
     *  | | | | | | | |
     *  | |_| | | | | |
     *  | | | | | |_| |
     * _|_|_|_|_|_|_|_|_
     *   0 1 2 3 4 5 6
     */
    MaximumAreaHistogram(int[] arr){

        //find nearest smaller to left
        
        List<Integer> nsl = new ArrayList<>();
        Stack<Pair> s = new Stack<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(s.isEmpty()){
                nsl.add(-1);
            }else if(!s.isEmpty() && s.peek().first < arr[i]){
                nsl.add(s.peek().second);
            }else{
                while(!s.isEmpty() && s.peek().first > arr[i]){
                    s.pop();
                }

                if(!s.isEmpty()){
                    nsl.add(s.pop().second);
                }else{
                    nsl.add(-1);
                }
            }

            s.push(new Pair(arr[i], i));
        }

        //clear stack for reuse
        while(!s.isEmpty()){
            s.pop();
        }


        //find nearest smaller to right

        List<Integer> nsr = new ArrayList<>();

        for(int i = n -1; i>=0; i--){
            if(s.isEmpty()){
                nsr.add(n);
            }else if(!s.isEmpty() && s.peek().first < arr[i]){
                nsr.add(s.peek().second);
            }else{
                while(!s.isEmpty() && s.peek().first > arr[i]){
                    s.pop();
                }
                if(!s.isEmpty()){
                    nsr.add(s.peek().second);
                }else{
                    nsr.add(n);
                }
            }
            s.push(new Pair(arr[i], i));
        }
        Collections.reverse(nsr);

        //find width 
        // && Maximum area array
        int MAX = Integer.MIN_VALUE;
        // List<Integer> width = new ArrayList<>();
        for(int i=0;i<n;i++){
             MAX = Math.max(MAX, arr[i] * Math.abs(nsr.get(i) - nsl.get(i) - 1));
        }

        // print maximum area hostogram
        System.out.println("Maximum area Histogram is : "+MAX);

        





    }
    
}
