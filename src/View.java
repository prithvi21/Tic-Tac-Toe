import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame{
     private JPanel panel=new JPanel();
     private JPanel scorePanel=new JPanel();
     JButton[][] button=new JButton[3][3];
     private JLabel status=new JLabel();
     private final String xTurn="Player X turn";
     private final String oTurn="Player O turn";
     private int row;
     private int column;
     JButton start=new JButton("Restart Game");
     private JTextField scoreX=new JTextField("Player X score",20);
     private JTextField scoreO=new JTextField("Player O score",20);
     private JTextField drawScore=new JTextField("Number of draws",20);
     private JMenuBar mb=new JMenuBar();
     private JMenu menu=new JMenu("File");
     private JMenuBar help=new JMenuBar();
     private JMenu helpMenu=new JMenu("Help");
     JMenuItem restart=new JMenuItem("Restart Game");
     JMenuItem close=new JMenuItem("Close");
    JMenuItem url=new JMenuItem("About Tic Tac Toe");

    View(){
        //Setting the menu
        this.add(mb);
        mb.setBackground(Color.PINK);
        this.add(help);
        help.setBackground(Color.cyan);
        mb.add(menu);
        menu.add(restart);
        menu.add(close);
        mb.setBounds(0,0,50,20);
        help.add(helpMenu);
        help.setBounds(50,0,50,20);
        helpMenu.add(url);

        //Setting the Frame
        this.setResizable(false);
        this.setTitle("Tic Tac Toe");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.getContentPane().setBackground(new Color(184,222,60));
        this.setLayout(null);

        //restart button
        this.add(start);
        start.setBounds(150,325,300,100);
        start.setBackground(new Color(55,43,223));
        start.setForeground(Color.WHITE);
       //setting game panel
        this.add(panel);
        this.add(status);
        status.setForeground(Color.BLACK);
        status.setBounds(150,75,300,100);
        status.setText(xTurn);//initial status
        status.setFont(new Font("Courier New",Font.BOLD,20));
        panel.setBounds(150,150,300,150);
        panel.setLayout(new GridLayout(3,3));
        for(int i=0;i<button.length;i++) {
            for (int j = 0; j < button[i].length; j++) {
                button[i][j] = new JButton();
                button[i][j].setBackground(Color.orange);
                button[i][j].setForeground(new Color(255,20,147));
                panel.add(button[i][j]);
            }
        }


        //setting score panel
         this.add(scorePanel);
         scorePanel.setBackground(new Color(205,92,92));
         scorePanel.setBounds(600,150,300,150);

         scorePanel.add(scoreX);
         scoreX.setEditable(false);
         scoreX.setBackground(new Color(255,218,185));
         scoreX.setForeground(new Color(4,79,79));
         scorePanel.add(scoreO);
         scoreO.setBackground(new Color(255,218,185));
         scoreO.setForeground(new Color(4,79,79));
         scoreO.setEditable(false);
         scorePanel.add(drawScore);
         drawScore.setEditable(false);






    }

    void setScore(Model m){
        scoreX.setText("Player X Score:"+m.getScore(m.cross));
        scoreO.setText("Player O Score:"+m.getScore(m.noughts));
        drawScore.setText("Number of draws:"+m.getScore("draw"));
    }

    void setRow(int row){
        this.row=row;
    }

    int getRow(){
        return row;
    }

    void setCol(int column){
        this.column=column;
    }

    int getCol(){
        return column;
    }

    void switchStatus(){
        if(getStatus().equals(xTurn)|| getStatus().equals(new Model().verdict()))
            setStatus(oTurn);
        else setStatus(xTurn);
    }

    void setStatus(String status){
        this.status.setText(status);
    }

    String getStatus(){
        return status.getText();
    }

    String xTurn(){
        return xTurn;
    }

    String oTurn(){
        return oTurn;
    }

void listener2(ActionListener a){
        start.addActionListener(a);
}

void menuListener(ActionListener a){
        restart.addActionListener(a);
        close.addActionListener(a);
        url.addActionListener(a);
}


    void listener(ActionListener a){
        for(int r=0;r<=2;r++){
            for(int c=0;c<=2;c++){
                button[r][c].addActionListener(a);
            }
        }

    }
}
