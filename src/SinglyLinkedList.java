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

    //Search for a an element in a linked list

    public boolean searchNode(ListNode head, int searchKey) {

        if (head == null) {

            return false;
        }

        ListNode current = head;

        while (current != null) {

            if (current.data == searchKey) {

                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Reverse Singly Linked List

    public ListNode reverseLinkedList(ListNode head) {

        if (head == null) {

            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {

            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }


    //Delete a Node at a given position

    public ListNode deleteNodeAtPosition(ListNode head, int position) {

        int size = length(head);

        if (position > size || position < 1) {
            System.out.println("Invalid position was given");
            return head;
        }

        if (position == 1) {

            ListNode temp = head;
            head.next = head;
            temp.next = null;
            return temp;
        } else {

            ListNode previous = head;
            int count = 1;

            while (count < position - 1) {

                previous = previous.next;
                count++;
            }

            ListNode current = previous.next;
            previous.next = current.next;
            current.next = null;
            return current;
        }

    }

    //Delete the last Node from Linked List

    public ListNode deleteLast(ListNode head) {

        ListNode previousToLast = null;
        if (head == null) {
            return head;
        }

        ListNode last = head;


        while (last.next != null) {
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
        } else {
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
            count++;
            current = current.next;
        }
        return count;
    }

    // Function to find the kth to last element using two pointer

    public int kthToLastUsingToPointers(ListNode head, int n) {

        ListNode pointerP = head;
        ListNode pointerQ = head;

        int position = 1;

        while (position <= n - 1) {

            pointerP = pointerP.next;
            position++;
        }

        while (pointerP.next != null) {

            pointerP = pointerP.next;
            pointerQ = pointerQ.next;
        }
        return pointerQ.data;

    }

    //Function to return the Kth element to last in the linked list.

    public int KthToLast(int n, ListNode head) {

        ListNode current = head;

        int len = length(current);

        int passes = len - n;

        int count = 0;

        while (count != passes) {

            current = current.next;
            count ++;
        }

        return current.data;
    }

    // return the sum of a Linked list then return it's value

    public int sumNodesInLinkedList(ListNode head) {

        ListNode current = head;
        int carry = 0;

        while (current != null) {

            carry += current.data;
            current = current.next;
        }

        return carry;
    }

    public ListNode addTwoLinkedListInReverseOrder(ListNode head1, ListNode head2) {

        ListNode newHead = new ListNode(0);
        ListNode current1 = head1;
        ListNode current2 = head2;
        ListNode current3 = newHead;
        int carry = 0;

        while (current1 != null || current2 != null) {

            if (current1 != null) {

                carry += current1.data;
                current1 = current1.next;
            }

            if (current2 != null) {

                carry += current2.data;
                current2 = current2.next;
            }

            current3.next = new ListNode(carry%10);
            current3 = current3.next;
            carry /= 10;

            if (carry == 1) {

                current3.next = new ListNode(1);
            }
        }

        return newHead.next;
    }


    //Given a List write a function that prints elements it holds
    public void display(ListNode head) {

        //First we need to check if the head is null as they will not be any elements to print

        if (head == null) {
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

        ListNode head = new ListNode(7);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(6);
        //ListNode fourth = new ListNode(11);

        ListNode head2 = new ListNode(5);
        ListNode second2 = new ListNode(9);
        ListNode third2 = new ListNode(2);
        //ListNode fourth2 = new ListNode(1);

        //attach each node together to form a list
        head.next = second; //10 --> 8
        second.next = third; //10 --> 8 --> 1
        third.next = null; //10 --> 8 --> 1 --> 11
        //fourth.next = null; //10 --> 8 --> 1 --> 11 --> null

        //attach each node2 together to form a list
        head2.next = second2;
        second2.next = third2;
        third2.next = null;
        //fourth2.next = null;

        //to text it, we create an object from the main class
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.display(head);
        //singlyLinkedList.display(head2);

        System.out.println(singlyLinkedList.kthToLastUsingToPointers(head, 3));
//        ListNode thirdNode = singlyLinkedList.deleteNodeAtPosition(head, 3);
//        System.out.println(thirdNode.data);
//        singlyLinkedList.display(head);

//        int h3 = singlyLinkedList.sumNodesInLinkedList(head2);
//        System.out.println(h3);

//        if (singlyLinkedList.searchNode(head, 22)) {
//
//            System.out.println("Searched key was found");
//        } else {
//            System.out.println("Searched key was NOT found!!!");
//        }

//        ListNode reverse = singlyLinkedList.reverseLinkedList(head);
//        singlyLinkedList.display(reverse);

        //ListNode h5 = singlyLinkedList.addTwoLinkedListInReverseOrder(head, head2);
        //singlyLinkedList.display(h5);

        //System.out.println("Length of Linked list is - " + singlyLinkedList.length(head));
        //head = singlyLinkedList.insertAtPosition(head,7, 5);
        //singlyLinkedList.display(head);

        /*System.out.println("Length of Linked list is - " + singlyLinkedList.length(newHead));
        singlyLinkedList.display(newHead);
        singlyLinkedList.DeleteAtBeginning(newHead2);
        singlyLinkedList.display(newHead2); */
    }
}
