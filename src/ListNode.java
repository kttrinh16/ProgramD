public class ListNode{
    private ListNode next;
    private int data;

    public ListNode(){
        next = null;
        data = Integer.MIN_VALUE;
    }

    public ListNode(int data){
        next = null;
        this.data = data;
    }

    public ListNode getNext(){
        return next;
    }

    public void setNext(ListNode node){
        next = node;
    }

    public int getData(){
        return data;
    }

    public void setData(int elem){
        data = elem;
    }

}
