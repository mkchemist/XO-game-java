/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo.app;

/**
 * Board Class that control game board
 * 
 * 
 * @author mk_ch
 */
public class Board {
    /**
     * game board cells
     * 
     * @var 2d array of BoardCell
     */
    BoardCell[][] cells = {
        {new BoardCell(1), new BoardCell(2), new BoardCell(3)},
        {new BoardCell(4), new BoardCell(5), new BoardCell(6)},
        {new BoardCell(7), new BoardCell(8), new BoardCell(9)},        
    };
    /**
     * game moves count
     * 
     * @var integer
     */
    int moves;
    
    /**
     * Container Instance
     * 
     * @var Container
     */
    Container app;
    
    /**
     * Board constructor
     * 
     * @param app 
     */
    public Board(Container app) {
        this.app = app;
        this.moves = 0;
    }
    
    /**
     * Draw game board
     * 
     * @return void
     */
    public void drawBoard(){
        int i;
        int y;
        for(i = 0 ; i < 3 ; ++i) {
            System.out.println("-------------------------------------------------");
            System.out.print("|");
            for(y = 0 ; y < 3 ; ++y) {
                if(this.cells[i][y].getVal() != null) {
                    System.out.print("\t");
                    if(this.cells[i][y].getVal() == "X") {
                        System.out.print("\u001B[32m");                    
                    } else {
                        System.out.print("\u001B[31m");                                    
                    }
                    System.out.print(this.cells[i][y].getVal()); 
                    System.out.print("\u001B[0m\t|");                                    
    
                } else {                
                    System.out.print("\t"+this.cells[i][y].getId()+"\t|");
                }
            }
            System.out.print("\n");
        }
        System.out.println("-------------------------------------------------");
    }
    
    /**
     * update board and draw player sign
     * on selected cell
     * 
     * @param move
     * @param player 
     */
    public void updateBoard(int move, Player player) {
        if(this.moves == 8) {
            this.app.terminateGame();
        }
        int[] cell = this.getCellCoords(move);
        if(this.cells[cell[0]][cell[1]].isLocked() == true) {
            this.app.lockedCellAlert(this.cells[cell[0]][cell[1]].getOwner());
            return;
        } 
        this.cells[cell[0]][cell[1]].setOwner(player.getName());
        this.cells[cell[0]][cell[1]].setVal(player.getSign());
        this.cells[cell[0]][cell[1]].lock();
        this.moves++;
        this.app.shouldTurn();
        this.drawBoard();

    }
    
    /**
     * get cell coordinations
     * 
     * @param move
     * @return array of integers 
     */
    private int[] getCellCoords(int move) {
        /**
         * row number
         */
        int row = (move-1)/3;
        /**
         * column number
         * 
         */
        int col = (move-(3*row))-1;
        /**
         * cell array
         * 
         */
        int[] cell = {row, col};
        return cell;
    }
    /**
     * get the given cell number from 
     * board cells
     * 
     * @param i
     * @return BoardCell
     */
    private BoardCell getCell(int i) {
       int[] pos = this.getCellCoords(i);
       return this.cells[pos[0]][pos[1]];
    }
    
    /**
     * get the given board cell value
     * 
     * @param i
     * @return String
     */
    public String getCellValue(int i)
    {
        BoardCell cell = this.getCell(i);
        return cell.getVal();
    }
}
