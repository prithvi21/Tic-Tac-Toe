import java.util.InputMismatchException;
import java.util.Scanner;
public class Player extends Game {
    final char cross = 'X';
    final char noughts = 'O';
    private int row;//x co-ordinate
    private int col;//y co-ordinate
    private Scanner input = new Scanner(System.in);


    /* param z  noughts or cross */
    @Override
    void prompt(char z) throws InputMismatchException {
        System.out.println("Enter x co-ordinate:");
        row = input.nextInt();
        System.out.println("Enter y co-ordinate:");
        col = input.nextInt();
        if (z == cross) playerMove(row, col, grid, cross);
        else playerMove(row,col,grid, noughts);
    }

    private boolean validCell(int row, int col) {
        this.row=row;
        this.col=col;
        return (grid[row][col] == 0);
    }

    private void playerMove(int row, int col, char grid[][], char t) throws ArrayIndexOutOfBoundsException {
        this.grid = grid;
        this.row = row;
        this.col = col;
        try {
            if (validCell(row, col))
                grid[row][col] = t;
            else {
                System.out.println("Cell occupied");
                prompt(t);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cell does not exist");
            prompt(t);
        }
    }


//    @Override
    boolean win(char z,char[][] grid) {
        return
        (
                (grid[0][0]==z&&grid[0][1]==z&&grid[0][2]==z) ||
                        (grid[1][0]==z&&grid[1][1]==z&&grid[1][2]==z) ||
                        (grid[2][0]==z&&grid[2][1]==z&&grid[2][2]==z) ||
                        (grid[0][0]==z&&grid[1][1]==z&&grid[2][2]==z) ||
                        (grid[0][2]==z&&grid[1][1]==z&&grid[2][0]==z)
        );


    }

    @Override
    boolean no_winner_yet(char[][] grid){
        return !win(cross,grid) && !win(noughts,grid);
    }

boolean gridNotFull(){
        return (grid[0][0]==0 || grid[0][1]==0 || grid[0][2]==0|| grid[1][0]==0||grid[1][1]==0
               ||grid[1][2]==0 || grid[2][0]==0||grid[2][1]==0||grid[2][2]==0);
}

boolean condition(char[][] grid){
        return no_winner_yet(grid) && gridNotFull();
}
}




