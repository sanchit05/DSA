class NGR {
    //input: [1,3,2,4,8]
    //output: [3,4,4,8,-1]
    public static List<Integer> findNGR(int[] arr){
        List<Integer> result = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        int n = arr.length();
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

        Collection.reverse(result);

        System.out.println(result);
        return result;
        
    }


}