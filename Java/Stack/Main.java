package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
public class Main {
    //input: [1,3,2,4,8]
    //output: [3,4,4,8,-1]
    public static void findNGR(int[] arr){
        
        List<Integer> result = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            if(s.isEmpty()){
                result.add(-1);
            }else if(s.peek() > arr[i]){
                result.add(s.peek());
            }else{
                while(!s.isEmpty() && s.peek() < arr[i]){
                    s.pop();
                }
                if(!s.isEmpty()){
                    result.add(s.peek());
                }else{
                    result.add(-1);
                }
            }
            s.push(arr[i]);
        }
        Collections.reverse(result);
        System.out.println(result);
    }

    public static void findNGL(int[] arr){
        List<Integer> result = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        int n = arr.length;

        for(int i=0;i<n;i++){
            if(s.isEmpty()){
                result.add(-1);
            }else if(s.peek() > arr[i]){
                result.add(s.peek());
            }else{
                while(!s.isEmpty() && s.peek() < arr[i]){
                    s.pop();
                }
                if(!s.isEmpty()){
                    result.add(s.peek());
                }else{
                    result.add(-1);
                }
            }

            s.push(arr[i]);
        }

        Collections.reverse(result);
        System.out.println(result);
    }

    public static void findNSR(int[] arr){
        List<Integer> result = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        int n = arr.length;

        for(int i=n-1;i>=0;i--){
            if(s.isEmpty()){
                result.add(-1);
            }else if(s.peek() < arr[i]){
                result.add(s.peek());
            }else{
                while(!s.isEmpty() && s.peek() > arr[i]){
                    s.pop();
                }

                if (!s.isEmpty()) {
                    result.add(s.peek());
                }else{
                    result.add(-1);
                }
            }

            s.push(arr[i]);
        }

        Collections.reverse(result);
        System.out.println(result);
    }

    public static void findNSL(int[] arr){
        List<Integer> result = new ArrayList<>();
        Stack<Integer> s = new Stack<>();   
        int n = arr.length; 
        for(int i=0;i<n;i++){
            if(s.isEmpty()){
                result.add(-1);
            }else if(s.peek() < arr[i]){
                result.add(s.peek());
            }else{
                while(!s.isEmpty() && s.peek() > arr[i]){
                    s.pop();
                }   
                if (!s.isEmpty()) {
                    result.add(s.peek());
                }else{
                    result.add(-1);
                }
            }   
            s.push(arr[i]);
        }   
        // Collections.reverse(result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        // int[] arr = new int[]{100,80,60,70,60,75,85}; 
        // int[] newarr = new int[]{2,3,3,2};
        int[][] arr = new int[][]{{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
        // findNGR(arr);
        // findNGL(arr);
        // findNSR(arr);
        // findNSL(arr);
        // new StcockSpanProblem(arr);
        // new MaximumAreaHistogram().maximumAreaHistogram(newarr);
        int result = new MaxAreaRectInBinaryMatrix().maxAreaRectInBinaryMatrix(arr);
        System.out.println(result);
        
    }
}
