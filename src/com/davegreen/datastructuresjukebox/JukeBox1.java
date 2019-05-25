/*
 * There is a problem with this in that the code prints out all the duplicates
 * See DataStructutreJukeBox2 for using Sets(type of collection that does not allow duplicates) instead of ArrayLists
 */
package com.davegreen.datastructuresjukebox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Dave
 */
public class JukeBox1
{
    private ArrayList<JukeBox1Songs> songList;
    
    public JukeBox1()
    {
        songList = new ArrayList<JukeBox1Songs>();
    }
    
    public void go()
    {
        getSongs();
        
        System.out.println("THIS IS THE UNSORTED LIST");
        System.out.println("##########################");
        System.out.println(songList);
        System.out.println("##########################");
        System.out.println("THIS IS THE SORTED LIST BY TITLE");
        
        Collections.sort(songList);
        System.out.println("##########################");
        System.out.println(songList);
        System.out.println("##########################");
        
        ArtistCompare artistCompare = new ArtistCompare();
        System.out.println("THIS IS THE SORTED LIST BY ARTIST");
        
        Collections.sort(songList, artistCompare);
        System.out.println("##################################");
        System.out.println(songList);
    }
    
    public void getSongs()
    {
        try
        {
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null)
            {
                addSong(line);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void addSong(String lineToParse)
    {
        String[] tokens = lineToParse.split("/");
        
        JukeBox1Songs nextSong = new JukeBox1Songs(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }
    
    public class ArtistCompare implements Comparator<JukeBox1Songs>
    {

        @Override
        public int compare(JukeBox1Songs one, JukeBox1Songs two)
        {
            return one.getArtist().compareTo(two.getArtist());
        } 
    }
}
