public class peakelementinbitonicarray {
    public static void main(String[] args) {
        int a[] = {2, 4, 6, 8, 9, 7, 5, 3, 1, 0};
        System.out.println(binarysearchbitonic(a));
    }

    static int binarysearchbitonic(int a[]) {
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            int mid = 0;
            try {
                mid = start + (end - start) / 2;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (a[mid] < a[mid + 1]) {//we're in the increasing half
                start = mid + 1;
            } else if (a[mid] > a[mid + 1]) {
                end = mid;// we're in the decreasing half
            }
        }
        return a[start];
    }
}
