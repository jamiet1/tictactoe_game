// Jamie Tian
// 04/18/2023
// TicTacToe.java
// class TicTacToe has the main method. It creates a new Board object, Player object, and GameLogic object. It calls the play function in the class GameLogic with the objects gameBoard and players passed as arguments.
public class TicTacToe2 {
    public static void main(String[] args){
        Board gameBoard = new Board();
        Player players = new Player();
        GameLogic logic = new GameLogic();
        logic.play(gameBoard, players);
    }
}
