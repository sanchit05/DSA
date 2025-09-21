package Stack;

public class MaxAreaRectInBinaryMatrix {

    public int maxAreaRectInBinaryMatrix(int arr[][]){
        int size = arr[0].length;

        int newArr[] = new int[size];

        int max = 0;
                
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                newArr[j] = arr[i][j] == 0 ? 0  : newArr[j] + 1 ;
            }
            int temp = new MaximumAreaHistogram().maximumAreaHistogram(newArr);
            max = Math.max(max, temp);
        }

        return max;


    }
}