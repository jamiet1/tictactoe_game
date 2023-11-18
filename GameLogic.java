// Jamie Tian
// 04/18/2023
// GameLogic.java
// class GameLogic is for input validation for the number of players, the number of pieces the winner needs to have to win, non-repeated character each play chooses to represent their chess, non-repeated chess location the player chooses to place their chess.
// It has methods to check the condition whether the winner is found or the game is a draw.
// It has the mutator and accessor for the boolean value for determining if the game is over.
// It has a method play with a game board and players passed as arguments that plays the tic-tac-toe 2 game with input validation and conditions checked.
public class GameLogic {
    private boolean endOfProgram = false;
    /**
     * input validation for Player class member variable playerNum
     * passes a Player object
     * @param
     */
    public void validPlayerNum(Player p){
        p.setPlayerNum();
        while(p.getPlayerNum() < 3){
            System.out.println("Invalid! ");
            p.setPlayerNum();
        }
    }
    /**
     * input validation for Player class member variable winnerPieces
     * passes a Player object
     * @param
     */
    public void validWinnerPieces(Player p){
        p.setWinnerPieces();
        while(p.getWinnerPieces() < 3 || p.getWinnerPieces() > (p.getPlayerNum() + 1)){
            System.out.println("Invalid! ");
            p.setWinnerPieces();
        }
    }
    /**
     * input validation for Player class member variable chess
     * passes an array of Player objects, an integer
     * @param
     */
    public void nonRepeatedChessChar(Player[] p, int pNum){
        for(int i = 0; i < pNum; i++){
            System.out.println("Player" + (i + 1) +", choose a character to represent your chess: ");
            p[i] = new Player();
            p[i].setChess();
            for(int j = 0; j < i; j++){
                while(p[i].getChess() == p[j].getChess()){
                    System.out.println("Unavailable, choose another character: ");
                    p[i] = new Player();
                    p[i].setChess();
                    j = 0;
                }
            }
        }
    }
    /**
     * input validation for Player class member variables row and col
     * passes a Board object, a two-dimensional array, a Player object
     * @param
     */
    public void nonRepeatedChessPlace(Board board, char[][] b, Player p){
        p.placeChess();
        while(p.getRow() >= board.getSize() || p.getCol() >= board.getSize() || p.getRow() < 0 || p.getCol() < 0 || b[p.getRow()][p.getCol()] != '\0'){
            if (p.getRow() >= board.getSize() || p.getCol() >= board.getSize() || p.getRow() < 0 || p.getCol() < 0) System.out.println("Unavailable, out of bounds, choose another row and column: ");
            else System.out.println("Unavailable, coordinate already taken, choose another row and column: ");
            p.placeChess();
        }
        board.updateBoard(p.getRow(), p.getCol(), p.getChess());
        board.printBoard();
    }
    /**
     * condition check for checking whether the same chess appears specific times that meets the condition to win
     * passes a Board object, a character, an integer
     * return a boolean value
     * @param
     * @return
     */
    public boolean winnerNotFound(Board board, char chess, int target){
        int size = board.getSize();
        char[][] b = board.getBoard();
        int countRow = 0, countCol = 0, count1 = 0, count2 = 0;
        // vertical and horizontal check
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (b[i][j] == chess) countRow++;
                else countRow = 0;
                if (b[j][i] == chess) countCol++;
                else countCol = 0;
                if (countRow >= target || countCol >= target) return false;
            }
            countRow = 0;
            countCol = 0;
        }
        // negative diagonal check
        for(int i = 0; i < size - 2; i++){
            int k = 0;
            for(int j = i; j < size; j++){
                if(b[k][j] == chess) count1++;
                else count1 = 0;
                if (i > 0 && b[j][k] == chess) count2++;
                else count2 = 0;
                if (count1 >= target || count2 >= target) return false;
                k++;
            }
            count1  = 0;
            count2 = 0;
        }
        // positive diagonal check
        for(int i = 0; i < size - 2; i++) {
            int k = size -  1;
            int l = 0;
            for(int j = i; j < size; j++){
                if(b[k][j] == chess) count1++;
                else count1 = 0;
                if (i > 0 && b[k - i][l] == chess) count2++;
                else count2 = 0;
                if (count1 >= target || count2 >= target) return false;
                k--;
                l++;
            }
            count1  = 0;
            count2 = 0;
        }
        return true;
    }
    /**
     * condition check for checking whether the board member variable of a Board object is all filled to determine if the game is a draw
     * passes a Board object
     * return a boolean value
     * @param
     * @return
     */
    public boolean notDraw(Board board){
        char[][] b = board.getBoard();
        for(int i = 0; i < board.getSize(); i++){
            for(int j = 0; j < board.getSize(); j++){
                if(b[i][j] == '\0'){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * sets the private member variable endOfProgram to a boolean value
     * passes a boolean
     * @param
     */
    void setEndOfProgram(boolean setBool){
        endOfProgram = setBool;
    }
    /**
     * return the private member variable endOfProgram
     * @return
     */
    boolean getEndOfProgram(){
        return endOfProgram;
    }
    /**
     * passes a Board object, a Player object
     * calls member functions of Player class with input validation and condition check
     * @param
     */
    void play(Board board, Player players){
        validPlayerNum(players);
        validWinnerPieces(players);
        Player[] player = new Player[players.getPlayerNum()];
        board.setSize(players.getPlayerNum());
        board.setBoard();
        System.out.println(players.getPlayerNum() + " player game creates a " + board.getSize() + "x" + board.getSize() + " board: ");
        board.printBoard();
        nonRepeatedChessChar(player, players.getPlayerNum());
        while(!getEndOfProgram()){
            for(int i = 0; i < players.getPlayerNum(); i++){
                System.out.println("Player" + (i + 1) +", choose row and column your will place your chess: ");
                nonRepeatedChessPlace(board, board.getBoard(), player[i]);
                if(!notDraw(board)){
                    System.out.println("Game over! It is a draw");
                    setEndOfProgram(true);
                    break;
                }else if(!winnerNotFound(board, player[i].getChess(), players.getWinnerPieces())){
                    System.out.println("Game over! Player" + (i + 1) + " wins! ");
                    setEndOfProgram(true);
                    break;
                }
            }
        }
    }
}