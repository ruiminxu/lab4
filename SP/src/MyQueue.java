import java.util.ArrayList;
public class MyQueue
{
    private Node head;
    private Node tail;

    public MyQueue(String name)
    {
        add(name);
    }
    public boolean isEmpty()
    {
        return head == null;
    }

    public void add(String data)
    {
        Node node = new Node(data);
        if(tail != null)
        {
            tail.next = node;
        }

        tail = node;

        if(head == null)
        {
            head = node;
        }

    }

    public void peek()
    {
        System.out.println(getHead());
    }

    public String remove()
    {
        String data = head.data;
        head = head.next;

        if(head == null)
        {
            tail = null;
        }

        return data;
    }

    public String getHead()
    {
        return head.data;
    }


    public void printQue()
    {
        Node pointer = head;
        while(pointer != null)
        {
            System.out.println(head.data);
            pointer = pointer.next;
        }
    }
}
