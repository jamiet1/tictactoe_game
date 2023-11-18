// Jamie Tian
// 04/18/2023
// Player.java
// class Player is for setting and getting the number of players, the number of pieces the winner needs to have to win, the character the player chooses to be their chess, and the row and column the player chooses to place the chess.
import java.util.Scanner;
public class Player {
    Scanner s1 = new Scanner(System.in);
    Scanner s2 = new Scanner(System.in);
    private int playerNum;
    private int winnerPieces;
    private char chess;
    private int row;
    private int col;
    /**
     * integer input validation
     */
    public void isInt(){
        while(!s1.hasNextInt()){
            System.out.println("Invalid! Enter an integer: ");
            s1.next();
        }
    }
    /**
     * sets the private member variable playerNum to the user input
     */
    public void setPlayerNum(){
        System.out.println("Enter a number of players larger than 3: ");
        isInt();
        this.playerNum = s1.nextInt();
    }
    /**
     * return the private member variable playerNum
     * @retyrn
     */
    public int getPlayerNum(){
        return this.playerNum;
    }
    /**
     * sets the private member variable winnerPieces to the user input
     */
    public void setWinnerPieces(){
        System.out.println("Enter how many pieces the winner needs to have in a row, enter a number between 3 and the player number plus 1: ");
        isInt();
        this.winnerPieces = s1.nextInt();
    }
    /**
     * return the private member variable winnerPieces
     * @retyrn
     */
    public int getWinnerPieces(){
        return this.winnerPieces;
    }
    /**
     * sets the private member variable chess to the user input
     */
    public void setChess(){
        chess = s2.next().charAt(0);
    }
    /**
     * return the private member variable chess
     * @retyrn
     */
    public char getChess(){
        return this.chess;
    }
    /**
     * sets the private member variables row and col to the user inputs
     */
    public void placeChess(){
        isInt();
        row = s1.nextInt();
        isInt();
        col = s1.nextInt();
    }
    /**
     * return the private member variable row
     * @retyrn
     */
    public int getRow(){
        return this.row;
    }
    /**
     * return the private member variable col
     * @retyrn
     */
    public int getCol(){
        return this.col;
    }
}
