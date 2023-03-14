package array;

public class TestArray {
    public static void main(String[] args) {
        DynamicArray dynaicArray = new DynamicArray();
        dynaicArray.addLast(1);
        dynaicArray.addLast(2);
        dynaicArray.addLast(3);
        dynaicArray.addLast(4);
        dynaicArray.addLast(5);
        dynaicArray.addLast(6);

        int remove = dynaicArray.remove(2);

    }
}
