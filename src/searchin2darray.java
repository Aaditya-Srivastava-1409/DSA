public class searchin2darray {
    public static void main(String[] args) {
        int arr[][]={
                {1,4,7,10},
                {2,5,8,11},
                {3,6,9,12}
        };
        int target =122;
        serchin(arr,target);
    }
    static void serchin(int arr[][], int target){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if (target==arr[i][j]){
                    System.out.println("target found at "+i+j);
                }
               
            }
        }

    }
}
