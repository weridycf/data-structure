package BinarySearch;

/**
 * 数组中有重复元素，查找目标元素最左侧的下标值
 * @author weridy
 */
public class Leftmost {
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,8,18,18,18,45,78,190};
        int target = 18;
        System.out.println(leftIndex(arr,target));
    }

    public static int leftIndex(int[] arr, int target){
        int left = 0, right = arr.length;
        int candidate = -1;
        while (left<right){
            int middle = (left+right)>>>1;
            if (target<arr[middle]){
                right=middle;
            }else if (arr[middle]<target){
                left=middle+1;
            }else {
                candidate=middle;
                right=middle;
            }
        }
        return candidate;
    }
}
