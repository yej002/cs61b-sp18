public class LinkedListDeque<T>{
    private IntNode sentinel;
    private int size;

    public class IntNode{
        public IntNode prev;
        public T item;
        public IntNode next;

        public IntNode(IntNode p, T i, IntNode n){
            prev = p;
            item = i;
            next = n;
        }
    }
//    create a empty Dllist.
    public LinkedListDeque(){
        sentinel = new IntNode(null,null,null);
        size = 0;
    }
    public LinkedListDeque(T x){
        sentinel = new IntNode(null,null,null);
        sentinel.next = new IntNode(sentinel,x,null);
        size = 1;
    }
//    adds an item of typeT to the front of the deque.
    public void addFirst(T item){
        sentinel.next = new IntNode(sentinel,item,sentinel.next);
        size += 1;
    }
//    adds an item of typeT to the end of the deque.
    public void addLast(T item){
        size += 1;
        IntNode p = sentinel;
//        advance p to the end of the list.
        while(p.next != null){
            p = p.next;
        }
        p.next = new IntNode(p, item, null);
    }
//    returns ture if deque is empty.
    public boolean isEmpty() {
        return size == 0;
    }
//    returns the number of items in the deque.
    public int size() {
        return size;
    }
//    Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {
        IntNode p = sentinel.next;
        while (p != null){
            System.out.print(p.item + " ");
            p = p.next;
        }
    }
//     Removes and returns the item at the front of the deque.
//     If no such item exists, returns null.
    public T removeFirst() {
        if(sentinel.next != null){
            T p = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return p;
        }
        return null;
    }
//    Removes and returns the item at the back of the deque.
//    If no such item exists, returns null.
    public T removeLast() {
        if(sentinel.next != null){
            IntNode p = sentinel;
            while(p.next != null){
                p = p.next;
            }
            T last = p.item;
            p = null;
            size -= 1;
            return last;
        }
        return null;
    }
//    Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
//    If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        int i = 0;
        IntNode p = sentinel.next;
        if(sentinel.next!=null){
            while (i < index){
                p = p.next;
                i += 1;
            }
            return p.item;
        }
        return null;
    }

    public T getRecursive(int index) {
        if(size == 0 || index > size-1 || index < 0){
            return null;
        }
        IntNode p = sentinel.next;
        return getRecursiveHelper(index,p);
    }
    private T getRecursiveHelper(int index, IntNode p){
        if (index == 0){
            return p.item;
        }
        return getRecursiveHelper(index - 1, p.next);
    }
}

