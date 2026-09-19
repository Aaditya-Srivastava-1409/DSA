public class postionofanelementininfinitearray {
    public static void main(String[] args) {
        int[] a = {
                1, 2, 3, 4, 5, 6, 7, 8, 12, 14, 16, 18,
                19, 22, 23, 26, 28, 29, 31, 33, 39, 44, 51, 60
        };
        //
        int target = 60;
        System.out.println(findCorrectRange(a, target));
    }

    static int findCorrectRange(int[] a, int target) {
        int start = 0;
        int end = 1;

        while (a[end]<target) {
            int boxSize = end - start + 1;
            start = end + 1;
            end += 2 * boxSize;
        }

        return binarySearch(a, target, start, end);
    }

    static int binarySearch(int[] a, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1; // Target not found
    }
}