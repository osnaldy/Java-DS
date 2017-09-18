public class SinglyLinkedList {

    // SinglyLinkedList class will have ListNode as instance variable
    private ListNode head; //this will be the head of the linkedList

    //It contains a static Inner class ListNode
    private static class ListNode {

        private int data;
        private ListNode next;

        //Then we need to create a constructor that will initialize a new node

        public ListNode(int datas) {

            this.data = datas;
            this.next = null;

        }
    }
    public static void main(String[] args) {

    }
}
