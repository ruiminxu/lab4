import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class SpotifyPlayer {


    public static void main(String[] args) throws Exception{

        Scanner keyboard = new Scanner(System.in);
        String[] fileList = {"regional-global-daily-2019-01-01.csv", "regional-global-daily-2019-03-01.csv", "regional-global-daily-2019-06-01.csv", "regional-global-daily-2019-09-01.csv"};

        SpotifyHandler handler = new SpotifyHandler();
        ArrayList<String> temp = new ArrayList<>();


        for (int i = 0; i < fileList.length; i++)
        {
            MyQueue que = new MyQueue(fileList[i]);
            handler.handleFile(que.getHead());
            for (int j = 0; j < 200; j++) {
                temp.add(handler.getCsvList().get(j));
            }
        }

        handler.handleClass(temp);

        ArrayList<Artist> s = handler.getArtistList();

        ArrayList<Song> b = handler.getSongList();

        quicksort(b, 0, b.size() - 1);


        File file = new File("Artists-WeekOf10252020.txt");
        file.createNewFile();
        FileWriter writeFile = new FileWriter(file);
        writeFile.write("List Of songs in four quarters:\n");

        for(int i = 0; i < b.size(); i++)
        {
            writeFile.write(i+1 + ". " + b.get(i).getSongName()
                    + " " + b.get(i).getSinger() + " " + b.get(i).getStreamNumber() + " " + b.get(i).getURL() +"\n");
        }

        writeFile.flush();
        writeFile.close();
        keyboard.close();



    }

    public static void quicksort(ArrayList<Song> b, int low, int high) {
        int i = low, j = high;

        String pivot = b.get(low + (high - low) / 2).getSongName();

        while (i <= j)
        {
            while (b.get(i).getSongName().compareToIgnoreCase(pivot) < 0)
            {
                i++;
            }

            while (b.get(j).getSongName().compareToIgnoreCase(pivot) > 0)
            {
            j--;
            }

            if (i <= j)
            {
            swap(b, i, j);
            i++;
            j--;
            }
         }

        if (low < j) {
            quicksort(b, low, j);
        }

        if (i < high) {
            quicksort(b, i, high);
        }


    }

    public static void swap(ArrayList<Song> b, int i, int j)
        {
            Song temp = b.get(i);
            b.set(i, b.get(j));
            b.set(j, temp);
        }



    }



