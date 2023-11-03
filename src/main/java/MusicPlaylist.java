import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MusicPlaylist {

    public static void main(String[] args) {
        Map<String, Integer> playlist = new HashMap<>();

        // Pre-populating the playlist with initial songs
        playlist.put("Aadat by Atif", 75);
        playlist.put("Barrish by Issy", 12);
        playlist.put("Love me by Nauman", 45);
        playlist.put("Daaku by Sidhu", 30);
        playlist.put("Hello by Sia", 23);
        playlist.put("Hug by Imran khan", 12);
        playlist.put("Rollay by Singh", 9);
        playlist.put("Hero by Arijit", 87);
        playlist.put("Sajna by Atif", 7);
        playlist.put("Lamborghini by Imran khan", 65);

        Scanner scanner = new Scanner(System.in);

        // Menu to add or remove songs
        while (true) {
            System.out.println("\nOptions: ");
            System.out.println("1. Add a new song to the playlist");
            System.out.println("2. Remove a song from the playlist");
            System.out.println("3. Show songs with play count above 10");
            System.out.println("4. Show the current playlist");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter the song name: ");
                    String song = scanner.nextLine();
                    System.out.print("Enter the artist name: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter the play count: ");
                    int playCount = scanner.nextInt();
                    playlist.put(song + " by " + artist, playCount);
                    System.out.println("Song added to the playlist!");
                    break;

                case 2:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter the song name to remove: ");
                    String songToRemove = scanner.nextLine();
                    Integer removed = playlist.remove(songToRemove);
                    if (removed != null) {
                        System.out.println("Song removed from the playlist: " + songToRemove);
                    } else {
                        System.out.println("Song not found in the playlist.");
                    }
                    break;

                case 3:
                    System.out.println("\nSongs with play count above 10:");
                    for (Map.Entry<String, Integer> entry : playlist.entrySet()) {
                        if (entry.getValue() > 10) {
                            System.out.println(entry.getKey() + " (Play count: " + entry.getValue() + ")");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\nCurrent Playlist:");
                    for (Map.Entry<String, Integer> entry : playlist.entrySet()) {
                        System.out.println(entry.getKey() + " (Play count: " + entry.getValue() + ")");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the playlist manager. Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
