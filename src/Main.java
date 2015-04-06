import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	private static  ArrayList<Song> songList = new ArrayList<Song>();
	public static void main(String args[]) {	
		songList = getList();
		Heap songHeap = new Heap();
		for(int i = 0; i > songList.size();i++){
			songHeap.addNode(songList.get(i));	
		}
		
		Scanner input = new Scanner(System.in);
		int currentSong = 0;
		boolean keepPlaying = true;
		
		
		while (keepPlaying) {
			System.out
					.println("Choose an option:\n1: Display all songs\n2: Display current song\n3: "
							+ "Add a new song into the list \n4: Play next song \n"
							+ "5: Re-rate current song \n6: Quit");
			int gameState = checkInt(1, 6);
			switch (gameState) {
			case 1:
				for (int i = 0; i < songList.size(); i++) {
					System.out.println(songList.get(i).toString());
				}
				break;
			case 2:
				System.out.println(songList.get(currentSong).toString());
				break;
			case 3: 
				System.out.println("Enter the title of the new song ");
				String newSongTitle = input.nextLine();
				
				System.out.println("Enter the Artist of the new song");
				String newSongArtist = input.nextLine();
				
				System.out.println("Enter the album where song comes from");
				String newSongAlbum = input.nextLine();
				
				System.out.println("Enter the rating of the new song ");
				int newSongrRating = input.nextInt();
				Song newSong = new Song(newSongTitle, newSongArtist, newSongAlbum,newSongrRating);
				songList.add(newSong);
				//Will also have to be added into the heap 
				break;
			case 4:
				currentSong++;
				System.out.println("Now playing " + songList.get(currentSong));
				break;
			case 5:
				System.out.println("Now playing " + songList.get(currentSong));
				songList.get(currentSong).getRating();
				System.out.println("Please enter the new rating of the song");
				int r = input.nextInt();
				songList.get(currentSong).setRating(r);
				break;
			case 6:
				System.out.println("Thank you for your patronage");
				keepPlaying = false;
				break;
			}
		}
	}
	
	
	
	public static ArrayList<Song> getList(){
		ArrayList<Song> SL = new ArrayList<Song>();
		ArrayList<String[]> s = new ArrayList<String[]>();
		try {
			File songList = new File("playlist.txt");
			Scanner readFile = new Scanner(songList);
			while (readFile.hasNext()) {
				s.add(readFile.nextLine().split(","));

			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file");
		}

		for (int i = 0; i < s.size(); i++) {
			Song song = new Song(s.get(i)[0], s.get(i)[1], s.get(i)[2],
					Integer.parseInt(s.get(i)[3]));
			SL.add(song);
		}	
		
		return SL;
	}

	public static int checkInt(int low, int high) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		int validNum = 0;
		while (!valid) {
			if (in.hasNextInt()) {
				validNum = in.nextInt();
				if (validNum >= low && validNum <= high) {
					valid = true;
				} else {
					System.out.println("Invalid input, please try again ");
				}
			} else {
				// clear buffer of junk input
				try {
					in.next();
				} catch (NoSuchElementException i) {
					System.out.println(" ..........");
				}

				System.out.println("Invalid input! Please try again! ");
			}
		}
		return validNum;
	}
}
