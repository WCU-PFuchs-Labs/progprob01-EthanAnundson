/*
Given a sorted linked list, delete all nodes that have duplicate
numbers, leaving only distinct numbers from the original list.In this 
program, you need to 
(1) read 5 numbers and set them in a linkedlist in order
(2) delete duplicate

Example 1:
input: 1,2,3,3,5
output: head-->1-->2-->3-->5-->null

Example 2:
input: 1,1,1,2,3
output: head-->1-->2-->3-->null

Please complete the following program to fullfil the function.
*/
import java.util.Scanner; //to Read the 5 numbers
import java.util.ArrayList; //to help order the 5 numbers
import java.util.Collections; //to help order the 5 numbers
public class homework20_1
{
   public static void main(String[] args)
   {
        Scanner sc = new Scanner(System.in); //Inititalizes scanner to System.in
        ArrayList<Integer> numbers = new ArrayList<>(); //Initializes ArrayList of type Integer called numbers

        for(int i =0; i<5; i++){ //Prints to add number and adds number to the ArrayList
            System.out.println("add a number to the linkedList");
            numbers.add(sc.nextInt());
        }
        sc.close(); //Closes scanner
        Collections.sort(numbers); //Sorts the ArrayList
        ListNode node1 = new ListNode(numbers.get(0)); //Initialized the 5 nodes with the numbers from the ArrayList
        ListNode node2 = new ListNode(numbers.get(1));
        ListNode node3 = new ListNode(numbers.get(2));
        ListNode node4 = new ListNode(numbers.get(3));
        ListNode node5 = new ListNode(numbers.get(4));
        node1.next = node2; //Sets the nodes pointer to the next node
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        LinkedList list = new LinkedList(); //initializes a LinkedList named list
        list.head = node1; //Sets the LinkedList head to node1
        System.out.println(list.toString()); //Prints the String of the LinkedList to string before removing duplicates
        deleteDuplicates(list); //Removes duplicates
        System.out.println(list.toString()); //Prints the LinkedList to string after removing duplicates
      
   
   }
   public static void deleteDuplicates(LinkedList llist){ //Method to remove duplicates
        ListNode point = llist.head; //Makes ListNode called point and makes it equal to head

        while (point != null && point.next != null) //runs while method while the head doesnt equal null and the pointer doesnt equal node either
        {
            if (point.value == point.next.value) {
            point.next = point.next.next;
            } else {
            point = point.next;
            }
        }
    }

}

class ListNode
{
   int value;
   ListNode next;
   ListNode(int v){value = v;}
}

class LinkedList
{
   ListNode head;
   public String toString()
   {
      String nodeData = "";
      ListNode ref = head;
      while(ref != null)
      {
         nodeData += ref.value + "-->";
         ref = ref.next;
      }
      return "head-->"+nodeData+"null";
   }
}
