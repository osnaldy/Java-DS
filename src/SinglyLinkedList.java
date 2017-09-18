public class SinglyLinkedList {

    // SinglyLinkedList class will have ListNode as instance variable
    //private ListNode head; //this will be the head of the linkedList

    //Given a List write a function that prints elements it holds

    public void display(ListNode head) {

        //First we need to check if the head is null as they will not be any elements to print

        if (head == null)
        {
            return;
        }
        ListNode current = head;
        // wi will look each element in the list until it ends as last node will point to null
        while (current != null) {
            System.out.print(current.data + " --> "); //print current element

            current = current.next; //here we move current node to the next node
        }
        System.out.println(current); // here it will be null
    }
    //It contains a static Inner class ListNode
    private static class ListNode {

        private int data;
        private ListNode next;

        //Then we need to create a constructor that will initialize a new node

        public ListNode(int data) {

            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {

        //Create a linked list
        //10 --> 8 --> 1 --> 11 --> null
        //10 as the head node of Linked List

        ListNode head = new ListNode(10);
        ListNode second = new ListNode(8);
        ListNode thrid = new ListNode(1);
        ListNode fourth = new ListNode(11);

        //attach each node together to form a list
        head.next = second; //10 --> 8
        second.next = thrid; //10 --> 8 --> 1
        thrid.next = fourth; //10 --> 8 --> 1 --> 11
        fourth.next = null; //10 --> 8 --> 1 --> 11 --> null

        //to text it, we create an object from the main class
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.display(head);
    }
}
