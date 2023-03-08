package BinarySearch;

/**
 * @author weridy
 */
public class Basic {
    /**
     * 二分查找基础版
     *  Return 找到返回索引
     *         找不到返回-1
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,8,18,34,45,78,190};
        int target = 8;
        System.out.println(binarySearchBasic(arr, target));
        System.out.println(binarySearchAlterNative(arr, target));

    }

    /**
     * 二分查找基础版
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchBasic(int[] arr, int target){
        //设置指针和初值
        int left = 0;
        int right = arr.length-1;
        //范围内有东西
        while (left <= right) {
            int middle = (left + right)>>>1;
            if (arr[middle] == target) {
                //找到直接返回
                return middle;
            }
            if (target < arr[middle]) {
                // 目标小于中间值，右侧指针左移
                right = middle-1;
            }
            if (arr[middle] < target) {
                // 目标大于中间值，左侧指针右移
                left = middle + 1;
            }
        }
        return -1;
    }


    /**
     * 二分查找改动版
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchAlterNative(int[] arr, int target){
        //设置指针和初值
        int left = 0, right = arr.length;
        while (left<right){
            int middle = (left+right)>>>1;
            if (arr[middle]==target){
                return middle;
            }else if (target<arr[middle]){
                right=middle;
            }else if (arr[middle]<target){
                left=middle+1;
            }
        }
        return -1;
    }

}
