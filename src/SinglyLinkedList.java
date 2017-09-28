public class SinglyLinkedList {

    // SinglyLinkedList class will have ListNode as instance variable
    //private ListNode head; //this will be the head of the linkedList

    //Insert a new node at the end of the linked list

    public ListNode insertAtEnd(ListNode head, int data) {

        ListNode newNode = new ListNode(data);

        if (head == null) {
            return newNode;
        }

        ListNode current = head;

        while (current.next != null) {

            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    //Delete the last Node from Linked List

    public  ListNode deleteLast(ListNode head) {

        ListNode previousToLast = null;
        if (head == null) {
            return head;
        }

        ListNode last = head;


        while (last.next != null)
        {
            previousToLast = last;
            last = last.next;
        }
        previousToLast.next = null;
        return last;
    }

    //Insert Node after position of a given node

    public void insertAfter(ListNode previous, int data) {

        if (previous == null) {

            System.out.println("The given previous Node cant be null");
        }

        ListNode newNode = new ListNode(data);
        newNode.next = previous.next;
        previous.next = newNode;
    }

    //Insert Node at a given position

    public ListNode insertAtPosition(ListNode head, int data, int position) {

        int size = length(head);

        if (position > size + 1 || position < 1) {

            System.out.println("Invalid position");
            return head;
        }

        ListNode newNode = new ListNode(data);

        if (position == 1) {

            newNode.next = head;
            return newNode;
        }
        else {
            ListNode previous = head;
            int count = 1;

            while (count < position - 1) {

                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            newNode.next = current;
            previous.next = newNode;
            return head;
        }
    }

    //Delete node at the beginning of the list

    public ListNode DeleteAtBeginning(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    //given list node head and integer data insert integer the at the beginning

    public ListNode InsertAtBeginning(ListNode head, int data) {

        ListNode newNode = new ListNode(data);

        if (head == null) {
            return newNode;
        }

        newNode.next = head; //points to the current head
        head = newNode;
        return newNode; // this head will be new head having new data
    }

    // given a ListNode head, find the length of linked list
    public int length(ListNode head) {

        if (head == null) {
            return 0;
        }
        //create cound variable to hold length
        int count = 0;
        ListNode current = head;
        //loop each element and increment count until list ends
        while (current != null) {
            count ++;
            current = current.next;
        }
        return count;
    }

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
        ListNode last = singlyLinkedList.deleteLast(head);
        System.out.println(last.data);
        singlyLinkedList.display(head);

        //System.out.println("Length of Linked list is - " + singlyLinkedList.length(head));
        //head = singlyLinkedList.insertAtPosition(head,7, 5);
        //singlyLinkedList.display(head);

        /*System.out.println("Length of Linked list is - " + singlyLinkedList.length(newHead));
        singlyLinkedList.display(newHead);
        singlyLinkedList.DeleteAtBeginning(newHead2);
        singlyLinkedList.display(newHead2); */
    }
}