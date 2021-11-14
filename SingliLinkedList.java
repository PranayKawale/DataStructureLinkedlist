package com.linkedlist;

public class SingliLinkedList {
	 //Represent a node of the singly linked list
    public static class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    //Represent the head and tail of the singly linked list
    private Node head = null;
    private Node tail = null;

    //addNode() will add a new node to the list, Create a new node, Checks if the list is empty by using head address
    public void addNode(int x){
        Node newNode = new Node(x);

        if (head == null){
            head = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        tail = newNode;
    }

    //displayList() will display all the nodes
    public void displayList(){
        Node temp = head;
        if (head == null){
            System.out.println("Singly Linked List is Empty");
        }
        System.out.println("Node's of Singly Linked List :");
        while (temp != null){
            System.out.println(temp.data + "");
            temp = temp.next;
        }
        System.out.println();

    }

    //Add nodes to the list at Beginning
    public void addToBegin(int x){
        if (head == null){
            this.head = new Node(x);
        }else{
            Node temp = new Node(x);
            temp.next = head;
            head = temp;
        }
    }
    //Add nodes to the list at End
    public void addToEnd(int x){
        Node node = new Node(x);
        if (head == null){
            this.head = node;
        }else{
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public Node getHead(){
        return head;
    }

    public void addAtPos(int pos, int x, Node head) {
        Node temp = head;
        Node temp2 = new Node(x);
        temp2.next = null;
        pos--;
        while (pos != 1){
            temp = temp.next;
            pos--;
        }
        temp2.next = temp.next;
        temp.next = temp2;
    }
    
    //Remove nodes to the Beginning
    public void remNodeAtBegn(){
        if (head == null){
        }else {
            head = head.next;
        }
    }

    
    //Remove nodes to the Ending
    public void remNodeAtEnd(){
        if (head == null && head.next == null){
            return;
        }
        Node temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }


  //Search nodes to the Beginning to End
    public void searchNode(int traget){
        int i=0;
        while (head != null){
            i++;
            if (head.data == traget){
                System.out.println(traget+" Value is at "+ i + " Node");
            }
            head = head.next;
        }
        System.out.println("Singly Linked List is Empty");
    }


    public void remNodeAtPos(int pos, int target, Node head){
        Node temp = head;
        Node prev = head;
        if (temp != null && temp.data == target){
            temp = temp.next;
            return;
        }
        while (temp != null && temp.data != target){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        if (temp == null)
            return;
    }

  //Nodes size
    public int size(){
        Node temp = head;
        int i = 0;
        while (temp != null){
            i++;
            temp = temp.next;
        }
        return i;
    }

    //Sorting using bubble sort
    public void sort(){
        for (Node i = head; i.next != null; i = i.next){
            for (Node j = head; j.next != null; j = j.next){
                if (j.data > i.next.data){
                    int temp = j.data;
                    j.data = j.next.data;
                    j.next.data = temp;
                }
            }
        }
    }



    public static void main(String[] args) {
        SingliLinkedList slList = new SingliLinkedList();

        //Add nodes to the list at End
        slList.addToEnd(56);
        slList.addToEnd(30);
        slList.addToEnd(40);




        //Search nodes to the Given Position
        slList.addAtPos(4, 70, slList.head);

        //Search nodes to the Given Position and Deleted the Node
        slList.remNodeAtPos(3, 40, slList.head);

        slList.addToEnd(40);

        //Sorting using bubble sort
        slList.sort();

        //Call the Displays Method
        slList.displayList();

        System.out.println("Size of the Above Linked List is "+slList.size());





    }
}