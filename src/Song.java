import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Song implements Comparable {
	private ArrayList<String[]> s = new ArrayList<String[]>();
	private ArrayList<Song> songList = new ArrayList<Song>();
	private String title, artist, album;
	private int rating;

	public Song(String t, String a, String alb, int r) {
		this.title = t;
		this.artist = a;
		this.album = alb;
		this.rating = r;
	}

	

	public ArrayList<Song> getList() {
		return songList;
	}

	public String toString() {
		return this.title + " "+ this.artist + " " + this.album + " " + this.rating;
	}

	public int compareTo(Object other) {
		
		Song otherSong = (Song) other;
		if(other instanceof Song){
			return  0;
		}
		
		return 0;
		
	}

}
