public class Playlist
{
    private SongNode head;
    private SongNode tail;

    public boolean isEmpty()
    {
        return head == null;
    }

    public Song peek()
    {
        return head.data;
    }

    public void add(Song data)
    {
        SongNode node = new SongNode(data);
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

    public Song remove()
    {
        Song data = head.data;
        head = head.next;

        if(head == null)
        {
            tail = null;
        }

        return data;
    }




}
