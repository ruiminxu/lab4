public class SongNode
{
    Song data;
    SongNode next;

    public SongNode(Song data)
    {
        this.data = data;
    }

    public void setData(Song data)
    {
        this.data = data;
    }

    public void setNext(SongNode next)
    {
        this.next = next;
    }

    public Song getData()
    {
        return data;
    }

    public SongNode getNext()
    {
        return next;
    }
}
