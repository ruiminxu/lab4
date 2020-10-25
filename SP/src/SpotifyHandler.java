import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class SpotifyHandler
{
    private String name;
    private ArrayList<String> csvList = new ArrayList<>();
    private ArrayList<Artist> artistList = new ArrayList<>();
    private ArrayList<Song> songList = new ArrayList<>();

    public SpotifyHandler()
    {

    }

    public void handleFile(String fileName)
    {
        try
        {
            Scanner readFile = new Scanner(new File(fileName));
            String description = readFile.nextLine();
            String header = readFile.nextLine();

            while(readFile.hasNextLine())
            {
                String line = readFile.nextLine();
                csvList.add(line);
            }


        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void handleClass(ArrayList<String> temp)
    {
        for(int i = 0; i < temp.size(); i++)
        {
            String[] temp1 = temp.get(i).split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            Artist artist = new Artist(temp1[2]);
            Song song = new Song(temp1[0], temp1[1], temp1[2], temp1[3], temp1[4]);


            boolean flag = false;
            int index = 0;

            for(int j = 0; j < artistList.size(); j++)
            {
                if(artist.getName().equalsIgnoreCase(artistList.get(j).getName()))
                {
                    flag = true;
                    index = j;
                }
            }

            boolean flag1 = false;
            for(int k = 0; k < songList.size(); k++)
            {
                if(song.getSongName().equalsIgnoreCase(songList.get(k).getSongName()))
                {
                    flag1 = true;
                }
            }

            if(songList.isEmpty())
            {
                songList.add(song);
            }else if(!songList.isEmpty() && flag1 == false)
            {
                songList.add(song);
            }else if(!songList.isEmpty() && flag1 == true)
            {
                return;
            }



            if(!artistList.isEmpty() && flag == false)
            {
                artist.addSong(song);
                artistList.add(artist);

            }else if(!artistList.isEmpty() && flag == true)
            {
                artistList.get(index).addSong(song);
            }else {
                artist.addSong(song);
                artistList.add(artist);
            }
        }



    }

    public ArrayList<Song> getSongList()
    {
        return songList;
    }

    public ArrayList<Artist> getArtistList()
    {
        return artistList;
    }

    public ArrayList<String> getCsvList()
    {
        return csvList;
    }
}
