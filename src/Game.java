abstract public class Game {
    public char[][] grid=new char[3][3];


    public void board(char[][] grid){//3 x 3 grid
        this.grid=grid;
       System.out.println("   "+"0\t"+"1\t"+"2\t");
       for(int i=0;i<=2;i++)
       System.out.println(i+"\t"+grid[i][0]+"\t"+grid[i][1]+"\t"+grid[i][2]);
    }

     abstract void prompt(char z);

    abstract boolean gridFull();
    abstract boolean win(char z);
    abstract boolean no_winner_yet();
    abstract boolean condition();

void verdict(){
    if(win('X')) System.out.println("Player X wins");
    else if(win('O')) System.out.println("Player O wins");
    else System.out.println("It's a draw");
}



    public static void main(String[] args){
Game g=new Player();
g.board(g.grid);//empty grid
while(g.condition()){   //while x nor y have won
System.out.println("Turn of X");
g.prompt('X');
g.board(g.grid);
if(g.condition()) {   //if no winner after line 33 then turn of O
    System.out.println("Turn of O");
    g.prompt('O');
    g.board(g.grid);
}
}
g.verdict();
}
    }


