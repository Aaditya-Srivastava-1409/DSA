public class postionofanelementininfinitearray {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,12,14,16,18,19,22,23,26,28,29,31,33,39,44,51,60};

        int target = 7;
        System.out.println(findcorrectrange(a, target));
    }

    static int findcorrectrange(int a[], int target) {
        int start = 0;
        int end = 1;

        while (true) {
            try {
                if (a[end] >= target) {
                    break; // found a box that could contain target
                }
                // box not big enough, grow it
                int boxsize = end - start + 1;
                start = end + 1;
                end = end + boxsize * 2;
            } catch (ArrayIndexOutOfBoundsException e) {
                // end went past the real array — shrink end back down
                // and let binary search work with whatever is valid
                end = end / 2;
                break;
            }
        }

        return binarysearcha(a, target, start, end);
    }

    static int binarysearcha(int a[], int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            try {
                if (a[mid] == target) {
                    return mid;
                } else if (a[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // mid landed outside real array — treat as "too big"
                end = mid - 1;
            }
        }
        return -1; // not found
    }
}