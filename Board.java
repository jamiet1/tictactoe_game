// Jamie Tian
// 04/18/2023
// Board.java
// class Board is for setting and getting the board size and the board, printing the board with each element at each row and column location outputted, and updating the element at a specific row and column location.
public class Board {
    private int size;
    private char[][] board;
    /**
     * passes an integer pNum
     * sets the private member size
     * @param
     */
    public void setSize(int pNum){
        size = pNum + 1;
    }
    /**
     * return the private member variable size
     * @retyrn
     */
    public int getSize(){
        return size;
    }
    /**
     * set the private member variable board with row and column equals to size
     */
    public void setBoard(){
        board = new char[size][size];
    }
    /**
     * return the private member variable board
     * @retyrn
     */
    public char[][] getBoard(){
        return board;
    }
    /**
     * outputs each element at each row and column location of the member variable board
     */
    public void printBoard(){
        System.out.println("(Row numbers on the left, column numbers on the top)");
        System.out.print("  ");
        for(int i = 0; i < size; i++){
            System.out.print("|" + i + " ");
        }
        System.out.print("|");
        System.out.println();
        System.out.println("--+".repeat(size + 1));
        for(int i = 0; i < size; i++){
            System.out.print(i + " ");
            for(int j = 0; j < size; j++){
                if(board[i][j] == '\0'){
                    System.out.print("|  ");
                }else{
                    System.out.print("|" + board[i][j] + " ");
                }
            }
            System.out.print("|");
            System.out.println();
            System.out.println("--+".repeat(size + 1));
        }
    }
    /**
     * passes an integer row, an integer col, and a char chess as functions arguments
     * sets the character of the member variable board at row and col to chess
     * @param
     */
    public void updateBoard(int row, int col, char chess){
        board[row][col] = chess;
    }
}
