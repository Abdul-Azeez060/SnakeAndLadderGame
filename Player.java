public class Player {
    private String name;
    private int id;
    private static int runningId = 1;
    private char button; 

    Player(String name, char button){
        this.name = name;
        this.button = button;
        id = runningId; 
        runningId++;
    }

    String getName(){
        return name;
    }

    int getId(){
        return id;
    }

    char getButton(){
        return button;
    }
}
