package array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author weridy
 * 自定义动态数组
 */
public class DynamicArray implements Iterable<Integer>{

    //逻辑大小
    private int size;

    //容量
    private int capacity = 8;

    private int[] array = {};

    /**
     * 末尾插入元素
     * @param element
     */
    public void addLast(int element){
        array[size] = element;
        size++;
    }

    /**
     * 向指定位置插入数据
     * @param index 索引位置
     * @param element 待插入元素
     */
    public void add(int index, int element){
        checkAndGrow();
        //添加范围
        if (index >=0 && index<size) {
            System.arraycopy(array, index,
                    array, index+1, size-index);
        }
        array[index] = element;
        size++;
    }

    /**
     * 检查数组容量并扩容
     */
    private void checkAndGrow() {
        //容量检查
        if (size==0){
            array = new int[capacity];
        }else if (size == capacity) {
            //进行扩容 1.5 倍
            capacity += capacity>>1;
            int[] newArr = new int[capacity];
            System.arraycopy(array,0,
                    newArr, 0, size);
            array = newArr;
        }
    }

    /**
     * 查找指定索引位置的元素
     * @param index 索引位置
     * @return
     */
    public int get(int index){
        //大于数据范围则抛出异常
        if (index >= size){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    /**
     * 遍历方式1
     * @param consumer  遍历要执行的操作，入参：每个元素
     */
    public void foreach(Consumer<Integer> consumer){
        for (int i = 0; i < size - 1; i++) {
//            System.out.println(array[i]);
            //提供 array[i]
            //返回 void
            consumer.accept(array[i]);
        }
    }

    /**
     *  迭代器循环
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            // 匿名内部类
            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }

    /**
     * stream 流循环
     * @return
     */
    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array,0,size));
    }

    /**
     * 删除指定索引元素
     * @param index 索引
     * @return
     */
    public int remove(int index){  // [0. size)
        int removed = array[index];
        if (index < size-1) {
            System.arraycopy(array, index+1,
                    array, index, size - index - 1);
        }
        size--;
        return removed;
    }

}
