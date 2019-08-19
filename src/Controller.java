import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;

public class Controller {
    Model model;
    View view;
    private int row,col;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.listener(new BoardListener());
        view.menuListener(new MenuClick());
        view.listener2(new RestartListener());
    }

    /* clicked button gets disabled and colour changes if clicked*/
    void gameButtons(ActionEvent e,JButton[][] button){
        for (int r = 0; r <= 2; r++) {
            for (int c = 0; c <= 2; c++) {
                if (e.getSource() == view.button[r][c]) {
                    view.setRow(r);
                    view.setCol(c);
                    view.button[r][c].setEnabled(false);
                    view.button[r][c].setBackground(new Color(240,255,255));
                }
            }
        }
    }

    void resetBoard(){
        for(int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                view.button[r][c].setEnabled(true);
                view.button[r][c].setBackground(Color.orange);
                view.button[r][c].setText("");
            }
        }
    }

    void playerTurns(){
        row=view.getRow();
        col=view.getCol();
        if (view.getStatus().equals(view.xTurn())) {
            view.button[row][col].setText(model.cross);
            model.add(row, col, model.cross);
        } else {
            view.button[row][col].setText(model.noughts);
            model.add(row,col, model.noughts);
        }
    }

    void gameWinner(ActionEvent e){
        if (model.win(model.cross)) {
            view.setStatus(model.verdict());
            model.incX();
            disableButtons(e,view.button);
        }
        else if (model.win(model.noughts)){
            view.setStatus(model.verdict());
            model.incO();
            disableButtons(e,view.button);
        }
        else if (model.draw()){
            view.setStatus(model.verdict());
            model.incDraw();
            disableButtons(e,view.button);
        }
    }

    class RestartListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            resetBoard();
            model.emptyBoard(model.getBoard());
            view.switchStatus();

        }
    }

    void disableButtons(ActionEvent e,JButton[][] button){
        for (int r = 0; r <= 2; r++) {
            for (int c = 0; c <= 2; c++) {
                    view.button[r][c].setEnabled(false);
                    if(view.button[r][c].getText().equals(""))
                        view.button[r][c].setBackground(Color.BLACK);
            }
        }
    }

    class BoardListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                gameButtons(e,view.button);
                playerTurns();
                view.switchStatus();
                gameWinner(e);
                view.setScore(model);
            }
        }

        class MenuClick implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
            if(e.getSource()==view.restart)
                view.start.doClick();
            if(e.getSource()==view.url){
                try {
                    Desktop.getDesktop().browse(new URL(model.getURL()).toURI());
                } catch (Exception a) {
                    a.printStackTrace();
                }
            }
            else System.exit(0);
            }
        }


    }
