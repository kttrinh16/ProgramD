import java.util.EmptyStackException;



public class LinkedStack {
    /**
     * initalize the top and length in the stack
     *
     * @param top
     * first node in the stack
     */
    private int length;
    private ListNode top;

    /**
     * initialize the length to 0 and top to null
     */
    public LinkedStack(){
        length = 0;
        top = null;
    }

    /**
     * adding a new node to the stack
     * @param data
     * @postcondition
     * new node is added to the top of the stack
     */
    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.setNext(top);
        length++;
    }

    /**
     * removes the top of the stack
     * @return the list without the removed node
     * @throws EmptyStackException
     */
    public int pop() throws EmptyStackException{
        if(isEmpty())
            throw new EmptyStackException();
        int result = top.getData();
        top = top.getNext();
        length--;
        return result;

    }


    /**
     * prints out the top node of the stack but doesn't remove it
     * @return
     * @throws EmptyStackException
     */
    public int peek() throws EmptyStackException{
        if(isEmpty())
            throw new EmptyStackException();

        return top.getData();
    }

    /**
     * checks to see if the stack is empty
     * @return true or false
     */
    public boolean isEmpty(){
        return(length == 0);
    }

    /**
     *
     * @return
     */
    public int size(){
        return length;
    }

    public String toString(){
        String result = "";
        ListNode current = top;
        while(current != null){
            result = result + current.toString() + "\n";
            current = current.getNext();
        }
        return result;
    }

}
