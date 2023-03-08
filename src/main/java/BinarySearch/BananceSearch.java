package BinarySearch;

public class BananceSearch {
    public static void main(String[] args) {

    }

    public static int balanceBinarySearch(int[] arr, int target){
        int left =0, right = arr.length;

        while (1<right - left){
            int middle = (right - left)>>>1;
            if(target < arr[middle]){
                right = middle;
            } else {
                left = middle;
            }
        }

        if (arr[left] == target) {
            return left;
        } else {
            return -1;
        }

    }
}
