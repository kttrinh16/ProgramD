import java.util.List;
import java.util.NoSuchElementException;

public class LinkedQueue<E> {

    private ListNode front;
    private ListNode rear;
    private int size;

    /**
     * initialization of the queue front and rear node
     */
    public LinkedQueue(){
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * checks if the queue is empty
     * @return true or false
     */
    public boolean isEmpty(){
        return (size == 0);
    }


    /**
     * adds a new node to the end of the queue
     * @return FIFO added node
     */
    public int deQueue(){
        int data = front.getData();
        front = front.getNext();
        if(isEmpty()){
            rear = null;
        }
        size--;
        System.out.println("Element" + data + "Removed");
        return data;
    }

    /**
     * removes the front of the queue
     * @param data
     * @return queue without the front node
     */
    public void enQueue(E data){
        ListNode n = new ListNode();
        if(front == null){
            front = n;
            rear = n;

        }
        else{
            rear.setNext(n);
        }
        size++;
        System.out.println("data:" + data + " has been added to the queue");
    }

    public String toString(){
        String result = "";
        ListNode current = front;
        while(current !=null){
            result = result + current.toString() + "\n";
            current = current.getNext();
        }
        return result;
    }



}
