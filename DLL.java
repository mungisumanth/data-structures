import java.util.*;
import java.io.*;

class DLLImplement
{
	public static void main(String args[])throws IOException
	{
		Scanner obj = new Scanner(System.in);
		DLL dll = new DLL();
		int ele, pos, option;
		do{
		System.out.println("\n1. create list\n2. insert at beginning\n3. insert in middle\n4. insert at end\n5. delete at beginning\n6. delete in middle\n7. delete at end\n8. display\n9. Display reverse\n10. exit\nEnter your choice:");
		option = obj.nextInt();
		switch(option)
		{
			case 1: System.out.println("Enter number:");
				ele = obj.nextInt();
				dll.create_list(ele);
				break;
			case 2: System.out.println("Enter number:");
				ele = obj.nextInt();
				dll.insert_beg(ele);
				break;
			case 3: System.out.println("Enter number:");
				ele = obj.nextInt();
				System.out.println("Enter position:");
				pos = obj.nextInt();
				dll.insert_mid(ele, pos);
				break;
			case 4: System.out.println("Enter number:");
				ele = obj.nextInt();
				dll.insert_end(ele);
				break;
			case 5: dll.delete_beg();
				break;
			case 6: System.out.println("Enter position:");
				pos = obj.nextInt();
				dll.delete_mid(pos);
				break;
			case 7: dll.delete_end();
				break;
			case 8: dll.display();
				break;
			case 9: dll.display_reverse();
				break;
			case 10: System.out.println("Operations on the double linked list complete");
		}
		}while(option != 10);
	} //end of main
}

class DLL
{
	Node head = new Node();
	void create_list(int ele)
	{
		Node newnode = new Node();
		newnode.data = ele;
		newnode.next = newnode.prev = null;
		head = newnode;
	}
	void insert_beg(int ele)
	{
		Node newnode = new Node();
		newnode.data = ele;
		newnode.prev = null;
		newnode.next = head;
		head.prev = newnode;
		head = newnode;
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
		newnode.next = ptr.next.next;
		ptr.next.next.prev = newnode;
		newnode.prev = ptr.next;
		ptr.next.next = newnode;
	}
	void insert_end(int ele)
	{
		Node newnode = new Node();
		newnode.data = ele;
		Node ptr = new Node();
		ptr = head;
		while(ptr.next != null)
		{
			ptr = ptr.next;
		}
		newnode.next = null;
		newnode.prev = ptr;
		ptr.next = newnode;
	}
	void delete_beg()
	{
		head = head.next;
		head.prev  = null;
	}
	void delete_mid(int pos)
	{
		Node ptr = new Node();
		ptr = head;
		for(int i=1;i<pos-1;i++)
		{
			ptr = ptr.next;
		}
		ptr.next.next.prev = ptr;
		ptr.next = ptr.next.next;
	}
	void delete_end()
	{
		Node ptr= new Node();
		ptr = head;
		while(ptr.next != null)
		{
			ptr = ptr.next;
		}
		ptr.prev.next = null;
		ptr.prev = null;
	}
	void display()
	{
		Node ptr = new Node();
		ptr = head;
		while(ptr.next != null)
		{
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		}
		System.out.print(ptr.data + "->END");
	}
	void display_reverse()	
	{
		Node ptr = new Node();
		ptr = head;
		while(ptr.next != null)
		{
			ptr= ptr.next;
		}
		while(ptr.prev != null)
		{
			System.out.print(ptr.data + "->");
			ptr = ptr.prev;
		}
		System.out.print(ptr.data + "->END");
	}
}