import java.util.*;
import java.io.*;

class CDLLImplement
{
	public static void main(String args[]) throws IOException
	{
		Scanner obj = new Scanner(System.in);
		CDLL cdll = new CDLL();
		int ele, pos, option;
		do{
		System.out.println("\n1. create list\n2. insert at beginning\n3. insert in middle\n4. insert at end\n5. delete at beginning\n6. delete in middle\n7. delete at end\n8. display\n9. display in reverse\n10. exit\nEnter your choice:");
		option = obj.nextInt();
		switch(option)
		{
			case 1: System.out.println("Enter element:");
				ele = obj.nextInt();
				cdll.create_list(ele);
				break;
			case 2: System.out.println("Enter element:");
				ele = obj.nextInt();
				cdll.insert_beg(ele);
				break;
			case 3: System.out.println("Enter element:");
				ele = obj.nextInt();
				System.out.println("Enter position:");
				pos = obj.nextInt();
				cdll.insert_mid(ele, pos);
				break;
			case 4: System.out.println("Enter element:");
				ele = obj.nextInt();
				cdll.insert_end(ele);
				break;
			case 5: cdll.delete_beg();
				break;
			case 6: System.out.println("Enter element to delete:");
				ele = obj.nextInt();
				cdll.delete_mid(ele);
				break;
			case 7: cdll.delete_end();	
				break;
			case 8: cdll.display();
				break;
			case 9: cdll.display_reverse();
				break;
			case 10: System.out.println("Chosen the exit option, thanks!");
		}
		}while(option <= 9);
	}//end of main
}

class CDLL
{
	Node head = new Node();
	void create_list(int ele)
	{
		Node newnode = new Node();
		newnode.data = ele;
		newnode.next = newnode.prev = newnode;
		head = newnode;
	}
	void insert_beg(int ele)
	{
		Node newnode = new Node();
		newnode.data = ele;
		newnode.next = head;
		newnode.prev = head.prev;
		head.prev.next = newnode;
		head.prev = newnode;
		head = newnode;
	}
	void insert_end(int ele)
	{
		Node newnode = new Node();
		newnode.data = ele;
		newnode.next = head;
		newnode.prev = head.prev;
		head.prev.next = newnode;
		head.prev = newnode;
	}
	void insert_mid(int ele, int pos)
	{
		Node newnode = new Node();
		newnode.data = ele;
		Node ptr = new Node();
		ptr = head;
		for(int i=1;i<pos-1;i++)
		{
			ptr = ptr.next;
		}
		newnode.next = ptr.next;
		ptr.next.prev = newnode;
		newnode.prev = ptr;
		ptr.next = newnode;
	}
	void delete_beg()
	{
		head.prev.next = head.next;
		head.next.prev = head.prev;
		head = head.next;
	}
	void delete_end()
	{
		head.prev.prev.next = head;
		head.prev = head.prev.prev;
	}
	void delete_mid(int ele)
	{
		Node ptr = new Node();
		ptr = head;
		while(ptr.data != ele)
		{
			ptr = ptr.next;
		}
		ptr.prev.next = ptr.next;
		ptr.next.prev = ptr.prev;
	}
	void display()
	{
		Node ptr = new Node();
		ptr = head;
		while(ptr.next != head)
		{
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		}
		System.out.print(ptr.data + "->" + head.data + "->...");
	}
	void display_reverse()
	{
		Node ptr = new Node();
		ptr = head.prev;
		while(ptr.prev != head)
		{
			System.out.print(ptr.data + "->");
			ptr = ptr.prev;
		}
		System.out.print(ptr.data + "->" + head.data + "->...");
	}
}