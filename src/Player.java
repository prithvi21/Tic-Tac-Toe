import java.util.InputMismatchException;
import java.util.Scanner;
public class Player extends Game {
    final char cross = 'X';
    final char noughts = 'O';
    private int x;//x co-ordinate
    private int y;//y co-ordinate
    private Scanner input = new Scanner(System.in);

    @Override
    void prompt(char z) throws InputMismatchException {
        System.out.println("Enter x co-ordinate:");
        x = input.nextInt();
        System.out.println("Enter y co-ordinate:");
        y = input.nextInt();
        if (z == cross) playermove(x, y, grid, cross);
        else playermove(x, y, grid, noughts);
    }

    private boolean validCell(int row, int col) {
        x = row;
        y = col;
        boolean bool = false;
        if (grid[x][y] == 0) bool = true;
        return bool;
    }

    private void playermove(int x, int y, char grid[][], char t) throws ArrayIndexOutOfBoundsException {
        this.grid = grid;
        this.x = x;
        this.y = y;
        try {
            if (validCell(x, y))
                grid[x][y] = t;
            else {
                System.out.println("Cell occupied");
                prompt(t);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cell does not exist");
            prompt(t);
        }
    }


    @Override
    boolean win(char z) {
        boolean win=false;
        if(
                (grid[0][0]==z&&grid[0][1]==z&&grid[0][2]==z) ||
                        (grid[1][0]==z&&grid[1][1]==z&&grid[1][2]==z) ||
                        (grid[2][0]==z&&grid[2][1]==z&&grid[2][2]==z) ||
                        (grid[0][0]==z&&grid[1][1]==z&&grid[2][2]==z) ||
                        (grid[0][2]==z&&grid[1][1]==z&&grid[2][0]==z)
        )
win=true;

        return win;
    }

    @Override
    boolean no_winner_yet(){
        boolean bool=false;
        if(!win(cross) && !win(noughts)) bool=true;
        return bool;
    }

boolean gridFull(){
        boolean bool=true;
       if(grid[0][0]==0 || grid[0][1]==0 || grid[0][2]==0|| grid[1][0]==0||grid[1][1]==0||grid[1][2]==0 ||
               grid[2][0]==0||grid[2][1]==0||grid[2][2]==0) bool=false;
       return bool;

}

boolean condition(){
        return no_winner_yet() && !gridFull();
}
}




