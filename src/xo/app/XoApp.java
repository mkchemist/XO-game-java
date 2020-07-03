/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo.app;


/**
 *
 * @author mk_ch
 */
public class XoApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Container game = new Container();
        game.scanPlayer("X", 1);
        game.scanPlayer("O",2);
        game.board.drawBoard();
        game.start();
    }
    
}
