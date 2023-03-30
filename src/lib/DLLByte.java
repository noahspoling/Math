package lib;
/* 
 * Class: DLLByte.java
 * Author: Noah Poling
 * Description: Doubly Linked List that stores value as a byte.
 * Numbers stored are only 0,9 and the max value from multiplication is 81
 * Byte will never fall outside of scope for all supported operations.
 * Using a DLL since a lot of Math operations will start at the tens digit.
 * Random access not needed so it saves on space not having methods for that
 * 
 * NOT USED YET
 */
public class DLLByte {
    
    Node head;

    //Class Object for DLL Nodes
    class Node {
        byte data;
        Node prev;
        Node next;

        //Node Constructor
        Node(byte d){ data = d; }
    }

    /*
     * Create node and add parameter value
     * Sets head to node after inserted node
     * Sets previous node to null since it is the head
     * Then if DLL was not empty give a previous reference to new node 
     * Then sets head as new value
     */

    public void push( byte value ) {

        Node newNode = new Node(value);
        newNode.next = head;
        newNode.prev = null;
        if(head != null){
            head.prev = newNode;
        }
        head = newNode;
    }

    /*
     * Creates node and sets its next Node as null indicating the end of the DLL
     */
    public void append(byte value) {

    }
}
