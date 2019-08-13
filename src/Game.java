abstract public class Game {
    public char[][] grid=new char[3][3];

    public void board(char[][] grid){//3 x 3 grid
        this.grid=grid;
       System.out.println("   "+"0\t"+"1\t"+"2\t");
       for(int i=0;i<=2;i++)
       System.out.println(i+"\t"+grid[i][0]+"\t"+grid[i][1]+"\t"+grid[i][2]);
    }

    abstract void prompt(char z);
    abstract boolean gridNotFull();
    abstract boolean win(char z,char[][] grid);
    abstract boolean no_winner_yet(char[][] grid);
    abstract boolean condition(char[][] grid);

  final String verdict(char[][] grid){
    this.grid=grid;
    if(win('X',grid)) return ("Player X wins");
    else if(win('O',grid)) return ("Player O wins");
    else return ("It's a draw");
}

    public static void main(String[] args){
Game g=new Player();
g.board(g.grid);//empty grid
while(g.condition(g.grid)){   //while x nor y have won
System.out.println("Turn of X");
g.prompt('X');
g.board(g.grid);
if(g.condition(g.grid)) {   //if no winner then turn of O
    System.out.println("Turn of O");
    g.prompt('O');
    g.board(g.grid);
}
}
System.out.println(g.verdict(g.grid));
}
    }


