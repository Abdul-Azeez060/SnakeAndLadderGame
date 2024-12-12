import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*  dice value atleast 1
 * No of players atleast 2
 * No two ladders or snakes at the same number 
 * there must be either a ladder or a snake  or nothing at the particular positon
 */ 
// this won't work if  the end of the ladder is a snake, or the end of the snake is ladder
// as I am not checking those conditions after the line 60
public class Board {
    private int boardSize; 
    Dice dice;
    ArrayList<Ladder> ladders; 
    ArrayList<Snake> snakes; 
    Queue<Player> currentPlayers; 
    HashMap<Integer, Integer> currentPostion; 

    Board(Dice dice, ArrayList<Ladder> ladders,ArrayList<Snake> snakes,Queue<Player> currenPlayers, int boardSize, HashMap<Integer, Integer> currentPostion ){
        this.dice = dice;
        this.ladders = ladders;
        this.snakes = snakes;
        this.currentPlayers = currenPlayers;
        this.boardSize = boardSize;
        this.currentPostion = currentPostion;
    }

    void getWinnerCard(Player player, int rankCount){
        if(rankCount == 1) System.out.println("Winner Winner Chicken Dinner "+ player.getName()+ " won the game with rank " + rankCount);
        else if(rankCount == 2) System.out.println("Booyah Booyah Booyah "+ player.getName()+ "won the game with rank "+ rankCount);
        else System.out.println("Your rank is "+ rankCount);
       
    }

    void startGame(){
        int rankCount = 1;
        Scanner sc = new Scanner(System.in);
        while(currentPlayers.size() > 1){
            Player player =  currentPlayers.poll();
            int currentValue = currentPostion.get(player.getId());
            char playerButton = player.getButton();
            char inputButton = ' ';
            while(inputButton != playerButton){
                System.out.println(player.getName() + " Please enter your button to roll the dice");
                    inputButton = sc.next().charAt(0);
            }
            int value = dice.rollDice();
            System.out.println("Dice rolled "+ value);
            int nextValue = currentValue + value;
            if(nextValue > boardSize){
                System.out.println("The value exits the "+ boardSize +", better luck for the next turn");
            }else if(nextValue == boardSize){
                getWinnerCard(player, rankCount);
                rankCount++;
                continue;
            }else {
               for(Snake snake : snakes){
                if(snake.startPos == nextValue){
                    nextValue = snake.endPos;
                    System.out.println("ooh Snake bite at "+ snake.startPos + " --> " + snake.endPos);
                }
               }
               boolean ladderTaken = false;
               for(Ladder ladder : ladders){
                if(ladder.startPos == nextValue){
                    nextValue = ladder.endPos;
                    ladderTaken = true;
                    System.out.println("Lucky you, there is a ladder at "+ ladder.startPos+ " --> " + ladder.endPos);
                }
               }
               if(ladderTaken && nextValue == boardSize){
                 getWinnerCard(player, rankCount);
                 rankCount++;
               }
               currentPostion.put(player.getId(), nextValue); 
            }
            nextValue = (nextValue > boardSize) ? (currentValue) : (nextValue);
            int remaining = boardSize-nextValue;
            System.out.println(player.getName() +" "+ currentValue+ " --> " + nextValue + " remaining steps "+ remaining );
            currentPlayers.add(player);
            System.out.println();
        }

    }
  
}
