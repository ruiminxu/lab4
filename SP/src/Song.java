public class Song
{
    private String position;
    private String songName;
    private String singer;
    private String streamNumber;
    private String URL;

    public Song(String position, String songName, String singer, String streamNumber, String URL)
    {
        this.singer = singer.replaceAll("\"", "").strip();
        this.position = position;
        this.songName = songName.replaceAll("\"", "").strip();
        this.streamNumber = streamNumber;
        this.URL = URL;
    }

    public void setSongName(String songName)
    {
        this.songName = songName;
    }

    public void setSinger(String singer){ this.singer = singer;}

    public void setPosition(String position)
    {
        this.position = position;
    }

    public void setURL(String URL)
    {
        this.URL = URL;
    }

    public void setStreamNumber(String streamNumber)
    {
        this.streamNumber = streamNumber;
    }

    public String getSongName()
    {
        return songName;
    }

    public String getSinger() {return singer;}

    public String getPosition()
    {
        return position;
    }

    public String getURL()
    {
        return URL;
    }

    public String getStreamNumber()
    {
        return streamNumber;
    }
}
