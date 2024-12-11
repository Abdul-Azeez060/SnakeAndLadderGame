import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Player> currentPlayers = new LinkedList<>();
        System.out.println("Enter the number of dice");
        int noOfDice = in.nextInt();
        System.out.println("Enter board size");
        int boardSize = in.nextInt();
        System.out.println("Enter Number of players ");
        int noOfPlayers = in.nextInt();
        in.nextLine();
        ArrayList<Player> players = new ArrayList<>();
        for(int i = 0; i < noOfPlayers; i++){
            System.out.println("Please enter the name for player " + i + " ");
            String name = in.nextLine();
            System.out.println("Please enter the unique button for this player ");
            char button = in.next().charAt(0);
            in.nextLine();
            Player player = new Player(name, button);
            players.add(player);
            currentPlayers.add(player);
        }
       
        ArrayList<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(2, 6));
        ladders.add(new Ladder(4, 9));
        ArrayList<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(7, 9));
        HashMap<Integer, Integer> currentPosition = new HashMap<>();
        for(int i = 0; i < noOfPlayers; i++){
            currentPosition.put(players.get(i).getId(), 1);
        }

        Board board = new Board(new Dice(noOfDice),ladders ,snakes,currentPlayers ,boardSize,currentPosition);
        board.startGame();
        in.close();
        
    }
}
