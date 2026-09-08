public class binarysearch {
    public static void main(String[] args) {
        int a[] = {1, 2, 9, 14, 25, 36, 43, 58, 67, 70, 810, 911, 1012, 1113, 1214, 1315, 1416, 1517};
        int target = 0;
        //may cause overflow
        // int mid=high+low/2;
        System.out.println("taregt is at index :"+binarysearch_fn(a, target));
    }
        static int binarysearch_fn ( int a[], int target){
            int high = a.length - 1;
            int low = 0;

            while (high >= low) {
                int mid = low + (high - low) / 2;
                if (a[mid] > target) {
                    //assign index, not value
                    high = mid - 1;


                } else if (a[mid] < target) {
                    low = mid + 1;
                } else if (target == a[mid]) {
                    return mid;
                }
            }
            return -1;
        }
    }

