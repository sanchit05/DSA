package Stack;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import Helper.Pair;

public class StcockSpanProblem {

    StcockSpanProblem(int[] arr){
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        Stack<Pair> s = new Stack<>();

        for(int i = 0;i<n;i++){
            if(s.isEmpty()){
                result.add(1);
            }else if(s.peek().first > arr[i]){
                result.add(i - s.peek().second);                
            }else{
                while(!s.isEmpty() && s.peek().first < arr[i]){
                    s.pop();
                }

                if(s.isEmpty()){
                    result.add(1);
                }else{
                    result.add(i - s.peek().second);
                }
            }
            s.push(new Pair(arr[i], i));
        }

        System.out.println(result);

    }
}
