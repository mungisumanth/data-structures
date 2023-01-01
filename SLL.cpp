//SINGLE LINKED LIST
#include<stdio.h>
#include<stdlib.h>
struct node
{
	int data;
	struct node *next;
};
struct node *createlist(struct node*);
struct node *insertbeg(struct node*);
struct node *insertmid(struct node*);
struct node *insertend(struct node*);
struct node *deletebeg(struct node*);
struct node *deletemid(struct node*);
struct node *deleteend(struct node*);
struct node *display(struct node*);

struct node *start = NULL;
int main()
{
	int option;
	do{
	printf("1. create list\n2. insert at beginning\n3. insert in middle\n4. insert at end\n5. delete at beginning\n6. delete from middle\n7. delete at end\n8. display\nEnter your choice:");
	scanf("%d", &option);
	switch(option)
	{
		case 1: start = createlist(start);
			break;
		case 2: start = insertbeg(start);
			break;
		case 3: start = insertmid(start);
			break;
		case 4: start = insertend(start);
			break;
		case 5: start = deletebeg(start);
			break;
		case 6: start = deletemid(start);
			break;
		case 7: start = deleteend(start);
			break;
		case 8: start = display(start);
			break;
	}
	}while(option <=8);
	return 0;
} // end of main class

struct node *createlist(struct node *start)
{
	struct node *newnode, *ptr;
	int num;
	printf("Enter data:");
	scanf("%d",&num);
	newnode = (struct node*)malloc(sizeof(struct node));
	newnode ->data = num;
	newnode->next = NULL;
	if(start == NULL)
	{
		start = newnode;
		return start;
	}
	else
	{
		ptr = start;
		while(ptr->next != NULL)
		{
			ptr = ptr->next;
		}
		ptr->next = newnode;
		return start;
	}
} //end of create list

struct node *insertbeg(struct node *start)
{
	struct node *newnode, *ptr;
	int num;
	printf("Enter number:");
	scanf("%d",&num);
	newnode = (struct node*)malloc(sizeof(struct node));
	newnode->data = num;
	newnode ->next = start;
	start = newnode;
	return start;
} //end of insert at beginning

struct node *insertmid(struct node *start)
{
	struct node *newnode, *ptr;
	int num, pos;
	printf("Enter data:");
	scanf("%d", &num);
	printf("enter after which element:");
	scanf("%d", &pos);
	newnode = (struct node*)malloc(sizeof(struct node));
	newnode->data = num;
	ptr = start;
	while(ptr->next->data != pos)
	{
		ptr = ptr->next;
	}
	newnode->next = ptr->next->next;
	ptr->next->next = newnode;
	return start;
} //end of insert in middle

struct node *insertend(struct node *start)
{
	struct node *newnode, *ptr;
	int num;
	printf("enter data:");
	scanf("%d",&num);
	newnode = (struct node*)malloc(sizeof(struct node));
	newnode->data = num;
	ptr = start;
	while(ptr->next != NULL)
	{
		ptr = ptr->next;
	}
	ptr->next = newnode;
	newnode->next = NULL;
	return start;
} //end of insert at end

struct node *deletebeg(struct node *start)
{
	struct node *ptr;
	ptr = start;
	start = start->next;
	free(ptr);
	return start;
} // end of delete at beginning

struct node *deleteend(struct node *start)
{
	struct node *ptr;
	ptr = start;
	while(ptr->next != NULL)
	{
		ptr = ptr->next;
	}
	free(ptr->next);
	return start;
} //end of delete at end

struct node *deletemid(struct node *start)
{
	struct node *ptr, *ptr1;
	int num;	
	printf("enter the element to delete:");
	scanf("%d",&num);	
	ptr = start;
	while(ptr->next->data != num)
	{
		ptr = ptr->next;
	}
	ptr1 = ptr->next;
	ptr->next = ptr->next->next;
	free(ptr1);
	return start;
} //end of delete in middle

struct node*display(struct node *start)
{
	struct node *ptr;
	ptr = start;
	printf("Elements in the linked list are:\n");
	while(ptr->next != NULL)
	{
		printf("%d->", ptr->data);
		ptr = ptr->next;	
	}
	printf("%d->END", ptr->data);
} //end of display
