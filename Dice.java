class Dice{
    private int noOfDice;

    Dice(int noOfDice){
        this.noOfDice = noOfDice;
    }

    int rollDice(){
        return noOfDice + (int)(Math.random() * (6*noOfDice - noOfDice + 1));
    }
}