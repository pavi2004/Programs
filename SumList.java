import java.util.*; 
 class Node 
	{ 
		int data; 
		Node next; 
 
		public Node(int data) 
		{ 
			this.data = data; 
		} 
	} 
 
public class SumList 
{ 
	
	Node head;
  void push(int data)
  {
    Node newnode=new Node(data);
    newnode.next=this.head;
    this.head=newnode;
  }
 
   void insert(int data)
  {
    Node newnode=new Node(data);
    if(this.head==null)
    {
      this.head=newnode;
      return;
    }
    Node temp=this.head;
    while(temp.next!=null)
    {
      temp=temp.next;
    }
    temp.next=newnode;
  }

	 void printList(Node head) 
	{ 
    Node temp=head;
		while (temp.next != null ) 
		{ 
			System.out.print(temp.data + "->"); 
			temp = temp.next; 
		} 
    System.out.println(temp.data);
	} 
  
  void addTwoList(Node head1,Node head2)
  {
    int sum,carry=0;
    while(head1!=null || head2!=null)
    {
      int h1,h2;
      if(head1==null)
        h1=0;
      else
      {
        h1=head1.data;
        head1=head1.next;
      }
      if(head2==null)
        h2=0;
      else
      {
        h2=head2.data;
        head2=head2.next;
      }
      sum=carry+h1+h2;
      carry=0;
      if(sum>9)
      {
        carry=1;
        sum=sum%10;
      }
      this.insert(sum);
      
    }
    if(carry>0)
    {
      this.insert(carry);
    }
  }
	public static void main(String[] args) 
	{ 
    Scanner sc=new Scanner(System.in);
		SumList list1=new SumList(); 
    SumList list2=new SumList(); 
    SumList list3=new SumList(); 
    int n;
    n=sc.nextInt();
    for(int i=0;i<n;i++)
    {
      int data=sc.nextInt();
        list1.push(data);
    }
    n=sc.nextInt();
    for(int i=0;i<n;i++)
    {
      int data=sc.nextInt();
        list2.push(data);
    }
    list3.addTwoList(list1.head,list2.head);
    list3.printList(list3.head);
    
  }
}
