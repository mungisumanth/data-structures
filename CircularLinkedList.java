import java.util.*;
import java.io.*;

class CLLImplement
{
	public static void main(String args[]) throws IOException
	{
		Scanner obj = new Scanner(System.in);
		CLL cll = new CLL();
		int ele, pos, option;
		do{
		System.out.println("\n1. create list\n2. insert at beginning\n3. insert in middle\n4. insert at end\n5. delete at beginning\n6. delete in middle\n7. delete at end\n8. display\n9. Exit\nEnter your choice:");
		option = obj.nextInt();
		switch(option)
		{
			case 1: System.out.println("Enter element:");
				ele = obj.nextInt();
				cll.create_list(ele);
				break;
			case 2: System.out.println("Enter element:");
				ele = obj.nextInt();
				cll.insert_beg(ele);
				break;
			case 3: System.out.println("Enter element:");
				ele = obj.nextInt();
				System.out.println("Enter position:");
				pos = obj.nextInt();
				cll.insert_mid(ele, pos);
				break;
			case 4: System.out.println("Enter element:");
				ele = obj.nextInt();
				cll.insert_end(ele);
				break;
			case 5: cll.delete_beg();
				break;
			case 6: System.out.println("Enter element to delete:");
				ele = obj.nextInt();
				cll.delete_mid(ele);
				break;
			case 7: cll.delete_end();	
				break;
			case 8: cll.display();
				break;
			case 9: System.out.println("Chosen the exit option, thanks!");
		}
		}while(option <= 8);
	}//end of main
}

class CLL
{
	Node1 head = new Node1();
	void create_list(int ele)
	{
		Node1 newnode = new Node1();
		newnode.data = ele;	
		newnode.next = newnode;
		head = newnode;
	}
	void insert_beg(int ele)
	{
		Node1 newnode = new Node1();
		newnode.data = ele;
		newnode.next = head;
		head.next = newnode;
		head = newnode;
	}
	void insert_mid(int ele, int pos)
	{
		Node1 newnode = new Node1();
		newnode.data = ele;
		Node1 ptr = new Node1();
		ptr = head;
		for(int i=1;i<pos-1;i++)
		{
			ptr= ptr.next;
		}
		newnode.next = ptr.next;
		ptr.next = newnode;
	}
	void insert_end(int ele)
	{
		Node1 newnode = new Node1();
		newnode.data = ele;
		Node1 ptr = new Node1();
		ptr = head;
		while(ptr.next != head)
		{
			ptr = ptr.next;
		}
		newnode.next = head;
		ptr.next = newnode;
	}
	void delete_beg()
	{
		Node1 ptr = new Node1();
		ptr = head;
		while(ptr.next != head)
		{
			ptr = ptr.next;
		}
		head = head.next;
		ptr.next = head;
	}
	void delete_end()
	{
		Node1 ptr = new Node1();
		ptr = head;
		while(ptr.next.next != head)
		{
			ptr = ptr.next;
		}
		ptr.next = head;
	}
	void delete_mid(int ele)
	{
		Node1 ptr = new Node1();
		ptr = head;
		while(ptr.next.data != ele)
		{
			ptr = ptr.next;
		}
		ptr.next = ptr.next.next;
	}
	void display()
	{
		Node1 ptr = new Node1();
		ptr = head;
		while(ptr.next != head)
		{
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		}
		System.out.print(ptr.data + "->" +head.data + "...");
	}
}
				
