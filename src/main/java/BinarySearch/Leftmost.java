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
        System.out.println(rightIndex(arr, target));
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
                //记录候选位置
                candidate=middle;
                right=middle;
            }
        }
        return candidate;
    }

    /**
     * 查找重复元素最右侧索引值
     * 找到返回索引，未找到返回-1
     * @param arr
     * @param target
     * @return
     */
    public static int rightIndex(int[] arr, int target){
        int left=0, right=arr.length -1;
        //候选者
        int candidata = -1;
        while (left<=right){
            int middle = (left+right)>>>1;
            if (target<arr[middle]){
                right = middle -1;
            } else if (arr[middle] < target){
                left = middle+1;
            } else {
                candidata = middle;
                left = middle+1;
            }
        }
        return candidata;
    }
}
