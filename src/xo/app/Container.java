/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo.app;
import java.util.Scanner;

/**
 * game container
 * that act as a container for all game classes
 * 
 * 
 * @author mk_ch
 */
public class Container {
    Board board = null;
    boolean should_teminate;
    Scanner scanner;
    Player player_one;
    Player player_two;
    boolean should_turn;
    
    /**
     * Container Class Constructor
     * 
     * register game board
     * register game players
     * register scanner 
     * 
     */
    public Container () {
        this.board = new Board(this);
        this.should_teminate = false;
        this.scanner = new Scanner(System.in);
        this.should_turn = false;
    }
    
    /**
     * terminate game
     * 
     * 
     * 
     */
    public void terminateGame() {
        this.should_teminate = true;
    }
    
    /**
     * Print locked cell alert
     * 
     * 
     * @param name 
     */
    public void lockedCellAlert(String name) {
        System.out.println("this Cell is filled by "+ name);
    }
    /**
     * Scan for player and set Player name and sign
     * 
     * @param sign
     * @param id 
     * @return void
     */
    public void scanPlayer(String sign,int id)
    {
        System.out.println("Enter Player "+id+" name");
        String name = this.scanner.next();
        if("".equals(name) || " ".equals(name)  || "\n".equals(name)) {
            this.scanPlayer(sign,id);
        }
        if("X".equals(sign)) {
            this.player_one = new Player(name, sign);
        } else {
            this.player_two = new Player(name,sign);
        }
        System.out.println("thanks "+name);
    }
    
    /**
     * Setting players turn
     * control who should play now
     * 
     * @return void 
     */
    public void shouldTurn() {
        this.should_turn  = !this.should_turn;
    }
    
    /**
     * starting game
     * 
     * @return void
     */
    public void start(){
        while(true) {
            if(this.should_teminate == true) {
                this.board.drawBoard();
                System.out.println("Draw GAME");    
                break;
            }
            int move  = this.scanner.nextInt();
            Player player = this.should_turn == true ? this.player_two : this.player_one; 
            this.board.updateBoard(move, player);
            this.checkWinner();
        }
    }
    
    private void checkWinner()
    {
        /**
         * Winning possibilities 
         * 2d array
         */
        int[][] win_pos = {
            {1,2,3},
            {1,5,9},
            {1,4,7},
            {2,5,8},
            {3,5,7},
            {3,6,9},
            {4,5,6},
            {7,8,9}
        };
        for(int i = 0 ; i < 8 ; i++) {
            int[] pos = win_pos[i];
            if(this.isPlayerWin(pos, this.player_one.getSign()) == true) {
                String name = this.player_one.getName();
                System.out.println(name+" Win");
            }
            if(this.isPlayerWin(pos, this.player_two.getSign()) == true) {
                String name = this.player_two.getName();
                System.out.println(name+" Win");
            }
        }
    }
    
    private boolean isPlayerWin(int[] pos,String sign)
    {
        Board board = this.board;
        return board.getCellValue(pos[0]) == sign
                && board.getCellValue(pos[1]) == sign
                && board.getCellValue(pos[2]) == sign;
    }
}
