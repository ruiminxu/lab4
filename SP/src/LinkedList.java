public class LinkedList
{
    private Node head;
    private String data;
    private int size;

    public void insert(String data)
    {

        if (head == null) {
            head = new Node(data);
            size++;
            return;
        }
        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }

        pointer.next = new Node(data);
        size++;
    }

    public void printList()
    {
        Node pointer = head;
        while(pointer != null)
        {
            System.out.println(pointer.getData());
            pointer = pointer.next;
        }
    }


}
