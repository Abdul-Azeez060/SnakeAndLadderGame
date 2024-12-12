import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<Character> set = new HashSet<>();
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
            while(set.contains(button)){
                System.out.println(button + " is already taken by others please enter unique button");
                button =  in.next().charAt(0);
            }
            set.add(button);
            in.nextLine();
            Player player = new Player(name, button);
            players.add(player);
            currentPlayers.add(player);
        }
       
        ArrayList<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(2, 6));
        ladders.add(new Ladder(4, 9));
        ArrayList<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(9, 7));
        HashMap<Integer, Integer> currentPosition = new HashMap<>();
        for(int i = 0; i < noOfPlayers; i++){
            currentPosition.put(players.get(i).getId(), 1);
        }

        Board board = new Board(new Dice(noOfDice),ladders ,snakes,currentPlayers ,boardSize,currentPosition);
        board.startGame();
        in.close();

     

        
    }
}
