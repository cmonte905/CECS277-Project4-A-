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

	public void getRating() {
		System.out.println("Current rating: " + this.rating);
	}

	public void setRating(int r) {
		this.rating = r;
	}

	public ArrayList<Song> getList() {
		return songList;
	}

	public String toString() {
		return this.title + " " + this.artist + " " + this.album + " "
				+ this.rating;
	}

	public int compareTo(Object other) {
		Song otherSong = (Song) other;
		if (this.rating == otherSong.rating) {
			boolean check = true;
			int i =0;
			while(check){
				if(i> otherSong.title.length() || i > this.title.length()){
					if(this.title.length() > otherSong.title.length()){
						i = otherSong.title.length()-1;
					}
					else{
						i = this.title.length()-1;
					}
					
				}
				if (this.title.charAt(i) > otherSong.title.charAt(i)){
					return 1;
				}
				else if(this.title.charAt(i) < otherSong.title.charAt(i)){
					return -1;
				}
				else{
					i++;
				}
			}
			
			return 0;
		} else if (this.rating > otherSong.rating) {
			return 1;
		} else {
			return -1;
		}

	}

}
