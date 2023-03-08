package BinarySearch;

public class LeftMost2 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,8,18,18,18,45,78,190};
        int target = 18;
        System.out.println(binarySearchLeftMost2(arr,target));
        System.out.println(binarySearchRightMost2(arr, target));
    }

    /**
     *
     * @param arr
     * @param target
     * @return 返回 >= target 的最靠左索引
     */
    public static int binarySearchLeftMost2(int[] arr, int target){
        int left =0, right = arr.length -1;
        while (left<=right){
            int middle = (right+left)>>>1;
            if (target <= arr[middle]){
                right=middle-1;
            }else {
                left=middle+1;
            }
        }
        return left;
    }


    /**
     *
     * @param arr
     * @param target
     * @return 返回 >= target 的最靠左索引
     */
    public static int binarySearchRightMost2(int[] arr, int target){
        int left =0, right = arr.length -1;
        while (left<=right){
            int middle = (right+left)>>>1;
            if (target < arr[middle]){
                right=middle-1;
            }else {
                left=middle+1;
            }
        }
        return left -1;
    }
}
