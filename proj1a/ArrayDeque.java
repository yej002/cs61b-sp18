public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;

    /**
     * Creates an empty list.
     */
    @Override
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }


    //    adds an item of typeT to the front of the deque.
    @Override
    public void addFirst(T item) {
        resize1((size + 1) * 2); /**RFACTOR*/
        items[0] = item;
        size += 1;
    }

    //    adds an item of typeT to the end of the deque.
    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize2(size * 2); /**RFACTOR*/
        }
        items[size] = item;
        size += 1;
    }

    public void resize1(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 1, size);
        items = a;
    }
    public void resize2(int capacity) {
        if (size == items.length) {
            T[] a = (T[]) new Object[capacity];
            System.arraycopy(items, 0, a, 0, size);
            items = a;
        }
    }
    @Override
    public T getFirst() {
        T first = items[0];
        return first;
    }
    @Override
    public T getLast() {
        T last = items[size - 1];
        return last;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

//    Deletes item from front of the list and
//      returns deleted item.
    @Override
    public T removeFirst(){
        T first = getFirst();
        items[0] = null;
        T[] a = (T[]) new Object[items.length];
        System.arraycopy(items, 1, a, 0, size-1);
        items = a;
        size -= 1;
        return first;
    }
//    Deletes item from back of the list and
//      returns deleted item.
    @Override
    public T removeLast(){
        T last = getLast();
        items[size - 1] = null;
        size -= 1;
        return last;
    }
}