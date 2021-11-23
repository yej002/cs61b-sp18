public class SList{

  public class IntNode{
    public int item;
    public IntNode next;
    public IntNode(int item, IntNode next) {
      this.item = item;
      this.next = next;
    }
  }
  private IntNode first;

  public SList(int x) {
        first = new IntNode(x, null);
    }
   
  public void addFirst(int x) {
    first = new IntNode(x, first);
  }
   
   
  public void reverse() {
    first = reverseRecursiveHelper(first);
  }
   
  private IntNode reverseRecursiveHelper(IntNode front) {
    if (front == null || front.next == null) {
      return front;
    }
    IntNode reversed = reverseRecursiveHelper(front.next);
    front.next.next = front;
    front.next = null;
    return reversed;
  }
       
  public static void main(String[] args) {        
    SList A = new SList(4);
    A.addFirst(3);
    A.addFirst(2);
    A.addFirst(1);
    A.reverse();  
    }
}
