import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Song {
    private String title;
    private String artist;
    private int playCount;
// Constructor to initialize the Song object with title, artist, and play count.
    public Song(String title, String artist, int playCount) {
        this.title = title;
        this.artist = artist;
        this.playCount = playCount;
    }
// Getter method for retrieving the title of the song.
    public String getTitle() {
        return title;
    }
// Getter method for retrieving the artist of the song.
    public String getArtist() {
        return artist;
    }
// Getter method for retrieving the play count of the song.
    public int getPlayCount() {
        return playCount;
    }
// Setter method for updating the play count of the song.
    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }
// Override toString() method to provide a string representation of the Song object.
    @Override
    public String toString() {
        return title + " by " + artist + " (Play count: " + playCount + ")";
    }
}

public class MusicPlaylist {
    private static List<Song> playlist = new ArrayList<>();
// Main method to run the playlist manager.
    public static void main(String[] args) {
        initializePlaylist();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayOptions();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addSongToPlaylist(scanner);
                    break;
                case 2:
                    removeSongFromPlaylist(scanner);
                    break;
                case 3:
                    showSongsAbovePlayCount();
                    break;
                case 4:
                    displayPlaylist();
                    break;
                case 5:
                    exitPlaylistManager(scanner);
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
// Method to initialize the playlist with default songs.
    private static void initializePlaylist() {
        playlist.add(new Song("Aadat", "Atif", 75));
        playlist.add(new Song("Barrish", "Issy", 12));
        playlist.add(new Song("Love me", "Nauman", 45));
        playlist.add(new Song("Daaku", "Sidhu", 30));
        playlist.add(new Song("Hello", "Sia", 23));
        playlist.add(new Song("Hug", "Imran khan", 12));
        playlist.add(new Song("Rollay", "Singh", 9));
        playlist.add(new Song("Hero", "Arijit", 87));
        playlist.add(new Song("Sajna", "Atif", 7));
        playlist.add(new Song("Lamborghini", "Imran khan", 65));
    }
// Method to display the menu of options to the user.
    private static void displayOptions() {
        System.out.println("\nOptions: ");
        System.out.println("1. Add a new song to the playlist");
        System.out.println("2. Remove a song from the playlist");
        System.out.println("3. Show songs with play count above 10");
        System.out.println("4. Show the current playlist");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
    }
// Method to add a new song to the playlist based on user input.
    private static void addSongToPlaylist(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter the song name: ");
        String song = scanner.nextLine();
        System.out.print("Enter the artist name: ");
        String artist = scanner.nextLine();
        System.out.print("Enter the play count: ");
        int playCount = scanner.nextInt();
        playlist.add(new Song(song, artist, playCount));
        System.out.println("Song added to the playlist!");
    }
// Method to remove a song from the playlist based on user input.
    private static void removeSongFromPlaylist(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter the song name to remove: ");
        String songToRemove = scanner.nextLine();
        Song song = findSong(songToRemove);
        if (song != null) {
            playlist.remove(song);
            System.out.println("Song removed from the playlist: " + song);
        } else {
            System.out.println("Song not found in the playlist.");
        }
    }
// Method to find a song in the playlist based on its title.
    private static Song findSong(String songName) {
        for (Song song : playlist) {
            if (song.getTitle().equalsIgnoreCase(songName)) {
                return song;
            }
        }
        return null;
    }
// Method to display songs with play count above 10.
    private static void showSongsAbovePlayCount() {
        System.out.println("\nSongs with play count above 10:");
        for (Song song : playlist) {
            if (song.getPlayCount() > 10) {
                System.out.println(song);
            }
        }
    }
// Method to display the current playlist.
    private static void displayPlaylist() {
        System.out.println("\nCurrent Playlist:");
        for (Song song : playlist) {
            System.out.println(song);
        }
    }
 // Method to exit the playlist manager and close the scanner.
    private static void exitPlaylistManager(Scanner scanner) {
        System.out.println("Exiting the playlist manager. Thank you!");
        scanner.close();
    }
}

