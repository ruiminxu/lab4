import java.util.ArrayList;
public class Artist
{
    private String name;
    private int totalStreamNumber;
    private ArrayList<Song> songList;

    public Artist(String name)
    {
        this.name = name.replaceAll("\"", "").strip();
        songList = new ArrayList<>();
    }

    public void addSong(Song song)
    {
        boolean flag = false;
        int index = 0;

        for(int i = 0; i < songList.size(); i++)
        {
            if(song.getSongName().equalsIgnoreCase(songList.get(i).getSongName()))
            {
                flag = true;
                index = i;
            }
        }

        if(!songList.isEmpty() && flag == false)
        {
            songList.add(song);
            setTotalStreamNumber();
        }else if(!songList.isEmpty() && flag == true)
        {
            return;
        }else {
            songList.add(song);
            setTotalStreamNumber();
        }
    }

    public void setTotalStreamNumber()
    {
        if(!songList.isEmpty())
        {
            for (int i = 0; i < songList.size(); i++)
            {
                totalStreamNumber += Integer.parseInt(songList.get(i).getStreamNumber());
            }
        }else{
            totalStreamNumber += Integer.parseInt(songList.get(0).getStreamNumber());
        }
    }

    public int getTotalStreamNumber()
    {
        return totalStreamNumber;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Song> getSongsList()
    {
        return songList;
    }

    public void printList()
    {
        System.out.println("The artist " + name + " has " + songList.size() + " songs: ");
        for(int i = 0; i < songList.size(); i++)
        {
            System.out.println(i+1 + ". " + songList.get(i).getSongName() + " " + songList.get(i).getStreamNumber());
        }
    }


}
