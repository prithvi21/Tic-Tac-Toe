import java.util.ArrayList;

public class Model {
    private char[][] board=new char[3][3];
    final String cross="X";
    final String noughts="O";
    private final String xWon="Player X won!";
    private final String oWon="Player O won!";
    private final String drawGame="It's a draw";
    private final String websiteURL="https://en.wikipedia.org/wiki/Tic-tac-toe";
    private int xScore=0;
    private int oScore=0;
    private int drawScore=0;

    void add(int r,int c,String symbol){
        char ch=symbol.charAt(0);
        board[r][c]=ch;
    }

    String getURL(){
        return websiteURL;
    }

    boolean win(String symbol) {
        char z=symbol.charAt(0);
        return
                (
                        (board[0][0]==z&&board[0][1]==z&&board[0][2]==z) ||
                                (board[1][0]==z&&board[1][1]==z&&board[1][2]==z) ||
                                (board[2][0]==z&&board[2][1]==z&&board[2][2]==z) ||
                                (board[0][0]==z&&board[1][1]==z&&board[2][2]==z) ||
                                (board[0][2]==z&&board[1][1]==z&&board[2][0]==z) ||
                                (board[0][1]==z&&board[1][1]==z&&board[2][1]==z) ||
                                (board[0][2]==z&&board[1][2]==z&&board[2][2]==z) ||
                                (board[0][0]==z&&board[1][0]==z&&board[2][0]==z)
                );


    }

    boolean draw(){
        if(gridFull()) return !win(noughts)&&!win(cross);
        return false;
    }

    boolean gridFull(){
        for(int r=0;r<=2;r++){
            for(int c=0;c<=2;c++){
                if(board[r][c]==0) return false;
            }
        }
        return true;
    }

    char[][] getBoard(){
        return board;
    }

    void emptyBoard(char[][] board){
        this.board=board;
        for(int r=0;r<=2;r++){
            for(int c=0;c<=2;c++){
                board[r][c]=0;
            }
        }
    }

    void incX(){
        xScore++;
    }

    void incO(){
        oScore++;
    }

    void incDraw(){
        drawScore++;
    }

    int getScore(String symbol){
        if(symbol==cross) {
            return xScore;
        }
        else if(symbol==noughts) return oScore;
        else return drawScore;
    }


    String verdict(){
        if(win(cross)) return xWon;
        else if(win(noughts)) return oWon;
        else return drawGame;
    }

}
